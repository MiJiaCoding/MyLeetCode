/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    /*
     * 动态规划
     * dp[i][j]表示当前使用i总面值的硬币，j是当前amount总金额数量
     * dp[i][0]=1 就是说金额amount为0的时候，只有一种组合，就是不用选
     * i每次变换从1到 j从0到amount，j越大，可能使用的当前面额的硬币数越多，
     * 累加过去。
     */
    public int change(int amount, int[] coins) {
        int [][]dp=new int [coins.length+1][amount+1];
        for (int i=0;i<coins.length+1;i++) dp[i][0]=1;

        for (int i=1;i<coins.length+1;i++){
            for (int j=1;j<amount+1;j++){
                // dp[i][j]初始是0
                // 先加上不用这个第i-1中面额硬币就能装满j 的组合数
                dp[i][j]+=dp[i-1][j];
                // coins[i-1]是当前是否加入第i-1也就是当前这个面额的硬币
                // i-1是因为 下标i是从1开始的，而我们的coins是从开始的
                if (j>=coins[i-1])
                dp[i][j]+=dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }



    // public int change(int amount, int[] coins) {
    //     int[] dp = new int[amount + 1];
    //     dp[0] = 1;
    //     for (int coin : coins) {
    //         for (int i = coin; i <= amount; i++) {
    //             dp[i] += dp[i - coin];
    //         }
    //     }
    //     return dp[amount];
    // }



    
}
// @lc code=end

