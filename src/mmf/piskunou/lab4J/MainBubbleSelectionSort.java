package mmf.piskunou.lab4J;
/**
 * @author Yury Piskunou mmf-39
 * @since 15/09/19
 *//*

/*
9. Составить две программы, которые реализуют алгоритмы
ускоренной сортировки «пузырьком» и выбором. Исходные данные
задавать с помощью датчика случайных чисел.
*/

public class MainBubbleSelectionSort {
    public static void main(String[] args) {
        Input input = new Input();
        long start, end;
        start = System.nanoTime();
        /*int[] resultOne =*/
        input.SpeedSortBubble(input.getNumbersForBubble(), 1, true);
        end = System.nanoTime();
        System.out.println("Quick bubble sort with " + input.getN()
                        + " elements worked for " + ((double) (end - start) / 1000000000) + " seconds!");
        start = System.nanoTime();
        /*int[] resultTwo =*/
        input.SortChoice(input.getNumbersForSelection());
        end = System.nanoTime();
        System.out.println("Algorithm with selection out from " + input.getN()
                        + " elements worked " + ((double) (end - start) / 1000000000) + " seconds!");
    }
}
