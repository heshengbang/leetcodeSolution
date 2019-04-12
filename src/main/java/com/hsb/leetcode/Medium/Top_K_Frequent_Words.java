package com.hsb.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/12 20:24
 *
 * @author heshengbang
 */

public class Top_K_Frequent_Words {
    public static void main(String[] args) {
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(str, 3));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> results = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        for (String item: words) {
            if (results.contains(item)) {
                int index = results.indexOf(item);
                counts.set(index, counts.get(index) + 1);
            } else {
                results.add(item);
                counts.add(1);
            }
        }
        for (int j = 0; j < counts.size(); j++) {
            for (int i = j + 1; i < counts.size(); i++) {
                if (counts.get(j) < counts.get(i) || (counts.get(i).equals(counts.get(j)) && results.get(j).compareTo(results.get(i)) > 0 )) {
                    int temp = counts.get(j);
                    counts.set(j, counts.get(i));
                    counts.set(i, temp);
                    String tempStr = results.get(j);
                    results.set(j, results.get(i));
                    results.set(i, tempStr);
                }

            }
        }
        return results.subList(0, k);
    }
}
