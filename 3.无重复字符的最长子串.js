/*
 * @lc app=leetcode.cn id=3 lang=javascript
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */

// // 滑动窗口
// var lengthOfLongestSubstring = function(s) {
//     const set = new Set()
//     let i = 0,j = 0,maxlength = 0
//     for (i;i<s.length;i++){
//         if (!set.has(s[i])){
//             set.add(s[i])
//             maxlength = Math.max(maxlength,set.size)
//         }else{
//             while(set.has(s[i])){
//                 set.delete(s[j])
//                 j++
//             }
//             set.add(s[i])
//         }
//     }
//     return maxlength
// };

var lengthOfLongestSubstring = function(s) {
    const set = new Set()
    let res=0
    let j=0
    for (let i=0;i<s.length;i++){
        if (!set.has(s[i])){
            set.add(s[i])
            res=Math.max(res,set.size)
        }else{
            while(set.has(s[i])){
                set.delete(s[j])
                j++
            }
            set.add(s[i])
        }
    }   
    return res
}
// @lc code=end




