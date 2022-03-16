package PaiXu;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class MaoPaoPaiXu {
    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        MaoPaoPaiXu maoPaoPaiXu = new MaoPaoPaiXu();
        int[] array = {9,8,6,7,3,1,2};
        System.out.println(Arrays.toString(maoPaoPaiXu.maoPao01(array)));
    }

    /**
     * 对应的方法
     * @param arr
     * @return
     */
    public int[] maoPao01(int[] arr) {
        // 认真思考会发现，如果元素有五个，那么其实排序的次数应该是4次。
        // 因此 i < arr.length-1。
        // 排序其实都是在第二个 for 循环里进行的，那么 j 的首位置应该是 0。
        // 如果第一次排序完成，那么第二次排序其实是不需要在排第一次排序后的元素的，如何控制这个位置，其实就是第一个 for 循环起到的作用。
        for(int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
}
