package mmf.piskunou.lab3J;
/**
 * @author Yury Piskunou mmf-39
 * @since 15/09/19
 *//*

/*
9.Разработать следующий алгоритм и программу с использованием рекурсии.
Ввод одномерного массива и линейного поиска целочисленного значения ключа в нем.
*/

import java.util.Scanner;

public class MainLinearSearchRecursive {
    public static void main(String[] args) {
        Input input = new Input();
        System.out.print("Enter digit to find: ");
        int number = (new Scanner(System.in)).nextInt();

        long start;
        start = System.nanoTime();
        int result = input.LinearSearchRecursive(input.getArray(),0, input.getArray().length - 1, number);
        System.out.println("Search has been working for " +
                ((double) (System.nanoTime() - start) / 1000000) + " ms!");
        System.out.println(result == -1 ? "It can't find number!" : "Number been found: " + result);
    }
}
