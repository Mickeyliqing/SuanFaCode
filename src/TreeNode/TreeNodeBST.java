package TreeNode;

/**
 * 二叉搜索树的运算
 */
public class TreeNodeBST {

    /**
     * 问题1
     * 判断二叉搜索树的合法性
     * @param root
     * @return
     */
    public boolean isBST(TreeNode root) {
        builder(root, null, null);
        return true;
    }

    /**
     * 构造辅助方法
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean builder(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return false;
        }
        if (min.val > root.val) {
            return false;
        }
        if (max.val < root.val) {
            return false;
        }
        return builder(root.left, min, root) && builder(root.right, root, max);
    }

    /**
     * 问题2
     * 查找一个二叉搜索树的节点
     * @param root
     * @param k
     * @return
     */
    public boolean selectBST(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            return true;
        }
        if (root.val < k) {
            return selectBST(root.right, k);
        }
        return selectBST(root.left, k);
    }

    /**
     * 问题3
     * 插入一个数据元素到二叉搜索树中
     * @param root
     * @param k
     * @return
     */
    public TreeNode insertBST(TreeNode root, int k) {
        if (root == null) {
            return new TreeNode(k);
        }
        if (root.val < k) {
            root.right = insertBST(root.right, k);
        }
        if (root.val > k) {
            root.left = insertBST(root.left, k);
        }
        return root;
    }

    /**
     * 问题4
     * 在二叉搜索树中删除一个数据元素
     * @param root
     * @param k
     * @return
     */
    public TreeNode delTreeNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (root.val == k) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = getMin(root.right);
            root.val = node.val;
            // 交换完元素后，要及时删除交换后的元素
            root.right = delTreeNode(root.right, node.val);
        }
        if (root.val < k) {
            root.right = delTreeNode(root.right, k);
        }
        if (root.val > k) {
            root.left = delTreeNode(root.left, k);
        }
        return root;
    }

    /**
     * 去找最右边最小的数据元素，那么走右边的最左边的数据元素，就是最小的。
     * @param root
     * @return
     */
    public TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
