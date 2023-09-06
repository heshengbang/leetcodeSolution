package com.hsb.leetcode.dp;

public class Lesson12 {
    /**
     * 给定一个整数数组array，求这个数组中乘积最大的子数组，并返回该子数组的乘积
     *
     * 从重叠子问题，无后效性，最优子结构的三个判断依据判定，这个题可以用动态规划来解决
     *
     * 无论哪个子数组，必定以array中的某个元素为最大乘积子数组的最后一个元素
     * 备忘录可以用一维数组，dp[i]表示以i为最后一个元素的最大乘积的值，这其中必定有题中要求的答案
     *  示例：{2， 8，-2， 4} 中 dp[0] = 2，dp[1]=16
     * 初始化，每个元素位置，最小的乘积都是自己，所以初始化的时候可以dp[i] = array[i]
     * 状态转移方程
     *  dp[i] = dp[i - 1] * array[i]
     *  但是array[i]有可能是为负数，同样dp[i - 1]也有可能为负数
     *      如果dp[i - 1]为负数，array[i] 为正数，则乘积为负数，并且变得更小了，此时反而求到了以i为最后一个元素的子数组中乘积最小的值
     *      如果dp[i - 1]为负数，array[i] 为负数，则乘积为正数，此时变得更大了，此时求到了题中要求的以i为最后一个元素的子数组中乘积最大的值
     *      如果dp[i - 1]为正数，array[i] 为正数，则乘积为正数，此时变得更大了，此时求到了题中要求的以i为最后一个元素的子数组中乘积最大的值
     *      如果dp[i - 1]为正数，array[i] 为负数，则乘积为负数，此时变得更小了，此时反而求到了以i为最后一个元素的子数组中乘积最小的值
     *  从上面的分析来看，dp[i - 1]和array[i]的正负性会影响下一步的决策，array[i]并不会变，但是dp[i - 1]可能因为它的子问题发生变化，所以需要将dp中的的正负作为一个考虑
     *  除了保存以i为最后一个元素的子数组中的最大乘积之外，还需要考虑它的最小乘积，因为如果它乘上一个负数，则可以反转来成为最大的值
     *  所以回溯 上一步，定义备忘录的时候，应该定义最大和最小两个备忘录
     *  max_dp[i] 表示以i为最后一个元素的子数组中最大的乘积
     *  min_dp[i] 表示以i为最后一个元素的子数组中最小的乘积
     *
     *  状态转移方程 max_dp[i] = {array[i] > 0, max[i - 1] * array[i]; array[i] = 0, 0; array[i] < 0, min[i - 1] * array[i]}
     *  状态转移方程 min_dp[i] = {array[i] > 0, min[i - 1] * array[i]; array[i] = 0, 0; array[i] < 0, max[i - 1] * array[i]}
     *
     *  遍历max_dp[]，获取到最大值，也可以在max_dp[]求值的过程中保存一个最大值
     *
     * @param array 给定数组
     * @return 子数组最大的乘积
     */
    private int getMaxProduct(int[] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return array[0];
        }
        // dp[i]保存以i为最后一个元素的子数组的最大乘积
        int[] max_dp = new int[length];
        // dp[i]保存以i为最后一个元素的子数组的最小乘积
        int[] min_dp = new int[length];
        // 初始状态，以i为最后一个元素的子数组最小都是它本身，所以乘积也是它本身
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            max_dp[i] = array[i];
            min_dp[i] = array[i];
            ans = Math.max(ans, array[i]);
        }
        for (int i = 1; i < length; i++) {

            // 重新定义了两个极值备忘录以后，重新分析
            // 如果array[i]为负数，要求max_dp则应该用以i为最后一个元素的子数组的最小乘积乘以array[i]，结果是最大的max_dp[i]
            if (array[i] < 0) {
                max_dp[i] = min_dp[i - 1] * array[i];
                min_dp[i] = max_dp[i - 1] * array[i];
            } else if (array[i] == 0) {
                max_dp[i] = 0;
                min_dp[i] = 0;
            } else {
                max_dp[i] = max_dp[i - 1] * array[i];
                min_dp[i] = min_dp[i - 1] * array[i];
            }
            ans = Math.max(ans, max_dp[i]);
        }
        return ans;
    }




    /**
     * 给定数组array和一个整数k，找出k个不重叠的子数组，使它们的和最大。
     *  每个子数组中的元素在原数组中都应该使连续的，但是子数组之间不要求连续，也不要求这k个子数组就是整个数组array
     *  示例1：array={1,2,3,4}  k=1，输出 6
     *      解释：将数组划分为1个子数组，而这个数组中的所有元素都是正数，所以元素越多越好，整个数组的子数组就拥有最大和，结果就是10
     *  示例2：array={-1, 4, -2, 3, -2, 3}, k=2，输出8
     *      解释：将数组划分2个子数组，可以划分为{4} 和 {3， -2 ，3}这两个子数组，它们的和为8
     *
     *  从题目中可以看到k的数目会直接影响结果
     *      如果k大于数组长度，那么这个时候无法划分，最大和应该是 0
     *      如果k等于数组长度，那么这个时候数组中的每个元素都构成一个子数组，此时的最大和，其实就是整个数组的所有元素加起来的结果
     *      如果k小于数组长度，那么就表示划分子数组的时候可以考虑某些负元素是可以不取，这样可以获取到子数组的最大和
     * 按照经验来看，数组的索引应该是一个状态参数，k就是另一个状态参数，这样就有两个状态参数
     * 两个状态参数之间也互相影响，所以需要一个二维数组来作为备忘录dp[][]
     * dp[i][j] 表示从array的0 ~ j的位置中取i个子数组，而这个dp[i][j]表示取出来的这些子数组的最大和
     *      参照上面示例2中，dp[2][3]就表示从-1，4，-2，3中取两个子数组，例如{4}，{3} 这样dp[2][3] = 7
     *  初始状态，dp[i][j]中j > i 为 0，如果j == i 则是sum(array[0 ... i])，此为初始状态
     *
     *  状态转移方程
     *      dp[i][j] 需要考虑是否要把array[j] 放到i个数组中的第i个。（因为要求连续的原因，array[j]即便要被放入，也只能放到第i个数组中）
     *          不放入，此时就相当于从j - 1个元素中挑选i个数组，使其和最大，即dp[i][j - 1]
     *          如果放入，则考虑其是否和其他元素放在一起，还是自己单独一个子数组，评判标准是谁的和更大一些，谁就是应该被决策中
     *              如果和其他元素一起，就相当于是在从 0 ~ j个元素中挑选i个数组，并且第i个数组中一定包含第j个元素
     *                  按照上述描述是无法直接获得这个值的，但是可以另外设置一个备忘录来从子问题中推导出来
     *
     *                      从给定数组nums中选取k个子数组，并且nums数组的最后一个元素一定在第k个子数组的最后一个位置
     *                      假定新的备忘录是status[k][i]
     *                          如果i < k，显然是无法将i个元素的数组分为k个子数组的，所以此时的status[k][i] = 0，此是初始状态其一
     *                          如果i = k，此时一个元素一个子数组，所有子数组的最大和就应该是 status[k][i] = sum(nums[0 ... i]) = status[k - 1][i - 1] + nums[i]，此是初始状态其二
     *                          如果i > k，就考虑从i个元素中取k个子数组，并且第k个子数组中一定要包含第i个元素，这种情况下需要区分，
     *                          第k个子数组中只有第i个元素还是和其他元素共同构成第k个子数组
     *                              如果第k个子数组中只包含第i个元素，那么剩下的i - 1个元素中挑选k-1个子数组，并且也不需要约束第i-1个元素必须在第k-1个子数组中，此时更像是dp[k - 1][i - 1]
     *                                  那么可以推导出status[k][i] = dp[k - 1][i - 1] + nums[i]
     *                              如果第k个子数组中包含了包括第i个元素在内的多个元素，那么意味着第i - 1个元素也在第k个子数组中，即子问题在i - 1个元素中挑选k个子数组使其和最大
     *                                  那么可以推导出status[k][i] = status[k][i - 1] + nums[i]
     *                          具体应该决策哪种，应该以和最大的为准，所以status[k][i] = Max(dp[k - 1][i - 1] + nums[i], status[k][i - 1] + nums[i])
     *
     *                 回到上一个问题，此时就可以获取【从 0 ~ j个元素中挑选i个数组，并且第i个数组中一定要包含第j个元素的值】，即status[i][j]
     *
     *              如果不和其他元素放在一起，就相当于自己单独一个数组
     *                  此时其他元素则相当于从j - 1个元素中挑选i - 1个子数组，使之和最大
     *                  array[j]自己一个元素构成第i个数组，那么dp[i][j] = dp[i - 1][j - 1] + nums[j]
     *
     *      综上，初始化状态以外的状态转移方程dp[i][j] = max(dp[i][j - 1], status[i][j])
     * @param array 给定数组
     * @param k 子数组个数
     * @return 最大的子数组之和
     */
    private int getSubArray(int[] array, int k) {
        int length = array.length;
        // dp[i][j]表示从0 ... i的子数组中选取j个子数组，这j个子数组的和是最大的
        int[][] dp = new int[length + 1][k + 1];
        // dp[i][j]表示从0 ... i的组数组中选取j个子数组，并且第i个元素一定在第j个数组中，这j个子数组的和是最大的
        int[][] status = new int[length + 1][k + 1];

        // 无论多少个元素，分为0个子数组，最大和也是0
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < length + 1; i++) {
            status[i][0] = 0;
        }

        // 无论分多少个数组，元素为0，最大和也是0
        for (int j = 0; j < k + 1; j++) {
            dp[0][j] = 0;
        }
        for (int j = 0; j < k + 1; j++) {
            status[0][j] = 0;
        }

        // i == j的情况，整个数组加起来即可
        for (int x = 1; x < (length < k ? length + 1 : k + 1); x++) {
            dp[x][x] = dp[x - 1][x - 1] + array[x - 1];
            status[x][x] = status[x - 1][x - 1] + array[x - 1];
        }

        for (int i = 1; i < length + 1; i++){
            for (int j = 1; j < k + 1; j++) {
                if (i < j) {
                    // 如果元素个数小于子数组的个数，直接为0
                    dp[i][j] = 0;
                    status[i][j] = 0;
                } else if (i == j) {
                    // 如果元素个数等于子数组的个数，则累加之前的元素即可
                    dp[i][j] = dp[i - 1][j - 1] + array[i - 1];
                    status[i][j] = status[i - 1][j - 1] + array[i - 1];
                } else {
                    // 如果第i个元素单独一个数组
                    status[i][j] = Math.max(status[i][j], dp[i - 1][j - 1] + array[i - 1]);
                    // 如果第i个元素和其他元素公用一个数组，那么i - 1应该和它在一个数组，此时就是子问题status[i - 1][j]
                    status[i][j] = Math.max(status[i][j], status[i - 1][j] + array[i - 1]);

                    // 如果元素个数大于子数组个数，则考虑array[i - 1]是否应该在最优解中
                    // 如果不在最优解中，那么就相当于dp[i - 1][j]
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    // 如果在最优解中则考虑其单独一个子数组还是和其他元素一个子数组
                    // 单独一个数组  dp[i][j] = dp[i - 1][j - 1] + array[i - 1];
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + array[i - 1]);
                    // 和其他元素构成最后一个数组，此时可以取status[i][j]，上面已经有限求出来了
                    dp[i][j] = Math.max(dp[i][j], status[i][j]);
                }
            }
        }
        return dp[length][k];
    }

    public static void main(String[] args) {
        Lesson12 it = new Lesson12();
//        int[] array = {-1, 4, -2, 3, -2, 3};
//        int k = 2;

//        int[] array = {1, 2, 3, 4};
//        int k = 1;

//        System.out.println(it.getSubArray(array, k));


//        int[] array1 = {2, 8, -2, 4};

        int[] array2 = {-2, 0, -1};
        System.out.println(it.getMaxProduct(array2));
    }
}
