package mmf.piskunou.lab1J;

public class AlgorithmProductWorst implements Testable {
    static byte[][] matrix;

    public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
        Input input = new Input();
        matrix = input.runner(inputSize);
    }

    private int inputSize;

    public long runner(int iterations) {
        long start = System.currentTimeMillis();
        for (int k = 0; k < iterations; k++) {
            long product = 1;
            for (int i = 0; i < inputSize; i++)
                for (int j = 0; j < inputSize; j++) {
                    if (matrix[i][j] == 0) return (System.currentTimeMillis() - start);
                    product *= matrix[i][j];
                    if (product == 0)
                        product = matrix[0][0];
                }
        }
        return (System.currentTimeMillis() - start);
    }
}
