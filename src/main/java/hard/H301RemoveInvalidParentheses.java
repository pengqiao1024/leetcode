package hard;

import utils.Utils;

import java.util.*;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/9/17 18:32
 * @Description: 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *  
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * <p>
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * <p>
 * 示例 3：
 * 输入：s = ")("
 * 输出：[""]
 */
public class H301RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("x("));
    }

    public static List<String> removeInvalidParentheses(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new LinkedList<>();
        boolean isInvalid = false;
        char[] eIndexes = new char[s.length()];//记录下标情况，无问题记为0，否则记为当前需要处理的字符
        for (int i = 0; i < s.length(); i++) {
            eIndexes[i] = '0';
            if (chars[i] == '(') {
                deque.addLast(i);
            } else if (chars[i] == ')') {
                if (deque.isEmpty()) {
                    isInvalid = true;
                    eIndexes[i] = ')';
                } else {
                    deque.pollLast();
                }
            }
        }
        while (!deque.isEmpty()) {
            eIndexes[deque.pollLast()] = '(';
            isInvalid = true;
        }
        if (!isInvalid) {
            return List.of(s);
        }
        List<Set<String>> sl = new ArrayList<>();
        int pre = 0;
        for (int i = 0; i < eIndexes.length; i++) {
            if (eIndexes[i] == '0') {
                if (i == eIndexes.length - 1) {
                    if (eIndexes[pre] == ')') {
                        String subs = new String(chars, pre + 1, eIndexes.length - 1 - pre);
                        sl.add(Set.of(subs));
                    } else if (eIndexes[pre] == '(') {
                        sl.add(removeOneChar(chars, pre, i, '('));
                    }
                }
            } else if (eIndexes[i] == '(') {
                if (eIndexes[pre] == 0) {
                    if (pre == 0) {
                        String subs = new String(chars, 0, i);
                        sl.add(Set.of(subs));
                    }
                } else if (eIndexes[pre] == '(') {
                    sl.add(removeOneChar(chars, pre, i - 1, '('));
                } else {
                    String subs = new String(chars, pre + 1, i - pre - 1);
                    sl.add(Set.of(subs));
                }
                pre = i;
            } else if (eIndexes[i] == ')') {
                sl.add(removeOneChar(chars, pre, i, ')'));
                pre = i;
            }
        }
        System.out.println(sl);
        List<String> res = new ArrayList<>();
        res.add("");
        for (Set<String> strings : sl) {
            List<String> nr = new ArrayList<>();
            if (strings != null && strings.size() > 0) {
                for (String str : res) {
                    for (String ss : strings) {
                        nr.add(str + ss);
                    }
                }
                res = nr;
            }
        }
        return res;
    }

    /**
     * 移除(
     *
     * @param chars
     * @param left
     * @param right
     * @return
     */
    private static Set<String> removeOneChar(char[] chars, int left, int right, char remove) {
        Set<String> res = new HashSet<>();
        if (left == right) {
            return res;
        }
        for (int i = left; i <= right; i++) {
            if (chars[i] == remove) {
                String str = new String(chars, left, i - left) + new String(chars, i + 1, right - i);
                if (isInvalid(str)) {
                    res.add(str);
                }
            }
        }
        return res;
    }

    private static boolean isInvalid(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                deque.addLast(i);
            } else if (chars[i] == ')') {
                if (deque.isEmpty()) {
                    return false;
                } else {
                    deque.pollLast();
                }
            }
        }
        return deque.isEmpty();
    }
}
