package com.hsb.leetcode.medium;

public class Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
            total = total + rest[i];
        }
        if (total < 0) {
            return -1;
        }
        int startIndex = 0, leftGas = 0;
        for (int i = 0; i < gas.length; i++) {
            leftGas += rest[i];
            if (leftGas < 0) {
                leftGas = 0;
                startIndex = i + 1;
            }
        }
        System.gc();
        return startIndex;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        boolean allGasZero = true;
        boolean allCostZero = true;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] == 0) {
                if (cost[i] != 0) {
                    continue;
                } else {

                }
            }
            if (gas[i] == 0 && cost[i] != 0) {
                continue;
            } else if (gas[i] == 0 && cost[i] == 0) {

            }
            int rest = gas[i], tmp, index = i;
            boolean start_flag = true;
            while (start_flag || index != i) {
                start_flag = false;
                tmp = cost[index];
                index++;
                if (index == gas.length) {
                    index = 0;
                }
                rest = rest - tmp;
                if (rest < 0) {
                    break;
                }
                rest = rest + gas[index];
            }
            if (rest >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Gas_Station item = new Gas_Station();
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
        // -2 -2 -2 3 3

        int[] gas = {3,1,1};
        int[] cost = {1,2,2};

//        int[] gas = {2};
//        int[] cost = {2};

//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};
        // -1 -1 1

//        int[] gas = {5,8,2,8};
//        int[] cost = {6,5,6,6};
        // -1 3 -4 2

//        int[] gas = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2};
//        int[] cost = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0};


        System.out.println(item.canCompleteCircuit(gas, cost));
    }
}
