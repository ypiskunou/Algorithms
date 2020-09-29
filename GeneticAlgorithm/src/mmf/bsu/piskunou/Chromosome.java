package mmf.bsu.piskunou;

public class Chromosome {

    private int[] genes = new int[Config.GENES_QTY];
    private float fitness;
    private float similarity;
//region getSet
    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public float getSimilarity() {
        return similarity;
    }

    public void setSimilarity(float similarity) {
        this.similarity = similarity;
    }
//endregion

    public float calculateFitness() {
        int u = genes[0];
        int w = genes[1];
        int x = genes[2];
        int y = genes[3];
        int z = genes[4];

        int fitness = Math.abs(Config.TARGET_VALUE - GeneticAlgorithm.function(u, w, x, y, z));
        GeneticAlgorithm.log("Близость: " + fitness);
        return 0 != fitness ? 1 / (float) fitness : Config.TARGET_REACHED_FLAG;
    }

    public Chromosome mutateWithGivenSimilarity() {
        GeneticAlgorithm.log("*** НАЧАЛО мутации...\nВероятность мутации = " + Config.MUTATION_SIMILARITY);
        Chromosome result = (Chromosome) this.cloneChromosome();
        for (int i = 0; i < Config.GENES_QTY; ++i) {
            float randomPercent = GeneticAlgorithm.getRandomFloat(0, 100);
            if (randomPercent < Config.MUTATION_SIMILARITY) {
                int oldValue = result.getGenes()[i];
                int newValue = GeneticAlgorithm.getRandomGene();
                GeneticAlgorithm.log("Мутация произошла в гене №" + i + ", Рандомное число = " + randomPercent
                        + ", старое значение = " + oldValue + ", новое значение = " + newValue);
                result.getGenes()[i] = newValue;
            }
        }
        GeneticAlgorithm.log("*** КОНЕЦ мутации...");
        return result;
    }

    public Chromosome[] doubleCrossover(Chromosome chromosome) {
        GeneticAlgorithm.log("*** НАЧАЛО двойного скрещивания...");
        GeneticAlgorithm.log("Хромосома 1 родителя: " + this);
        GeneticAlgorithm.log("Хромосома 2 родителя: " + chromosome);
        int crossoverLine = getRandomCrossoverLine();
        Chromosome[] result = new Chromosome[2];
        result[0] = new Chromosome();
        result[1] = new Chromosome();
        for (int i = 0; i < Config.GENES_QTY; ++i) {
            if (i <= crossoverLine) {
                result[0].getGenes()[i] = this.getGenes()[i];
                result[1].getGenes()[i] = chromosome.getGenes()[i];
            } else {
                result[0].getGenes()[i] = chromosome.getGenes()[i];
                result[1].getGenes()[i] = this.getGenes()[i];
            }
        }
        GeneticAlgorithm.log("Итогововая хромосома №0:\n" + result[0]);
        GeneticAlgorithm.log("Итогововая хромосома №1:\n" + result[1]);
        GeneticAlgorithm.log("*** КОНЕЦ двойного скрещивания...");
        return result;
    }

    public Chromosome singleCrossover(Chromosome chromosome) {
        GeneticAlgorithm.log("*** НАЧАЛО одиночного скрещивания...\nВызов двойного скрещивания...");
        Chromosome[] children = doubleCrossover(chromosome);
        GeneticAlgorithm.log("Выбор одного из двух потомков, вернувшихся из двойного скрещивания...");
        int childNumber = GeneticAlgorithm.getRandomInt(0, 1);
        GeneticAlgorithm.log("Выбранный потомок №" + childNumber + ", с хромосомой: " + children[childNumber]);
        GeneticAlgorithm.log("*** КОНЕЦ одиночного скрещивания...");
        return children[childNumber];
    }

    // выводит хромосому длины 5 по генам: вида (0,1,0,1,1)
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("(");
        for (int i = 0; i < Config.GENES_QTY; ++i) {
            result.append(genes[i]);
            result.append(i < Config.GENES_QTY - 1 ? ", " : "");
        }
        result.append(")");
        return result.toString();
    }

    private static int getRandomCrossoverLine() {
        int line = GeneticAlgorithm.getRandomInt(0, Config.GENES_QTY - 2);
        GeneticAlgorithm.log("Линия скрещивания будет на позиции " + line);
        return line;
    }

    protected Object cloneChromosome() {
        Chromosome resultChromosome = new Chromosome();
        resultChromosome.setFitness(this.getFitness());
        resultChromosome.setSimilarity(this.getSimilarity());
        resultChromosome.setGenes(this.genes.clone());
        return resultChromosome;
    }
}