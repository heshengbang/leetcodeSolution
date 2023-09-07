package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 * Constraints:
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 */
public class Triangle {
    /**
     *
     * 从题目中可以读出，path需要从top到bottom，那如果triangle的元素为0，那么和也为0，如果元素为1，那么和也就是唯一元素里面的值的和
     *  这里面的元素索引，其实就是层数
     * 所以，初始状态就是层数为0，那么和也为0，如果层数为1，那么最小和就是这一层值最小的元素本身，但是题设中第一层只有一个元素，所以就是这唯一的元素本身
     *
     * 状态参数，考虑到题目中的说法，每一层都要依赖上层的索引，那么实际上变化的状态参数有两个，第一个是层数，第二个是上一层中取值位置的索引值
     *  层数决定了当前这一层的数据集
     *  上一层取值位置的索引值决定了在数据集中取哪个值，i或者i+1
     *
     * 状态参数推导出 备忘录的形式应该是二维数组，但是考虑到这是一个三角矩阵，每一层的元素个数并不固定，所以采用两层列表代替二维数组
     *
     * dp[i][j] 代表自顶部第一层开始到第i层从左至右第j个元素的最小路径和，要求从自顶到第的最小和，则遍历第i层的所有元素即可
     *
     * 为什么没使用一维数组，是因为存在一种情况：
     *      1
     *     3 3
     *    5 3 4
     * 第二层的最优解有多个，多个最优解，每个位置的取值当前这一层虽然一样，但是在下一层千差地别，所以应该保留上一层的所有情况，虽然最优解无法退出下一层的最优解，但是上一层的解可以推出下一层的解
     * 同样使用一维数组可能会出产生的问题：
     *      1
     *     2 3
     *   10 4 -10
     *
     * 和上面的分析一样，第二层的最优解并不能推出第三层的最优解，因此使用一维数组无法解答问题
     *
     * @param triangle 给定的三角矩阵
     * @return 最少的路径和
     */
    public int minimumTotalWithDP(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int length = triangle.size();
        // 备忘录
        List<List<Integer>> dp = new ArrayList<>();
        // 初始化，最top的第一层只有一个元素，
        dp.add(Collections.singletonList(triangle.get(0).get(0)));
        for (int i = 1; i < length; i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    tmp.add(dp.get(i - 1).get(j) + list.get(j));
                } else if (j == list.size() - 1) {
                    tmp.add(dp.get(i - 1).get(j - 1) + list.get(j));
                } else {
                    tmp.add(Math.min(dp.get(i - 1).get(j), dp.get(i - 1).get(j - 1)) + list.get(j));
                }
            }
            dp.add(tmp);
        }
        List<Integer> tmp = dp.get(triangle.size() - 1);
        int ans = Integer.MAX_VALUE;
        for (Integer it: tmp) {
            ans = Math.min(ans, it);
        }
        return ans;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> pre = null;
        for (List<Integer> it: triangle) {
            List<Integer> tmp = new ArrayList<>();
            if (pre == null) {
                tmp.add(it.get(0));
                results.add(tmp);
            } else {
                for (int i = 0; i < it.size(); i++) {
                    if (i == 0) {
                        tmp.add(pre.get(i) + it.get(i));
                    } else if (i == it.size() - 1) {
                        tmp.add(pre.get(i - 1) + it.get(i));
                    } else {
                        tmp.add(Math.min(pre.get(i), pre.get(i - 1)) + it.get(i));
                    }
                }
            }
            pre = tmp;
        }
        int ans = Integer.MAX_VALUE;
        for (Integer it: pre) {
            ans = Math.min(ans, it);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
//        list.add(Arrays.asList(2));
//        list.add(Arrays.asList(3,4));
//        list.add(Arrays.asList(6,5,7));
//        list.add(Arrays.asList(4,1,8,3));

        list.add(Arrays.asList(-1));
        list.add(Arrays.asList(2,3));
        list.add(Arrays.asList(1,-1,-3));


        Triangle it = new Triangle();
        System.out.println(it.minimumTotal(list));
    }
}
