package mmf.piskunou.lab1J;

import java.text.MessageFormat;
import java.util.ArrayList;

public class AlgorithmTester {
    public ArrayList<Integer> getResult() {
        return result;
    }
    private ArrayList<Integer> result = new ArrayList<>();

    private Testable algorithmToTest;

    AlgorithmTester(Testable algorithmToTest){
        this.algorithmToTest=algorithmToTest;
    }

    public void runner(int n) {
        int inputSize;
        int timeConsumed;
        int totalTimeConsumed=0;
        System.out.println(MessageFormat.format(" Finding the matrix elements products for {0} times... \n", n));
        System.out.print("[");
        StringBuilder temp=new StringBuilder();

        for (inputSize = 5000; inputSize <= 10000; inputSize += 200) {
            algorithmToTest.setInputSize(inputSize);
            timeConsumed=(int)algorithmToTest.runner(n);
            totalTimeConsumed+=timeConsumed;
            result.add(timeConsumed/n);
            System.out.print("|");
        }
        System.out.println("]  "+MessageFormat.format("Total calculation" +
                " time consumed: {0} ms   {1}", totalTimeConsumed, temp));
    }
}
