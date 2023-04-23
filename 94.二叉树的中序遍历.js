/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
// var inorderTraversal = function (root) {
//   if (root == null) return [];
//   let res = new Array();
//   const dfs = (root) => {
//     if (root == null) return;
//     dfs(root.left);
//     res.push(root.val);
//     dfs(root.right);
//   };
//   dfs(root);
//   return res;
// };

var inorderTraversal = function (root) {
  // 入栈： 左  右
  //出： 中 左 右
  if (root == null) return [];
  let stack = [];
  let res = [];
  let cur = root;
  while (cur || stack.length) {
    if (cur) {
      stack.push(cur);
      cur = cur.left;
    } else {
      cur = stack.pop();
      res.push(cur.val);
      cur = cur.right;
    }
  }
  return res;
};
// @lc code=end
