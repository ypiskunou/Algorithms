package mmf.piskunou.lab1TM;

import java.util.ArrayList;

public class TuringMachine {
    TuringMachine(int state, Head head, ArrayList<Transition> turingProgram) throws IllegalArgumentException{
        if (head == null) throw new IllegalArgumentException(head.getClass().getName());
        if (turingProgram == null) throw new IllegalArgumentException(turingProgram.getClass().getTypeName());

        this.state = state;
        this.head = head;
        this.turingProgram = turingProgram;
    }

    private int state;
    public int getState() {
        return state;
    }

    private Head head;
    public Head getHead() {
        return head;
    }

    private ArrayList<Transition> turingProgram;
    public ArrayList<Transition> getTuringProgram() {
        return turingProgram;
    }

    private TuringMachine Step() {
        if (state < State.WORK.ordinal()) return this;

        Transition transition = new Transition(State.WORK.ordinal(), Head.BLANK,
                head.Read(), HeadDirection.NoMove, State.ERROR.ordinal());
        for(Transition t: turingProgram)
        {
            if(t.getInitialState()==state && t.getRead() == head.Read()) {
                transition = t;
                break;
            }
        }

        return new TuringMachine(transition.getNextState(),
                head.Write(transition.getWrite()).Move(transition.getHeadDirection()), turingProgram);
    }

    public TuringMachine Run() {
        TuringMachine turingMachine = this;
        while (turingMachine.state >= State.WORK.ordinal())
            turingMachine = turingMachine.Step();

        return turingMachine;
    }
}