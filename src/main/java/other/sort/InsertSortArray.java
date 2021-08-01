package other.sort;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/21 15:24
 * @Description: 插入排序  数组
 */
public class InsertSortArray {
    public static void main(String[] args) {
        int[] array = new int[]{19, 22, 31, 24, 55, 3, 2, 9, 17, 25, 53};
        print(array);
        insertSortArray(array);
        print(array);
    }

    private static void insertSortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
//            System.out.println("开始处理第" + i + "个元素:" + array[i]);
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
//                    System.out.println("该元素应该替换至" + j + "的位置");
                    int tmp = array[i];
                    //[j,i)中间的数，向后移动一位
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = tmp;
                    break;
                }
            }
//            print(array);
        }
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
