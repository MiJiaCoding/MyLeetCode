/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int dp[]=new int [nums.length];
        dp[0]=nums[0];
        int res = dp[0];
        for (int i =1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            if (res<dp[i]) res=dp[i];
        }
        return res;
    }

    public int maxSubArray(int[] nums){
        int pre=nums[0];
        int res =nums[0];
        for (int i=1;i<nums.length;i++){
            pre=Math.max(pre+nums[i],nums[i]);
            if(pre>res) res=pre;
        }
        return res ;
    }
}

// @lc code=end

