/*
 * @lc app=leetcode.cn id=1379 lang=java
 *
 * [1379] 找出克隆二叉树中的相同节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        if (original==null) return null;
        if (original==target) return cloned;

        // 同时遍历俩个树
        TreeNode left=getTargetCopy(original.left,cloned.left,target);
        TreeNode right=getTargetCopy(original.right,cloned.right,target);

        // 最终的结果一定在左树或右树return 的里面（没有结果就是return null）
        // 递归return return....把targetreturn回到根节点的。 最终根节点返回答案

        //结果在左子树就返回左子树，否则结果就在右子树，返回右子树
        if (left != null) return left;
        return right;
    }
}
// @lc code=end

