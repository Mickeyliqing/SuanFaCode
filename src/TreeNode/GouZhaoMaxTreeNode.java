package TreeNode;

/**
 * 构造一颗最大二叉树
 */
public class GouZhaoMaxTreeNode {

    /**
     * 题目的意思是：给定一个不含重复元素的整数数组，构造一颗最大二叉树。
     * 要求是：
     * 1：二叉树的根是数组的最大元素。
     * 2：左子树是数组最大元素左边部分构造出来的最大二叉树。
     * 3：右子树是数组最大元素右边部分构造出来的最大二叉树。
     *
     * 对于构造二叉树，根节点要做的就是想办法把自己构建出来。
     * 其实对于整个数组来说，找到最大值后，余下的部分，又可以看作新的数组，然后在新的数组里在找到最大值，以此循环
     * 根据以上的思路分析，很明显递归方法比较适合
     */

/*
    //伪代码
    TreeNode constructMaxTree01([3,2,1,6,0,5]) {
        TreeNode root = new TreeNode(6);
        //根据题目的意思，很明显 6 已经是树的根了，那么数字 6 左边的就只有是左子树，在 6 的左子树中在继续构造同样的继续递归
        root.left = constructMaxTree01([3,2,1]);
        //6 右边的就只有是右子树，在 6 的右子树中在继续构造同样的继续递归
        root.right = constructMaxTree01([0,5]);
        return root;
    }

    //伪代码在详细一点
    TreeNode constructMaxTree02(int[] nums) {
        if(nums == null) {
            return null;
        }
        //不断寻找最大值的过程
        int maxVal = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < maxVal; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        //找到最大值构造树的根，然后递归左，右子树
        TreeNode root = new TreeNode(maxVal);
        //递归左子树
        root.left = constructMaxTree02(nums[0...index-1]);
        //递归右子树
        root.right = constructMaxTree02([index+1...nums.length-1]);
        return root;
    }
*/

    /**
     * 完整代码
     * @param nums
     * @return
     */
    TreeNode constructMaxTree(int[] nums) {
        return bulid(nums, 0, nums.length - 1);
    }

    /**
     * 构造辅助函数
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    TreeNode bulid(int[] nums, int lo, int hi) {
        if(lo > hi) {
            return null;
        }
        int index = -1;
        int maxVal = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            if(nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = bulid(nums, lo, index - 1);
        root.right = bulid(nums, index + 1, hi);
        return root;
    }
}
