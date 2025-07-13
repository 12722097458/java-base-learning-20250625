package com.ityj.base;

public class A003_ArrayTest {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = new int[] {1, 2, 3};
        int[] arr3 = new int[3];
        arr3[0] = 1;
        arr3[1] = 2;
        arr3[2] = 3;

        int[][] ar1 = {{1,2,3},{1,2,3},{1,2,3}};
        int[][] ar2 = new int[][]{{1,2,3},{1,2,3},{1,2,3}};
        int[][] ar3 = new int[3][2];  // 底层是一个长度为3的一维数组。 每个一维数组又由一个长度为2的一维数组组成
        ar3[0][0] = 11;
        ar3[0][1] = 12;
        ar3[1][0] = 21;
        ar3[1][1] = 22;
        ar3[2][0] = 31;
        ar3[2][1] = 32;
        int[][] ar4 = new int[3][];   // 此时二维数组只知道长度为3， 具体值没有初始化。 直接取值会出现NPE
        //int i = ar4[1][1]; // NPE
        // 初始化后开辟了空间，才能取值。
        ar4[1] = new int[4];
        int j = ar4[1][1];   // 0
        System.out.println("j = " + j);

    }
}
