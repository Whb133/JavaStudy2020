package socketPractice.TCP;

import java.io.*;
import java.net.Socket;

public class ContinuousClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            new Thread(new SendSocket(s)).start();
            new Thread(new ReceiveSocket(s)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReceiveSocket implements Runnable {
    private Socket s;

    public ReceiveSocket(Socket s) {
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

class SendSocket implements Runnable {
    private Socket s;

    public SendSocket(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            while (true) {

                br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter ps = new PrintWriter(s.getOutputStream(), true);
                String line = br.readLine();
                ps.println("Client:" + line);
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