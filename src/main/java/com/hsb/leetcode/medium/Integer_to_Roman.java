package com.hsb.leetcode.medium;

/**
 * @author heshengbang
 * 2019/10/9.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 */
public class Integer_to_Roman {
    public String intToRoman(int num) {
        String result = "";
        if (num > 2999) {
            result = "MMM";
        } else if (num > 1999) {
            result = "MM";
        } else if (num > 999) {
            result = "M";
        }
        num = num % 1000;
        if (num > 899) {
            result = result + "CM";
        } else if (num > 799) {
            result = result + "DCCC";
        } else if (num > 699) {
            result = result + "DCC";
        } else if (num > 599) {
            result = result + "DC";
        } else if (num > 499) {
            result = result + "D";
        } else if (num > 399) {
            result = result + "CD";
        } else if (num > 299) {
            result = result + "CCC";
        } else if (num > 199) {
            result = result + "CC";
        } else if (num > 99) {
            result = result + "C";
        }
        num = num % 100;
        if (num > 89) {
            result = result + "XC";
        } else if (num > 79) {
            result = result + "LXXX";
        } else if (num > 69) {
            result = result + "LXX";
        } else if (num > 59) {
            result = result + "LX";
        } else if (num > 49) {
            result = result + "L";
        } else if (num > 39) {
            result = result + "XL";
        } else if (num > 29) {
            result = result + "XXX";
        } else if (num > 19) {
            result = result + "XX";
        } else if (num > 9) {
            result = result + "X";
        }
        num = num % 10;
        if (num == 9) {
            result = result + "IX";
        } else if (num == 8) {
            result = result + "VIII";
        } else if (num == 7) {
            result = result + "VII";
        } else if (num == 6) {
            result = result + "VI";
        } else if (num == 5) {
            result = result + "V";
        } else if (num == 4) {
            result = result + "IV";
        } else if (num == 3) {
            result = result + "III";
        } else if (num == 2) {
            result = result + "II";
        } else if (num == 1) {
            result = result + "I";
        }
        return result;
    }

    public String intToRoman1(int num) {
        StringBuffer sb = new StringBuffer("");
        while (num > 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num >= 500) {
                if (num + 100 >= 1000) {
                    sb.append("CM");
                    num = num - 900;
                } else {
                    sb.append("D");
                    num -= 500;
                }
            } else if (num >= 100) {
                if (num + 100 >= 500) {
                    sb.append("CD");
                    num -= 400;
                } else {
                    sb.append("C");
                    num -= 100;
                }
            } else if (num >= 50) {
                if (num + 10 >= 100) {
                    sb.append("XC");
                    num -= 90;
                } else {
                    sb.append("L");
                    num -= 50;
                }
            } else if (num >= 10) {
                if (num + 10 >= 50) {
                    sb.append("XL");
                    num -= 40;
                } else {
                    sb.append("X");
                    num -= 10;
                }
            } else if (num >= 5) {
                if (num + 1 >= 10) {
                    sb.append("IX");
                    num -= 9;
                } else {
                    sb.append("V");
                    num -= 5;
                }
            } else {
                if (num + 1 >= 5) {
                    sb.append("IV");
                    num -= 4;
                } else {
                    sb.append("I");
                    num -= 1;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer_to_Roman item = new Integer_to_Roman();
        // MXMIV  MCMXCIV
        System.out.println(item.intToRoman1(1066));
    }
}
