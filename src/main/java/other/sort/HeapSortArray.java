package other.sort;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/7/26 10:57
 * @Description: 堆排序  数组
 */
public class HeapSortArray {
    public static void main(String[] args) {
        int[] array = new int[]{19, 22, 31, 24, 55, 3, 2, 9, 17, 25, 53};
//        print(array);
        heapSortArray(array);
//        print(array);
    }

    public static void heapSortArray(int[] array) {
        //1.构造最大堆
        initHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            print(array);
            //2.交换顶点和最后一个值
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            //3.排除最后一个值，继续调整结构  循环
            balance(array, i, 0);
        }


    }

    private static void initHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            balance(array, array.length, i);
        }
    }

    private static void balance(int[] array, int length, int i) {
        int change = -1;//-1代表无需交换，否则是交换子节点位置
        int left = getLeft(i);
        if (left > length - 1) {//无子节点
            return;
        } else if (left == length - 1) {//仅有左节点
            if (array[i] < array[left]) {
                change = left;
            }
        } else { //左右节点都有
            if (array[left] < array[left + 1]) {
                if (array[i] < array[left + 1]) {//array[i]>array[left + 1],则说明array[i]最大，无需操作
                    //交换left+1与i
                    change = left + 1;
                }
            } else {
                if (array[i] < array[left]) {
                    //交换left与i
                    change = left;
                }
            }
        }
        if (change != -1) {
            int tmp = array[i];
            array[i] = array[change];
            array[change] = tmp;
            balance(array, length, change);
        }
    }

    private static int getLeft(int index) {
//        return (index + 1) * 2 - 1;
        return 2 * index + 1;
    }

    private static int getRight(int index) {
//        return (index + 1) * 2 - 1  + 1;
        return (index + 1) * 2;
    }

    private static int getParent(int index) {
//        return (index + 1) / 2 - 1;
        return index / 2;
    }


    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
