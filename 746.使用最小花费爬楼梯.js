/*
 * @lc app=leetcode.cn id=746 lang=javascript
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    // 一开始是站在下标为 0或1 的台阶上
    let n = cost.length
    let dp = new Array (n)
    dp[0] = dp[1] = 0
    for (let i = 2; i <= n; i++) {
        dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    }
    return dp[n]

};

// // 空间优化
// var minCostClimbingStairs = function (cost) {
//   let pre = 0;
//   let cur = 0;
//   for (let i = 2; i <= cost.length; i++) {
//     let tmp = cur;
//     cur = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
//     pre = tmp;
//   }
//   return cur;
// };
// @lc code=end
