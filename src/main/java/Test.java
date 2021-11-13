import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/11/1 19:25
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
    }

    private static void print(String s) {
        String[] ss = s.split(",");
        for (String str : ss) {
            System.out.print(str);
            int whiteC = 5 - str.length();
            for (int i = 0; i <whiteC ; i++) {
                System.out.print(" ");
            }
            System.out.print(",");
        }
        System.out.println();
    }
}
