import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        int len=nums.length;
        
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[len - 1] < 0){
            return res;
        }
        if (nums[0]==0 && nums[len-1]==0){
      
            ArrayList<Integer> res2=new ArrayList<>();
            for (int i=0;i<3;i++){
                // 三数之和 return 结果只需要3个0
                Integer x=nums[i];
                res2.add(x);
            }
            res.add(res2);
            return res;
        }

        // if (len ==3 ){
        //     int sum=0;
        //     for ( int i = 0;i<len;i++){
        //         sum+=nums[i];
        //     }
        //     if (sum==0){
        //         ArrayList<Integer> res3=new ArrayList<>();
        //         for (int i=0;i<nums.length;i++){

        //             Integer x=nums[i];
        //             res3.add(x);
        //         }
        //         res.add(res3);
        //         return res; 
        //     }else{
        //         return res;
        //     }
            
        // }
     
            // ArrayList<Integer> res3=new ArrayList<>();
            // for (int i=0;i<nums.length;i++){

            //     Integer x=nums[i];
            //     res3.add(x);
            // }
            // res.add(res3);
            // return res;
        
        HashSet<Integer> temp= new HashSet<>();
        // HashSet temp= new HashSet (Arrays.asList(nums));
        Deque<Integer>path = new LinkedList<>();
        for (int i=0;i<nums.length;i++){
            Integer x=nums[i];
            temp.add(x);
        }
        dfs(nums,len,0,3,path,res,temp,0);
        return res;
    }
    private void dfs(int[]nums,int len,int i,int cnt, Deque<Integer>path,List<List<Integer>>res,HashSet<Integer> temp,int target){

        if (cnt==1){
            if(target>=nums[i]&&temp.contains(target)){
                //最后一个数直接用哈希表查找,要查找的数必须大于当前的左边界，不然会出错
                path.push(target);
                res.add(new ArrayList<>(path));
                path.pop();
            }
            return ;
        }

        for (int j=i;j<=len-cnt&&target>=nums[j]*cnt;++j){
            // 剪枝优化: nums[j]*cnt 剪枝
            if(j>i&&nums[j]==nums[j-1]|| nums[j] + (cnt - 1) * nums[len - 1] < target ){
                /* 
                 * 排序后的减枝,两种情况都减去，
                 * 第一种同层时，如果相邻俩元素相同，减去
                 * 第二种是进行一个估算，假设cnt=3，也就是选第一个数后，
                 * 三数之和，当前是nums[j]，这种这个数作为第一个数的情况下，
                 * 另外两数之和最大时2*nums[len-1] (从小到大排序的)，如果三数之和
                 * 小于target，就不用把这层j都给遍历了。
                 * 
                 * 加上第二种减枝可以减少15-20ms
                 */

                    continue;
            }
            path.push(nums[j]);
            dfs(nums,len,j+1,cnt-1,path,res,temp,target-nums[j]);
            path.pop();
        }
    }
}
// @lc code=end

