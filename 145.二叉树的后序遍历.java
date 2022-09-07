import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode preAcess =null;
        while (root!=null ||!stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.right==null || root.right ==preAcess ){
                res.add(root.val);
                // 关键
                preAcess=root;
                root=null;
            }else{
                stack.push(root);
                root=root.right;
            }
        }
        return res;
    }
}
// @lc code=end

