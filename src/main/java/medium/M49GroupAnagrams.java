package medium;

import java.util.*;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/6 15:01
 * @Description: 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *  
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * <p>。
 */
public class M49GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        System.out.println(groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String s = new String(cs);
            List<Integer> indexs = map.computeIfAbsent(s, k -> new ArrayList<>());
            indexs.add(i);
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            for (Integer index : entry.getValue()) {
                list.add(strs[index]);
            }
            res.add(list);
        }
        return res;
    }

}
