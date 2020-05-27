package socketPractice.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ContinuousServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            System.out.println(s.getInetAddress().getHostName()
                    + ".....connected");
            new Thread(new SendServerSocket(s)).start();
            new Thread(new ReceiveServerSocket(s)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SendServerSocket implements Runnable {
    private Socket s;

    public SendServerSocket(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter ps = null;
        try {
            while (true) {

                br = new BufferedReader(new InputStreamReader(System.in));
                ps = new PrintWriter(s.getOutputStream(), true);
                String line = br.readLine();
                if (line != null) {
                    ps.println("Server:" + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ReceiveServerSocket implements Runnable {
    private Socket s;

    public ReceiveServerSocket(Socket s) {
        super();
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            while (true) {

                br = new BufferedReader(new InputStreamReader(
                        s.getInputStream()));
                String line = br.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}