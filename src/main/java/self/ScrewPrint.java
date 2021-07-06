package self;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/4/19 15:16
 * @Description: 螺旋打印
 */
public class ScrewPrint {
    public static void main(String[] args) {
        int n = 6;//列数
//        int m=2;//行数
        screwPrint(n);
    }

    /**
     * 数组表示
     *
     * @param n
     */
    private static void screwPrint(int n) {
        int[][] res = new int[n][n];
        int r = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int num = 1;//开始元素
        for (int c = 1; c <= r; c++) {//控制层数
            int startI = c - 1;
            int startJ = c - 1;
            int endI = n - c;
            int endJ = n - c;
            if (startI == endI) {
                res[startI][startJ] = num;
                break;
            }
            for (int k = startJ; k <= endJ; k++) {//左->右
                res[startI][k] = num++;
            }
            for (int k = startI + 1; k <= endI; k++) {//上->下
                res[k][endI] = num++;
            }
            for (int k = endJ - 1; k >= startJ; k--) {//右->左
                res[endI][k] = num++;
            }
            for (int k = endI - 1; k >= startI + 1; k--) {//下->上
                res[k][startI] = num++;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 数组
     *
     * @param n
     */
    private static void screwPrint2(int n) {
        int cel = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int i = 0; i < cel; i++) {
            for (int k = i; k < n - i; k++) {

            }
        }

    }
}
