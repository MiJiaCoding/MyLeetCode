/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    const res=[]
    const path=[]
    backTracking(nums,nums.length,[])
    return res
    function backTracking(n,k,used){
        if(path.length===k){
            res.push(Array.from(path))
            return 
        }
        for(let i=0;i<k;i++){
            if(used[i]) continue
            path.push(n[i])
            used[i]=true
            backTracking(n,k,used)
            path.pop()
            used[i]=false
        }
    }
};
// @lc code=end

