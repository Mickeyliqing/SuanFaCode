package TreeNode;

import java.util.LinkedList;

public class XuLieHuaTreeNode {

    /**
     * 给定一颗二叉树，把它序列化成一个数组
     * 遍历二叉树的方式有：前序，中序，后序
     * 本方法采用前序遍历的方式，其它遍历方式思路一样
     * 把二叉树展开成数组，重点是要处理好各个节点之前的连接，这个连接可以用 "," 连接。另外就是对于空节点的处理，这里的空节点可以使用“#”代替
     * 这样处理的好处是，根据一次遍历后的结果，就可以根据遍历的数组展开成二叉树
     */

    // 定义两个变量，用来连接数组和替代空节点
    String SEP = ",";
    String NULL = "#";

    // 前序遍历方式序列化二叉树
    public String xuLieHua(TreeNode root) {
        // 同样的思路可以借助辅助函数
        StringBuilder str = new StringBuilder();
        xuLieHua(root, str);
        return str.toString();
    }

    // 定义辅助函数
    public void xuLieHua(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append(NULL).append(SEP);
            return;
        }
        // 前序遍历数据元素
        str.append(root.val).append(SEP);
        // 调用迭代方法，完成左，右子树遍历
        xuLieHua(root.left, str);
        xuLieHua(root.right, str);
    }

    /**
     * 把上面的数组，反序列化成二叉树
     */
    public TreeNode fanXuLieHua(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String str : data.split(SEP)) {
            // str 数据元素，后进先出
            nodes.addLast(str);
        }
        return fanXuLieHua(nodes);
    }

    public TreeNode fanXuLieHua(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 移除并返回列表的第一个数据元素
        String first = nodes.removeFirst();
        // 前序遍历，第一个数据元素就是根节点
        TreeNode root = new TreeNode(Integer.parseInt(first));
        // 迭代实现左，右子树
        root.left = fanXuLieHua(nodes);
        root.right = fanXuLieHua(nodes);
        return root;
    }
}
