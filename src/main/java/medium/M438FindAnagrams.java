package medium;

import javax.naming.InitialContext;
import java.util.*;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/25 16:10
 * @Description: 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *  
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class M438FindAnagrams {
    public static void main(String[] args) {
        String s = "bbb";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : pc) {
            pMap.merge(c, 1, Integer::sum);
        }
        int sIndex = 0;
        while (true) {
            Map<Character, Integer> sMap = new HashMap<>();
            int start = getInitSMap(sc, sIndex, sMap, pMap.keySet(), p.length());
            if (start == Integer.MAX_VALUE) {
                break;
            }
            if (isAnagrams(sMap, pMap)) {
                res.add(start);
            }
            sIndex = findAnagramsInRange(start, sc, pc, sMap, pMap, res);
            if (sIndex == Integer.MAX_VALUE) {
                break;
            }
        }


        return res;
    }

    private static int findAnagramsInRange(int start, char[] sc, char[] pc, Map<Character, Integer> sMap, Map<Character, Integer> pMap, List<Integer> res) {
        for (int i = start + 1; i <= sc.length - pc.length; i++) {
            int end = i + pc.length - 1;
            if (!pMap.containsKey(sc[end])) {
                return end + 1;
            }
            sMap.merge(sc[i - 1], -1, Integer::sum);
            sMap.merge(sc[end], 1, Integer::sum);
            if (isAnagrams(sMap, pMap)) {
                res.add(i);
            }
        }
        return Integer.MAX_VALUE;
    }


    private static int getInitSMap(char[] sc, int start, Map<Character, Integer> sMap, Set<Character> pSet, int len) {
        int count = 0;
        for (int i = start; i < sc.length; i++) {
            if (!pSet.contains(sc[i])) {
                sMap.clear();
                count = 0;
                continue;
            }
            sMap.merge(sc[i], 1, Integer::sum);
            if (++count == len) {
                return i - len + 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 是否是异位
     *
     * @param sMap
     * @param pMap
     * @return
     */
    private static boolean isAnagrams(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
            if (!entry.getValue().equals(sMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
