package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pengqiao01
 * @date: 2019/7/1 18:36
 */

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * <p>
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M227Calculate {
    public static void main(String[] args) {
        String s = "3+5 / 2 ";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        List<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();//存储数字
        for (int i = 0; i < s.length(); i++) {
            String ss = "" + s.charAt(i);
            if (ss.equals(" ")) {//去除空格
                continue;
            }
            if (iscal(ss)) {//是计算符号 则将之前的 数字和该符号 都pup 并清空sb
                pup(strings, sb.toString());
                pup(strings, ss);
                sb = new StringBuilder();
            } else {//是数字 则记录 且继续进行下一个字符串判断
                sb.append(ss);
            }
        }
        pup(strings, sb.toString());//将最后一个字符存入
        return result(strings);
    }

    /**
     * 存储  并进行乘除计算
     * @param list
     * @param s
     */
    private static void pup(List<String> list, String s) {
        list.add(s);
        if (list.size() < 3) {//不够一个操作 结束
            return;
        }
        if (!iscal(s)) {
            String pre = list.get(list.size() - 2);//前一个值，为操作符
            if (pre.equals("*")) {//二阶运算则计算
                int c = Integer.parseInt(list.get(list.size() - 3)) * Integer.parseInt(s);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                list.add("" + c);
            } else if (pre.equals("/")) {
                int c = Integer.parseInt(list.get(list.size() - 3)) / Integer.parseInt(s);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                list.add("" + c);
            }
        }
    }

    private static int result(List<String> list) {
        int sum = Integer.parseInt(list.get(0));
        for (int i = 1; i < list.size(); i += 2) {
            int x = sum;
            int y = Integer.parseInt(list.get(i + 1));
            if (list.get(i).equals("+")) {
                sum = x + y;
            } else {
                sum = x - y;
            }
        }
        return sum;
    }

    private static boolean iscal(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
