/*
 * @lc app=leetcode.cn id=509 lang=javascript
 *
 * [509] 斐波那契数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
// var fib = function(n) {
//     let dp = [0,1]
//     for (let i = 2; i < n+1; i++) {
//         dp[i] = dp[i-1] + dp[i-2]
//     }
//     return dp[n]
// };

var fib = function(n) {
    let pre = 0
    let res = 1
    switch(n) {
        case 0 :
            return 0
        case 1 :
            return 1
    }
    for (let i = 2; i<n+1 ; i++) {
        let temp = res
        res = pre + res
        pre = temp
    }
    return res
}
// @lc code=end

