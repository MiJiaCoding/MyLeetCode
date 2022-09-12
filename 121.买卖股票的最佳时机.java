/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    // public int maxProfit(int[] prices) {
    //     if (prices.length<2) return 0;
    //     int res =0;
    //     int dp[]=new int [prices.length];
    //     int min=prices[0];
    //     for (int i=1;i<prices.length;i++){
    //         if (prices[i]<min) min = prices[i];
    //         dp[i]=Math.max(dp[i-1],prices[i]-min);
    //         if (res<dp[i]) res=dp[i];
    //     }
    //     return res ;
    // }
f

    public int maxProfit(int[] prices) {
        if (prices.length<2) return 0;
        int res =0;
        int temp =0;
        int min=prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i]<min) min = prices[i];
            temp=Math.max(temp,prices[i]-min);
            if (res<temp) res=temp;
        }
        return res ;
    }
}
// @lc code=end

