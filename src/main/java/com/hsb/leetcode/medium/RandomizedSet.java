package com.hsb.leetcode.medium;

import java.sql.Array;
import java.util.*;

public class RandomizedSet {
    private HashMap<Integer, Object> memory;
    private Object valueObject;

    public RandomizedSet() {
        memory = new HashMap<>();
        valueObject = new Object();
    }

    public boolean insert(int val) {
        if (memory.containsKey(val)) {
            return false;
        }
        memory.put(val, valueObject);
        return true;
    }

    public boolean remove(int val) {
        if (memory.containsKey(val)) {
            memory.remove(val, valueObject);
            return true;
        }
        return false;
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<>(memory.keySet());
        Collections.shuffle(list);
        return list.get(0);
    }
}
