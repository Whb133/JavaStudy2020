package ioPractice.BufferedIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamTest {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("fileTest.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            int c = 0;
            while ( (c = bis.read()) != -1){
                System.out.print((char) c);
            }
            bis.close();
        }catch (FileNotFoundException e){
            System.out.println("文件未找到！");
            e.printStackTrace();
        }catch (IOException ioe){
            System.out.println("读取失败！");
            ioe.printStackTrace();
        }
    }
}
