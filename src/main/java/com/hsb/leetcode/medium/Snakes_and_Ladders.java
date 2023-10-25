package com.hsb.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Snakes_and_Ladders {
    public int snakesAndLadders(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean fromLeftToRight = true;
        Map<Integer, Integer> mem = new HashMap<>();
        int index = 1;
        for (int i = m - 1; i >= 0; i--) {
            if (fromLeftToRight) {
                for (int j = 0; j < n; j++) {
                    mem.put(index++, board[i][j]);
                }
                fromLeftToRight = false;
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    mem.put(index++, board[i][j]);
                }
                fromLeftToRight = true;
            }
        }
        HashSet<Integer> start = new HashSet<>();
        start.add(1);
        return bfs(start, n * m, mem, new HashSet<>(), 0);
//        return dfs(1, n * m, mem, new HashSet<>(), 0);
    }

    private Map<Integer, Integer> stepMem = new HashMap<>();
    private int dfs(int start, int dest, Map<Integer, Integer> mem, HashSet<Integer> hasVisited, int step) {
        if (start == dest) {
            stepMem.put(start, step);
            return step;
        }
        if (hasVisited.contains(start)) {
            stepMem.put(start, -1);
            return -1;
        }
        hasVisited.add(start);
        int maxReachStep = Math.min(dest, start + 6);
        int minStep = Integer.MAX_VALUE;
        for (int i = 1;; i++) {
            if (start + i <= maxReachStep) {
                if (new Integer(-1).equals(mem.get(start + i))) {
                    int ans;
                    if (stepMem.containsKey(start + i)) {
                        ans = stepMem.get(start + i) + step;
                    } else {
                        ans = dfs(start + i, dest, mem, hasVisited, step + 1);
                    }
                    if (ans != -1) {
                        minStep = Math.min(ans, minStep);
                    }
                } else {
                    int ans;
                    if (stepMem.containsKey(mem.get(start + i))) {
                        ans = stepMem.get(mem.get(start + i)) + step;
                    } else {
                        ans = dfs(mem.get(start + i), dest, mem, hasVisited, step + 1);
                    }
                    if (ans != -1) {
                        minStep = Math.min(ans, minStep);
                    }
                }
            } else {
                break;
            }
        }
        hasVisited.remove(start);
        if (minStep == Integer.MAX_VALUE) {
            stepMem.put(start, -1);
            return -1;
        } else {
            stepMem.put(start, minStep);
            return minStep;
        }
    }

    private int bfs(HashSet<Integer> start, int dest, Map<Integer, Integer> mem, HashSet<Integer> hasVisited, int step) {
        HashSet<Integer> nextStep = new HashSet<>();
        for (Integer it: start) {
            if (hasVisited.contains(it)) {
                continue;
            }
            hasVisited.add(it);
            int maxReachStep = Math.min(dest, it + 6);
            for (int i = 1;; i++) {
                if (it + i <= maxReachStep) {
                    if (new Integer(-1).equals(mem.get(it + i))) {
                        nextStep.add(it + i);
                    } else {
                        nextStep.add(mem.get(it + i));
                    }
                } else {
                    break;
                }
            }
        }
        if (nextStep.contains(dest)) {
            return step + 1;
        }
        if (nextStep.isEmpty()) {
            return -1;
        }
        return bfs(nextStep, dest, mem, hasVisited, step + 1);
    }

    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        Snakes_and_Ladders it = new Snakes_and_Ladders();
        System.out.println(it.snakesAndLadders(board));
    }
}
