package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/17 16:44
 * @Description: 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class M139WordBreak {
    public static void main(String[] args) {
        String s = "catsdogan";
        List<String> wordDict = List.of("cats", "dog", "sand", "ans", "cat");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    private static boolean wordBreak(String s, List<String> wordDict, int start) {
        boolean flag = false;
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                if (end == s.length()) {
                    return true;
                }
                if (wordBreak(s, wordDict, end)) {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
