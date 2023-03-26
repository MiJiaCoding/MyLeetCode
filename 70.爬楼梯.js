/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let dp = [0,1,2] // 到第二层有两种方法
    for (let i = 3; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2]
    }
    return dp[n]
};

// 假设是完全背包  一步 可以走m个台阶
var climbStairs = function (n) {
    let dp = new Array(n + 1).fill(0);
    dp[0] = 1;
    const m = 2;
    for (let i = 1; i <= n; i++) {
      for (let j = 1; j <= m; j++) {
        if (i - j >= 0) dp[i] += dp[i - j];
      }
    }
    m;
    return dp[n];
  };



// @lc code=end

