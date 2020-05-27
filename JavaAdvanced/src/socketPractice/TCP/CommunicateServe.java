package socketPractice.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class CommunicateServe {
    public static void main(String[] args){
        ServerSocket ss = null;
        Socket s= null;
        BufferedWriter sbw = null;
        BufferedReader sbr = null;
        try {
           ss = new ServerSocket(10000);

        } catch (IOException e) {
            System.out.println("服务端创建失败！");
            e.printStackTrace();
        }
        try{
            s = ss.accept();
            sbw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            sbw.write("Server:链接已经建立！\r\n");
            sbw.flush();

//            PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
//            pw.write("123\r\n");
////            pw.println("123");
//            pw.flush();


            sbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(sbr.readLine());

            sbw.close();
            sbr.close();
            s.close();
        }catch(IOException ioe){
            System.out.println("服务端链接失败！");
            ioe.printStackTrace();
            System.out.println(new Date());
        }

    }
}
