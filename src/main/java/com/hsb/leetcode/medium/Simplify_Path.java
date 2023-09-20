package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Simplify_Path {

    public String simplifyPath1(String path) {
        int length = path.length();
        char[] chars = path.toCharArray();
        int index = 0;
        List<String> list = new ArrayList<>();
        while (index < length) {
            String tmp = String.valueOf(chars[index]);
            index++;
            while (index < length && chars[index] != '/') {
                tmp = tmp + chars[index];
                index++;
            }
            if (tmp.length() == 1) {
                continue;
            } else {
                if ("/..".equals(tmp)) {
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                } else if ("/.".equals(tmp)) {
                    // do nothing;
                } else {
                    list.add(tmp);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        if (sb.length() == 0) {
            return "/";
        } else {
            return sb.toString();
        }
    }

    public String simplifyPath(String path) {
        int length = path.length();
        char[] chars = path.toCharArray();
        char[] ac = new char[length];
        int index = 0, acIndex = 0;
        while (index < length) {
            if (chars[index] == '.') {
                int tmp = index;
                int count = 0;
                while (chars[tmp] == '.') {
                    count++;
                    tmp++;
                }
                // 表示只有一个. 是指当前目录，直接掠过，不管
                if (count == 1) {
                    index++;
                    continue;
                } else if (count == 2) {
                    // 表示上一级目录
                    acIndex = toUpLevel(ac, acIndex);
                } else {

                }
            }
            if (chars[index] == '/') {
                // 如果是开头的字符，则必须留下
                if (acIndex == 0) {
                    ac[acIndex] = chars[index];
                    acIndex++;
                } else if (ac[acIndex - 1] != '/' && index != chars.length - 1) {
                    // 如果不是开头的字符，并且前一个字符也不是/，同时也不是最后一个字符，那么这个/可以保留
                    ac[acIndex] = chars[index];
                    acIndex++;
                }
                index++;
                continue;
            }
            if (chars[index] >= 'a' && chars[index] <= 'z') {
                ac[acIndex] = chars[index];
                index++;
                acIndex++;
            }
        }
        return new String(ac, 0, acIndex);
    }

    private int toUpLevel(char[] ac, int acIndex) {
        if (acIndex == 0) {
            return 0;
        }
        int count = 2;
        for (int i = acIndex - 1; i >= 0; i--) {
            if (ac[i] == '/') {
                count--;
                if (count == 0) {
                    // 找到/，保留/
                    return i + 1;
                }
            }
        }
        // 找不到，保留第一个/，从第2个字符开始
        return 1;
    }

    public static void main(String[] args) {
//        String path = "/a/./b/../../c/";
//        String path = "/../";
        String path = "/home//foo/";
        Simplify_Path it = new Simplify_Path();
        System.out.println(it.simplifyPath1(path));
    }
}
