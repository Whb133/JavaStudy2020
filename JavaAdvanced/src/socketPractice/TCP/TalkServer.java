package socketPractice.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TalkServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        PrintWriter serverpw = null;
        BufferedReader serverbr = null;
        Scanner serverin = new Scanner(System.in);;
        try {
            ss = new ServerSocket(50000);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("服务端链接出错！");
        }
        try {
            s = ss.accept();

            serverbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            serverpw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            String clientwords = null;
            while (! "end".equalsIgnoreCase((clientwords=serverbr.readLine()))){
                System.out.println(clientwords);
                String sysin = null;
                if (serverin.hasNext()){
                    sysin = serverin.nextLine();
                }
                serverpw.println("Server:"+sysin);
                serverpw.flush();
            }
            serverbr.close();
            serverpw.close();
            serverin.close();
            s.close();
            System.out.println("链接关闭！");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("服务器异常！");
        }
    }
}
