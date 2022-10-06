package java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *获取ip地址
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("192.168.169.156");
            System.out.println(byName);
            InetAddress byName1 = InetAddress.getByName("www.mi.com");
            System.out.println("byName1 = " + byName1);
            InetAddress byName2 = InetAddress.getLocalHost();
            System.out.println("byName2 = " + byName2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
