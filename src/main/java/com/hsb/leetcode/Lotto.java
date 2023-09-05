package com.hsb.leetcode;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author heshengbang
 * 2019/3/24.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class Lotto {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        long address = unsafe.allocateMemory(4);
        unsafe.putInt(address, 15);
        System.out.println(unsafe.getInt(address));
    }

    public static void main1(String[] args) {

        List<Integer> current = Arrays.asList(3, 8, 21, 26, 33);
//        String original = "03 08 21 26 33 04 05 07 09 13 14 33 02 04 01 04 18 24 28 02 03 06 22 28 29 33 02 07 16 18 24 25" +
//                " 27 02 07 10 12 15 17 19 02 03 06 13 16 19 29 03 07 11 17 19 29 33 08 09 01 03 14 26 30 06 11 01 04 14 15" +
//                " 21 01 05 07 13 17 24 33 01 10 01 08 16 27 34 03 12 04 11 19 25 32 01 02 03 18 19 26 34 06 12 01 05 07 22" +
//                " 25 03 04 03 05 13 16 28 02 06 02 05 10 13 30 04 06 12 14 20 28 31 09 11 08 10 15 17 18 01 08 05 09 17 18" +
//                " 19 07 10 04 12 13 16 17 04 09 03 07 24 25 27 02 12 03 09 15 18 26 06 12 03 08 17 20 24 06 11 03 12 16 29" +
//                " 32 01 05 14 17 19 25 30 04 08 21 26 27 29 34 05 06 15 16 17 31 32 03 09 04 08 18 20 32 10 12 02 07 14 22 31 01 07";
        String original = "03 08 21 26 33 04 05 07 09 13 14 33 02 04 01 04 18 24 28 02 03 06 22 28 29 33 02 07 16 18 24 25 27 02 07 10 12 15 17 19 02 03 06 13 16 19 29 03 07";
        List<List<Integer>> datas = parse(original);
//        datas = datas.subList(3, 10);
        List<List<Integer>> orderData = order(datas);

        List<Double> average;
        average = getAverage4RemoveAllExtreme(orderData);
        if (checkRed(average, current, false)) {
            System.out.println(average);
        }
        average = getAverage4RemoveOneExtreme(orderData);
        if (checkRed(average, current, false)) {
            System.out.println(average);
        }
        average = getAverage(orderData);
        if (checkRed(average, current, false)) {
            System.out.println(average);
        }
    }

    private static boolean checkRed(List<Double> data, List<Integer> current, boolean isCheck) {
        if (isCheck) {
            for (int i = 0;i < 5; i++) {
                BigDecimal b = new BigDecimal(data.get(i));
                if (current.contains(b.setScale(0, BigDecimal.ROUND_HALF_UP).intValue())) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    private static List<Double> getAverage(List<List<Integer>> orderData) {
        List<Double> results = new ArrayList<>();
        for (List<Integer> item : orderData) {
            int total = 0, count = 0;
            for (Integer anItem : item) {
                total += anItem;
                count++;
            }
            BigDecimal b = new BigDecimal((total * 1.0) / count);
            results.add((b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()));
        }
        return results;
    }

    private static List<Double> getAverage4RemoveOneExtreme(List<List<Integer>> orderData) {
        List<Double> results = new ArrayList<>();
        for (List<Integer> item : orderData) {
            int total = 0, count = 0;
            for (int i = 1; i < item.size() - 1; i++) {
                total += item.get(i);
                count++;
            }
            BigDecimal b = new BigDecimal((total * 1.0) / count);
            results.add((b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()));
        }
        return results;
    }

    private static List<Double> getAverage4RemoveAllExtreme(List<List<Integer>> orderData) {

        List<Double> results = new ArrayList<>();
        for (List<Integer> item : orderData) {
            int lowest = item.get(0), biggest = item.get(item.size() - 1), total = 0, count = 0;
            for (Integer integer : item) {
                if (integer != lowest && integer != biggest) {
                    total += integer;
                    count++;
                }
            }
            if (count == 0) {
                results.add((double) -1);
                continue;
            }
            BigDecimal b = new BigDecimal((total * 1.0) / count);
            results.add((b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()));
        }
        return results;
    }

    private static void print(List<List<Integer>> orderData) {
        for (List<Integer> item : orderData) {
            System.out.println(item);
        }
    }

    private static List<List<Integer>> order(List<List<Integer>> datas) {
        List<List<Integer>> results = new ArrayList<>(7);
        List<Integer> order;
        for (int i = 0; i < 7; i++) {
            order = new ArrayList<>();
            for (List<Integer> item : datas) {
                order.add(item.get(i));
            }
            Collections.sort(order);
            results.add(order);
        }
        return results;
    }

    private static List<List<Integer>> parse(String data) {
        String[] datas = data.split(" ");
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> array = new ArrayList<>(7);
        for (int i = 0; i < datas.length; i++) {
            array.add(Integer.parseInt(datas[i]));
            if (i % 7 == 6) {
                results.add(array);
                array = new ArrayList<>();
            }
        }
        return results;
    }
}
