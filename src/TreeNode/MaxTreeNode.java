package TreeNode;

public class MaxTreeNode {

    // 构建伪代码，梳理思路
    /*public TreeNode maxTree01([6,3,5,8,9,7]) {
        // 第一步找到最大值，然后构建树的根节点
        TreeNode root = new TreeNode(9);
        // 递归调用，构建左右子树
        root.left = maxTree01(6,3,5,8);
        root.right = maxTree01(7);
        return root;
    }*/

    // 把上面的伪代码细分
  /*  public TreeNode maxTree02(int[] arr) {
        // 第一步，找到数组中的最大值
        int tmp = arr[0];
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[0]) {
                tmp = arr[i];
                k = i;
            }
        }
        // 构建二叉树
        // 但这这里能明显发觉，在同一个方法中是无法实现的，需要构建一个辅助函数来操作
        TreeNode root = new TreeNode(tmp);
        root.left = maxTree02(0, k-1);
        root.right = maxTree02(k+1, arr.length-1);
        return root;
    }*/

    public TreeNode maxTree03(int[] array) {
        return builde(array, 0, array.length-1);
    }

    // 拆分函数的话，先确定主函数，然后在确定子函数，主要是参数
    public TreeNode builde(int[] arr,int m, int n) {
        if(m > n) {
            return null;
        }
        // 第一步，找到数组中的最大值
        int tmp = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > tmp) {
                tmp = arr[i];
                k = i;
            }
        }
        TreeNode root = new TreeNode(tmp);
        root.left = builde(arr,m, k-1);
        root.right = builde(arr,k+1, n);
        return root;
    }
}
