package ioPractice.FileIO;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileOutputStream  out = null;
        File file = new File("fileTest.txt");
        try{
            out = new FileOutputStream("fileTest.txt");
        }catch (FileNotFoundException e){
            System.out.println("未找到文件！");
            e.printStackTrace();
            System.exit(-1);
        }
        byte []  outchars= {'w','h','b'};
        try{
            out.write(outchars);
            out.flush();
            out.close();

        }catch (IOException e){
            System.out.println("文件内容写入失败!");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
