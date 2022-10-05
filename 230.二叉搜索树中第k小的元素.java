/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    /*
     * 对于搜索二叉树来说，直接中序遍历就是从小到大排序
     */
    
    int count=0;
    int res =-1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    private void dfs(TreeNode root,int k){
        if (root==null ||res!=-1) return ;
        dfs(root.left,k);
        count++;
        if (count==k){
            res=root.val;
        }
        dfs(root.right,k);
    }
}
// @lc code=end

