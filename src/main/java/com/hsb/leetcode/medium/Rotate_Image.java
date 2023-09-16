package com.hsb.leetcode.medium;


/**
 * 亦或特性
 *  y = x ^ y ^ y
 *  x = x ^ y ^ x
 *
 *  当需要交换两个变量的值，又不想额外使用中间值，可以使用以下方式：
 * a = a ^ b，实际此时 a' = a ^ b
 * b = a ^ b，此时即 a' ^ b，相当于原始的 a ^ b ^ b，所以此时b = a
 * a = a ^ b，此时相当于 a' ^  a，相当于原始的 a ^ b ^ a，所以此时a = b
 * 此时a和b的值就被交换了
 */

public class Rotate_Image {
    /**
     *
     *  * 亦或特性
     *  *  y = x ^ y ^ y
     *  *  x = x ^ y ^ x
     *  *
     *  *  当需要交换两个变量的值，又不想额外使用中间值，可以使用以下方式：
     *  * a = a ^ b，实际此时 a' = a ^ b
     *  * b = a ^ b，此时即 a' ^ b，相当于原始的 a ^ b ^ b，所以此时b = a
     *  * a = a ^ b，此时相当于 a' ^  a，相当于原始的 a ^ b ^ a，所以此时a = b
     *  * 此时a和b的值就被交换了
     *
     * 顺时针旋转90°，先上下颠倒，再按照左上到右下的对角线，交换对应位置的值
     *
     * 如果是顺时针180°，则可以按上面这个方式做两次，也可以上下交换，然后以中轴线交换两边的值
     *
     * @param matrix 给定矩阵
     */
    public void rotate(int[][] matrix) {
        // 将矩形的上下行交换，从最顶还最低，一直到中间，要么换完，要么剩一行没法换
        for (int i = 0, j = matrix.length - 1; i < j; i++, j --) {
            for (int x = 0; x < matrix[0].length; x++) {
                matrix[i][x] = matrix[i][x] ^ matrix[j][x];
                matrix[j][x] = matrix[i][x] ^ matrix[j][x];
                matrix[i][x] = matrix[i][x] ^ matrix[j][x];
            }
        }
        // 以左上到右下角为一条对角线，交换对角线两边对应位置的值
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length;j++) {
                // 不需要自己和自己换
                if (i == j) {
                    continue;
                }
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};

        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        Rotate_Image it = new Rotate_Image();
        it.rotate(matrix);
        System.out.println(matrix);
    }
}
