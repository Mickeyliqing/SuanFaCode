package PaiXu;

import java.util.Arrays;

/**
 * 插入排序
 */
public class ChaRuPaiXu {
    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        ChaRuPaiXu chaRuPaiXu = new ChaRuPaiXu();
        int array[] = {8,9,3,5,6,2,1};
        System.out.println(Arrays.toString(chaRuPaiXu.inSort01(array)));
    }

    /**
     * 一般方法，存在不足
     * @param arr
     * @return
     */
    public int[] inSort01(int[] arr) {
        // 因为第一个元素默认有序，所以这里从第二个位置开始
        for (int i = 1; i < arr.length; i++) {
            // 这里这样写有一个问题，那就是当前两个排序完成后，第三个数据元素不会在与第一个数据元素比较。
            while(arr[i-1] > arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = tmp;
            }
        }
        return arr;
    }

    /**
     * 修改后的方法
     * @param arr
     * @return
     */
    public int[] inSort02 (int[] arr) {
        // 因为第一个元素默认有序，所以这里从第二个位置开始
        for (int i = 1; i < arr.length; i++) {
            // 定义 j 变量，负责控制自减。
            int j = i;
            int tmp = arr[j];
            // 当满足上一位已经排序好的元素比下一位元素的值大的时候，开始交换。
            while(j > 0 && arr[j-1] > tmp) {
                arr[j] = arr[j-1];
                // 完成上面操作后 arr[j-1] 这个位置上是没有值的。
                // j-- 在进入循环条件的时候，arr[j] 这个位置的元素是空的，元素的值在 tmp 那里。所以条件之中 arr[j-1] > tmp。
                j--;
            }
            // 当这两个值不再相等的时候，完成下一步的交换。注意这个是 j 的值和一开始赋值给 j 的值是不同的。
            if(i != j) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
