package TreeNode;

/**
 * 在二叉搜索树中寻找第 K 小的元素
 */
public class MinKTreeNode {

    /**
     * 题目的意思是：在二叉搜索树中寻找第 K 小的元素。
     * 这个时候就要从二叉搜索树的性质下手了。
     * 只知道二叉搜索树中序遍历是一个升序的数组，但具体到本题代码如何设计就不知道了
     * @param root
     */
    public void zuiXiao01(TreeNode root) {
        zuiXiao01(root.left);
        int str = root.val;
        zuiXiao01(root.right);
    }

    /**
     * 确定本地使用中序遍历，那么具体的处理代码就应该在中序遍历的位置
     * @param root
     * @param k
     */
    public void zuiXiao02(TreeNode root, int k) {
        int m = 0;
        int n = 0;
        if (root == null) {
            return;
        }
        zuiXiao02(root.left, k);
        // 中序遍历，代码处理的位置
        m++;
        // 判断 k 位置上的元素是否是要找的元素
        if (m == k) {
            n = root.val;
            return;
        }
        zuiXiao02(root.right, k);
    }

}
