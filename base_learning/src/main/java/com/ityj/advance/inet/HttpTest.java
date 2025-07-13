package com.ityj.advance.inet;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpTest {


    @Test
    public void http() throws IOException, URISyntaxException {
        URL url = new URL("http://localhost:8888/ping");
        URI uri = url.toURI();
        Object content = url.getContent();
        int port = url.getPort();
        System.out.println("port = " + port);
    }

    @Test
    public void httpConncet() throws IOException, URISyntaxException {
        URL url = new URL("http://localhost:8888/ping");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[8];
        int len;
        while ((len = inputStream.read(buff)) != -1) {
            System.out.println(new String(buff, 0, len));
        }
        inputStream.close();
        System.out.println("complete...........");
    }

    @Test
    // since JDK11
    public void httpClient() throws IOException, URISyntaxException, InterruptedException {
        URL url = new URL("http://localhost:8888/ping");

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest. newBuilder()
                .uri(URI.create("http://localhost:8888/ping"))
                .header("Content-Type", "text/plain; charset=UTF-8")
                .build();
        HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> res = httpClient.send(request, stringBodyHandler);
        String body = res.body();
        System.out.println("body = " + body);

        System.out.println("complete...........");
    }

}
