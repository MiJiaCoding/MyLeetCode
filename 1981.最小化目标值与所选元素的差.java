import javax.swing.text.StyledEditorKit.BoldAction;

/*
 * @lc app=leetcode.cn id=1981 lang=java
 *
 * [1981] 最小化目标值与所选元素的差
 */

// @lc code=start
class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        /*
         * dp[i][j]表示：到第i行时候，是否能得到j这个数字，可以得到->true,否则 false;
         * k 表示遍历某一行的每个数！
         * if (dp[i][j]==false) dp[i][j] = dp[i-1][j-arr[i][k]]
         * 初始化：dp[0][arr[0][k]] = true
         */

        // 观察数据，mat[i][j]<=70,说明 我们dp[i][j] j 最大70*70
        boolean [][] dp = new boolean [70*70+1][70*70+1];

        // mat是m*n的矩阵 

        // k是列的个数
        // 初始化 (只用初始第一行的数组)
        for(int k=0;k<mat[0].length;k++){
            dp[0][mat[0][k]]=true;
        }

        // i=1相当于从第2行开始
        for(int i=1;i<mat.length;i++){
            for(int k=0;k<mat[0].length;k++){
                for(int j=mat[i][k];j<70*70+1;j++){
                    if (dp[i][j]==false){
                        // 对于第i层，的目标和j，遍历这层，（减去这层的第k的数）即mat[i][k]
                        // 如果减去之后，上一层i-1 是true 说明 数字和j可以到达！！
                        // （类似于target=target-arr[k]这个意思）
                        dp[i][j]=dp[i-1][j-mat[i][k]];
                    }
                }
            }
        }
        int res=0;
        // 注意 第一行起始时dp[0][]
        if (dp[mat.length-1][target]==true){
            return res;
        }else{
            int left=target;
            int right=target;
            while(true){
                if(dp[mat.length-1][left]==true){
                    res=target-left;
                    break;
                }
                if (dp[mat.length-1][right]==true){
                    res=target+right;
                    break;
                }
               if (left>0) left--;
               if (right<70*70) right++;
            }
           
        }
        return res;
    }
}
// @lc code=end

