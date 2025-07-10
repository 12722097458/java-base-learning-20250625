package com.ityj.advance.inet;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {


    @Test
    public void client() throws IOException {
        Socket socket = new Socket("192.168.110.236", 8088);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("TCPTest.client.......".getBytes());
        outputStream.close();
        socket.close();
        System.out.println("client end...");
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[8];
        int len;
        System.out.println("收到数据：" + socket.getInetAddress());
        while ((len = inputStream.read(buff)) != -1) {
            System.out.print(new String(buff, 0, len));
        }
        System.out.println("server end...");
        socket.close();
        serverSocket.close();
    }

}
