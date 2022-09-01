import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    // 暴力没写
    // public List<Integer> findDisappearedNumbers(int[] nums) {
    //     int n=nums.length;
    //     HashMap<Integer,Integer> temp=new HashMap<>();
        
    //     for (int i=1;i<=n;i++){
    //         temp.add(i);
    //     }
    //     System.out.println(temp);

    // }

        /*
         * 不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗?
         * 你可以假定返回的数组不算在额外空间内。
         */
    public List<Integer> findDisappearedNumbers(int[] nums) {
            
            /*
             *  对数组进行处理，可以对nums[i]的值 
             * 找到相应的index=nums[i]，再-1(防止越界)，然后再对nums[index-1]取负数
             * 进行标记,即数组下表+1这个index就是数组出现过的值
             * 但是对于那些已经被取了负数的值 则要进行进行还原
             */
            int n=nums.length;
            List<Integer> result = new ArrayList<>();
            for (int num: nums){
                int x = (num-1) % n; //取模还原出来它本来的值
                
                // 没有下面这行代码就是计算 出现过的值
                nums[x]+=n;

            }
            for (int i=0;i<n;i++){
                if (nums[i]<=n){
                    result.add(i+1);
                }
            }
            return result;
    }


}
// @lc code=end

