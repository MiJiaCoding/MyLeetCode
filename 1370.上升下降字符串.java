/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
    /*
     * 正序遍历26个字母 然后再逆序遍历一边26个字母
     * 直到s字符串为空
     */
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

