package com.hsb.leetcode.dp;

public class Lesson13 {
    /**
     * 给定两个单词s1和s2，计算出s1转换成s2所使用的最少操作数。每次只能对单词做以下操作：
     *  1. 插入一个字符
     *  2. 删除一个字符
     *  3. 替换一个字符
     *
     *  示例：s1 = "giraffe"  s2 = "irbff"
     *
     *  输出：3
     *  解释：1. giraffe -> iraffe (删除 g
     *       2. iraffe -> irbffe (用b替换a
     *       3. irbffe -> irbff (删除e
     *
     *  第一个想到的状态参数就是操作数，第二个想到的状态参数有两个，第1是s1的索引，第2个是s2的索引
     *
     *  如果状态参数分别用s1的索引和s2的索引，那么初始化，
     *      s1长度为0的时候，s2的操作数就是自身的长度，因为每一步都是删除自己的一个字符
     *      s2长度为0的时候，s1的操作数也是自身的长度，因为每一步都是删除自己的一个字符
     *
     *  根据状态参数的个数，设置状态存储dp[s2.length][s1.length]，
     *  其中dp[i][j]代表s1.subString(0, j)转换到s2.subString(0, i)所需的操作数
     *
     *  分析计算方向是从左上到右下
     *  dp[i][j]的值，要将s1.subString(0, j)转换为s2.subString(0, i)，需要考虑以下情况：
     *      如果由dp[i][j - 1] 推导出 dp[i][j]， s1的子字符串长度从j - 1变为j，则意味着它的尾部增加了一个字符，
     *          此时如果dp[i][j - 1]已经是最优解的话，在最优解的基础上加一个删除操作即可，即dp[i][j] = dp[i][j - 1] + 1;
     *          例如：ab 转换为 cd 需要两步替换操作，如果是abz转换为cd就需要两步替换操作+一步删除操作
     *
     *      如果由dp[i - 1][j] 推导出 dp[i][j]， s2的子字符串长度从i - 1变为i，意味着它尾部增加了一个字符
     *          dp[i - 1][j]已经是s1.subString(0, j)转换为s2.subString(0, i - 1)的最少步骤，此时只需要在这个步骤上加一个插入操作即可，即dp[i][j] = dp[i - 1][j] + 1
     *          例如：ab 转换为 cd 需要两步替换操作，如果是cdz，则需要两步替换+一步插入
     *
     *      如果由dp[i - 1][j - 1] 推导出 dp[i][j]，则s1.subString(0, j - 1)转换为s2.subString(0, i - 1)，
     *          此时，如果s1.charAt(i) == s2.charAt(j)，则最优转换步数不变，还是dp[i - 1][j - 1]
     *              例如：ab 转换为 cd为两步替换操作，如果是abz转换为cdz，则依然是两步替换操作
     *
     *              如果s1.charAt(i) ≠ s2.charAt(j)，则直接用替换操作即可，相当于是增加了一个替换操作，即 dp[i - 1][j - 1] + 1
     *              例如：ab 转换为 cd为两步替换操作，如果是abx转换为cdz，则是两步替换操作+一步替换操作，共三步替换操作
     *
     *  根据上述分析，题设要求最少的步数，状态转移方程应该是
     *      dp[i][j] = Min(dp[i][j - 1] + 1, dp[i - 1][j] + 1, s1.charAt(i) == s2.charAt(j) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1), i > 0, j > 0;
     *
     * @param s1 给定字符串
     * @param s2 给定字符串
     * @return s1转换为s2所需的最少操作数
     */
    private int editDistance(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        // 纵轴代表原字符串的长度，横轴代表目标字符串的长度
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            // 当目标字符串是空字符串的时候，源字符串只需要每次做删除字符操作即可
            dp[i][0] = i;
        }
        for (int i = 0; i < s2.length() + 1; i++) {
            // 当原目标字符串为空字符串的时候，原目标字符串只需要每次做字符插入操作即可
            dp[0][i] = i;
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
//        String s1 = "abc", s2 = "cd";
        String s1 = "aba", s2 = "abda";
        Lesson13 it = new Lesson13();
        System.out.println(it.editDistance(s1, s2));
    }
}
