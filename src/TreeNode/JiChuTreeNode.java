package TreeNode;
/**
 * 二叉树的基础方法
 */
public class JiChuTreeNode {

    /**
     * 先序遍历
     * @param root
     */
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

    /**
     * 中序遍历
     * @param root
     */
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

    /**
     * 后续遍历
     * @param root
     */
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

    /**
     * 递归对二叉树的访问
     * @param root
     */
    void traverse(TreeNode root) {
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 计算一颗二叉树有多少节点
     * @param root
     * @return
     */
    int count(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    /**
     *  实现一颗二叉树的反转
     * @param root
     * @return
     */
    TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        //先把 root 两边的子节点反转
        TreeNode tmp = root.left;
        root.left = root.right;
        root.left = tmp;

        //让左右子节点的子节点继续反转
        //此时可以把子节点看成 (root) 节点去理解
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /**
     * 把二叉树的每层节点都用 next 指针连接起来
     * (ERROR) 这个方法有个问题，那就是不属于同一个父节点的两个子节点无法相连
     * @param root
     * @return
     */
    TreeNode connect(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }
        //连接左右两个节点
        root.left.next = root.right;
        //递归遍历左子节点
        connect(root.left);
        //递归遍历右子节点
        connect(root.right);
        return root;
    }

    /**
     * 把二叉树的每层节点都用 next 指针连接起来
     * 这个方法就可以解决上面的那个问题
     * @param root
     * @return
     */
    TreeNode connects(TreeNode root) {
        if(root == null) {
            return root;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    void connectTwoNode(TreeNode n1, TreeNode n2) {
        if(n1 == null || n2 == null) {
            return;
        }
        //连接左右两个节点
        n1.next = n2;
        //递归遍历相同父节点的两个子节点
        connectTwoNode(n1.left, n1.right);
        connectTwoNode(n2.left, n2.right);
        //递归遍历跨父节点的两个子节点
        connectTwoNode(n1.right, n2.left);
    }
}
