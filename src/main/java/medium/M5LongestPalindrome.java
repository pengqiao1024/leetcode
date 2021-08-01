package medium;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M5LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int left = 0;
        int maxLength = 0;
        String res = null;
        while (left < s.length()) {
            String tmp = s;
            char lc = s.charAt(left);
            while (true) {
                int index = tmp.lastIndexOf(lc);
                tmp = s.substring(left, index + 1);
                if (isPalindrome(tmp)) {
                    if (tmp.length() > maxLength) {
                        maxLength = tmp.length();
                        res = tmp;
                    }
                    if (s.length() - left < maxLength) {
                        return res;
                    }
                    break;
                }
            }
            left++;
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
