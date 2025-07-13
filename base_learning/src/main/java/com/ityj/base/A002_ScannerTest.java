package com.ityj.base;

import java.util.Scanner;

public class A002_ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next = scanner.nextInt();
        System.out.println("next = " + next);


        label2: for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < 20; j++) {
                if (i == 18) {
                    break label2;  // 跳出所有循环
                }
            }
        }
    }
}
