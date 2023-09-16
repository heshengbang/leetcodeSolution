package com.hsb.leetcode.medium;

import java.util.Arrays;

public class LRUCache1 {
    private int[] keys_value;
    private int[] index_keys;
    private int[] keys_index;
    private int count;
    private int capacity;

    public LRUCache1(int capacity) {
        // key to value, initial with -1
        this.keys_value = new int[10001];
        Arrays.fill(keys_value, -1);
        // index to key, initial with -1
        this.index_keys = new int[3000];
        // key to index, initial with -1
        this.keys_index = new int[10001];
        Arrays.fill(index_keys, -1);
        Arrays.fill(keys_index, -1);
        this.count = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        // 获取value为-1，表明该key并不存在，直接返回
        if (keys_value[key] < 0) {
            return -1;
        }
        int value = keys_value[key];
        int index = keys_index[key];
        // 访问到的元素放到数组最后面
        for (int i = index; i < count; i++) {
            if (i + 1 >= 3000) {
                continue;
            }
            int currentKey = index_keys[i + 1];
            if (currentKey != -1) {
                keys_index[currentKey] = i;
                index_keys[i] = currentKey;
            }
        }
        if (count - 1 >= 0) {
            index_keys[count - 1] = key;
            keys_index[key] = count - 1;
        }
        return value;
    }

    public void put(int key, int value) {
        // 不为-1，证明key存在，直接替换值
        if (keys_value[key] >= 0) {
            keys_value[key] = value;
            get(key);
            return;
        }
        if (count == capacity) {
            // 擦除最早放入的记录
            int oldKey = index_keys[0];
            keys_index[oldKey] = -1;
            keys_value[oldKey] = -1;
            // 向数组最左边移动
            for (int i = 0; i < count;i++) {
                if (i + 1 == count) {
                    continue;
                }
                int currentKey = index_keys[i + 1];
                keys_index[currentKey] = i;
                index_keys[i] = currentKey;
            }
            index_keys[count - 1] = key;
            keys_index[key] = count - 1;
            keys_value[key] = value;
        } else {
            keys_value[key] = value;
            index_keys[count] = key;
            keys_index[key] = count;
            count++;
        }
    }

    public static void main(String[] args) {
        LRUCache1 lruCache = new LRUCache1(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }

}
