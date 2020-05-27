package ioPractice.ioCodes.File;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {

//        ConstructorTest();

//        listFiles1(new File("E:\\JavaCode\\JavaStudy2020"));

//        listFiles2(new File("E:\\JavaCode\\JavaStudy2020"));

        reName();
    }

    static void ConstructorTest(){
        /*
        * 非真实的磁盘文件，只存在于内存层面
        * */

        //构造器1
        File file1 = new File("hello.txt");//相对路径：
        File file2 = new File("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\ioPractice\\ioCodes\\File\\hello.txt");//绝对路径
        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\ioPractice\\ioCodes", "filetest");
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3, "hq.txt");
        System.out.println(file4);
    }

    static void  listFiles1(File file){
        String[] files = file.list();
        for (String s : files){
            System.out.println(s);
        }
    }

    static void  listFiles2(File file){
        File[] files = file.listFiles();
        for (File s : files){
            System.out.println(s);
        }
    }

    static void reName(){
        //把文件重命名为指定的文件路径（内容复制）
        File file = new File("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\ioPractice\\ioCodes\\File\\hello.txt");
        File file1 = new File("E:\\io.txt");
        System.out.println(file.renameTo(file1));
    }
}
