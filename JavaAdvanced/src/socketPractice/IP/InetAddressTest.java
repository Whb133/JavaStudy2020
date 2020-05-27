package socketPractice.IP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress inet1;
        InetAddress inet2;
        InetAddress inet3;
        InetAddress inet4;


        try {
            inet1 = InetAddress.getByName("192.168.0.1");
            System.out.println(inet1);

            inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());

            inet3 = InetAddress.getByName("localhost");
            System.out.println(inet3);

            inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
