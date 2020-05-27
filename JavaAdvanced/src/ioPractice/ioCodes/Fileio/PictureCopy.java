package ioPractice.ioCodes.Fileio;

import java.io.*;

public class PictureCopy {
    /*
    字符流不能复制图片音频等文件，只有字节流可以复制
    * */
    public static void main(String[] args) {
        File file = new File("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\ioPractice\\ioDocs\\f123.png");
        File file1 = new File("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\ioPractice\\ioDocs\\f1234.png");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int len;
        byte[] bytebuf = new byte[10];
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            while ((len = fis.read(bytebuf)) != -1){

                fos.write(bytebuf,0,len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
