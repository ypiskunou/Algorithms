package mmf.piskunou.lab1TM;

import java.util.ArrayList;
import java.util.Collections;

public class TuringProgram {
    public static ArrayList<Transition> addition = new ArrayList<>();
    public static ArrayList<Transition> binaryIncrement = new ArrayList<>();
    public static ArrayList<Transition> inversePenta = new ArrayList<>();
    static {
        Collections.addAll
                (
                        addition,
                        new Transition(0, Head.BLANK, Head.BLANK, HeadDirection.Right, 0),
                        new Transition(0, '1', '1', HeadDirection.Right, 1),
                        new Transition(1, Head.BLANK, '1', HeadDirection.Right, 2),
                        new Transition(1, '1', '1', HeadDirection.Right, 1),
                        new Transition(2, Head.BLANK, Head.BLANK, HeadDirection.Left, 3),
                        new Transition(2, '1', '1', HeadDirection.Right, 2),
                        new Transition(3, Head.BLANK, Head.BLANK, HeadDirection.NoMove, State.STOP.ordinal()),
                        new Transition(3, '1', Head.BLANK, HeadDirection.NoMove, State.STOP.ordinal())
                );
        Collections.addAll
                (
                        binaryIncrement,
                        new Transition(0, '0', '0', HeadDirection.Right, 1),
                        new Transition(0, '1', '1', HeadDirection.Right, 1),
                        new Transition(0, Head.BLANK, Head.BLANK, HeadDirection.Right, 0),
                        new Transition(1, '0', '0', HeadDirection.Right, 1),
                        new Transition(1, '1', '1', HeadDirection.Right, 1),
                        new Transition(1, Head.BLANK, Head.BLANK, HeadDirection.Left, 2),
                        new Transition(2, '0', '1', HeadDirection.NoMove, State.STOP.ordinal()),
                        new Transition(2, '1', '0', HeadDirection.Left, 2),
                        new Transition(2, Head.BLANK, '1', HeadDirection.NoMove, State.STOP.ordinal())
                );
        Collections.addAll
                (
                        inversePenta,
                        new Transition(0, '0', '0', HeadDirection.Right, 0),
                        new Transition(0, '1', '1', HeadDirection.Right, 0),
                        new Transition(0, '2', '2', HeadDirection.Right, 0),
                        new Transition(0, '3', '3', HeadDirection.Right, 0),
                        new Transition(0, '4', '4', HeadDirection.Right, 0),
                        new Transition(0, Head.BLANK, '5', HeadDirection.Left, 1),
                        new Transition(1, '0', '5', HeadDirection.Right, 6),
                        new Transition(1, '1', '5', HeadDirection.Right, 2),
                        new Transition(1, '2', '5', HeadDirection.Right, 3),
                        new Transition(1, '3', '5', HeadDirection.Right, 4),
                        new Transition(1, '4', '5', HeadDirection.Right, 5),
                        new Transition(2, '0', '0', HeadDirection.Right, 2),
                        new Transition(2, '1', '1', HeadDirection.Right, 2),
                        new Transition(2, '2', '2', HeadDirection.Right, 2),
                        new Transition(2, '3', '3', HeadDirection.Right, 2),
                        new Transition(2, '4', '4', HeadDirection.Right, 2),
                        new Transition(2, '5', '5', HeadDirection.Right, 2),
                        new Transition(2, Head.BLANK, '1', HeadDirection.Left, 7),
                        new Transition(3, '0', '0', HeadDirection.Right, 3),
                        new Transition(3, '1', '1', HeadDirection.Right, 3),
                        new Transition(3, '2', '2', HeadDirection.Right, 3),
                        new Transition(3, '3', '3', HeadDirection.Right, 3),
                        new Transition(3, '4', '4', HeadDirection.Right, 3),
                        new Transition(3, '5', '5', HeadDirection.Right, 3),
                        new Transition(3, Head.BLANK, '2', HeadDirection.Left, 7),
                        new Transition(4, '0', '0', HeadDirection.Right, 4),
                        new Transition(4, '1', '1', HeadDirection.Right, 4),
                        new Transition(4, '2', '2', HeadDirection.Right, 4),
                        new Transition(4, '3', '3', HeadDirection.Right, 4),
                        new Transition(4, '4', '4', HeadDirection.Right, 4),
                        new Transition(4, '5', '5', HeadDirection.Right, 4),
                        new Transition(4, Head.BLANK, '3', HeadDirection.Left, 7),
                        new Transition(5, '0', '0', HeadDirection.Right, 5),
                        new Transition(5, '1', '1', HeadDirection.Right, 5),
                        new Transition(5, '2', '2', HeadDirection.Right, 5),
                        new Transition(5, '3', '3', HeadDirection.Right, 5),
                        new Transition(5, '4', '4', HeadDirection.Right, 5),
                        new Transition(5, '5', '5', HeadDirection.Right, 5),
                        new Transition(5, Head.BLANK, '4', HeadDirection.Left, 7),
                        new Transition(6, '0', '0', HeadDirection.Right, 6),
                        new Transition(6, '1', '1', HeadDirection.Right, 6),
                        new Transition(6, '2', '2', HeadDirection.Right, 6),
                        new Transition(6, '3', '3', HeadDirection.Right, 6),
                        new Transition(6, '4', '4', HeadDirection.Right, 6),
                        new Transition(6, '5', '5', HeadDirection.Right, 6),
                        new Transition(6, Head.BLANK, '0', HeadDirection.Left, 7),
                        new Transition(7, '0', '0', HeadDirection.Left, 7),
                        new Transition(7, '1', '1', HeadDirection.Left, 7),
                        new Transition(7, '2', '2', HeadDirection.Left, 7),
                        new Transition(7, '3', '3', HeadDirection.Left, 7),
                        new Transition(7, '4', '4', HeadDirection.Left, 7),
                        new Transition(7, '5', '5', HeadDirection.Left, 8),
                        new Transition(7, Head.BLANK, Head.BLANK, HeadDirection.Right, 9),
                        new Transition(8, '0', '0', HeadDirection.NoMove, 1),
                        new Transition(8, '1', '1', HeadDirection.NoMove, 1),
                        new Transition(8, '2', '2', HeadDirection.NoMove, 1),
                        new Transition(8, '3', '3', HeadDirection.NoMove, 1),
                        new Transition(8, '4', '4', HeadDirection.NoMove, 1),
                        new Transition(8, '5', '5', HeadDirection.Left, 8),
                        new Transition(8, '_', '_', HeadDirection.Right, 9),
                        new Transition(9, '0', '0', HeadDirection.NoMove, State.STOP.ordinal()),
                        new Transition(9, '1', '1', HeadDirection.NoMove, State.STOP.ordinal()),
                        new Transition(9, '2', '2', HeadDirection.NoMove, State.STOP.ordinal()),
                        new Transition(9, '3', '3', HeadDirection.NoMove, State.STOP.ordinal()),
                        new Transition(9, '4', '4', HeadDirection.NoMove, State.STOP.ordinal()),
                        new Transition(9, '5', Head.BLANK, HeadDirection.Right, 9)
                );
    }
}