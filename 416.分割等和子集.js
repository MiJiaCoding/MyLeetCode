/*
 * @lc app=leetcode.cn id=416 lang=javascript
 *
 * [416] 分割等和子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition = function (nums) {
    // 01背包 容量sum/2  物品价值和重量一样
  const sum = nums.reduce((pre, cur) => pre + cur);
  if (sum%2!==0) return false
  const n = nums.length;
  const dp = new Array(Math.floor(sum / 2) + 1).fill(0);
  for (let i = 0; i < n; i++) {
    for (let j = sum / 2; j >= nums[i]; j--) {
      dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
      if (dp[j] === sum / 2) {
        // 提前返回 比如sum=12， dp[6]=6,dp[7]=6,dp[8]=6...在dp[6]的时候直接返回即可
        return true;
      }
    }
  }
  return dp[sum/2] === sum/2
};
// @lc code=end
