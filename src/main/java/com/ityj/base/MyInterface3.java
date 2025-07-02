package com.ityj.base;

public interface MyInterface3 {
    void t();

    default void d(){};


    public static final int x = 0;
}
class B {

    int x = 1;

}

class C extends B implements MyInterface3 {

    @Override
    public void t() {
        //System.out.println("x = " + x); // Reference to 'x' is ambiguous, both 'B. x' and 'MyInterface3.x' match
        int x = super.x;  // 1
        int x1 = MyInterface3.x; // 0
    }
}
