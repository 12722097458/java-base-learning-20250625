package com.ityj.advance.io;

import java.io.*;

public class FileCopyBuffered {


    public static void main(String[] args) {

        File file = new File("src/main/resources/static/tt微信图片_20241230163708.jpg");
        File file2 = new File("out_2.jpg");
        // 内部提供了一个缓冲区， 能提高读写速度
        //     private static int DEFAULT_BUFFER_SIZE = 8192;     buf = new byte[8192];
        // BufferedWriter   // private char cb[]; = new char[8192];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2))) {
            byte[] buff = new byte[8];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0 , len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("complete...");
    }
}
