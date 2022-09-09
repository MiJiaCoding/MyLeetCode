/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
    public String sortString(String s) {
        int [] cnt=new int [26];
        for (int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        StringBuilder res =new StringBuilder();
        while(res.length()<s.length()){
            for (int i =0;i<26;i++){
                if (cnt[i]>0){
                    res.append((char)(i+'a'));
                    cnt[i]--;
                }
            }
            for (int i=25;i>=0;i--){
                if(cnt[i]>0){
                    res.append((char)(i+'a'));
                    cnt[i]--;
                }
            }
        }
        return res.toString();
    }
}
// @lc code=end

