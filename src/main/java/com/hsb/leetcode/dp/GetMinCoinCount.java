package com.hsb.leetcode.dp;

import java.util.ArrayList;
import java.util.Collections;

public class GetMinCoinCount {

    private int getMinCoinCountOfValue(int total, int[] values, int valueIndex) {
        int valueCount = values.length;
        if (valueIndex == valueCount) {
            return Integer.MAX_VALUE;
        }
        int minResult = Integer.MAX_VALUE;
        int currentValue = values[valueIndex];
        int maxCount = total / currentValue;
        for (int count = maxCount; count >= 0; count--) {
            int rest = total - count * currentValue;
            // 如果rest为0，表示余额已除尽，组合完成
            if (rest == 0) {
                minResult = Math.min(minResult, count);
                break;
            }
            // 否则尝试用剩余面值求当前余额的硬币总数
            int restCount = getMinCoinCountOfValue(rest, values, valueIndex + 1);
            // 如果后续没有可用组合
            if (restCount == Integer.MAX_VALUE) {
                // 如果当前面值已经为0，返回-1表示尝试失败
                if (count == 0) {
                    break;
                }
                // 否则尝试把当前面值-1
                continue;
            }
            minResult = Math.min(minResult, count + restCount);
        }
        return minResult;
    }

    private int getMinCoinCountLoop(int total, int[] values, int k) {
        int minCount = Integer.MAX_VALUE;
        int valueCount = values.length;
        if (k == valueCount) {
            return Math.min(minCount, getMinCoinCountOfValue(total, values, 0));
        }
        for (int i = k; i <= valueCount - 1; i++) {
            // k位置已经排列好
            int t = values[k];
            values[k] = values[i];
            values[i] = t;
            minCount = Math.min(minCount, getMinCoinCountLoop(total, values, k + 1));
            // 回溯
            t = values[k];
            values[k] = values[i];
            values[i] = t;
        }
        return minCount;
    }


    private int getMinCoinCountOfValue() {
        int[] values = {5, 3}; // 硬币面值
        int total = 11; // 总价
        int minCoin = getMinCoinCountLoop(total, values, 0);
        return (minCoin == Integer.MAX_VALUE) ? -1 : minCoin; // 输出答案
    }

    private int getMinCountsWithDP(int k, int[] values) {
        int[] memo = new int[k + 1];
        memo[0] = 0;
        for (int i = 1; i < k + 1; i++) {
            memo[i] = k + 1;
        }
        for (int i = 1; i < k + 1; i++) {
            for (int coin: values) {
                if (i - coin < 0) {
                    continue;
                }
                memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }
        return memo[k] == k + 1 ? -1 : memo[k];
    }

    private int getMinCountsDPSolAdvance() {
        int[] values = {3, 5};
        int total = 22;
        return getMinCountsWithDP(total, values);
    }

    public static void main(String[] args) {
        GetMinCoinCount getMinCoinCount = new GetMinCoinCount();
        System.out.println(getMinCoinCount.getMinCountsDPSolAdvance());
    }
}
