package other.sort;

import java.util.Arrays;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/21 17:11
 * @Description: 归并排序 数组
 */
public class MergeSortArray {
    public static void main(String[] args) {
        int[] array = new int[]{19, 22, 31, 24, 55, 3, 2, 9, 17, 25, 53};
        print(array);
        mergeSortArray(array);
        print(array);
    }

    private static void mergeSortArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        mergeSortArray(array, left, right);
    }

    private static void mergeSortArray(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left == right) {
            return;
        }
        mergeSortArray(array, left, mid);
        mergeSortArray(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /**
     * @param array
     * @param left
     * @param mid   该元素属于前一个数组
     * @param right
     */
    private static void merge(int[] array, int left, int mid, int right) {
        int[] copy = Arrays.copyOf(array, array.length);
        int index = left;
        int lindex = left;
        int hindex = mid + 1;
        while (lindex <= mid || hindex <= right) {
            if (lindex > mid) {
                array[index++] = copy[hindex++];
                continue;
            }
            if (hindex > right) {
                array[index++] = copy[lindex++];
                continue;
            }
            if (copy[lindex] < copy[hindex]) {
                array[index++] = copy[lindex++];
            } else {
                array[index++] = copy[hindex++];
            }
        }
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
