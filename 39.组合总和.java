import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
   
    // public List<List<Integer>> combinationSum(int[] candidates, int target){
    //     int len=candidates.length;
    //     List<List<Integer>> res =new ArrayList<>();
    //     if (len==0){
    //         return res;
    //     }        
    //     Deque<Integer>path=new LinkedList<>();
    //     dfs(candidates, 0, len, target, path, res);
    //     return res;
    // }
    
    
    // private void dfs(int[]candidates,int begin,int len,int target,Deque<Integer>path,List<List<Integer>>res){
    //     if (target<0){
    //         return ;
    //     }
    //     if (target==0){
    //         res.add(new ArrayList<>(path));
    //         return ;
    //     }

    //     for (int i=begin;i<len;i++){
    //         path.push(candidates[i]);
    //         // 因为每一个元素可以重复使用，所以下一轮搜索的起点依然是下标i
    //         dfs(candidates,i,len,target-candidates[i],path,res);
    //         // 状态重置
    //         path.pop();
    //     }
    // }

    /*
     * 加上剪枝函数（先排好序,从小到大），如果递归到某一个节点后 target-candidates[i]<0,
     * 那么target减去i+1，i+2...的数必然更<0
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        int len=candidates.length;
        List<List<Integer>> res =new ArrayList<>();
        if (len==0){
            return res;
        }        
        Deque<Integer>path=new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, len, target, path, res);
        return res;
    }
    
    
    private void dfs(int[]candidates,int begin,int len,int target,Deque<Integer>path,List<List<Integer>>res){
        if (target<0){
            return ;
        }
        
        if (target==0){
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i=begin;i<len;i++){
            if(target-candidates[i]<0){
                break ;
            }
            path.push(candidates[i]);
            // 因为每一个元素可以重复使用，所以下一轮搜索的起点依然是下标i
            dfs(candidates,i,len,target-candidates[i],path,res);
            // 状态重置
            path.pop();
        }
    }

}



// @lc code=end

