package mmf.piskunou.lab1TM;

import java.util.ArrayList;
import java.util.Collections;

public class MainTuringMachine {
    public static void main(String args[]) {

        MainTuringMachine.AddTwoNumbers();
        MainTuringMachine.BinaryIncrement();
        MainTuringMachine.InversePenta();
    }

    public static void AddTwoNumbers() {
        System.out.println(" \nAdding uni. ");
        final String expected = " Tape expected: 11111__ ";
        ArrayList<Character> tape = new ArrayList<Character>();
        Collections.addAll(tape, '1','1','1', Head.BLANK, '1','1');
        TuringMachine turingMachine = new TuringMachine(State.WORK.ordinal(), new Head(tape, 0),
                TuringProgram.addition);

        TuringMachine result = turingMachine.Run();
        System.out.println(result.getHead().toString());
        System.out.println(expected);
    }

    public static void BinaryIncrement() {
        System.out.println(" \nBinary Increment. ");
        final String expected = " Tape expected: 1100_ ";
        ArrayList<Character> tape = new ArrayList<Character>();
        Collections.addAll(tape, '1','0','1', '1');
        TuringMachine turingMachine = new TuringMachine(State.WORK.ordinal(), new Head(tape, 0),
                TuringProgram.binaryIncrement);

        TuringMachine result = turingMachine.Run();
        System.out.println(result.getHead().toString());
        System.out.println(expected);
    }

    public static void InversePenta() {
        System.out.println(" \nAdding Penta. ");
        final String expected = " Tape expected: 2413 ";
        ArrayList<Character> tape = new ArrayList<Character>();
        Collections.addAll(tape, '3','1','4', '2');
        TuringMachine turingMachine = new TuringMachine(State.WORK.ordinal(), new Head(tape, tape.size()-1),
                TuringProgram.inversePenta);

        TuringMachine result = turingMachine.Run();
        System.out.println(result.getHead().toString());
        System.out.println(expected);
    }
}
