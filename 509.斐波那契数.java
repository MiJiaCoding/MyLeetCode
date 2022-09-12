/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    // 动态规划
    // public int fib(int n) {
    //     if (n<=1) return n;
    //     int []dp = new int [n+1];
    //     dp[0]=0;
    //     dp[1]=1;
    //     for (int i=2;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }
    
    // 动态规划优化 只用两个变量空间
    public int fib(int n){
        if (n<=1) return n;
    int res=0;
    int pre=1;
    int prepre=0;
    for (int i=2;i<=n;i++){
        res =pre+prepre;
        prepre=pre;
        pre=res;
    }
    return res;
    }
}
// @lc code=end

