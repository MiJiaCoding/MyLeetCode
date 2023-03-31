/*
 * @lc app=leetcode.cn id=279 lang=javascript
 *
 * [279] 完全平方数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function (n) {
  // 完全背包 dp[j] 
  // dp[j]：和为j的完全平方数的最少数量为dp[j]
  let dp = new Array(n + 1).fill(Infinity);
  dp[0] = 0;
  for (let i = 0; i**2 <= n; i++) {
    let v = i ** 2;
    for (let j = v; j <= n; j++) {
      dp[j] = Math.min(dp[j], dp[j - v] + 1);
    }
  }
  return dp[n];
};

// @lc code=end
