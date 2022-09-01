/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start

class Solution {

    /*
     * 双指针 移动的方法（也可以用交换）i循环 然后把j到数组最后置为0即可
    */
    //请注意 ，题目要求是必须在不复制数组的情况下原地对数组进行操作。
    public void moveZeroes(int[] nums) {
        int j=0;
        // 第一次遍历，j记录非0的个数，至少是非零的都赋值给nums[j]
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        // 第二次遍历，因为统计完非零的数了，剩下的直接赋值成0即可。
        for (int k=j;k<nums.length;k++){
            nums[k]=0;
        }
    }   
}
// @lc code=end

