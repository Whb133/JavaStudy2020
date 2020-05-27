package ioPractice.FileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileReader in = null;
        FileWriter out = null;
        try {
            in =  new FileReader("E:\\Java_Programs\\src\\iopratice\\FileCopy.java");
            out = new FileWriter("E:\\Java_Programs\\fileTest.txt");
            int c= 0;
            while ((c = in.read()) != -1){
                out.write(c);
            }
            out.flush();
            out.close();
        }catch (FileNotFoundException e){
            System.out.println("文件未找到！");
            System.exit(-1);
        }catch (IOException e1){
            System.out.println("复制文件时出错！");
            System.exit(-1);
        }
        System.out.println("文件复制！");
    }
}
