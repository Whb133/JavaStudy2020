package ioPractice.PrintIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest1 {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("fileTest.txt");
            ps = new PrintStream(fos);
            if (ps != null) {
                System.setOut(ps);
            }
            for (int i = 0; i < 50; i++) {
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
