import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {

    
    // List<List<Integer>> res = new ArrayList<>();

    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     Arrays.sort(nums);
    //     backTrace(nums, 0, new ArrayList<>());
    //     return res;
    // }

    // public void backTrace(int[] nums, int index, List<Integer> tmp){
    //     res.add(new ArrayList<>(tmp));
    //     for(int i = index; i < nums.length; ++i){
    //         //剔除重复元素
    //         if(i != index && nums[i] == nums[i - 1]){
    //             continue;
    //         }
    //         tmp.add(nums[i]);
    //         backTrace(nums, i + 1, tmp);
    //         tmp.remove(tmp.size() - 1);
    //     }
    // }




    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        if(len==0){
            return res;
        }
        Arrays.sort(nums);
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
            if(i> depth&&nums[i]==nums[i-1]){
                continue;
            }
            path.push(nums[i]);
            dfs(nums,len,i+1,path,res);
            path.pop();
        }
    }


    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     int len=nums.length;
    //     List<List<Integer>>res=new ArrayList<>();
    //     if(len==0){
    //         return res;
    //     }

    //     Arrays.sort(nums);
    //     Deque<Integer>path=new LinkedList<>();
    //     int depth=0;
    //     boolean[]used= new boolean[len];
    //     dfs(nums,len,0,used,path,res);  
    //     return res;
    // }

    
    // private void dfs(int[] nums,int len,int depth,boolean[] used,Deque<Integer>path, List<List<Integer>>res){
    //     res.add(new ArrayList<>(path));
    //     if(depth == len ){
    //         return ;
    //     }
    //     for (int i=0;i<len;i++){
    //         if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false){
    //             break ;
    //         }
    //         path.push(nums[i]);
    //         used[i]=true;
    //         dfs(nums,len,i+1,used,path,res);
    //         used[i]=false;
    //         path.pop();
    //     }
    // }
}
// @lc code=end

