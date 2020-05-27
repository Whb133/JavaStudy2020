package socketPractice.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class CommunicateClient {
    public static void main(String[] args) {
        Socket s = null;
        BufferedReader cbr =null;
        BufferedWriter cbw = null;
        try{
            s = new Socket("127.0.0.1",10000);
            cbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(cbr.readLine());

            cbw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            cbw.write("Client:你好！服务端\r\n");
            cbw.flush();
            cbw.close();
            cbr.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println(new Date());
        }

    }

}
