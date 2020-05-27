package JavaCommomClass.FilePractice;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        String separator = File.separator;
        //使用分隔符编译器自动识别系统，windows  //  ，Linux  \,   同时\两个系统都可以使用
        String filename = "testfile.txt";
        String filepath = "E:\\JavaCode\\JavaStudy2020\\JavaBasic\\src\\filePractice\\";
        String director = "mkdir1"+separator+"mkdir2";
        File file = new File(filepath+director,filename);
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        if(file.exists()){
            System.out.println("该文件已存在！");
            System.out.println("Filename is "+file.getAbsolutePath());
            System.out.println("File length :"+file.length());
        }else {
            file.getParentFile().mkdirs();
            try{
                file.createNewFile();
                System.out.println("创建文件成功！");
            }catch (IOException ioe){
                ioe.printStackTrace();
                System.out.println("创建文件失败！");
            }
        }
    }
}
