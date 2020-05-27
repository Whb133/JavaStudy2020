package socketPractice.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServe {
    public static void main(String[] args) {

        BufferedWriter bw = null;
        DataInputStream dis = null;
        try {
            ServerSocket ss = new ServerSocket(6000);

            Socket s = ss.accept();

//            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            System.out.println(br.readLine());
//            br.close();
            dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());

            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write("hello" + s.getInetAddress() + "：" + s.getPort() + " goodbye!");
            bw.flush();
            bw.close();
            dis.close();
            ss.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
