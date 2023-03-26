/*
 * @lc app=leetcode.cn id=96 lang=javascript
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function (n) {
  // dp[i] 表示以i为根 的 二叉搜索树的种数
  // 二叉搜索树性质： 左结点 小于 右结点
  // 二叉树 1～j-1 右边 是 j+1 ～ i
  //  实际上 左边有j-1个点   右边有i-j个点  种数只和点点个数有关
  // 左边种数*右边种数 就是 总数
  const dp = new Array(n + 1).fill(0);
  dp[0] = 1
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= i; j++) {
      dp[i] += dp[j - 1] * dp[i - j];
    }
  }
  return dp[n];
};
// @lc code=end
