package medium;

import java.util.*;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/26 15:53
 * @Description: 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class M394DecodeString {
    public static void main(String[] args) {
        String res = decodeString("abc3[cd]xyz");
        System.out.println();
        System.out.println(res);
    }

    public static String decodeString(String s) {
        s = "1[" + s + "]";
        return decodeSub(s.toCharArray(), 0, s.length() - 1);
    }

    /**
     * @param chars
     * @param start
     * @param end
     * @return
     */
    private static String decodeSub(char[] chars, int start, int end) {
        System.out.println(new String(chars, start, end - start + 1));
        //获取重复次数
        int numl = start;
        while (chars[start] != '[') {
            start++;
        }
        int num = getNum(chars, numl, start - 1);
        //start-->[   end-->]
        StringBuilder sb = new StringBuilder();
        for (int i = start + 1; i < end; i++) {
            if ((chars[i] >= '0' && chars[i] <= '9')) {
                int subEnd = getEncodeStr(chars, i);
                String subStr = decodeSub(chars, i, subEnd);
                sb.append(subStr);
                i = subEnd;
            } else {
                sb.append(chars[i]);
            }
        }
        String res = "";
        for (int i = 0; i < num; i++) {
            res += sb.toString();
        }
        return res;
    }

    private static int getEncodeStr(char[] chars, int start) {
        Deque<Integer> leftIndexes = new LinkedList<>();
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == '[') {
                leftIndexes.addLast(i);
            } else if (chars[i] == ']') {
                leftIndexes.pollLast();
                if (leftIndexes.isEmpty()) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int getNum(char[] chars, int start, int end) {
        return Integer.parseInt(new String(chars, start, end - start + 1));
    }
}
