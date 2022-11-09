/*
 * @lc app=leetcode.cn id=5 lang=javascript
 *
 * [5] 最长回文子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
    //想法1 递归 1个的时候 自己就是回文，2个 这两个要相同，
    //3个  1，3 相同， 4个 1，4   2，3相同  5个 1，5  2，4， 相同
var longestPalindrome = function(s) {
    const n=s.length
    if (s === '' ||n < 2) return s;
    // let dp=new Array(n).fill(new Array(n).fill(false))
    // 下面两种dp都可以 ，上面那种有问题,里面new只有都是同一个数组若修改的里面的值
    // 其他位置会变，所以要map建立 具体可见demo1.js
    let dp = Array.from(Array(n), () => Array(n).fill(false));
    // let dp = Array(n).fill().map(()=>Array(n));
    let res=1
    let begin=0
    let end=0
    // dp[i][j] 表示 s[i]到s[j]是否是回文字符串
    for(let r=1;r<n;r++){
        for(let l=0;l<r;l++){
            if(s[l]===s[r]&&(r-l<=2||dp[l+1][r-1])){
                dp[l][r]=true
                if((r-l+1)>res){
                    res=r-l+1
                    begin=l
                    end=r
                }
            }
        }
    }
    return s.substring(begin,end+1)
}





// var longestPalindrome = function(s) {
//     // babad
//     // tag : dp
//     if (!s || s.length === 0) return "";
//     let res = s[0];
  
//     const dp = [];
  
//     // 倒着遍历简化操作， 这么做的原因是dp[i][..]依赖于dp[i + 1][..]
//     for (let i = s.length - 1; i >= 0; i--) {
//       dp[i] = [];
//       for (let j = i; j < s.length; j++) {
//         if (j - i === 0) dp[i][j] = true;
//         // specail case 1
//         else if (j - i === 1 && s[i] === s[j]) dp[i][j] = true;
//         // specail case 2
//         else if (s[i] === s[j] && dp[i + 1][j - 1]) {
//           // state transition
//           dp[i][j] = true;
//         }
  
//         if (dp[i][j] && j - i + 1 > res.length) {
//           // update res
//           res = s.slice(i, j + 1);
//         }
//       }
//     }
  
//     return res;
//   };
  /**
   * 
状态dp[i][j]: 以下标i开头j结尾的字串是否是回文串（boolean）
 */
// var longestPalindrome = function (s) {
//     let res = '';
//     let n = s.length;
//     let dp = Array.from(Array(n), () => Array(n).fill(false));
//     for (let i = n - 1; i >= 0; i--) {
//         for (let j = i; j < n; j++) {
//             dp[i][j] = s[i] === s[j] && (j - i < 2 || dp[i + 1][j - 1]);
//             if (dp[i][j] && j - i + 1 > res.length) {
//                 res = s.substring(i, j + 1);
//             }
//         }
//     }
//     return res;
// };

// @lc code=end

