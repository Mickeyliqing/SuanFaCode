package TreeNodeBinLiFangSi;

public class TreeNodeBianLi {

    //二叉树的遍历分为：先序遍历，中序遍历，后续遍历
    // 定义一颗二叉树
    class TreeNode {
        int val;
        TreeNode left, right;
    }
    // 先序遍历
    void DFS01 (TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root);
        if(root.left != null) {
            DFS01(root.left);
        }
        if (root.right != null) {
            DFS01(root.right);
        }
    }
    // 中序遍历
    void DFS02 (TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            DFS02(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            DFS02(root.right);
        }
    }
    // 后续遍历
    void DFS03 (TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            DFS03(root.left);
        }
        if (root.right != null) {
            DFS03(root.right);
        }
        System.out.println(root);
    }
}
