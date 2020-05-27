package socketPractice.UDP;

import java.io.IOException;
import java.net.*;

public class SimpleUDPClient {
    public static void main(String[] args) {

        byte[] words = "hello,udp".getBytes();
        DatagramPacket dp = new DatagramPacket(words,words.length,new InetSocketAddress("127.0.0.1",8888));
        try {
            DatagramSocket ds = new DatagramSocket(9999);
            ds.send(dp);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
