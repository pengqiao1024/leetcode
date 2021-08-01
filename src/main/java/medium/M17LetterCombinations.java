package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/12 14:57
 * @Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("232"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, List<String>> dis = new HashMap<>();
        dis.put('2', List.of("a", "b", "c"));
        dis.put('3', List.of("d", "e", "f"));
        dis.put('4', List.of("g", "h", "i"));
        dis.put('5', List.of("j", "k", "l"));
        dis.put('6', List.of("m", "n", "o"));
        dis.put('7', List.of("p", "q", "r", "s"));
        dis.put('8', List.of("t", "u", "v"));
        dis.put('9', List.of("w", "x", "y", "z"));
        if (digits == null) {
            throw new RuntimeException("param error");
        }
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            return dis.get(digits.charAt(0));
        }
        List<String> res = new ArrayList<>();
        res.addAll(dis.get(digits.charAt(0)));
        for (int i = 1; i < digits.length(); i++) {
            List<String> strs = dis.get(digits.charAt(i));
            List<String> tmp = new ArrayList<>();
            if (strs == null) {
                throw new RuntimeException();
            }
            for (String s : res) {
                for (String ss : strs) {
                    tmp.add(s + ss);
                }
            }
            res = tmp;
        }
        return res;
    }
}
