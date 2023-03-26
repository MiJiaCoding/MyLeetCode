var climbStairs = function (n) {
  let dp = new Array(n + 1).fill(0);
  dp[0] = 1;
  let m = 2;
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= m; j++) {
      if (i - j >= 0) {
        dp[i] += dp[i - j];
      }
    }
    console.log(`dp[${i}]=`, dp[i]);
  }
  return dp[n];
};

console.log("res:", climbStairs(4));
