package com.ityj.spring.entity;

public class LifeCycleBean {

    private String name;

    public LifeCycleBean() {
        System.out.println("1    LifeCycleBean 无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2    LifeCycleBean.setName " + name);
        this.name = name;
    }

    private void init() {
        System.out.println("4   LifeCycleBean.init() method");
    }

    private void destroy() {
        System.out.println("7   LifeCycleBean.destroy() method");
    }

}
