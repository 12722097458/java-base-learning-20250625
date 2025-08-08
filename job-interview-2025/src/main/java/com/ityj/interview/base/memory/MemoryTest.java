package com.ityj.interview.base.memory;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.lang.reflect.Field;


// --illegal-access=deny
//--add-opens java.base/java.lang=ALL-UNNAMED
//--add-opens java.base/java.lang.reflect=ALL-UNNAMED
//--add-opens java.base/java.lang.invoke=ALL-UNNAMED
//--add-opens java.base/java.math=ALL-UNNAMED
//--add-opens java.base/java.util=ALL-UNNAMED
//--add-opens java.base/java.util.concurrent=ALL-UNNAMED
//--add-opens java.base/java.net=ALL-UNNAMED
//--add-opens java.base/java.text=ALL-UNNAMED
public class MemoryTest {

    @Test
    public void testString() throws IllegalAccessException, NoSuchFieldException {
        String str = new String("SFT");
        System.out.println(VM.current().details());

        // 方法 1：通过反射（不推荐生产环境）
        Field field = str.getClass().getDeclaredField("value");
        field.setAccessible(true);
        byte[] internal = (byte[]) field.get(str);
        /*
        * java.lang.String object internals:
            OFF  SZ      TYPE DESCRIPTION               VALUE
              0   8           (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
              8   4           (object header: class)    0x0000e270
             12   4       int String.hash               0
             16   1      byte String.coder              0
             17   1   boolean String.hashIsZero         false
             18   2           (alignment/padding gap)
             20   4    byte[] String.value              [83, 70, 84]
            Instance size: 24 bytes
        *
        * */
        System.out.println(ClassLayout.parseInstance(str).toPrintable());

        /*
        * [B object internals:
            OFF  SZ   TYPE DESCRIPTION               VALUE
              0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
              8   4        (object header: class)    0x00006218
             12   4        (array length)            3
             12   4        (alignment/padding gap)
             16   3   byte [B.<elements>             N/A
             19   5        (object alignment gap)
            Instance size: 24 bytes
        * */
        System.out.println(ClassLayout.parseInstance(internal).toPrintable());
    }


    @Test
    public void testString_Chinese() throws IllegalAccessException, NoSuchFieldException {
        String str = new String("你好");  //   UTF-16 中文占用2个字节
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(str).toPrintable());

        // 方法 1：通过反射（不推荐生产环境）
        Field field = str.getClass().getDeclaredField("value");
        field.setAccessible(true);
        byte[] internal = (byte[]) field.get(str);
        System.out.println(ClassLayout.parseInstance(internal).toPrintable());  // 4   byte [B.<elements>             N/A
    }



    @Test
    public void testDouble() {
        Double d = new Double(123.4D);
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(d).toPrintable());  // (8 + 4) + 8(value) => 24

        DoubleHolder holder = new DoubleHolder();
        holder.value = 123.4;
        System.out.println(ClassLayout.parseInstance(holder).toPrintable());  //   8   double DoubleHolder.value        123.4    没有占用多余内存
    }

}

// 创建包含 double 的简单对象
class DoubleHolder {
    double value;
}
