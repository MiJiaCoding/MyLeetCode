import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    
    // O(n^2)
    // public int[] twoSum(int[] nums, int target) {
    //     int[] result= new int[2];
    //     for (int i=0;i<nums.length;i++){
    //         for (int j=i+1;j<nums.length;j++){
    //             if (nums[i]+nums[j]==target){
    //                 result[0]=i;
    //                 result[1]=j;
    //                 return result;
    //             }
    //         }
    //     }
    //     return result;
    // }
        
    // O(n)
    /*
    * 两个元素x，y必然是一前一后出现的，'如果存在符合条件的解，
    * 在遍历到x时，哈希表里没有符合的y，此时把x加入到了哈希表里，
    * 当遍历到y时，就可以在哈希表里找到对应的x了，所以只需要一次遍历
    */
    public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        HashMap<Integer,Integer> temp= new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int tofind=target-nums[i];
            Integer index=temp.get(tofind);
            if(null!=index){
                result[0]=i;
                result[1]=index;
                break;
            }else{
                temp.put(nums[i],i);
            }
        }
        return result;
    }
}
// @lc code=end

