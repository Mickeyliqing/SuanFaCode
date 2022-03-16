package TreeNode;

/**
 * 根据前序遍历的结果和中序遍历的结果构造二叉树
 */
public class GouZhaoTreeNode {

    /**
     * 题目的意思是根据前序遍历的结果和中序遍历的结果构造二叉树
     * 前序遍历中，第一个数据元素即为根节点
     * 在中序遍历中找到根节点元素的位置，那么就可以确定左右子树
     * 然后同样的方法，在左右子树中在寻找根节点和左右子树
     * 根据上面的分析，可以发现，使用递归实现较为方便
     */

    /**
     * 同样的思路，先把伪代码写出来
     * @param a
     * @param b
     * @return
     */
    public TreeNode gouTreeNode01(int[] a, int[] b) {
        return builder(a, 0, a.length-1, b, 0, b.length-1);
    }

    /**
     * 采用构造子函数的方式
     * @param a
     * @param m
     * @param n
     * @param b
     * @param k
     * @param h
     * @return
     */
    public TreeNode builder(int[] a, int m, int n, int[] b, int k, int h) {
        if(m > n) {
            return null;
        }
        // 02：找到这个根节点在数组 b 中的位置，那么就可以确定左右子树
        int tmp = a[0];
        int u = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == tmp) {
                u = i;
                break;
            }
        }
        //01： 首先可以确定的是，数组 a 中的第一个节点就是根节点
        TreeNode root = new TreeNode(a[0]);
        // 03：接下来就需要确定 m,n,k,h 这四个值就可以了
        // 04：l 是左子树的节点数
        int l = u - k;
        root.left = builder(a, m+1, m+l, b, k, u-1);
        root.right = builder(a, m+l+1, n, b, u+1, h);
        return root;
    }
}