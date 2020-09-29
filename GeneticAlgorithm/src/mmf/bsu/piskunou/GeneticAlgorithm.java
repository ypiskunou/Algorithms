package mmf.bsu.piskunou;

import java.util.Random;

/*
	1) Случайным образом создается исходная популяция.
	2) Каждая особь в популяции оценивается на успешность. Для этого применяется фитнесс-функция.
	3) Отбираются особи для кроссовера. Этот отбор должен происходить таким образом,
	чтобы с большей вероятностью скрещивались более успешные особи, т.е., особи, имеющие большее значение фитнесс-функции.
	4) Отобранные особи скрещиваются, каждый потомок подвергается мутации с заданной вероятностью.
	5) Из потомков формируется новая популяция, которая заменяет старую.
	6) Возвращаемся к шагу 2.
*/

public class GeneticAlgorithm {

    private Chromosome[] population = new Chromosome[Config.POPULATION_QTY];

    public static int function(int u, int w, int x, int y, int z) {
        return u * u * w * y * y + x + u * u * x * x * y * z * z + w;
    }

    public static void main(String[] args) {
        log("Количество индивидуумов = " + Config.POPULATION_QTY);
        log("Количество генов = " + Config.GENES_QTY);
        GeneticAlgorithm test = new GeneticAlgorithm();
        test.createInitialPopulation();

        int iterationsNumber = 0;
        do {
            int fillingWithFitnessesResult = test.fillChromosomesWithFitnesses();
            if (fillingWithFitnessesResult != Config.TARGET_NOT_REACHED_FLAG) {
                System.out.println("\nРещение найдено: " + test.getPopulation()[fillingWithFitnessesResult]);
                return;
            }
            test.fillChromosomeWithSimilaritys();
            test.printAllChromosomes();
            int[][] pairs = test.getPairsForCrossover();
            test.analizePairs(pairs);
            Chromosome[] nextGeneration = test.performCrossoverAndMutationForThePopulationAndGetNextGeneration(pairs);
            test.setPopulation(nextGeneration);
            System.out.println("-=== Итерация №" + iterationsNumber + " закончена ===-");
        } while (iterationsNumber++ < Config.MAX_ITERATIONS);
        System.out.println("Решение не найдено. Попробуйте еще...");
    }

    private void createInitialPopulation() {
        log("*** НАЧАЛОСЬ создание начальной популяции...");
        for (int i = 0; i < Config.POPULATION_QTY; ++i) {
            log("Создание хромосомы №" + i);
            population[i] = new Chromosome();
            fillChromosomeWithRandomGenes(population[i]);
        }
        log("*** ЗАКОНЧИЛОСЬ создание начальной популяции...");
    }

    private void fillChromosomeWithRandomGenes(Chromosome chromosome) {
        log("*** НАЧАЛОСЬ заполнение хромосомы случайными генами...");
        for (int i = 0; i < Config.GENES_QTY; ++i) {
            chromosome.getGenes()[i] = getRandomGene();
            log("Ген №" + i + " = " + chromosome.getGenes()[i]);
        }
        log("*** ЗАКОНЧИЛОСЬ заполнение хромосомы случайными генами...");
    }
//region rand
    public static int getRandomGene() {
        return getRandomInt(Config.GENE_MIN, Config.GENE_MAX);
    }

    public static int getRandomInt(int min, int max) {
        return new Random().nextInt(max + 1) + min;
    }
//endregion
    private int fillChromosomesWithFitnesses() {
        log("*** НАЧАЛОСЬ создание приспособленности для всех хромосом...");
        for (int i = 0; i < Config.POPULATION_QTY; ++i) {
            log("Высчитывание приспособленности индивидуума №" + i);
            float currentFitness = population[i].calculateFitness();
            population[i].setFitness(currentFitness);
            log("Приспособленность: " + population[i].getFitness());
            if (currentFitness == Config.TARGET_REACHED_FLAG) return i;
        }
        log("*** ЗАКОНЧИЛОСЬ создание приспособленности для всех хромосом...");
        return Config.TARGET_NOT_REACHED_FLAG;
    }

    private void fillChromosomeWithSimilaritys() {
        float allFitnessesSum = getAllFitnessesSum();
        log("*** НАЧАЛОСЬ создание вероятностей для всех хромосом...\nСумма всех приспособленностей = " + allFitnessesSum);
        float last = 0.0F;
        int i;
        for (i = 0; i < Config.POPULATION_QTY; ++i) {
            float likelihood = last + (100 * population[i].getFitness() / allFitnessesSum);
            last = likelihood;
            population[i].setSimilarity(likelihood);
            log("Создана вероятность для хромосомы №" + i + " = " + (100 * population[i].getFitness() / allFitnessesSum));
        }
        population[i - 1].setSimilarity(100);
        log("*** ЗАКОНЧИЛОСЬ создание вероятностей для всех хромосом...");
    }

    private float getAllFitnessesSum() {
        float allFitnessesSum = 0.0F;
        for (int i = 0; i < Config.POPULATION_QTY; ++i)
            allFitnessesSum += population[i].getFitness();
        return allFitnessesSum;
    }

    private int[][] getPairsForCrossover() {
        log("*** НАЧАЛСЯ поиск пар для скрещивания...");
        int[][] pairs = new int[Config.POPULATION_QTY][2];
        for (int i = 0; i < Config.POPULATION_QTY; ++i) {
            log("Ищу пару №" + i + "...");
            float rand = getRandomFloat(0, 100);
            int firstChromosome = getChromosomeNumberForThisRand(rand);
            log("Первый индивидуум... Рандомное число: " + rand + ", соответствующая хромосома:" + firstChromosome +
                    ", приспособленность хромосомы * 100: " + population[firstChromosome].getFitness() * 100);
            int secondChromosome;
            do {
                rand = getRandomFloat(0, 100);
                secondChromosome = getChromosomeNumberForThisRand(rand);
            } while (firstChromosome == secondChromosome);
            log("Второй индивидуум... Рандомное число: " + rand + ", соответствующая хромосома:" + secondChromosome +
                    ", приспособленность хромосомы * 100: " + population[secondChromosome].getFitness() * 100);
            pairs[i][0] = firstChromosome;
            pairs[i][1] = secondChromosome;
        }
        log("*** ЗАКОНЧИЛСЯ поиск пар для скрещивания...");
        return pairs;
    }

    private int getChromosomeNumberForThisRand(float rand) {
        int i;
        for (i = 0; i < Config.POPULATION_QTY; ++i)
            if (rand <= population[i].getSimilarity())
                return i;
        return 0;
    }

    public static float getRandomFloat(float min, float max) {
        return (float) (Math.random() * max + min);
    }

    private Chromosome[] performCrossoverAndMutationForThePopulationAndGetNextGeneration(int[][] pairs) {
        Chromosome[] nextGeneration = new Chromosome[Config.POPULATION_QTY];
        log("*** НАЧАЛО скрещиваний...");
        for (int i = 0; i < Config.POPULATION_QTY; ++i) {
            log("*** НАЧАЛО скрещивания №" + i);
            Chromosome firstParent = population[pairs[i][0]];
            Chromosome secondParent = population[pairs[i][1]];
            log("Первый родитель (№" + pairs[i][0] + ")\n" + firstParent);
            log("Второй родитель (№" + pairs[i][1] + ")\n" + secondParent);
            Chromosome result = firstParent.singleCrossover(secondParent);
            nextGeneration[i] = result;
            log("Хромосома потомка перед мутацией: " + nextGeneration[i]);
            nextGeneration[i] = nextGeneration[i].mutateWithGivenSimilarity();
            log("Хромосома потомка после мутации: " + nextGeneration[i]);
            log("*** КОНЕЦ скрещивания №" + i);
        }
        log("*** КОНЕЦ скрещиваний...");
        return nextGeneration;
    }

    public Chromosome[] getPopulation() {
        return population;
    }

    public void setPopulation(Chromosome[] population) {
        this.population = population;
    }

    public static void log(String message) {
        System.out.println(message);
    }

    private void printAllChromosomes() {
        log("Текущее состояние всех хромосом:");
        for (int i = 0; i < Config.POPULATION_QTY; ++i) {
            log("Хромосома №" + i + ": " + population[i].toString());
        }
    }

    private void analizePairs(int[][] pairs) {
        log("*** НАЧАЛСЯ анализ пар...");
        int[] totals = new int[Config.POPULATION_QTY];
        for (int i = 0; i < Config.POPULATION_QTY; ++i) {
            totals[i] = 0;
        }
        for (int i = 0; i < Config.POPULATION_QTY; ++i) {
            for (int j = 0; j < 2; ++j) {
                totals[pairs[i][j]]++;
            }
        }
        for (int i = 0; i < Config.POPULATION_QTY; ++i) {
            log("Индивидуум №" + i + ", приспособленность: " + population[i].getFitness() + ", Число пар:" + totals[i]);
        }
        log("*** ЗАКОНЧИЛСЯ анализ пар...");
    }

}