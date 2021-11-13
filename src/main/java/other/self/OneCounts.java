package other.self;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/10/15 14:22
 * @Description: 请设计一个程序，接收一个介于1000000 到100000000 之间的整数。计算1 到这个
 * 整数之间，包含数字1 的整数有多少个。
 */
public class OneCounts {

    public static void main(String[] args) {
        System.out.println(oneCounts(10000000));
    }

    private static int oneCounts(int num) {
        if (num < 1000000 || num > 100000000) {
            throw new RuntimeException("error param");
        }
        int start = 1;
        int count = 0;
        while (start <= num) {
            int index = getOneIndex(start);
            if (index < 0) {
                start++;
                continue;
            }
            int n = (int) Math.pow(10, index);
            count += n;
            start += n;
        }
        return count;
    }

    /**
     * 获取第一个1后面有多少位，无1则返回-1
     *
     * @param num
     * @return
     */
    private static int getOneIndex(int num) {
        char[] chars = ("" + num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                return chars.length - i - 1;
            }
        }
        return -1;
    }
}
