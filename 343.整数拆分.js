/*
 * @lc app=leetcode.cn id=343 lang=javascript
 *
 * [343] 整数拆分
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var integerBreak = function (n) {
  // dp[i]： 拆分数字i， 可以得到的最大乘积
  // j表示拆分的数字
  let dp = new Array(n + 1).fill(0);
  dp[2] = 1;
  for (let i = 3; i < n + 1; i++) {
    for (let j = 1; j <= i / 2; j++) {
      dp[i] = Math.max(dp[i], j * dp[i - j], j * (i - j));
    }
  }
  return dp[n];
};
// @lc code=end
