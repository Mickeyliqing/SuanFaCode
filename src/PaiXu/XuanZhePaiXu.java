package PaiXu;

import java.util.Arrays;

/**
 * 选择排序
 */
public class XuanZhePaiXu {
    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        int array[] = {5,3,1,6,9,8};
        XuanZhePaiXu xuanZhePaiXu = new XuanZhePaiXu();
        System.out.println(Arrays.toString(xuanZhePaiXu.selSort02(array)));
    }

    /**
     * 寻找最小元素
     * @param arr
     * @return
     */
    public int[] selSort01(int[] arr) {
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 从第二个数组开始寻找数组中余下数组中最小的那个元素
            for (int j = i + 1; j < arr.length; j++) {
                // 满足条件后完成元素的交换
                if (i < j && arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    // 上面的方法就是一个简单的选择排序。但它存在一个可以优化的问题。
    // 在寻找最小元素的时候，如果我有两个元素比数组上的第一个元素要小，那么我要交换两次元素。
    // 能不能直接找到对应的最小的那个元素，完成一次交换？

    /**
     * 修改后的代码如下：
     * @param arr
     * @return
     */
    public int[] selSort02(int[] arr) {
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 默认第一个数据元素为最小值
            int min = i;
            // 从第二个数值开始，找到余下数组中最小的那个元素
            for (int j = i+1; j < arr.length; j++) {
                if (i < j && arr[i] > arr[j]) {
                    min = j;
                }
            }
            // 找到最小的那个元素，把它放到合适的位置
            if(i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
}
