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




// @lc code=end

