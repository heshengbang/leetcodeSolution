package com.hsb.leetcode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("方法开始");
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.computeIfAbsent("AaAa", key -> map.computeIfAbsent("BBBB", key2->"BBBB"));
        map.computeIfAbsent("abcd", key -> map.computeIfAbsent("defc", key2 -> "什么鬼？"));
        System.out.println("方法结束 => " + map);
    }
}
