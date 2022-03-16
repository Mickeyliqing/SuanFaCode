package TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 构造二叉搜索树
 */
public class GouZhaoBSTTreeNode {

    /**
     * 问题1
     * 给定一串数组，然后去构造二叉搜索树
     * @param n
     * @return
     */
    public List<TreeNode> createBST(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        // 借助辅助函数去实现这个方法
        return builder(1, n);
    }

    /**
     * 定义辅助函数
     * @param m
     * @param n
     * @return
     */
    public List<TreeNode> builder(int m, int n) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<TreeNode> left;
        List<TreeNode> right;
        if (m > n) {
            list.add(null);
            return list;
        }
        // 穷举 root 节点所有的可能性
        for (int i = m; i < n; i++) {
            // 递归构造左右子树
            left = builder(m, i-1);
            right = builder(i+1, n);
            // 给 root 节点穷举所有可能左右子树组合
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode: right) {
                    // 作为根节点 root 的值
                    TreeNode root = new TreeNode();
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    /**
     * 问题2
     * 给定一个正整数 N ，计算 『1，N』 有几种不同的二叉搜索树的构造
     * 一般情况下，陷入这样的思考后，很难在一个方法中去实现对应的需求，那就要去思考：
     * 01、能不能借助辅助函数。
     * 02、能不能借助辅助变量。
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return count(1,n);
    }

    /**
     * 这样建变成在区间 【m，n】 上构造二叉搜索树
     * @param m
     * @param n
     * @return
     */
    public int count(int m, int n) {
        if (m > n) {
            return 1;
        }
        int res = 0;
        // 遍历一个数组用什么？for 循环
        for (int i = m; i <= n; i++) {
            // 递归构造左右子树
            int left = count(m, i-1);
            int right = count(i+1, n);
            // 左右子树的可能情况
            res += left*right;
        }
        return res;
    }

    /**
     * 问题3
     * 判断一棵树是否是合法的二叉搜索树
     * @param n
     * @return
     */
    public List<TreeNode> genTree(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return builders(1,n);
    }

    /**
     * 定义辅助函数
     * @param m
     * @param n
     * @return
     */
    public List<TreeNode> builders(int m, int n) {
        List<TreeNode> list = new ArrayList<>();
        if(m > n) {
            list.add(null);
            return list;
        }
        for (int i = m; i <= n; i++) {
            List<TreeNode> left = builder(m, i-1);
            List<TreeNode> right = builder(i+1, n);
            // 给 root 节点穷举所有左右子树的组合
            for (TreeNode leftnode : left) {
                for (TreeNode rightnode : right) {
                    // i 作为根节点的值
                    TreeNode root = new TreeNode(i);
                    root.left = leftnode;
                    root.right = rightnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
