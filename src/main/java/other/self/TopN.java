package other.self;

/**
 * @Author: 彭瞧  80276481
 * @Date: 2021/3/31 19:46
 * @Description:
 */
public class TopN {
    public static int N = 10;
    public static int[] array = {0, 7, 2, 7, 5, 0, 1, 1, 8, 4, 1};//最小堆

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
//            array[i + 1] = new Random().nextInt(10);
        }
//        array = {0,7, 2, 7, 5, 0, 1, 1, 8, 4, 1};
        print();
        for (int i = (N + 1) / 2; i > 0; i--) {
            balance(i);
            System.out.print(i + " ==>");
            print();
        }
    }

    public static void replaceTop(int a) {
        if (a < array[1]) {
            return;
        }
        array[0] = a;
        balance(1);
    }

    /**
     * 平衡(调整)
     *
     * @param i
     */
    public static void balance(int i) {
        int lIndex = left(i);
        int rIndex = right(i);
        int index = i;
        if (lIndex < N + 1 && array[lIndex] < array[i]) {
            index = lIndex;
        }
        if (rIndex < N + 1 && array[rIndex] < array[i]) {
            index = rIndex;
        }
        if (index != i) {
            index = rIndex < N + 1 && array[lIndex] > array[rIndex] ? rIndex : lIndex;
            change(i, index);
            balance(index);
        }
    }

    public static void change(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int left(int i) {
        return 2 * i;
    }

    private static int right(int i) {
        return 2 * i + 1;
    }

    private static void print() {
        for (int i = 1; i < N + 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
