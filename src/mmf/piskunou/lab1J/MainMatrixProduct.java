package mmf.piskunou.lab1J;

import java.io.IOException;

/**
 * @author Yury Piskunou mmf-39
 * @since 15/09/19
 */

public class MainMatrixProduct {
    private static AlgorithmTester algorithmTesterWorst=new AlgorithmTester(new AlgorithmProductWorst());
    private static ProviderCSV providerCSVWorst=new ProviderCSV();

    private static AlgorithmTester algorithmTesterBest=new AlgorithmTester(new AlgorithmProductBest());
    private static ProviderCSV providerCSVBest=new ProviderCSV();

    public static void main(String args[]) {
        int iterations=5;
        algorithmTesterWorst.runner(iterations);
        algorithmTesterBest.runner(iterations);

        try {
            providerCSVWorst.convertToCSV(algorithmTesterWorst.getResult(),"");// suffix for separate files
            providerCSVBest.convertToCSV(algorithmTesterBest.getResult(), "");
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }
}
