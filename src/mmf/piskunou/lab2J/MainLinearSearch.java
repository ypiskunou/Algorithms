package mmf.piskunou.lab2J;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Yury Piskunou mmf-39
 * @since 15/09/19
 */

public class MainLinearSearch {
    public static void main(String[] args) {
        long end, start;
        char quit=' ';
        while(quit!='q') {
            Input input = new Input();
            start = System.nanoTime();
            int position = input.findWord();
            end = System.nanoTime();
            if (position == -1) {
                System.out.println("No suits");
            } else {
                System.out.println("Word was find at " + (position + 1) + "th position at sorted array!");
            }
            System.out.println("Linear search worked for " + ((double) (end - start) / 1000000) + " ms!");
            System.out.println("Enter q - to exit.");
            try {
                quit = new Scanner(System.in).nextLine().charAt(0);
            }
            catch(IndexOutOfBoundsException exc) {
            }

        }
    }
}

/**
 * 1. Разработать алгоритм и программу простого линейного поиска
 с  циклом  For.  В  качестве  исходных  данных  использовать  строку
 текста,  из  которой  необходимо  выделить  слова.  Аргумент  поиска  –
 слово.
 *
 * */