package com.hsb.leetcode.medium;

import java.util.HashSet;

public class Minimum_Genetic_Mutation {
    private int result;
    public int minMutation(String startGene, String endGene, String[] bank) {
        result = -1;
        boolean[] path = new boolean[bank.length];
        bfs(startGene, endGene, 0, bank, path);
        return result;
    }

    private void bfs(String startGene, String endGene, int count, String[] bank, boolean[] path) {
        if (startGene.equals(endGene)) {
            if (result != -1) {
                result = Math.min(result, count);
            } else {
                result = count;
            }
            return;
        }

        char[] chars = startGene.toCharArray();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < bank.length; j++) {
                if (path[j]) {
                    continue;
                }
                char tmpChar = chars[i];
                if (tmpChar != 'A') {
                    chars[i] = 'A';
                    String tmpStr = new String(chars);
                    if (tmpStr.equals(bank[j])) {
                        path[j] = true;
                        bfs(tmpStr, endGene, count + 1, bank, path);
                        path[j] = false;
                    }
                }

                if (tmpChar != 'C') {
                    chars[i] = 'C';
                    String tmpStr = new String(chars);
                    if (tmpStr.equals(bank[j])) {
                        path[j] = true;
                        bfs(tmpStr, endGene, count + 1, bank, path);
                        path[j] = false;
                    }
                }

                if (tmpChar != 'T') {
                    chars[i] = 'T';
                    String tmpStr = new String(chars);
                    if (tmpStr.equals(bank[j])) {
                        path[j] = true;
                        bfs(tmpStr, endGene, count + 1, bank, path);
                        path[j] = false;
                    }
                }

                if (tmpChar != 'G') {
                    chars[i] = 'G';
                    String tmpStr = new String(chars);
                    if (tmpStr.equals(bank[j])) {
                        path[j] = true;
                        bfs(tmpStr, endGene, count + 1, bank, path);
                        path[j] = false;
                    }
                }
                chars[i] = tmpChar;
            }
        }
    }

    public static void main(String[] args) {
//        String startGene = "AACCGGTT", endGene = "AACCGGTA";
//        String[] bank = {"AACCGGTA"};

        String startGene = "AACCGGTT", endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};

        Minimum_Genetic_Mutation it = new Minimum_Genetic_Mutation();
        System.out.println(it.minMutation(startGene, endGene, bank));

    }

}
