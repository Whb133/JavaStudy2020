package ioPractice.DataIO;

import java.io.*;

public class DataInputStreamTest {
    public static void main(String[] args) {
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeDouble(Math.random());
            dos.writeBoolean(true);
            dos.writeInt(10);
            System.out.println(baos.size());

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(bais.available());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readInt());

            dos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
