package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/12 15:47
 * @Description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 */
public class H76MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        String tmp = "";
        int count = 0;
        for (; right < s.length(); right++) {
            if (!tMap.containsKey(s.charAt(right))) {
                continue;
            }
            count++;
            sMap.merge(s.charAt(right), 1, Integer::sum);
            if (count >= t.length() && check(tMap, sMap)) {
                for (; left <= right; left++) {
                    char c = s.charAt(left);
                    if (tMap.containsKey(c)) {
                        sMap.merge(c, -1, Integer::sum);
                        if (!check(tMap, sMap)) {
                            sMap.merge(c, 1, Integer::sum);
                            break;
                        }
                    }
                }
                if (tmp == "" || right - left < tmp.length()) {
                    tmp = s.substring(left, right + 1);
                }
            }
        }
        return tmp;
    }

    private static boolean check(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char k = entry.getKey();
            if (sMap.get(k) == null || sMap.get(k) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
