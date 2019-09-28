package com.hsb.leetcode.easy;

/**
 * @author heshengbang
 * 2019/9/28.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 *
 *
 */

public class Maximum_Number_of_Balloons {
    public int maxNumberOfBalloons(String text) {
        String alloon = text.replaceAll("b", "");
        int times = text.length() - alloon.length();
        if (times == 0) {
            return 0;
        }
        String lloon = alloon.replaceAll("a", "");
        if (alloon.length() - lloon.length() == 0) {
            return 0;
        } else {
            times = times < alloon.length() - lloon.length() ? times : alloon.length() - lloon.length();
        }
        String oon = lloon.replaceAll("l", "");
        if (lloon.length() - oon.length() == 0) {
            return 0;
        } else {
            int lTimes = (lloon.length() - oon.length()) / 2;
            times = times < lTimes ? times : lTimes;
        }

        String n = oon.replaceAll("o", "");
        if (oon.length() - n.length() == 0) {
            return 0;
        } else {
            int oTimes = (oon.length() - n.length()) / 2;
            times = times < oTimes ? times : oTimes;
        }

        String rest = n.replaceAll("n", "");
        if (n.length() - rest.length() == 0) {
            return 0;
        } else {
            times = times < n.length() - rest.length() ? times : n.length() - rest.length();
        }
        return times;
    }


    public static void main(String[] args) {
        Maximum_Number_of_Balloons item = new Maximum_Number_of_Balloons();
        System.out.println(item.maxNumberOfBalloons("loonbalxballpoon"));
    }
}
