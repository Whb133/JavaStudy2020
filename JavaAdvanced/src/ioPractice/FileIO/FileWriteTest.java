package ioPractice.FileIO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
    public static void main(String[] args) {
        FileWriter out = null;
        try{
            out = new FileWriter("fileTest.txt");
        }catch (IOException e){
            System.out.println("未找到文件");
            e.printStackTrace();
            System.exit(-1);
        }
        try{
            out.write("qwertyu");
            out.flush();
            out.close();
        }catch (IOException e){
            System.out.println("文件写入失败");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
