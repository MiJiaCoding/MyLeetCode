/*
 * @lc app=leetcode.cn id=494 lang=javascript
 *
 * [494] 目标和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// var findTargetSumWays = function(nums, target) {
//     // 01背包 偷/不偷 换成了+/-
//     // 设加法总和是x  那么减法对应的总和是sum-x；x-(sum-x)=target
//     //  式子化简 => x=(target + sum )/2  满足 背包装下这个x 即可
//     //dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
//     const n = nums.length
//     const dp =
//     for (let i )
// };

var findTargetSumWays = function (nums, target) {
  let cnt = 0;
  const backTrack = (nums, target, index, sum) => {
    if (index === nums.length) {
      if (target === sum) {
        cnt++;
        return 
      } else {
        return;
      }
    }
    backTrack(nums, target, index + 1, sum + nums[index]);
    backTrack(nums, target, index + 1, sum - nums[index]);
  };
  backTrack(nums, target, 0, 0);
  return cnt;
};
// @lc code=end
