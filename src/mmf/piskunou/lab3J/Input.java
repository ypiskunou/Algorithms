package mmf.piskunou.lab3J;

import java.util.Scanner;
import java.util.Arrays;

public class Input {
    public int[] getArray() {
        return array;
    }

    private int[] array;

    public Input() {
        System.out.print("Enter array's size: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i + 1) + " number to array: ");
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
    }

    public int LinearSearchRecursive(int[] array, int first, int last, int num) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (array[mid] == num)
                return array[mid];
            if (array[mid] > num)
                return LinearSearchRecursive(array, first, mid - 1, num);
            return LinearSearchRecursive(array, mid + 1, last, num);
        }
        return -1;
    }
}
