/*
 * @lc app=leetcode.cn id=62 lang=javascript
 *
 * [62] 不同路径
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */

// （化为求二叉树叶子节点的个数会出现超时）
// 用dp

var uniquePaths = function (m, n) {
  /**  求0，0 -> n-1,m-1 的路径数
   *  dp[i][j] 表示 0，0-> i,j 的路径数
   * 只有两个方向过来的 dp[i][j] = dp[i-1][j] + dp[i][j-1]
   * 初始值 dp[j][0] =0 d[i][0] =0
   * 遍历顺序左上到右下
   */

  const dp = Array.from(new Array(m), () => new Array(n).fill(0));
  for (let i = 0; i < m; i++) dp[i][0] = 1;
  for (let j = 0; j < n; j++) dp[0][j] = 1;
  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
  }
  return dp[m - 1][n - 1];
};

// 空间优化  一维 滚动数组

var uniquePaths = function (m, n) {
  let dp = new Array(n).fill(0);
  for (let j = 0; j < n; j++) dp[j] = 1;

  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      // 自己上边一个和左边一个
      dp[j] += dp[j - 1];
    }
  }
  return dp[n - 1];
};
// @lc code=end
