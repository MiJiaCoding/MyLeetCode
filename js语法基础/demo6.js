// var climbStairs = function (n) {
//   let dp = new Array(n + 1).fill(0);
//   dp[0] = 1;
//   let m = 2;
//   for (let i = 1; i <= n; i++) {
//     for (let j = 1; j <= m; j++) {
//       if (i - j >= 0) {
//         dp[i] += dp[i - j];
//       }
//     }
//     console.log(`dp[${i}]=`, dp[i]);
//   }
//   return dp[n];
// };

// console.log("res:", climbStairs(4));

var uniquePathsWithObstacles = function (obstacleGrid) {
  const m = obstacleGrid.length;
  const n = obstacleGrid[0].length;
  const dp = Array.from(new Array(m), () => new Array(n).fill(0));
  for (let i = 0; i < m; i++) {
    if (obstacleGrid[i][0] !== 1) {
      dp[i][0] = 1;
    } else {
      break;
    }
  }
  for (let j = 0; j < n; j++) {
    if (obstacleGrid[0][j] !== 1) {
      dp[0][j] = 1;
    } else {
      break;
    }
  }
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
     console.log(dp[i][j])
    }
  }
  return dp[m - 1][n - 1];
};

let arr = [
  [0, 0, 0],
  [0, 1, 0],
  [0, 0, 0],
];
console.log(arr);
console.log(uniquePathsWithObstacles("res", arr));
