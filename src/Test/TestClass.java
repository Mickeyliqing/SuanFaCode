package Test;

public class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int[] array = {8,9,6,7,1,3,5,2};
        System.out.println(testClass.test01(array));
    }

    public int test01(int[] arr) {
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                tmp = arr[i];
            }
        }
        return tmp;
    }
}
