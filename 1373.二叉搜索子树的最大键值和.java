/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private final int INF=100000000; // 1e8
    private int ans=0;


    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root){
        /*
         * 左树最大值小于根节点小于右数最小值
         * 
         *          数组 {sum，min，max}
         * 
         * 初始值要不影响递归，搜索二叉树要满足left_max <val<right_min
         * 初始默认是搜索二叉树，即满足上面这个不等式
         *    left_max=负无穷（-INF）
         *    right_min=！正无穷（INF）即可！！！
         * 
         */

         // 如果左子树不存在 ，左边sum =0
         // 如果左子树存在，整棵树最小值就是左子树的最小值
         // 如果左子树不存在，依然要返回左子树最小值，即根节点的值。

         // 数组 {sum，min，max}
        int [] left ={0,root.val,-INF};
        int [] right={0,INF,root.val};

        if (root.left != null) left = dfs(root.left);
        if (root.right != null ) right = dfs(root.right);

        if (left[2]<root.val&&root.val <right[1]){
            int s= left[0]+right[0]+root.val;
            ans=Math.max(ans,s);

            // 返回的是整颗子树的和、 最小值、最大值！！！
            return new int[]{s,left[1],right[2]};
        }
        // 如果不是左子树不是一个二叉搜索树
        // 那么return的一定不满足left_max <val<right_min
        // 所以 舍left_max=INF ,right_min=-INF
        // 注意 int[] {sum,min,max}
        return new int[]{-INF,-INF,INF};
    }
}
// @lc code=end

