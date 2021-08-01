package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/15 15:31
 * @Description: 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * <p>
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H32LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.empty()) {
                stack.pop();
            } else {
                stackRight.push(i);
            }
        }
        if (stack.empty() && stackRight.empty()) {//完全匹配
            return s.length();
        }
        List<Integer> disMatch = new ArrayList<>();
        while (!stack.empty() || !stackRight.empty()) {
            if (stack.empty()) {
                disMatch.add(stackRight.pop());
                continue;
            }
            if (stackRight.empty()) {
                disMatch.add(stack.pop());
                continue;
            }
            if (stack.peek() < stackRight.peek()) {
                disMatch.add(stackRight.pop());
            } else {
                disMatch.add(stack.pop());
            }
        }
        disMatch.add(-1);
        System.out.println(disMatch);
        int last = s.length() - 1;
        int maxLen = 0;
        for (Integer index : disMatch) {
            int len = last - index;
            if (len > maxLen) {
                maxLen = len;
            }
            last = index - 1;
        }
        return maxLen;
    }
}
