package TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层级遍历二叉树
 */
public class CengJiTreeNode {

    /**
     * 层级遍历二叉树
     * @param root
     */
    public void cengJi(TreeNode root) {
        if (root == null) {
            return ;
        }
        Queue queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = (TreeNode) queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
