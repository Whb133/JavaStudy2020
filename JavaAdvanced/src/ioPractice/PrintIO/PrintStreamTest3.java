package ioPractice.PrintIO;

import java.io.*;
import java.util.Date;

public class PrintStreamTest3 {
    public static void main(String[] args) {
        PrintStream ps = null;
        String s = null;
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream("log.txt",true);
            ps = new PrintStream(fos);

            while ((s = br.readLine()) != null){
                if(!"exit".equalsIgnoreCase(s)){
                    System.out.println(s.toUpperCase());
                    ps.println("---"+s+"---");
                }else {
                    break;
                }
            }
            ps.print("-----"+new Date()+"-----");
            br.close();
            ps.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
