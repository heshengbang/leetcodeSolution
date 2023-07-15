package com.hsb.leetcode.had;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 68. Text Justification
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * https://leetcode.com/problems/text-justification
 *
 */
public class Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> tmp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int stringLength = 0, wordsTotalLength = 0;
        for (int i = 0; i < words.length;) {
            if (stringLength + 1 + words[i].length() > maxWidth) {
                if (stringLength == 0 && words[i].length() == maxWidth) {
                    tmp.add(words[i]);
                    wordsTotalLength += words[i].length();
                    i++;
                }
                result.add(assembleString(tmp, maxWidth - wordsTotalLength, false));
                tmp = new ArrayList<>();
                stringLength = 0;
                wordsTotalLength = 0;
            } else {
                if (tmp.size() == 0) {
                    stringLength = stringLength + words[i].length();
                } else {
                    stringLength = stringLength + 1 + words[i].length();
                }
                tmp.add(words[i]);
                wordsTotalLength += words[i].length();

                i++;
            }
        }
        if (tmp.size() != 0) {
            result.add(assembleString(tmp, maxWidth - wordsTotalLength, true));
        }
        return result;
    }

    private String assembleString(List<String> words, int spaceNums, boolean lastLine) {
        if (words.size() == 1) {
            StringBuilder sb = new StringBuilder(words.get(0));
            sb.append(createSpace(spaceNums));
            return sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        if (lastLine) {
            for (int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                if (i != words.size() - 1) {
                    sb.append(' ');
                }
            }
            if (spaceNums > (words.size() - 1)) {
                sb.append(createSpace(spaceNums - (words.size() - 1)));
            }
        } else {
            int[] spaces = new int[words.size() - 1];
            Arrays.fill(spaces, spaceNums / spaces.length);
            for (int i = 0; i < spaceNums % spaces.length; i++) {
                spaces[i]++;
            }
            for (int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                if (spaces.length > i) {
                    sb.append(createSpace(spaces[i]));
                }
            }
        }
        return sb.toString();
    }

    private char[] createSpace(int space) {
        if (space <= 0) {
            return new char[0];
        }
        char[] chars = new char[space];
        for (int i = 0; i < space; i++) {
            chars[i] = ' ';
        }
        return chars;
    }

    public static void main(String[] args) {
//        Text_Justification item = new Text_Justification();
//        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
//        List<String> results = item.fullJustify(words, 16);
//        for (String it: results) {
//            System.out.println(it);
//        }

//        Text_Justification item = new Text_Justification();
//        String[] words = {"a"};
//        List<String> results = item.fullJustify(words, 1);
//        for (String it: results) {
//            System.out.println(it);
//        }

//        Text_Justification item = new Text_Justification();
//        String[] words = {"Science"};
//        List<String> results = item.fullJustify(words, 7);
//        for (String it: results) {
//            System.out.println(it);
//        }


//        Text_Justification item = new Text_Justification();
//        String[] words = {"What", "is", "Science"};
//        List<String> results = item.fullJustify(words, 7);
//        for (String it: results) {
//            System.out.println(it);
//        }


//        Text_Justification item = new Text_Justification();
//        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
//        List<String> results = item.fullJustify(words, 20);
//        for (String it: results) {
//            System.out.println(it);
//        }



//        Text_Justification item = new Text_Justification();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        List<String> results = item.fullJustify(words, 16);
//        for (String it: results) {
//            System.out.println(it);
//        }

        Text_Justification item = new Text_Justification();
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        List<String> results = item.fullJustify(words, 16);
        for (String it: results) {
            System.out.println(it);
        }
    }
}
