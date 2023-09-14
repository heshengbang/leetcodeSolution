package com.hsb.leetcode.had;

import java.util.ArrayList;
import java.util.List;

public class Wildcard_Matching {
    private int[][] mem;
    public boolean isMatch3(String s, String p) {
        char[] chars = s.toCharArray();
        int lengths = s.length();
        char[] charp = p.toCharArray();
        int lengthp = p.length();
        // 初始为-1， 0 为不可行，1为可行
        mem = new int[lengths + 1][lengthp + 1];
        for (int i = 0; i < lengths + 1; i++) {
            for (int j = 0; j < lengthp + 1; j++) {
                mem[i][j] = -1;
            }
        }
//        if (chars.length == 0 && charp.length == 0) {
//            return true;
//        } else if (chars.length == 0) {
//            if (charp.length == 0 || p.startsWith("*")) {
//                return true;
//            } else {
//                return false;
//            }
//        } else if (charp.length == 0) {
//            return false;
//        }
        return recursionMatch(s, 0, p, 0);
    }

    private boolean recursionMatch(String s, int sindex, String p, int pindex) {
        // 如果之前做过这个地方则判断这之后的可能
        if (mem[sindex][pindex] != -1) {
            return mem[sindex][pindex] == 1;
        }

        if (sindex == s.length() && pindex == p.length()) {
            mem[sindex][pindex] = 1;
            return true;
        } else if (sindex == s.length()) {
            String tmp = p.substring(pindex);
            tmp = tmp.replace("*", "");
            boolean tmpbool = tmp.length() == 0;
            if (tmpbool) {
                mem[sindex][pindex] = 1;
            } else {
                mem[sindex][pindex] = 0;
            }
            return tmpbool;
        } else if (pindex == p.length()) {
            mem[sindex][pindex] = 0;
            return false;
        }

        char chars = s.charAt(sindex);
        char charp = p.charAt(pindex);
        boolean tmpbool;
        if (charp != '*' && charp != '?') {
            tmpbool = chars == charp && recursionMatch(s, sindex + 1, p, pindex + 1);
        } else if (charp == '?') {
            tmpbool = recursionMatch(s, sindex + 1, p, pindex + 1);
        } else {
            boolean allPossible = false;
            // *匹配一个空字符串
            for (int i = sindex; i <= s.length(); i++) {
                allPossible = allPossible || recursionMatch(s, i, p, pindex + 1);
            }
            tmpbool = allPossible;
        }
        if (tmpbool) {
            mem[sindex][pindex] = 1;
        } else {
            mem[sindex][pindex] = 0;
        }
        return tmpbool;
    }

    public boolean isMatch2(String s, String p) {
        char[] chars = s.toCharArray();
        int lengths = s.length();
        char[] charp = p.toCharArray();
        int lengthp = p.length();
        if (chars.length == 0 && charp.length == 0) {
            return true;
        } else if (chars.length == 0) {
            if (charp.length == 0 || p.startsWith("*")) {
                return true;
            } else {
                return false;
            }
        } else if (charp.length == 0) {
            return false;
        }
        String[] notContainAny = p.split("\\*");
        List<int[]> indexBoundList = new ArrayList<>();
        int[] indexBound = new int[2];
        for (int i = 0; i < notContainAny.length; i++) {
            indexBound = match(notContainAny[i], s, i == 0 ? 0 : indexBound[1] + 1);
        }
        return false;
    }

    private int[] match(String p, String s, int startIndex) {
        if (p.length() == 0) {
            return new int[]{0, Integer.MAX_VALUE};
        }
        char[] charp = p.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            if (charp[i] != '?') {
                int start = s.indexOf(charp[i], startIndex);
            }
        }

        return new int[0];
    }

    /**
     * 通过递归法解决该问题后，发现该问题存在子问题重复计算的问题，同时左侧的答案依赖于右侧的子问题答案，并且这种依赖只是单向的，也存在最优的一个解，即可以匹配
     * 按照动态规划问题的三个要素，重复子问题，单向性依赖，最优子结构，这个题是可以通过动态规划来解答的
     *
     *
     * 从递归解法中可以看到该问题的备忘录需要二维数组，同时这个数组不应该是boolean类型，而应该是int型，需要三值状态，初始化-1，不匹配0，匹配1
     * 还是从递归解法中可以看到，该问题的计算方向应该是从右下角往左上角
     * 定义备忘录dp[i][j]其中 dp[i][j] 表示s.subString(i)能否匹配上p.subString(j)，按照上述的情况 dp[i][j]的值有三种，分别是初始-1，不能匹配0，匹配1
     *
     * 初始状态
     *  对于s.subString(s.length)来说，除了p全是*的子串，否则都是false。因为此时s为空字符，只有p为空或者全为*的情况能匹配。这是最下面一行的初始状态。
     *  对于p.subString(p.length)来说，只要s有字符，就是false。因为此时p为空字符，除非s也为空字符，否则都无法匹配。这是最右一列的初始状态。
     *  对于dp[s.length][p.length]来说，此时就是可以匹配，因为两个字符都是空
     *
     * 由递归解法可知计算方向是右下到左上
     *
     * 当p.charAt(j)为普通字符并且和s.charAt(i)一样的时候，dp[i][j]和dp[i + 1][j + 1]保持一致
     * 当p.charAt(j)为?时，dp[i][j]和dp[i + 1][j + 1]保持一致
     * 当p.charAt(j)为*时，
     *      可以把这个*当作不存在，此时dp[i][j]和dp[i][j + 1]保持一致
     *      可以把这个*匹配s.charAt(i)，此时dp[i][j]和dp[i + 1][j + 1]保持一致
     *      可以把这个*匹配多个s上的字符，此时dp[i][j]和dp[i + 1][j]保持一致
     *          此时p.subString(j)这个子串是以*开头的，如果此时dp[i + 1][j]是true，那么后续这一列的i -> 0，即无论在s.subString(i)前面插入多少字符，都应该是true
     *                                            如果此时dp[i + 1][j]是false，那么当前这个地方的dp[i][j] 则取决于上面另外两种情况
     *
     *
     * 状态转移方程dp[i][j] = {(p.charAt(j)=='*' && (dp[i + 1][j + 1]==1 || dp[i + 1][j]==1 || dp[i][j + 1]==1)) || (p.charAt(j)=='?'&&dp[i+1][j+1]==1) ? 1 : 0}
     *
     * 完成所有解题准备以后发现三元状态值是没必要的，-1这个状态是用不到的，可以进一步优化为二元状态值，即boolean类型
     *
     * 进一步优化备忘录的定义dp[i][j表示s.subString(i)能否匹配上p.subString(j)，可以则dp[i][j]为true否则就是false
     *
     * 状态转移方程dp[i][j] = {(p.charAt(j)=='*' && dp[i + 1][j + 1]||dp[i + 1][j]||dp[i][j + 1]) || (p.charAt(j)=='?'&&dp[i+1][j+1]) || (p.charAt(j)==s.charAt(i) && dp[i+1][j+1])}
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        int lengths = s.length();
        char[] charp = p.toCharArray();
        int lengthp = p.length();

        boolean[][] dp = new boolean[lengths + 1][lengthp + 1];
        dp[lengths][lengthp] = true;
        for (int i = lengthp - 1; i >= 0; i--) {
            if (dp[lengths][i + 1] && charp[i] == '*') {
                dp[lengths][i] = true;
            }
        }
        for (int i = lengths - 1; i >= 0; i--) {
            for (int j = lengthp - 1; j >= 0; j--) {
                char tmpp = charp[j];
                char tmps = chars[i];
                if (tmpp == tmps || tmpp == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                } else if (tmpp == '*') {
                    dp[i][j] = dp[i][j + 1] || dp[i + 1][j + 1] || dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Wildcard_Matching it = new Wildcard_Matching();
//        String s = "leetcode";
//        String p = "*e*t?d*";
//        String s = "aa";
//        String p = "*";
        String s = "";
        String p = "*a*";

        System.out.println(it.isMatch(s, p));
    }
}
