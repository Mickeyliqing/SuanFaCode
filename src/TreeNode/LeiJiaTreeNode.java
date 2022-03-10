package TreeNode;

public class LeiJiaTreeNode {

    /**
     * 题目的意思是把给定的二叉搜索树转化成累加树。使得每个节点的值等于原来大于节点或等于节点的值之和
     * 思考点同样在搜索二叉树的性质中。
     * 中序遍历的结果是升序排序，那如果要降序输出，就应该是右，根，左。
     * 在思考新的二叉树各个节点的关系：最大的那个节点的数据还是它自己，次一级的那个节点的数据是最大元素和它自己本身元素之和。
     * 如果把原来的二叉搜索树降序输出，然后各个节点的数据累加，在把累加的和赋值给原来的二叉树。问题是不是就解决了。
     * 这样既没有破坏原来二叉搜索树的结构，又满足了题目要求的条件。
     */
    public TreeNode leiJia01(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return null;
        }
        leiJia01(root.right);
        // 中序遍历，代码处理的位置
        // 累加各个元素的值
        sum += root.val;
        // 在把累加的数据元素赋值给原来的节点，作为新的节点
        root.val = sum;
        leiJia01(root.left);
        return root;
    }
}
