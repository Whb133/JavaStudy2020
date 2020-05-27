package ioPractice.TransformsIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            while (s != null) {
                if (!s.equalsIgnoreCase("exit")) {
                    System.out.println(s.toUpperCase());
                } else {
                    break;
                }
                s = br.readLine();
            }
            br.close();
        } catch (IOException ioe) {

        }
    }
}
