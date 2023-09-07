package com.hsb.leetcode.medium;

/**
 * Edit Distance
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 *
 */
public class Edit_Distance {

    /**
     * 最简单的状态，两个字符都是空字符的时候，转换需要0步
     * 如果word1是一个字符，word2是空字符，那转换需要1步，删除即可
     * 如果word1是空字符，word2是一个字符，那转换也需要一步，插入即可
     *
     * 如果word1和word2都是一个字符，那么就需要考虑这两个字符是否一样
     *      如果是同一个字符，则步骤为0
     *      如果不是同一个字符，则转换需要1步，替换即可
     *
     * 从上述分析可以看出，word1和word2转换的关联需要word1的索引和word2的索引，
     * 将这两个索引作为状态参数，其中一个变化，转换的值就有变化
     *
     * 设置状态备忘录为dp[i][j]，表示word1.subString(0, i)转换为word2.subString(0, j)需要的最少步骤
     *
     * 初始状态除了上面考虑的情况外，还有word2为空，但是word1不为空的情况，这个时候根据字符数量逐渐删减即可
     *      word1为空，word2不为空，这个时候，需要不断给word1中插入数据，根据字符数增多而步骤变多
     *
     * 状态转移方程，三种情况：
     *  在dp[i][j - 1]的情况下，目标字符串多了一个字符，这个时候只需要dp[i][j - 1] + 1，加一是为了一个插入操作
     *   dp[i - 1][j]的情况下，原字符串多了一个字符，这个时候只需要在dp[i - 1][j] + 1，加一是为了一个删除操作
     *   dp[i - 1][j - 1]的情况下，原字符串和目标字符串最后都多了一个字符，这个时候就需要判断
     *      如果字符相同，那么其实转换的步骤没变化，相当于同时尾部加一个字符
     *      如果字符不同，那么转换步骤一个替换即可，即dp[i - 1][j - 1] + 1
     * 在上述的三种情况下，决策的最终方式应该是使用步数最少的就该选用，所以转移方程应该如下：
     *  dp[i][j] = Min(dp[i][j - 1] + 1, dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1), i > 0, j > 0;
     *
     * @param word1 原字符串
     * @param word2 目标字符串
     * @return 最少步骤
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i < l2 + 1; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[l1][l2];
    }
}
