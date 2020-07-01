package mmf.piskunou.lab1TM;
import java.util.ArrayList;

public class Head {
    public static final char BLANK = '_';

    public Head(ArrayList<Character> tape, int headPosition)
    {
        if (tape == null) throw new NullPointerException();

        if (headPosition > tape.size() - 1 || headPosition < 0)
            throw new IndexOutOfBoundsException("\n Invalid head position ");

        this.tape = tape;
        this.headPosition = headPosition;
    }

    private ArrayList<Character> tape;
    public ArrayList<Character> getTape() { return tape; }

    private int headPosition;
    public int getHeadPosition() { return headPosition; }

    public Head Write(char head) {
        tape.set(headPosition, head);
        return new Head(tape, headPosition);
    }

    public Head MoveLeft() {
        if (headPosition == 0)
        {
            tape.add(0, BLANK);
            return new Head(tape, 0);
        }
        return new Head(tape, headPosition-1);
    }

    public Head MoveRight() {
        if (headPosition == tape.size()-1)
        {
            tape.add(headPosition+1, BLANK);
            return new Head(tape, headPosition+1);
        }
        return new Head(tape, headPosition+1);
    }

    public Head Move(HeadDirection direction)
    {
        switch (direction)
        {
            case Left:
                return MoveLeft();
            case NoMove:
                return this;
            case Right:
                return MoveRight();
            default:
                throw new IllegalArgumentException(direction.name());
        }
    }

    public char Read()
    {
        return tape.get(headPosition);
    }

    public @Override String toString() {
        StringBuilder tapeBuilder = new StringBuilder(" Tape: ");
        if(tape!= null)
            for (char c: tape)
                tapeBuilder.append(c);
        return tapeBuilder.toString();
    }

}
