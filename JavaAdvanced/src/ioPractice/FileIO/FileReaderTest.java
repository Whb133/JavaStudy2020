package ioPractice.FileIO;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader in = null;
        try {
            in = new FileReader("fileTest.txt");

        }catch (FileNotFoundException e){
            System.out.println("未找到文件");
            e.printStackTrace();
            System.exit(-1);
        }
        long num = 0;
        int c = 0;
        try{
            while ((c=in.read()) != -1){
                num++;
                System.out.print((char)c);
            }
            in.close();
            System.out.println();
            System.out.println("该文件共有"+num+"个字符");
        }catch (IOException e){
            System.out.println("文件读取失败");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
