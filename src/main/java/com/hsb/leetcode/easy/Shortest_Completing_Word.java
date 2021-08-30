package com.hsb.leetcode.easy;

public class Shortest_Completing_Word {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map = new int[26];
        for (char ch: licensePlate.toLowerCase().toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                continue;
            }
            map[ch - 'a']++;
        }
        String result = "";
        for (String item: words) {
            if (completingWord(map, item)) {
                if (result.length() == 0 || result.length() > item.length()) {
                    result = item;
                }
            }
        }
        return result;
    }

    private boolean completingWord(int[] map, String word) {
        int[] chars = new int[26];
        for (char ch: word.toLowerCase().toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                continue;
            }
            chars[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > chars[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Shortest_Completing_Word item = new Shortest_Completing_Word();
        String licensePlate = "iMSlpe4";
        String[] words = {"claim","consumer","student","camera","public","never","wonder","simple","thought","use"};

        System.out.println(item.shortestCompletingWord(licensePlate, words));
    }
}
