package ioPractice.PrintIO;

import java.io.*;

public class PrintStreamTest2 {
    public static void main(String[] args) {
        list("PrintStreamTest1.java",System.out);
    }
    public static void list(String filename, PrintStream pw){
        try {
            FileReader fos = new FileReader(filename);
            BufferedReader br = new BufferedReader(fos);
            String s =null;
            while ((s= br.readLine()) != null){
                pw.print(s);
            }
            br.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
