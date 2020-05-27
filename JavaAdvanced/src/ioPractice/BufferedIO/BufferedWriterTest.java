package ioPractice.BufferedIO;

import java.io.*;

public class BufferedWriterTest {
    public static void main(String[] args) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("fileTest.txt"));
            BufferedReader br = new BufferedReader(new FileReader("fileTest.txt"));
            for(int i =0 ;i < 50 ; i++){
                bw.write(String.valueOf(Math.random()));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            String  line = null;
            while ( (line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        }catch (IOException ioe){
            System.out.println("Failed!");
        }
    }
}
