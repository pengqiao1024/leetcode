package utils;

import java.util.Stack;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/8/9 17:25
 * @Description:
 */
public class Utils {

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("{");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j != array[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("}");
            if (i != array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void printArrayToMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArrayToMatrix(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
