package TreeNode;

import Test.TestClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GouZhaoBST {
    /**
     * 题目的意思是给定一串数组，然后去构造二叉搜索树
     */

    public List<TreeNode> createBST(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        // 借助辅助函数去实现这个方法
        return builder(1, n);
    }
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
}
