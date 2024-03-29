package com.hsb.leetcode.dp;

public class Lesson11 {

    /**
     * 给定一个未排序的整数数组arrays，找到最长上升序列的个数
     *      给定数组长度不会超过2000，并且结果一定是一个32位有符号整数
     * 首先，这个问题问的最长上升序列的个数，其实换个说法就是最长路径的不同走法
     *
     * 要找到最长上升序列的个数，首先应该知道最长上升序列的长度，所以第一步应该是求这个长度，参考findLengthOfLIS()的解法
     * 求最长长度的过程中会定义一个备忘录dp[]，求这个dp的过程中，其实会接触到每一个可能性，因此可以再定义一个备忘录用以计数
     * 比如定义一个counts，这个counts[i]就表示以i为最后一个上升元素的最长序列的个数
     *  初始状态可以确定的是，counts[i]至少都是1，因为即便单个元素的上升序列，最少的个数也是1，更何况即便有大于1的情况，也至少应该出现1次
     *  状态参数依然是索引，因为只有索引不断变化，才能取得各个位置的最长上升序列的个数
     *  状态转移方程可以参考LIS中的方式，count[i]应该依赖于以下内容：
     *   x < i
     *      arrays[x] < arrays[i]，此时arrays[i]是可以跟在dp[x]所在的上升序列的
     *          对于dp[i]来说，则需要判断是否需要更新
     *              如果dp[i] < dp[x] + 1，则表明之前的最长上升序列并不是最长的，这里还有更长的，所以dp[i] = dp[x] + 1
     *                  而counts[i]则显然应该和counts[x]保持一致，因为dp[i]的值更新为dp[x] + 1
     *              如果dp[i] == dp[x] + 1，则表明之前目前的最长上升序列长度和x位置的最长上升序列加arrays[i]是一致的，所以dp[i]无需变化
     *                  而counts[i]是计算最长个数的，所以应该把dp[x]的个数加上得到新的counts[i]
     *              如果dp[i] > dp[x] + 1，则表明目前是最长上升序列
     *                  而counts[i]自然无需更新
     *     arrays[x] >= arrays[i]，此时i无法和x位置的最长上升序列构成更长的上升序列，dp[i]和counts[i]都无需更新
     *
     * 在结束完循环以后，dp[]中保存了最长上升序列的长度，而counts[]中保存了最长上升序列的个数，由于组成最长上升序列的元素可以不一样，所以最长上升序列的长度可能在dp[]中有多个
     * 因此在之前的循环中，应该保存最长的长度，然后在循环结束后，遍历dp[]，如果和最长长度相等，则将counts[]位置的值加到答案中
     * 遍历结束后，获得答案并返回
     *
     * @param arrays 给定数组
     * @return 最长上升序列的个数
     */
    private int findNumOfLIS(int[] arrays) {
        int length = arrays.length;
        if (length == 0 || length == 1) {
            return length;
        }
        // 初始化的时候，把1当作最长上升序列的长度
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }
        // 定义一个数组，用来存储i这个位置，可以获得dp[i]的不同方式
        int[] counts = new int[length];
        for (int i = 0; i < length; i++) {
            counts[i] = 1;
        }
        int maxLengthOfLIS = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arrays[j] < arrays[i]) {
                    if (dp[i] < dp[j] + 1) {
                        counts[i] = counts[j];
                        dp[i] = dp[j] + 1;
                    } else if (dp[i] == dp[j] + 1) {
                        counts[i] = counts[i] + counts[j];
                    }
                }
            }
            maxLengthOfLIS = Math.max(maxLengthOfLIS, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i] == maxLengthOfLIS) {
                ans += counts[i];
            }
        }
        return ans;
    }

    /**
     *
     * 给定一个无序的整数数组arrays，找到其中最长的上升子序列的长度
     *      1. 可能有多个最长上升序列，返回长度即可
     *      2. 时间复杂度应该在O(n²)
     *
     *  动态规划的三个判断基础：重叠子问题，无后效性，最优子结构
     *
     * 初始状态，对于数组里面的每一个元素来说，哪怕后面没有比它更大的元素了，那它也可以构成以自己为元素的上升序列，长度为 1 。所以 初始状态就是备忘录中所有元素为1
     * 状态参数，同样以数组的索引为变化，从左至右，寻找每一个索引位置的值，但是它们的初始值都是1
     * 备忘录，状态参数只有一个，所以设定一个一维数组为备忘录，数组的值为以当前元素为最后一个上升元素的上升序列的长度
     * 状态转移方程
     *          对于一个给定元素arrays[i]，它要和之前的元素构成递增序列，那么它应该比前面的元素大
     *              假定 arrays[x] < arrays[i] (x < i) 那么arrays[i] 显然可以和arrays[x] 及x之前的元素构成一个递增序列，此时 dp[i] = dp[x] + 1;
     *          x < i 对于i之前的所有元素都是成立的，所以应该取这里面最长的那个dp[i]
     *          即，dp[i] 应该是去遍历i之前的所有arrays元素，找到其中 arrays[x]<arrays[i] && Max(dp[x])，然后加上i位置的这个值的计数1，就是dp[i]的值
     *
     * 状态转移方程就应该是dp[i] = dp[x] + 1，{x < i && arrays[x] < arrays[i] && Max(dp[x])};
     *
     * @param arrays 给定数组
     * @return 最长上升序列的商都
     */
    private int findLengthOfLIS(int[] arrays) {
        int length = arrays.length;
        if (length == 0 || length == 1) {
            return length;
        }
        // dp[i] 表示以i为最后一个上升元素的上升序列的长度
        int[] dp = new int[length];
        // 初始化默认每个上升序列的最短长度都是1
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }
        // 用一个变量记录最长上升序列的长度
        int ans = 1;
        // 不需要从0开始，因为0所在位置的dp[0] 最大也就是1，不会有什么变化
        for (int i = 1; i < length; i++) {
            // 遍历i之前的所有元素
            for (int j = 0; j < i; j++) {
                // 当j处的元素小于i处，那么i处的元素就可以和j处的元素构成一个上升序列，但是只取长度最长的dp[j]
                if (arrays[j] < arrays[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    /**
     * 给定一个未经排序的整数数组，找到最长且连续的递增序列，返回该序列的长度
     *
     * 初始状态   对于数组里面的每一个元素来说，它就是自己最短的递增序列，所以初始状态应该是最短连续递增序列的长度1
     * 状态参数   既然要求连续，那么每一个元素都应该大于前一个元素，这意味着数组的索引需要不断的移动
     *      比如要求的arrays中最长且连续的递增序列，那么最后一个递增序列一定是以arrays[n - 1]结束
     * 所以备忘录 可以根据状态参数，只有一个变量，设定一维数组，并且这个数组中每个元素的值代表一个递增序列以这个元素为最后一个递增元素
     * 状态转移方程  要求dp[i]就需要考虑arrays[i]是否大于arrays[i - 1]
     *      如果大于，则当前这个元素可以和上一个元素所在的连续递增序列继续构成连续递增序列，它的值只需要dp[i - 1] + 1
     *      如果小于等于，则当前这个元素只能是一个新的连续递增序列的开始，即 1
     * 所以状态转移方程应该是  dp[i] = arrays[i] > arrays[i - 1] ? dp[i - 1] + 1 :
     *
     * @param arrays 给定数组
     * @return 最长且连续的递增序列
     */
    private int findLengthOfLCIS(int[] arrays) {
        int length = arrays.length;
        if (length == 0 || length == 1) {
            return length;
        }
        // dp中的元素i代表arrays的子数组 0 ~ i中以i为最后一个递增元素的最长连续递增序列
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            // dp每个元素最低也是1，因为每个元素都可以以自己为最短连续递增序列
            dp[i] = 1;
        }
        // 记录过程中找到的最长连续递增序列的长度
        int ans = 1;
        // 不需要从0开始，因为0所在位置的dp[0] 最大也就是1，不会有什么变化
        for (int i = 1; i < length; i++) {
            if (arrays[i] > arrays[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Lesson11 it = new Lesson11();
        int[] array1 = {6, 6, 6, 6, 6};
        int[] array2 = {1, 3, 5, 0, 7};
        int[] array3 = {10, 9, 1, 5, 2, 6, 66, 18};
        System.out.println(it.findNumOfLIS(array2));
    }

}
