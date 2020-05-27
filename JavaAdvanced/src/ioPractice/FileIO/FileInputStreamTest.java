package ioPractice.FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream in = null;
        try {
            in = new FileInputStream("fileTest.txt");
        }catch (FileNotFoundException e){
            System.out.println("未找到文件！");
            e.printStackTrace();
            System.exit(-1);
        }
        int b = 0;
        long num = 0;
        try {
            while ((b=in.read()) != -1){
                num++;
                System.out.print((char) b+" ");
            }
            System.out.println();
            System.out.println("该文件共有"+num+"个字节");
        }catch (IOException e){
            System.out.println("文件读取失败！");
            System.exit(-1);
        }
    }
}
