package socketPractice.TCP;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        DataOutputStream dos = null;
        try {
            Socket s= new Socket("127.0.0.1",6000);

//            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//            bw.write("hello serve! i am client");
//            bw.flush();
//            bw.close();
            dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("hello serve! i am client");

            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(br.readLine());


            br.close();
            dos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
