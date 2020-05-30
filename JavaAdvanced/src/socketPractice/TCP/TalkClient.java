package socketPractice.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TalkClient {
    public static void main(String[] args){
        Socket s= null;
        PrintWriter clientpw = null;
        BufferedReader clientbr = null;
        Scanner clientin = new Scanner(System.in);
        try {
            s = new Socket("127.0.0.1", 50000);

            clientbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            clientpw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            clientpw.println("Client:hello,Server!");
            clientpw.flush();
            String serverwords = null;
            String sysin =null;
            while (! "end".equalsIgnoreCase((serverwords=clientbr.readLine()))){
                System.out.println(serverwords);
                if (clientin.hasNext()){
                    sysin = clientin.nextLine();
                }
                clientpw.println("Client:"+sysin);
                clientpw.flush();
            }

            clientbr.close();
            clientin.close();
            clientpw.close();
            s.close();
            System.out.println("链接关闭");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
