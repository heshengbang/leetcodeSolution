package com.hsb.leetcode.medium;

public class Daily_Temperatures {

    /**
     * 动态规划的解题思路
     *
     * 定义 int[] result = new int[length]; 其中result[i] 表示 i 向右侧找到严格比temperatures[i] 更大的数字temperatures[j]
     *      则result[i] = j - i
     *
     * 初始化  result[length - 1] = 0，因为它右边没有值，所以找不到比temperatures[length - 1]更大的数字
     *
     * 从右往左遍历
     *  如果 temperatures[i] < temperatures[i + 1] 则 result[i] = 1;
     *  如果temperatures[i] >= temperatures[i + 1] 则比较 temperatures[i] 和 temperatures[i + 1 + result[i + 1]]
     *
     * 状态转移方程 result[i] =
     *
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }
        int length = temperatures.length;
        int[] result = new int[length];

        for (int i = length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                result[i] = 1;
            } else {
                int index = i + 1;
                while (index < length) {
                    if (temperatures[i] >= temperatures[index]) {
                        if (result[index] == 0) {
                            break;
                        } else {
                            index = index + result[index];
                        }
                    } else {
                        result[i] = index - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

//        int[] temperatures = {30,40,50,60};

//        int[] temperatures = {30,60,90};

//        int[] temperatures = {30};


        Daily_Temperatures it = new Daily_Temperatures();
        System.out.println(it.dailyTemperatures(temperatures));
    }
}
