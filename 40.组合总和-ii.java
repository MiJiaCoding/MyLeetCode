import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        if(len==0){
            return res;
        }
        // 排序 方便减枝
        Arrays.sort(candidates);
        Deque<Integer>path=new LinkedList<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    private void dfs(int[] candidates,int begin,int len, int target,Deque<Integer>path,List<List<Integer>>res){
        if(target<0){
            
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=begin;i<len;i++){
            // 大减枝
            if(target-candidates[i]<0){
                break;
            }
            // 小减枝,防止排序后两个相邻的相同元素构成的结果被重复添加到res
            // 比如 1,2,2,3,5,6 其中 2 如果在target里面，则不需要看后面那个2
            // 下面这样会出错，比如说res可以有两个2，此时这种结果就会被跳过
            // if(candidates[i]==candidates[i+1]){
            //     // 跳出这个i+1
            //     continue;
            // }
            // 正确小减少枝写法
            if(i>begin&&candidates[i]==candidates[i-1]){
                continue;
            }
            path.push(candidates[i]);
            dfs(candidates,i+1,len,target-candidates[i],path,res);
            path.pop();
        }
    }
}
// @lc code=end

