package ioPractice.ioCodes.Fileio;

import java.io.*;

public class FileReaderT {
    /*
    * 说明点:
    1. read()的理解: 返回读入的一一个字符。如果达到文件末尾，返回-1
    2.异常的处理:为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3.读入的文件一定要存在，否则就会报FiLeNotFoundException.|

    * */
    public static void main(String[] args) {
        File file = new File("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\ioPractice\\ioDocs\\hello.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            int data;
            String str;
//            while (( data = fr.read()) != -1){
//                System.out.print((char) data);
//            }
            while (( str = br.readLine()) != null){
                System.out.print(str);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fr != null){
                try{
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
