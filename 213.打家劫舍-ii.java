/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length<2) return nums[0];
        if(nums.length==2) return nums[0]>nums[1]?nums[0]:nums[1];
        int len=nums.length;
        return Math.max(robRange(nums,0,len-1),robRange(nums, 1, len ));

    }
    public int robRange(int[]nums,int start,int end){
        // 注意下面两个int 的下标别写错了 不是0，1 要写成和start相关
        int prepre=nums[start];
        int pre=nums[start]>nums[start+1]?nums[start]:nums[start+1];
        for (int i=start+2;i<end;i++){
            int temp=pre;
            pre=Math.max(prepre+nums[i],pre);
            prepre=temp;
        }
        return pre;
    }
    
}
// @lc code=end

