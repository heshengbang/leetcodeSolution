package com.hsb.leetcode.had;

import java.util.HashMap;
import java.util.Map;

public class Max_Points_on_a_Line {
    /**
     * https://zhuanlan.zhihu.com/p/87888669
     */
    public int maxPoints(int[][] points) {
        int ans = 1;
        int m = points.length;
        // 选1个点和其他点算斜率，斜率相同的就在一条线上
        for (int i = 0; i < m; i++) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < m; j ++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                /* All the points are unique.
                    if (x == 0 && y == 0) {}
                 */
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                // 斜率的字符形式
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            // + 1是要把i所在的这个点算进去
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    public static void main(String[] args) {
        Max_Points_on_a_Line it = new Max_Points_on_a_Line();
        System.out.println(it.gcd(54, 120));
    }
}
