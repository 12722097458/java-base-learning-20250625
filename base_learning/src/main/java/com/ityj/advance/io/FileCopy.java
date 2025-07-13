package com.ityj.advance.io;

import java.io.*;

public class FileCopy {


    public static void main(String[] args) {

        File file = new File("base_learning/src/main/resources/static/tt微信图片_20241230163708.jpg");
        File file2 = new File("base_learning/src/main/resources/static/out.jpg");
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(file2)) {
            byte[] buff = new byte[8];
            int len;
            while ((len = fis.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("complete...");
    }
}
