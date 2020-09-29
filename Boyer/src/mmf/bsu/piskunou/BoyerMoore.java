package mmf.bsu.piskunou;

import java.util.ArrayList;

public class BoyerMoore {
    private int[] offset;
    private String pattern;
    private static final String WORD = "abcab";
    private static final String TEXT = "abcabcababcababcababcac";

    BoyerMoore(String pattern) {
        this.pattern = pattern;
        int M = pattern.length();
        int R = 256;
        offset = new int[R];
        for(int c = 0; c < R; c++)
            offset[c] = -1;
        for (int j = 0; j < M; j++)
            offset[pattern.charAt(j)] = j;
    }

    public void search(String txt) {
        String txtCopy = txt;
        int N = txt.length(), M = pattern.length();
        ArrayList<int[]> array = new ArrayList<>();
        for (int i = 0, skip; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M-1; j >= 0; j--)
                if (pattern.charAt(j) != txt.charAt(i + j)) {
                    skip = j - offset[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            if(skip == 0) {
                int[] tmp = new int[2];
                tmp[0] = i + M * array.size();
                tmp[1] = i + M * (array.size() + 1);
                array.add(tmp);
                txt = txt.substring(0, i) + txt.substring(i + M, N);
                N -= M;
            }
        }
        printAllEntry(array, txtCopy);
    }

    public void printAllEntry(ArrayList<int[]> array, String txt) {
        String result = txt;
        for (int i = array.size() - 1; i >= 0; i--) {
            result = result.substring(0, array.get(i)[1]) + ")" + result.substring(array.get(i)[1]);
            result = result.substring(0, array.get(i)[0]) + "(" + result.substring(array.get(i)[0]);
        }
        System.out.println(result);
        System.out.println("Количество вхождений: " + array.size());
    }

    public static void main(String[] arg) {
        BoyerMoore test = new BoyerMoore(WORD);
        test.search(TEXT);
    }
}
