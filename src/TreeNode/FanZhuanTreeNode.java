package TreeNode;

public class FanZhuanTreeNode {

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
