import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    // public int maxDepth(TreeNode root) {
    //     if (root == null){
    //         return 0;
    //     }else{
    //         return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    //     }
    // }

    /*
     * 用一个队列，节点，每一层的节点都要去看它的左子树右子树
     */
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0; 
        }
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth =0;
        while (!q.isEmpty()){
            int size = q.size()
            ;
            while(size !=0){
                root=q.poll();
                if (root.left!=null){
                    q.offer(root.left);
                }
                if(root.right!=null){
                    q.offer(root.right);
                }

                size--;
            }
            depth++;
        }
        return depth;
    }
    

}
// @lc code=end

