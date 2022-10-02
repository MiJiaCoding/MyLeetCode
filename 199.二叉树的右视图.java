import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
     *  前序遍历改变 根右左 然后用一个depth记录深度，每一个深度值保留一个！
     */
    List<Integer> res= new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
       
        dfs(root,0);
        return res;
    }
    /*
     * 先序遍历改编，根右左;
     */
    private void dfs(TreeNode root,int depth){
        if (root==null) return ;
        if (depth==res.size()){
            // 每个深度只保留最先白遍历到的。
            res.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
}
// @lc code=end


