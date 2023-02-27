/*
 * @lc app=leetcode.cn id=53 lang=javascript
 *
 * [53] 最大子数组和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
// var maxSubArray = function(nums) {
//     let dp = new Array(nums.length).fill(0)
//     dp[0] = nums[0]
//     let res = dp[0]
//     for (let i=1; i<nums.length; i++) {
//         dp[i] = Math.max(nums[i], dp[i-1] + nums[i])
//         if (dp[i] > res) res = dp[i]
//     }
//     return res
// };

var maxSubArray = function(nums) {
    let pre = nums[0]
    let res = pre
    for (let i=1; i<nums.length; i++) {
        pre = Math.max(pre + nums[i], nums[i])
        if (res < pre) res = pre
    }
    return res
}
// @lc code=end

