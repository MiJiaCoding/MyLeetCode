import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
     * 超时了
     */
    // public int rob(TreeNode root) {
    //     if(root==null) return 0;
    //     int money=root.val;
    //     if (root.left!=null){
    //         money+=rob(root.left.left)+rob(root.left.right);
    //     }
    //     if(root.right!=null){
    //         money+=rob(root.right.left)+rob(root.right.right);
    //     }
    //     return Math.max(money,rob(root.left)+rob(root.right));
    // }

    /*
     * 记忆化优化
     */
    // public int rob(TreeNode root) {
    //     HashMap<TreeNode,Integer> memo = new HashMap<>();
    //     return robInternal(root,memo);
    // }
    // public int robInternal(TreeNode root,HashMap<TreeNode,Integer>memo){
    //     if(root==null) return 0;
    //      if (memo.containsKey(root)) return memo.get(root);
    //     int money=root.val;
    //     if (root.left!=null){
    //         money+=robInternal(root.left.left, memo)+robInternal(root.left.right, memo);
    //     }
    //     if (root.right!=null){
    //         money+=robInternal(root.right.left, memo)+robInternal(root.right.right, memo);
    //     }
    //     int res=Math.max(money,robInternal(root.left, memo)+robInternal(root.right, memo));
    //     memo.put(root,res);
    //     return res;
    // }

    /*
     * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
        当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     */
    public int rob(TreeNode root){
        int []res = robInternal(root);
        return Math.max(res[0],res[1]);
    }
    public int[] robInternal(TreeNode root){
        if (root == null) return new int[2]; // [0,0]
        int []res =new int[2];
        int []left=robInternal(root.left);
        int []right=robInternal(root.right);
        res[0]=Math.max(left[0],left[1])+Math.max(right[0], right[1]);
        res[1]=root.val+left[0]+right[0];
        return res;
    }

}
// @lc code=end

