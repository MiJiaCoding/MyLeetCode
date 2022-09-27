/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        /*
         * 思考： F(i)表示
         * G(i)=sum F(j) (j=1->j)
         * dp[i]表示从第i个节点为根的时候，n个节点有多少种
         * 不同的二叉搜索树
         * 
         */
        int [] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i =2;i<n+1;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
// @lc code=end

