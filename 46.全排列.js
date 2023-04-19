~/*
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


// var permute = function (nums) {
//     let res = [];
//     let path = [];
//     let used = new Array(nums.length).fill(false);
//     dfs(nums, path, res, used, 0);
//     return res;
//   };

// let dfs = (nums, path, res, used, deep) => {
//     if (deep == nums.length) {
//       res.push(Array.from(path));
//       return;
//     }
//     for (let i = 0; i < nums.length; i++) {
//       if (!used[i]) {
//         path.push(nums[i]);
//         used[i] = true;
//         dfs(nums, path, res, used, deep + 1);
//         used[i] = false;
//         path.pop();
//       } else {
//         continue;
//       }
//     }
//   };
// @lc code=end

