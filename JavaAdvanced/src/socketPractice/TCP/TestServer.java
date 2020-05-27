package socketPractice.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(8000);
        } catch (IOException e) {
            System.out.println("服务端端口异常！");
            e.printStackTrace();
        }
        try {
            s = ss.accept();
            System.out.println(s.getInetAddress()+":"+s.getPort()+"已连接，链接建立成功！");
        } catch (IOException e) {
            System.out.println("连接建立异常！");
            e.printStackTrace();
        }
        new Thread(new SSend(s)).start();
        new Thread(new SReceive(s)).start();
    }
}

class SSend implements Runnable {

    Socket s;

    SSend(Socket s) {
        this.s = s;
    }

    public void run() {
        BufferedReader br;
        PrintWriter pw;
        String swords = null;
        Boolean flag = true;
        try {
            while (flag) {
                br = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                swords = br.readLine();
                if (!swords .equalsIgnoreCase("bye")) {
                    pw.println("Server:" + swords);
                    pw.flush();
                }else {
                    pw.println("Server:" + swords);
                    pw.flush();
                    flag = false;
                    System.out.println("链接正常断开！");
//                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.out.println("链接时异常！");
            e.printStackTrace();
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (IOException e) {
                System.out.println("链接关闭异常！");
                e.printStackTrace();
            }
        }
    }
}

class SReceive implements Runnable {

    Socket s;

    SReceive(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br;
        String swords = null;
        Boolean flag = true;
        try {
            while (flag) {
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                swords = br.readLine();
                if (!swords .equalsIgnoreCase("bye")) {
                    System.out.println(swords);
                }else {
                    flag = false;
                    System.out.println("链接正常断开！");
//                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}