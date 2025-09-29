package com.ityj.interview.base.enum2;

public enum Status {

    NEW,
    CREATED,
    CLOSED;

    private Status() {
        System.out.println("constructor Status...." + this);
    }


    public static void main(String[] args) {
        System.out.println(Status.CREATED);
    }
}
