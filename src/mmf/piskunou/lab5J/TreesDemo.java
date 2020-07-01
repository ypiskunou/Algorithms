package mmf.piskunou.lab5J;

import mmf.piskunou.lab5J.tree.BinaryTree;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class TreesDemo {
    private static final int KEYS_ARRAY_SIZE = 15;
    private static final int KEY_MIN_VALUE = 0;
    private static final int KEY_MAX_VALUE = 140;

    public static void main(String[] args) {
        int userKey;

        int[] array = generateRandomArray(KEYS_ARRAY_SIZE, KEY_MIN_VALUE, KEY_MAX_VALUE);
        System.out.println("\nKeys Array:");
        System.out.println(Arrays.toString(array));

        System.out.println("\nBinary tree");
        System.out.println("Initial binary tree: ");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.print();

        binaryTree.insert(array[array.length / 2]);
        for (int key : array) {
            binaryTree.insert(key);
        }
        System.out.println("Binary tree built: ");
        binaryTree.print();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter key to find: ");
            userKey = scanner.nextInt();
            Optional<Integer> optionalProximityKey = binaryTree.searchByProximityFromAbove(userKey);
            if (optionalProximityKey.isPresent()) {
                System.out.println("Closest key above given: " + optionalProximityKey.get());
            } else {
                System.out.println("There is no closest key above given");
            }
        }
    }

    private static int generateInt(int minValue, int maxValue) {
        return (int)Math.round(Math.random() * (maxValue - minValue) + minValue);
    }

    private static int[] generateRandomArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateInt(minValue, maxValue);
        }
        return array;
    }
}
