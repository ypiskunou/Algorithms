package mmf.piskunou.lab1J;

import java.io.*;
import java.util.ArrayList;

class ProviderCSV {

    private int numberOfStrings(File file) throws IOException{
        int lineNumber = 0;
        try{
            FileReader fileReader = new FileReader(file);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            while (lineNumberReader.readLine() != null){
                lineNumber++;
            }
        }
        catch (FileNotFoundException exc){
            exc.printStackTrace();
        }
        return lineNumber;
    }

    public void convertToCSV(ArrayList<Integer> data, String classSuffix) throws IOException{
        File file = new File("test" + classSuffix + ".csv");
        FileWriter fw = new FileWriter(file, numberOfStrings(file)==1);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Integer aData : data) {
            bw.append(String.valueOf(aData)).append(";");
        }
        bw.append("\n");

        bw.close();
        fw.close();
    }
}
