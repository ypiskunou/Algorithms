package mmf.piskunou.lab1TM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainTuringMachine {
    public static void main(String args[]) {

        try {
            MainTuringMachine.addTwoNumbers();
            MainTuringMachine.binaryIncrement();
            MainTuringMachine.inversePenta();
        }
        catch (IndexOutOfBoundsException | NullPointerException | IllegalArgumentException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }

    private static void addTwoNumbers() {
        System.out.println(" \nAdding uni. ");
        final String expected = " Tape expected: 11111__ ";
        ArrayList<Character> tape = new ArrayList<>();
        Collections.addAll(tape, '1', '1', '1', Head.BLANK, '1', '1');
        TuringMachine turingMachine = new TuringMachine(State.WORK.ordinal(), new Head(tape, 0),
                TuringProgram.addition);

        TuringMachine result = turingMachine.Run();
        System.out.println(result.getHead().toString());
        System.out.println(expected);
    }

    private static void binaryIncrement() {
        System.out.println(" \nBinary Increment. ");
        final String expected = " Tape expected: 1100_ ";
        ArrayList<Character> tape = new ArrayList<>();
        Collections.addAll(tape, '1', '0', '1', '1');
        TuringMachine turingMachine = new TuringMachine(State.WORK.ordinal(), new Head(tape, 0),
                TuringProgram.binaryIncrement);

        TuringMachine result = turingMachine.Run();
        System.out.println(result.getHead().toString());
        System.out.println(expected);
    }

    private static void inversePenta() {
        System.out.println(" \nAdding Penta. ");
        final String expected = " Tape expected: 2413 ";
        ArrayList<Character> tape = new ArrayList<>();
        Collections.addAll(tape, '3', '1', '4', '2');
        TuringMachine turingMachine = new TuringMachine(State.WORK.ordinal(), new Head(tape, tape.size() - 1),
                TuringProgram.inversePenta);

        TuringMachine result = turingMachine.Run();
        System.out.println(result.getHead().toString());
        System.out.println(expected);
    }
}
