package other.sort;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/22 19:39
 * @Description: 快排 数组
 */
public class QuickSortArray {
    public static void main(String[] args) {
        int[] array = new int[]{19, 22, 31, 24, 55, 3, 2, 9, 17, 25, 53, 19};
        print(array);
        quickSortArrayThirdPoint(array, 0, array.length - 1);
        print(array);
    }

    /**
     * [left,lt]  <
     * [lt+1,i-1] ==
     * [i,gt-1] 未开始
     * [gt,right]  >
     * <p>
     * 故 eq=lt+1
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickSortArrayThirdPoint(int[] array, int left, int right) {
        //        print(array);
//        System.out.println("left:" + left + " right:" + right);
        if (left >= right) {
            return;
        }
        int lt = left;
        int i = left + 1;
        int gt = right;
        int tmpV = array[left];
        while (i <= gt) {
            if (array[i] > tmpV) {
                swap(array, i, gt);
                gt--;
            } else if (array[i] < tmpV) {
                swap(array, i, lt);
                lt++;
                i++;
            } else {
                i++;
            }
        }
        quickSortArrayThirdPoint(array, left, lt - 1);
        quickSortArrayThirdPoint(array, gt + 1, right);
    }

    private static void quickSortArrayPitFill(int[] array, int left, int right) {
//        print(array);
//        System.out.println("left:" + left + " right:" + right);
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int tmpV = array[left];
        while (i < j) {
            while (i < j && array[j] > tmpV) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (i < j && array[i] < tmpV) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = tmpV;
        quickSortArrayPitFill(array, left, i - 1);
        quickSortArrayPitFill(array, i + 1, right);
    }

    private static void quickSortArray(int[] array, int left, int right) {
//        print(array);
//        System.out.println("left:" + left + " right:" + right);
        if (left >= right) {
            return;
        }
        int i = left + 1, j = right;
        while (j >= i) {
            while (i <= right && array[i] < array[left]) {
                i++;
            }
            while (j > left && array[j] > array[left]) {
                j--;
            }
            if (j >= i) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, left, j);
        quickSortArray(array, left, j - 1);
        quickSortArray(array, j + 1, right);
    }

    private static void swap(int[] array, int i1, int i2) {
        if (i1 != i2) {
            int tmp = array[i1];
            array[i1] = array[i2];
            array[i2] = tmp;
        }
    }


    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
