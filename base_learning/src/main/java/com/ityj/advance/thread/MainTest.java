package com.ityj.advance.thread;

import java.util.Arrays;
import java.util.Comparator;

public class MainTest {

    public static void main(String[] args) {

        // [[id,name,age,sex]，[id,name,age,sex]]
        // /**
        //* 有一个多维数组 [ID, Name, Salary, Sex] ,写一段完整正式的java 程序，对该数组进行排序，
        //* 排序方式依次以 Name，Salary，Sex ，打印输出结果。 可以使用你熟悉的java 编程技巧，数据结构，算法来实现程序。注意编程的规范化约束。
        //*/

        Object[][] arr = {{1,2,3,4},{1,1,1}};
        arr[0][0] = "111";
        arr[0][1] = "A";
        arr[0][2] = 33D;
        arr[0][3] = "N";


        arr[1][0] = "222";
        arr[1][1] = "A";
        arr[1][2] = 3333D;
        arr[1][3] = "M";






        Arrays.sort(arr, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                String o1Name = (String)o1[1];
                String o2Name = (String)o2[1];
                double o1Salary = (double)o1[2];
                double o2Salary = (double)o2[2];
                if (o1Name.compareTo(o2Name) == 0) {
                    if (o1Salary - o2Salary == 0) {
                        return ((String)o1[3]).compareTo((String)o2[3]);
                    } else {
                        return (int) (o1Salary - o2Salary);
                    }
                } else {
                    return o1Name.compareTo(o2Name);
                }
            }
        });

        System.out.println("arr = " + arr);

    }
}
