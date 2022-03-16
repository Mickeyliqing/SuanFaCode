package TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给定一颗二叉树，返回所有重复子树
 */
public class ChongFuTreeNode {

    /**
     * 题目是给定一颗二叉树，返回所有重复子树。
     * 那么如何解决这个问题呢？其实就两步。
     * 第一步：知道以自己为根节点的二叉树长什么样。
     * 第二步：知道其它节点为根节点的二叉树长什么样。
     * 知道自己为根节点的二叉树长什么样后，怎么去和其它节点上的数据比较呢？
     * 如果把以自己为根的二叉树拆解成一个字符串，那么在把其它节点为根的二叉树拆解成字符串，直接比较对应的字符串不就可以了。
     */

    /**
     * 01：把一颗二叉树拆解成字符串后输出
     * @param root
     * @return
     */
    public String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return traverse(root.left) + "," + traverse(root.right) + "," + root.val;
    }

    HashMap<String, Integer> map = new HashMap<>();
    LinkedList<TreeNode> node = new LinkedList<TreeNode>();

    /**
     * 02：为了思路清晰，这里借助辅助函数完成后续功能
     * @param root
     * @return
     */
    public String chongFuTree(TreeNode root) {
        // 完成拆解
        String subStree = traverse(root);
        // 借助 map 内的函数，完成比较
        int m = map.getOrDefault(subStree,0);
        // 多次重复，结果集也只会添加一次
        if (m == 1) {
            node.add(root);
        }
        // 对重复的子树出现的次数累加
        map.put(subStree, m+1);
        return subStree;
    }
}
