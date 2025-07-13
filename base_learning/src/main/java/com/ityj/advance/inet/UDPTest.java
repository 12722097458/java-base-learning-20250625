package com.ityj.advance.inet;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class UDPTest {


    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String str = "UDP报文。。。";
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), 0, str.getBytes().length,
                InetAddress.getByName("127.0.0.1"), 8099);

        datagramSocket.send(datagramPacket);
        datagramSocket.close();
        System.out.println("sender end...");
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8099);

        byte[] buffer = new byte[55];  // 可能读不完，或者读的过多
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
        datagramSocket.receive(datagramPacket);

        System.out.println("buffer = " + new String(buffer));

        datagramSocket.close();
        System.out.println("receiver end...");
    }

}
