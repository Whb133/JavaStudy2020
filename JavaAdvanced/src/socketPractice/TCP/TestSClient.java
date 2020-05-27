package socketPractice.TCP;

import java.io.*;
import java.net.Socket;

public class TestSClient {
    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket("127.0.0.1", 8000);
            System.out.println("链接建立成功！已链接至"+s.getInetAddress()+":"+s.getPort());
        } catch (IOException e) {
            System.out.println("链接建立异常！");
            e.printStackTrace();
        }
        new Thread(new CSend(s)).start();
        new Thread(new CReceive(s)).start();
    }
}


class CSend implements Runnable {

    Socket s;

    CSend(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br;
        PrintWriter pw;
        String cwords = null;
        Boolean flag = true;
        try {
            while (flag) {
                br = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(s.getOutputStream(), true);
                cwords = br.readLine();
                if (!cwords .equalsIgnoreCase("bye")){
                    pw.println("Client:"+cwords);
                }else {
                    pw.println("Server:" + cwords);
                    pw.flush();
                    flag = false;
                    System.out.println("链接正常断开！");
//                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.out.println("Client链接时异常！");
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                System.out.println("Client链接关闭异常！");
                e.printStackTrace();
            }
        }
    }
}

class CReceive implements Runnable {

    Socket s;

    CReceive(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br;
        String cwords = null;
        Boolean flag =true;
        try {
            while (flag) {
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                cwords = br.readLine();
                if (!cwords .equalsIgnoreCase("bye")) {
                    System.out.println(cwords);
                }else {
                    flag = false;
                    System.out.println("链接正常断开！");
//                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.out.println("Client链接时异常！");
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                System.out.println("Client关闭异常！");
                e.printStackTrace();
            }
        }
    }
}
