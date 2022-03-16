package TreeNode;

/**
 * 反转一棵二叉树
 */
public class FanZhuanTreeNode {

    /**
     * 反转一颗二叉树
     * @param root
     * @return
     */
    public TreeNode fanZhuan(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode node = new TreeNode();
        node = root.left;
        root.left = root.right;
        root.right = node;
        fanZhuan(root.left);
        fanZhuan(root.right);
        return root;
    }
}
