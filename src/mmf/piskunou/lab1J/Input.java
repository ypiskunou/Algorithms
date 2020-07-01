package mmf.piskunou.lab1J;
/** n is in range from 5000 to 10000*/

public class Input {

    public byte[][] runner(int n){
        return randomMatrix(n);
    }

    private byte[][] randomMatrix(int n) { // random data from -n to n
        byte[][] result = new byte[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = (byte)(Math.random()*10+10);
        return result;
    }
}
