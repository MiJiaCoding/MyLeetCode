/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {

    // 脑瘫 解法 考虑不周
    // public int rob(int[] nums) {
    //     int ou=0;
    //     int ji=0;
    //     for (int i=0;i<nums.length;i++){
    //         if(i%2==0){
    //             ou+=nums[i];
    //         }else{
    //             ji+=nums[i];
    //         }
    //     }
    //     return ou>ji? ou:ji;
    // }

    /*
     * dp[i] 表示 有i+1个房屋时候，偷盗的最高金额
     */
    // public int rob(int[] nums) {
    //     if (nums.length<2) return nums[0];
    //     int []dp=new int[nums.length];
    //     dp[0]=nums[0];
    //     dp[1]=nums[0]>nums[1]?nums[0]:nums[1];
    //     for (int i =2;i<nums.length;i++){
    //         dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
    //     }
    //     return dp[nums.length-1];
    // }

    public int rob(int[] nums){
        if (nums.length<2) return nums[0];
        int prepre=nums[0];
        int pre=nums[0]>nums[1]?nums[0]:nums[1];
        for (int i =2;i<nums.length;i++){
            int temp = pre;
           pre=Math.max(prepre+nums[i], pre);
           prepre=temp;
        }
        return pre;
    }
}
// @lc code=end

