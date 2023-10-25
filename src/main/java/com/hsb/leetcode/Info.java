package com.hsb.leetcode;

public class Info <T> {
    private T t;

    public void setVar(T var){
        this.t = var ;
    }
    public T getVar(){
        return this.t ;
    }
    public String toString(){
        // 直接打印
        return this.t.toString() ;
    }

    public static void main(String args[]){
        Info<String> i1 = new Info<>() ;        // 声明String的泛型对象
        Info<Object> i2 = new Info<>() ;        // 声明Object的泛型对象
        Info<Object> i3 = new Info<>() ;        // 声明Object的泛型对象
        i1.setVar("hello") ;
        i2.setVar(new Object()) ;

        i3.setVar(new DeadLockSample("", "", "")) ;
        fun(i1) ;
        fun(i2) ;
        fun(i3) ;
    }
    public static void fun(Info<? super String> temp){    // 只能接收String或Object类型的泛型，String类的父类只有Object类
        System.out.println(temp + ", ") ;
    }
}
