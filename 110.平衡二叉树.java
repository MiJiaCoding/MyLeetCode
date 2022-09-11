/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
     * 自底向上 相当于是后序遍历
     */
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null){
    //         return true;
    //     }
    //     return dfs(root)!=-1;
    // }
    // int dfs(TreeNode root){
    //     if (root == null){
    //         return 0;
    //     }
    //     int left = dfs(root.left);
    //     int right = dfs(root.right);

    //     // 以实例2 为例 root=[1,2,2,3,3,null,null,4,4]
    //     /*
    //      * 1.left-> 2.left-> 3.left-> 4.left  return 0 -> 4.right return 0 -> 4 return 0+1 =1 ;
    //      * -> 3.right -> 右4.left return 0 -> 右4.right return 0
    //      * -> 右4 return 0+1=1;
    //      * -> 3 return 1+1 =2
    //      */

    //      /*
    //       * left 和right 别忘了，这是针对某个点的递归，当他下一个节点返回拉萨河谷你来
    //       * 的是 -1 则提前 跳出递归！ （这是剪纸函数）
    //       */
    //     if(left == -1|| right == -1 || Math.abs(left-right)>1){
    //         return -1;
    //     }

    //     return Math.max(left,right)+1;
    // }


    /*
     * 自顶向下
     */
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left)&&isBalanced(root.right);
    }
    int depth(TreeNode root ){
        if (root == null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

}
// @lc code=end

