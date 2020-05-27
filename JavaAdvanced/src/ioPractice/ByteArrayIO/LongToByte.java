package ioPractice.ByteArrayIO;

import java.io.*;

public class LongToByte {
    public static void main(String[] args) {
        Long data = 8888888L;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeLong(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] databytes = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(databytes);
        DataInputStream dis = new DataInputStream(bais);
        try {
            System.out.println(dis.readLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
