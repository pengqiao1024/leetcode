package other.self;

import utils.Utils;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/4/19 15:16
 * @Description: 螺旋打印
 */
public class ScrewPrint {
    public static void main(String[] args) {
        int n = 3;//列数
        int m = 4;//行数
        char[][] res = screwPrint2(n, m);
        Utils.printArrayToMatrix(res);
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
     * @param n 列
     */
    private static char[][] screwPrint2(int n, int m) {
        int cel = n < m ? (n + 1) / 2 : (m + 1) / 2;
        char[][] res = new char[m][n];
        char c = 'A';
        for (int i = 0; i < cel; i++) {
            int startN = i;
            int endN = n - 1 - i;
            int startM = i;
            int endM = m - 1 - i;
            if (startN == endN) {//仅一列
                //上->下
                for (int k = startM; k <= endM; k++) {
                    res[k][endN] = c;
                    c = getNext(c);
                }
                return res;
            }
            if (startM == endM) {//仅一行
                //左->右
                for (int k = startN; k <= endN; k++) {
                    res[startM][k] = c;
                    c = getNext(c);
                }
                return res;
            }
            //左->右
            for (int k = startN; k <= endN; k++) {
                res[startM][k] = c;
                c = getNext(c);
            }
            //上->下
            for (int k = startM + 1; k <= endM; k++) {
                res[k][endN] = c;
                c = getNext(c);
            }
            //右->左
            for (int k = endN - 1; k >= startN; k--) {
                res[endM][k] = c;
                c = getNext(c);
            }
            //下->上
            for (int k = endM - 1; k > startM; k--) {
                res[k][startM] = c;
                c = getNext(c);
            }
//            Utils.printArrayToMatrix(res);
//            System.out.println();
        }
        return res;
    }

    private static char getNext(char c) {
        if (c == 'Z') {
            return 'A';
        } else {
            return (char) (c + 1);
        }
    }
}
