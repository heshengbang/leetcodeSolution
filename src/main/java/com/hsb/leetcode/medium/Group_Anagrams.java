package com.hsb.leetcode.medium;

import java.util.*;

public class Group_Anagrams extends AbstractList {

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(tmp, list);
            }
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] param = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] param = {"", ""};
        Group_Anagrams item = new Group_Anagrams();
        System.out.println(item.groupAnagrams1(param));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> memory = new HashMap<>();
        for (String item : strs) {
            insert(item, memory);
        }
        return new ArrayList<>(memory.values());
    }

    private void insert(String item, Map<String, List<String>> memory) {
        char[] chs = item.toCharArray();
        Arrays.sort(chs);
        String key = String.valueOf(chs);
        List<String> list = memory.get(key);
        if (memory.containsKey(key)) {
            if (list == null) {
                list = new ArrayList<>();
            }
        } else {
            list = new ArrayList<>();
        }
        list.add(item);
        memory.put(key, list);
    }


    String[] sa;
    List<List<String>> lls = null;

    @Override
    public Object get(int index) {
        if (lls == null) {
            makeList();
        }
        return lls.get(index);
    }

    @Override
    public int size() {

        if (lls == null) {
            makeList();
        }
        return lls.size();
    }

    private void makeList() {
        Map<int[], List<String>> m = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                for (int i = 0; i < 26; i++) {
                    if (a[i] != b[i]) {
                        return (a[i] - b[i]);
                    }
                }
                return 0;
            }
        });

        for (String s : sa) {
            int[] cc = countChars(s);
            List<String> l = m.get(cc);
            if (l == null) {
                l = new ArrayList<>();
                m.put(cc, l);
            }
            l.add(s);
        }

        lls = new ArrayList<>(m.values());
    }

    private int[] countChars(String s) {
        int[] cc = new int[26];
        for (char c : s.toCharArray()) {
            cc[c - 'a']++;
        }
        return cc;
    }
}
