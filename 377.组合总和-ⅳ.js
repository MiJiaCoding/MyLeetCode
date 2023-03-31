/*
 * @lc app=leetcode.cn id=377 lang=javascript
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function (nums, target) {
  // 求排列数   外层遍历背包容量， 内层遍历物品
  // 完全背包  背包容量需要正向遍历
  let dp = new Array(target + 1).fill(0);
  dp[0] = 1;
  for (let j = 0; j < target + 1; j++) {
    for (let i = 0; i < nums.length; i++) {
      if (j >= nums[i]) dp[j] += dp[j - nums[i]];
    }
  }
  return dp[target];
};
// @lc code=end
