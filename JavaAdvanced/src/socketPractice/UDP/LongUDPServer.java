package socketPractice.UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class LongUDPServer {
    public static void main(String[] args) {
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf,buf.length);
        try {
            DatagramSocket ds = new DatagramSocket(10000);
            ds.receive(dp);
            ByteArrayInputStream bais = new ByteArrayInputStream(buf,0,dp.getLength());
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readLong());

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
