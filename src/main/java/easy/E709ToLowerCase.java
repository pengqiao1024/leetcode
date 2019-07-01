package easy;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 17:48
 */

/**
 * 转换成小写字母
 * <p>
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * <p>
 * 示例 1：
 * 输入: "Hello"
 * 输出: "hello"
 * <p>
 * 示例 2：
 * 输入: "here"
 * 输出: "here"
 * <p>
 * 示例 3：
 * 输入: "LOVELY"
 * 输出: "lovely"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E709ToLowerCase {
    public static void main(String[] args) {
        String s = "LOVELY";
        System.out.println(toLowerCase(s));
    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {//char字段可以直接用单引号与字符比较ASCII值
                sb.append((char) (c + 32));//小写比大写的ASCII值大32
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
