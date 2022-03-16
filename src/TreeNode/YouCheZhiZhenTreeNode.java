package TreeNode;

/**
 * 填充二叉树的右侧指针
 */
public class YouCheZhiZhenTreeNode {

    /**
     * 填充二叉树的右侧指针
     * 这个方法存在一个问题，那就是不同父节点的两个节点无法相连起来
     * @param root
     * @return
     */
    public TreeNode youZhiZhen01(TreeNode root) {
        if (root == null || root.left == null) {
            return null;
        }
        root.left.next = root.right;
        root.right.next = null;
        youZhiZhen01(root.left);
        youZhiZhen01(root.right);
        return root;
    }

    /**
     * 优化后的方法
     * 转化思路：将每相邻的两个节点连接起来，那么可以借助一个辅助函数完成这件事
     * @param root
     * @return
     */
    public TreeNode youZhiZhen02(TreeNode root) {
        if (root == null){
            return null;
        }
        connectTwo(root.left,root.right);
        return root;
    }

    /**
     * 辅助函数
     * @param root1
     * @param root2
     */
    public void connectTwo(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        // 将两个节点连接,这里两个节点就建立了关联
        root1.next = root2;
        // 连接相同父节点的两个节点
        connectTwo(root1.left, root1.right);
        connectTwo(root2.left,root2.right);
        // 连接不同父节点的两个节点
        connectTwo(root1.right,root2.left);
    }
}
