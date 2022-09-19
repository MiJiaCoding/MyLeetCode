import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>>res =new ArrayList<>();
        // 用栈 
        Deque<Integer> path =  new LinkedList<>();
        boolean[] used = new boolean[len];
        dfs(nums,len,0,path,used,res);
        return res;
    }
    private void dfs(int[]nums,int len,int depth,Deque<Integer> path,boolean[]used,List<List<Integer>>res){
        if(len == depth){
            // tmp只有一份，在遍历过程中会add，remove，最终回溯会root的时候，tmp就是空的。所以那里每次都要new一个对象，将tmp拷贝过去。
            res.add(new ArrayList<>(path));
            return ; 
        }
        // 定位 一个没被用的元素的下标i 
        for (int i=0;i<len;i++){
            if (used[i]){
                continue;
            }
            path.push(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,path,used,res);
            path.pop();
            used[i]=false;
        }

    }
}
// @lc code=end


