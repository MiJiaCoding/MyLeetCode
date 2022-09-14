/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean [][] dp =new boolean[len][len];
        char[] charArray = s.toCharArray();
        if (len<2) return s;
        // 初始化，长度为1的子串都是回文的
        for (int i = 0 ; i < len ; i++) dp[i][i]=true;
        int maxlen=1;
        int begin=0;
        // 先一列一列的填写
        for (int j=1;j<len;j++){
            for (int i=0;i<j;i++){
                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else if (j-1-(i+1)+1<2) {
                    // j-1-(i+1)+1表示长度
                    dp[i][j]=true;
                }else{
                                        
                    dp[i][j]=dp[i+1][j-1];
                }
                if (dp[i][j]== true && j-i+1>maxlen){
                    maxlen =j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin, begin+maxlen);
    }

}
// @lc code=end

