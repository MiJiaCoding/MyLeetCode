/*
 * @lc app=leetcode.cn id=300 lang=javascript
 *
 * [300] 最长递增子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    if (nums.length<=1) return nums.length
    let n=nums.length
    let dp=[]
    let max=0
    for(let i=0;i<n;i++){
        dp[i]=1
        for(let j=i-1;j>=0;j--){
            if(nums[i]>nums[j]){
                dp[i]=Math.max(dp[i],dp[j]+1)
            }
        }
        max=Math.max(dp[i],max)
    }
    return max

};
// @lc code=end

