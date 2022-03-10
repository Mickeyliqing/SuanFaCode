package TreeNode;

public class ErChaSouTreeNode {

    /**
     * 判断二叉搜索树是否合法
     * 根据二叉搜索树的定义，我们发现这个方法存在一个问题，那就是在遍历左右子树的时候，无法保证和根节点的关系。
     * 无法满足：整个左子树的节点数据都比根节点小，右子树的节点数据都比根节点大
     */
    public boolean isBST01(TreeNode root) {
        if (root == null) {
            return false;
        }
        if ( root.left != null && root.val <= root.left.val) {
            return false;
        }
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        return isBST01(root.left) && isBST01(root.right);
    }

    /**
     * 根据上面分析的情况，也就是说在做比较的时候，需要保证每个节点和根节点之前的关系
     * 原有的方法思路是正确的，这里只需要添加一些细节上的改动即可
     * 可以考虑辅助函数或者辅助参数
     */
    public boolean isBST02(TreeNode root) {
        return builder(root, null, null);
    }

    /**
     * 这个方法的核心就是下面这两句话：
     * 01：限定左子树的最大值为 root.val
     * 02：右子树的最小值为 root.val
     */
    public boolean builder(TreeNode root,TreeNode min, TreeNode max) {
        if (root == null) {
            return false;
        }
        // 限定左子树的最大值为 root.val
        if (min != null && min.val >= root.val) {
            return false;
        }
        // 右子树的最小值为 root.val
        if (max != null && max.val <= root.val) {
            return false;
        }
        // 限定左子树的最大值为 root.val ,右子树的最小值为 root.val
        return builder(root.left, min, root) && builder(root.right, root, max);
    }

    /**
     * 在二叉搜索树中搜索一个树
     * 这个方法没什么好说的，就是利用二叉搜索中特有的性质
     */
    public boolean isIntBST01(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (k == root.val) {
            return true;
        }
        if (k < root.val) {
            isIntBST01(root.left, k);
        }
        if (k > root.val) {
            isIntBST01(root.right, k);
        }
        return true;
    }

    /**
     * 在二叉搜索树中插入一个数
     */
    public TreeNode insertBST01(TreeNode root, int k) {
        // 这里不正确的，如果 root 为 null。应该是以 k 为节点，新建一个二叉树
        if (root == null) {
            return null;
        }
        // 这里也不对，二叉搜索树中不存在重复元素
        if (k == root.val) {
            return new TreeNode();
        }
        // 这里也不对，新插入的元素，应该在赋值给左子树
        if (k < root.val) {
            insertBST01(root.left, k);
        }
        // 这里也不对，新插入的元素，应该赋值给右子树
        if (k > root.val) {
            insertBST01(root.right, k);
        }
        return root;
    }

    public TreeNode insertBST02(TreeNode root, int k) {
        // 如果 root 节点为 null ，那么新创建新的二叉树
        if (root == null) {
            return new TreeNode(k);
        }
        // 新插入的节点数据应该在赋值给左子树
        if (k < root.val) {
            root.left = insertBST02(root.left, k);
        }
        // 新插入的节点数据，应该在赋值给右子树
        if (k > root.val) {
            root.right = insertBST02(root.right, k);
        }
        return root;
    }

    /**
     * 在二叉搜索树中删除一个数
     * 这个方法存在一个问题，那就是找到对应的节点后要如何删除？那么会存在以下几种情况：
     * 01：如果这个节点的刚好左右子树为空，则直接删除即可
     * 02：如果这个节点有一个非空节点，那么删除这个节点后，要让这个非空的孩子节点替代自己
     * 03：如果这个节点，有两个孩子节点，那么就必须找到这个节点的左子树中最大的节点，或者右子树中最小的节点来替代自己
     */

    public TreeNode deleteBST01(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (k == root.val) {
            //deleteBST01(root, k);
        }
        if (k < root.val) {
            root.left = deleteBST01(root.left, k);
        }
        if (k > root.val) {
            root.right = deleteBST01(root.right, k);
        }
        return root;
    }
    /**
     * 01：如果这个节点的刚好左右子树为空，则直接删除即可
     * 02：如果这个节点有一个非空节点，那么删除这个节点后，要让这个非空的孩子节点替代自己
     * 03：如果这个节点，有两个孩子节点，那么就必须找到这个节点的左子树中最大的节点，或者右子树中最小的节点来替代自己
     */
    public TreeNode deleteBST02(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (k == root.val) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 第三种情况，这里以右子树最小值为例子
            TreeNode node = getMin(root.right);
            root.val = node.val;
            root.right = deleteBST02(root.right, node.val);
        }
        if (k < root.val) {
            root.left = deleteBST02(root.left, k);
        }
        if (k > root.val) {
            root.right = deleteBST02(root.right, k);
        }
        return root;
    }

    /**
     * 借助辅助函数，计算最小右子树
     */
    public TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.right;
        }
        return root;
    }
}
