import java.sql.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
     * 递归 时间O(n) 空间 O(1)
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        accessTree(root, res);
        return res;
    }

    public void accessTree(TreeNode root,List<Integer>res){
        if (root==null){
            return ;
        }
        accessTree(root.left,res);
        res.add(root.val);
        accessTree(root.right,res);
    }
    

    /*
     * 循环迭代
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>res =new ArrayList<>();
        Deque <TreeNode> stack = new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
            stack.push(root);
            root=root.left;
            }
            root=stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}
// @lc code=end

