package ioPractice.ioCodes.Fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterT {
    /*
    从内存中写出数据到硬盘的文件里。
    说明:
    1.输出操作，对应的File可以不存在的。并不会报异常
    2.
        File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
        File.对应的硬盘中的文件如果存在:
        如果流使用的构造器是: Filewriter(file,false) / FileWriter(file):对原有文件的覆盖。
        如果流使用的构造器是: Filewriter(file, true):不会对原有文件覆盖，而是在原有文件末尾追加内容。

    * */
    public static void main(String[] args) {

        File file = new File("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\ioPractice\\ioDocs\\hello.txt");
        FileWriter fw = null;
        try{
            fw = new FileWriter(file,true);
            fw.write("hello");
            fw.write("qwert");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
