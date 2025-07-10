package com.ityj.advance.inet;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {

    @Test
    public void testInet() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("192.168.110.236");
        System.out.println("inetAddress = " + inetAddress);

        InetAddress inetAddress2 = InetAddress.getByName("www.mi.com");
        System.out.println("inetAddress2 = " + inetAddress2);
    }

}
