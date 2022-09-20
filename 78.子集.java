import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    // public List<List<Integer>> subsets(int[] nums) {
    //     int len=nums.length;
    //     List<List<Integer>>res=new ArrayList<>();
    //     if(len==0){
    //         return res;
    //     }
    //     Deque<Integer>path=new LinkedList<>();
    //     int depth=0;
    //     boolean[] used = new boolean[len];
    //     dfs(nums,len,0,used,path,res);  
    //     return res;
    // }

    // private void dfs(int[] nums,int len,int depth,boolean[] used,Deque<Integer>path, List<List<Integer>>res){
    //     res.add(new ArrayList<>(path));
    //     if(depth == len ){
    //         return ;
    //     }
    //     for (int i=depth;i<len;i++){
    //         if(used[i]){
    //             continue;
    //         }
    //         path.push(nums[i]);
    //         used[i]=true;
    //         dfs(nums,len,i+1,used,path,res);
    //         used[i]=false;
    //         path.pop();

    //     }
    // }


     public List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        if(len==0){
            return res;
        }
        Deque<Integer>path=new LinkedList<>();
        int depth=0;
        dfs(nums,len,0,path,res);  
        return res;
    }

    private void dfs(int[] nums,int len,int depth,Deque<Integer>path, List<List<Integer>>res){
        res.add(new ArrayList<>(path));
        if(depth == len ){
            return ;
        }
        for (int i=depth;i<len;i++){
            path.push(nums[i]);
            dfs(nums,len,i+1,path,res);
            path.pop();
        }
    }
}
// @lc code=end

