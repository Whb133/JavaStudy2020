package ioPractice.PrintIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamT {
    public static void main(String[] args) {
        PrintStream ps = null;
        try{
            ps = new PrintStream(new FileOutputStream("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\ioPractice\\ioDocs\\hello.txt"));

            System.setOut(ps);
            System.out.println("nihao");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            ps.close();
        }
    }
}
