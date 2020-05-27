package Java9.Codes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamP {
    public static void main(String[] args) {
        ClassLoader classLoader = InputStreamP.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("helloin.txt");
             OutputStream os = new FileOutputStream("E:\\JavaCode\\JavaStudy2020\\Java9_10_11\\src\\helloout.txt")) {
//            if (is!=null){
//                System.out.println(1);
//            }
//            if (os!=null){
//                System.out.println(2);
//            }
            is.transferTo(os); //把输入流中的所有数据直接自动地复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
