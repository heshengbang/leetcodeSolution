package com.hsb.leetcode.medium;

/**
 * https://blog.csdn.net/TomAndersen/article/details/106482483
 */
public class Single_Number_II {

    /**
     * 核心思想就是每个数字都是32位0/1构成的，那么每个出现三次的数字，他们对应比特位的0/1出现次数也应该是3次
     * 出现一次的数字，它对应比特位的0/1不用管，只需要把那些比特位上1出现三次的比特位去掉三次，剩下的0/1都是只出现一次比特位对应的值
     *
     * 举个例子 [2，2，3，2] 这里面的二进制形式是10，10，11，10
     * 左至右统计
     *      第一个比特位1出现的次数是1，不用管
     *      第二个比特位1出现的次数是4，满3余1，这个1就是剩下的
     * 对于32位中的每个比特位都要这么处理，所以理论上每个比特位1出现的次数最多可能是3（不是4，因为满3变0，重新循环）
     * 所以用两个数字来代表每个比特位上1出现的次数 x,y
     *  其中x代表高位可以是0/1
     *  y代表地位也是0/1
     *  x/y合起来代表00 ~ 11的范围，正好是0 ~ 3
     * 挨个对每个比特位进行操作计算1出现的次数
     *  如果是0次，不管【对应x = 0, y = 0】
     *  如果是1次，不管【对应x= 0, y = 1】
     *  如果是2次，不管【对应x= 1, y = 0】
     *  如果是3次，变更为0【对应x=1, y = 1，但是需要通过逻辑运算将其转为x = 0, y = 0】
     * 下面的这个ones = 0就代表高位
     *      twos = 0 就代表地位
     *
     */
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (final int num : nums) {
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
        }
        return ones;
    }

    public int singleNumber1(int[] nums) {
        // 设置计数器,以及标记变量
        int a = 0, b = 0, mark = 1;
        // 遍历原始数组,统计各个bit位上数值1出现的次数
        for (int num : nums) {
            a ^= b & num;
            b ^= num;
            // 计算标记变量mark,更新计数器的值,若达到循环点3(即a=1,b=1),则将计数器对应bit位置为0,否则保持不变
            mark = ~(a & b);
            a &= mark;
            b &= mark;
        }
        // 由于本题中,待查找数出现次数为奇数次,因此只要每个bit位的最低计数位为1,则待查找数对应bit位也为1
        return b;
    }
}
