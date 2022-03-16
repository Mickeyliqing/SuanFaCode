package TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给定义一颗二叉树，返回所有子树
 */
public class FanHuiZiTreeNodee {

    /**
     *  01:先把这颗二叉树序列化
     * @param root
     * @return
     */
    public String travers(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return travers(root.left) + "," + travers(root.right) + "," + root.val;
    }

    /**
     * 借助辅助函数完成最后的结果
     * @param root
     * @return
     */
    public String bulider(TreeNode root) {
        String subString = travers(root);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Integer m = map.getOrDefault(subString, 0);
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        if(m == 1) {
            list.add(root);
        }
        map.put(subString, m+1);
        return subString;
    }
}
