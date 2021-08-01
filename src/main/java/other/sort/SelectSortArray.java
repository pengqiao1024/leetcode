package other.sort;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/20 10:06
 * @Description: 选择排序 数组
 */
public class SelectSortArray {
    public static void main(String[] args) {
        int[] array = new int[]{19, 22, 31, 24, 55, 3, 2, 9,17,25,53};
        selectSortArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void selectSortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }
}
