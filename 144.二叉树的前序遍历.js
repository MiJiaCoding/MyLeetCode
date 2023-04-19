/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
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
// var preorderTraversal = function (root) {
//   let res = [];
//   const dfs = (root) => {
//     if (root == null) return;
//     res.push(root.val)
//     dfs(root.left)
//     dfs(root.right)
//   };
//   dfs(root)
//   return res
// };

var preorderTraversal = function (root) {
  // 入栈 右 -> 左
  // 出栈 中 -> 左 -> 右
  if (root == null) return []
  let res = [];
  let stack = [root];
  let cur = null;
  while (stack.length) {
    cur = stack.pop();
    res.push(cur.val);
    cur.right && stack.push(cur.right)
    cur.left && stack.push(cur.left)
  }
  return res;
};
// @lc code=end
