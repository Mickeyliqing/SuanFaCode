package PaiXu;

import java.util.Arrays;

public class KuaiShuPaiXu {

    public static void main(String[] args) {
        KuaiShuPaiXu kuaiShuPaiXu = new KuaiShuPaiXu();
        int[] array = {9,5,8,2,6,3,1};
        kuaiShuPaiXu.querSort02(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void querSort01(int[] arr,int k, int m) {
        int left = 0;
        int right = arr.length-1;
        for (int i = 1; i < arr.length; i++) {
            while (arr[i] > arr[left]) {
                k = i;
            }
        }
        for (int j = arr.length-1; j > 0; j--) {
            while (arr[j] < arr[right]) {
                m = j;
            }
        }
        if (k == m){
            int tmp = arr[left];
            arr[left] = arr[k];
            arr[k] = tmp;
        }
    }

    public void querSort02(int arr[], int left, int right) {
        // 使用递归，就要有递归结束的条件
        if (left >= right) {
            return;
        }
        // 支点数据在代码后续容易改变，采用临时变量存储最为方便
        int tmp = arr[left];
        // 采用两个临时变量，代替元素移动
        int i = left;
        int j = right;
        // 所有的操作都必须满足这个基本条件
        while (i < j) {
            // 从右边开始。寻找比支点小的元素
            while (tmp <= arr[j] && i < j) {
                j--;
            }
            // 从左边开始，寻找比支点大的元素
            while (tmp >= arr[i] && i < j) {
                i++;
            }
            // 找到对应元素后，交换彼此的位置
            int point = arr[i];
            arr[i] = arr[j];
            arr[j] = point;
        }
        // 上述的操作都是在 （i < j） 这个条件下进行的。
        // 在这个方法中，i 和 j 的关系只有 （i < j） 或者 （i == j）。
        // 那么以下的操作就默认了是在（i == j） 的条件下进行的。
        arr[left] = arr[i];
        arr[i] = tmp;
        // 上述完成第一轮的排序，接下来调用递归即可。
        querSort02(arr, left, i - 1);
        querSort02(arr, i + 1, right);
    }
}
