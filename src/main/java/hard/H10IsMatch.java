package hard;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/12 11:15
 * @Description: 给定一个字符串s和一个字符规律p，实现一个支持'.'和'*'的正则表达式匹配
 * ‘.’匹配任一单个字符
 * '*'匹配领个或多个前面那一个元素
 * 所谓匹配，是涵盖整个字符串s
 * s仅包含a-z的小写字母  *每次出现时，前面都匹配到有效字符
 * <p>
 * 示例1
 * 输入: s="aa" p="a"
 * 输出:false
 * 解释:a无法匹配整个字符串
 * <p>
 * 示例2
 * 输入: s="aa" p="a*"
 * 输出:true
 * 解释:
 * <p>
 * 示例3
 * 输入: s="ab" p=".*"
 * 输出:true
 * 解释:
 * <p>
 * 示例3
 * 输入: s="aab" p="c*a*b*"
 * 输出:true
 * 解释:c0个，a2个 b1个
 * <p>
 * * 示例3
 * 输入: s="mississippi" p="mis*is*p*"
 * 输出:false
 * 解释:
 */
public class H10IsMatch {
    public static void main(String[] args) {
        String s = "2*1";
        System.out.println(s.substring(0, 1));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            throw new RuntimeException("param error");
        }
        int pos = p.indexOf(".*");
        int i = 0;//s字符串的下标
        for (int j = 0, pj = 0; j < p.length(); j++) {
            char c = p.charAt(j);
            if (c == '*') {
                if (!s.substring(i, i + j - pj).equals(p.substring(pj, j))) {
                    return false;
                }
                pj = j;
                i = i + j - pj;
            } else if (c == '.') {
                if (j < p.length() - 2 && p.charAt(j + 1) == '*') {
                    if (j < p.length() - 3) {
                        j = j + 2;
                    } else {
                        return true;
                    }
                } else {
                    i++;
                }
            } else {
                if (s.indexOf(i++) != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
