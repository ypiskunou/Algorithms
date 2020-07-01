package mmf.piskunou.lab4J;

import java.util.Scanner;
import java.util.Arrays;

public class Input {
    public int[] getArray() {
        return array;
    }
    private int[] array;

    public int[] getNumbersForBubble() {
        return numbersForBubble;
    }
    public int[] getNumbersForSelection() {
        return numbersForSelection;
    }
    private int[] numbersForBubble, numbersForSelection;
    private int n;


    public int getN() {
        return n;
    }

    public Input() {
        n = 100000;
        numbersForBubble = new int[n];
        numbersForSelection = new int[n];
        //Заполнение массивов целочисленными значениями от 0 до 100
        for(int i = 0; i < n; i++){
            numbersForBubble[i] = (int) (Math.random() * 100);
            numbersForSelection[i] = numbersForBubble[i];
        }
    }

    //Ускоренный алгоритм сортировки пузырьком
    public int[] SpeedSortBubble(int[] numbers, int k, boolean flag){
        while(flag){
            flag = false;
            for (int j = 0; j < numbers.length - k; j++)
                if(numbers[j] > numbers[j + 1]){
                    numbers[j] = numbers[j] + numbers[j + 1] - (numbers[j + 1] = numbers[j]);
                    flag = true;
                }
            k++;
        }
        return numbers;
    }

    //Сортировка вставками
    public int[] SortChoice(int[] numbers){
        for(int i = 1; i < numbers.length; i++)
            for(int j = i; j > 0 && numbers[j - 1] > numbers[j]; j--){
                numbers[j] = numbers[j] + numbers[j - 1] - (numbers[j - 1] = numbers[j]);
            }
        return numbers;
    }
}
