/*
 * @lc app=leetcode.cn id=1049 lang=javascript
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeightII = function (stones) {
  // 可以无限次撞击 ，最终只剩下1个石头
  //本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
  //dp[j]容量为j的背包可以背最大重量为dp[j]
  const sum = stones.reduce((pre, cur) => pre + cur);
  let size = Math.floor(sum / 2);
  const dp = new Array(size + 1).fill(0);
  for (let i = 0; i < stones.length; i++) {
    for (let j = Math.floor(size); j >= stones[i]; --j) {
      dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
    }
  }
  return sum - dp[size] - dp[size];
};
// @lc code=end
