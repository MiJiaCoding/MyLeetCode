/*
 * @lc app=leetcode.cn id=78 lang=javascript
 *
 * [78] 子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// 组合
var subsets = function (nums) {
  let res = [];
  let path = [];
  dfs(nums, path, res, 0);
  return res;
};
const dfs = (nums, path, res, deep) => {
  res.push(Array.from(path));

  if (deep === nums.length) {
    return;
  }
  for (let i = deep; i < nums.length; i++) {
    path.push(nums[i]);
    dfs(nums, path, res, i + 1);
    path.pop();
  }
};
// @lc code=end
