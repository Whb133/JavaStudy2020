package ioPractice.TransformsIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterTest {
    public static void main(String[] args) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream("fileTest.txt"));
            osw.write("qwertyuiop");
            System.out.println(osw.getEncoding());
            osw.close();

            osw = new OutputStreamWriter(new FileOutputStream("fileTest.txt",true),"ISO8859_1");
            osw.write("qwertyuiop");
            System.out.println(osw.getEncoding());
            osw.close();
        }catch (FileNotFoundException e){
            System.out.println("未找到文件");
        }catch (IOException ioe){
            System.out.println("文件写入错误");
        }
    }
}
