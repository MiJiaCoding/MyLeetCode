const Bag = (w, v, size) => {
  // 物品个数
  let n = w.length;
  // 注意是 0-i 是物品物品的下标编号，物品0，物品1....物品i ; 列数是背包的容量， 应该是从0 ～ size， 所依有size+1列！！！
  let dp = Array.from(new Array(n), () => new Array(size + 1).fill(0));
  // dp[i][j]表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
  // 初始化 1. j=0 ，背包容量是0，价值全是0
  for (let i = 0; i < n; i++) dp[i][0] = 0;
  // 初始化 2. 对于物品0号 ，只要背包容量够 就去装
  for (let j = w[0]; j <= size; j++) dp[0][j] = v[0];

  for (let i = 1; i < n; i++) {
    for (let j = 1; j < size + 1; j++) {
      if (j < w[i]) dp[i][j] = dp[i - 1][j];
      else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
    }
  }
  console.log(dp);
  return dp[n - 1][size];
};

const Bag2 = (w, v, size) => {
  const n = w.length;
  const dp = new Array(size + 1).fill(0);
  // 需要对于 j（背包容量）从后往前便利，防止重复计算同一个物品的价值
  for (let i = 0; i < n; i++) {
    for (let j = size; j >= w[0]; j--) {
      dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
    }
  }
  console.log(dp)
  return dp[size]
};

let w = [2, 3, 4, 5];
let v = [3, 4, 5, 8];
console.log("res:", Bag(w, v, 8));
console.log("res2:", Bag(w, v, 8));


