import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.JSpinner.DateEditor;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len= nums.length;
        if (len==0){
            return res;
        }
        // 排序 便于减枝
        Arrays.sort(nums);

        Deque<Integer>path=new LinkedList<>();
        boolean[] used=new boolean[len];
        dfs(nums,len,0,used,path,res );
        return res;
    }
    

    private void dfs(int[] nums,int len, int depth,boolean[] used,Deque<Integer>path,List<List<Integer>> res){
        if (depth==len){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i=0;i<len;i++){
            if(used[i]){
                continue;
            }
            /*
             * i>0是为了防止i-1<0!!!
             * 如果不加used[i-1]==false，那么不同层也不会出现相同元素了，这
             * 不是我们想要，我们只需要减去同层之间相邻的相同元素（排序后），
             * 不同层的相同 元素我们需要，（因为题目说nums数组中可能有相同元素），
             * 因此，我们发现回退的时候，used从true变回了false，则这是时候的
             * nums[i-1]不是我们需要的。
             * 
             */
        
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false){
                continue;
            }
            path.push(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,used,path,res);
            used[i]=false;
            path.pop();

        }
    }
}

// @lc code=end


