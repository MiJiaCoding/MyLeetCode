/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root!=null){
            dfs(root,targetSum);
            pathSum(root.left,targetSum);
            pathSum(root.right,targetSum);
            // 错误
            // dfs(root.left,targetSum);
            // dfs(root.right,targetSum);
        }
    
        return res;
    }
    private void dfs(TreeNode root, long targetSum){
        if (root == null) return ;
        if (root.val==targetSum){
            res++;
            // 不能加return  因为 此节点的子树可能还有满足条件的路劲
        }
        dfs(root.left,targetSum-root.val);
        dfs(root.right,targetSum-root.val);
        return ;
    }
}
// @lc code=end

