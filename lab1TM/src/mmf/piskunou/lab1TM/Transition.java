package mmf.piskunou.lab1TM;


public class Transition
{
    public Transition(int initialState, char read, char write, HeadDirection headDirection, int nextState)
    {
        this.initialState = initialState;
        this.read = read;
        this.write = write;
        this.headDirection = headDirection;
        this.nextState = nextState;
    }

    private int initialState;
    public int getInitialState() { return initialState; }

    private char read;
    public char getRead() { return read; }

    private char write;
    public char getWrite() { return write; }

    private HeadDirection headDirection;
    public HeadDirection getHeadDirection() { return headDirection; }

    private int nextState;
    public int getNextState() { return nextState; }
}
