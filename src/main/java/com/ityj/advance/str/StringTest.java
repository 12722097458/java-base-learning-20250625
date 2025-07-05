package com.ityj.advance.str;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Slf4j
public class StringTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // public final class String
        String str = "abc";
        String s = new String("abc");
        String abc = new String("abc").intern();
        System.out.println(str == abc);


        String stt = "09AZaz中国";
        char[] charArray = stt.toCharArray();
        System.out.println("charArray = " + Arrays.toString(charArray));
        String s1 = new String(charArray);
        System.out.println("s1 = " + s1);

        // 编码 ： 把能看懂的转换成看不懂的(二进制)
        byte[] bytes = stt.getBytes(StandardCharsets.UTF_8);  // UTF-8   一个中文3个字节
        System.out.println("bytes = " + Arrays.toString(bytes));
        byte[] gbkBytes = stt.getBytes("gbk");  // GBK  一个中文2字节
        System.out.println("gbkBytes = " + Arrays.toString(gbkBytes));
        
        // 解码
        // 乱码
        String mismatch = new String(gbkBytes, StandardCharsets.UTF_8);
        System.out.println("mismatch = " + mismatch);
        // 正确
        String correct = new String(gbkBytes, "GBK");
        System.out.println("correct = " + correct);
    }
}
