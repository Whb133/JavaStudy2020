package socketPractice.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SimpleUDPServer {
    public static void main(String[] args) {

        byte[] words = new byte[1024];
        DatagramPacket dp = new DatagramPacket(words,words.length);
        DatagramSocket ds = null;
        try {
             ds = new DatagramSocket(8888);

        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                ds.receive(dp);
                System.out.println(new String(words, 0, dp.getLength()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
