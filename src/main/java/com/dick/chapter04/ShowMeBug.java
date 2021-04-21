package com.dick.chapter04;

/**
 * @author shengwangzhong
 */
public class ShowMeBug {

    /**
     * 
     * // 写一个字符串大整数的加法运算函数，输入为两个正整数字符串，长度不等，上限8192，函数返回这两个正整数之和对应的字符串，举例：“123” + “11” = “134”；
     *
     * // 使用Java语言；时间不超过20分钟；
     */
    public static String sum(String str1, String str2) {
        // TODO: 补全加法运算代码逻辑；
        int carry = 0;
        char[] strArray1 = str1.toCharArray();
        char[] strArray2 = str2.toCharArray();
        String str = "";
        String returnStr = "";
        if (strArray1.length == strArray2.length) {
            for (int i = strArray1.length - 1; i >= 0; i--) {
                int a = strArray1[i] - 48 + strArray2[i] - 48 + carry;
                if (a >= 10) {
                    carry = 1;
                    str = str + (a - 10);
                } else {
                    // 没有进位
                    carry = 0;
                    str = str + a;
                }
            }
            if (carry != 0) {
                str = str + carry;
            }

            char[] c = str.toCharArray();
            for (int i = c.length - 1; i >= 0; i--) {
                returnStr += c[i];
            }
        } else if (strArray1.length > strArray2.length) {
            // 长度不一致 前边长后边短
            int j = strArray2.length - 1;
            for (int i = strArray1.length - 1; i >= 0; i--) {
                if (i == strArray1.length - strArray2.length - 1) {
                    break;
                }
                int a = strArray1[i] + strArray2[j] - 48 - 48 + carry;
                j--;
                if (a >= 10) {
                    carry = 1;
                    str = str + (a - 10);
                } else {
                    carry = 0;
                    str = str + a;
                }
            }

            if (carry == 0) {
                String s = "";
                for (int i = 0; i < strArray1.length - strArray2.length; i++) {
                    s = s + (strArray1[i] - 48);
                }
                char[] c = str.toCharArray();
                for (int i = c.length - 1; i >= 0; i--) {
                    s = s + c[i];
                }
                returnStr = s;
            } else {
                // 产生进位
                int temp[] = new int[strArray1.length - strArray2.length];
                for (int i = strArray1.length - strArray2.length - 1; i >= 0; i--) {
                    temp[i] = strArray1[i] - 48;
                }
                String s = "";
                for (int i = temp.length - 1; i >= 0; i--) {
                    temp[i] = temp[i] + carry;
                    if (temp[i] >= 10) {
                        temp[i] = temp[i] - 10;
                        carry = 1;
                    } else {
                        carry = 0;
                        break;
                    }
                    if (i == 0) {
                        break;
                    }
                }
                // 最后的最后还有进位
                if (carry == 1) {
                    for (int i = 0; i < temp.length; i++) {
                        s = s + temp[i];
                    }
                    s = 1 + s;
                } else {
                    // 最后没进位
                    for (int i = 0; i < temp.length; i++) {
                        s = s + temp[i];
                    }
                }
                // append str
                char[] c = str.toCharArray();
                for (int i = c.length - 1; i >= 0; i--) {
                    s += c[i];
                }
                returnStr = s;
            }
        } else {
            return sum(str2, str1);
        }
        return returnStr;
    }

    public static void main(String[] args) {
        String str1 = "123123";
        String str2 = "879";
        String result = sum(str2, str1);
        System.out.println("The sum is: " + result);
    }
}
