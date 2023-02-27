/*
 * @lc app=leetcode.cn id=165 lang=javascript
 *
 * [165] 比较版本号
 */

// @lc code=start
/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    // 使用split分割
    let v1 = version1.split('.')
    let v2 = version2.split('.')
    for(let i = 0; i < v1.length || i < v2.length; i++) {
        let x = 0, y = 0
        if (i < v1.length) x = parseInt(v1[i])
        if (i < v2.length) y = parseInt(v2[i])
        if (x > y) return 1
        if (x < y) return -1
    }
    return 0
};

var compareVersion = function(version1, version2) {
    const m = version1.length, n =version2.length
    let i = 0, j = 0
    while (i < m || j < n) {
        let x = 0
        while(i < m && version1[i]!=='.') {
            x = x*10 + version1[i].charCodeAt() - '0'.charCodeAt()
            i++
        }
        i++ // 跳过 字符. (为下一次循环准备)

        let y = 0
        while(j < n && version2[j]!=='.') {
            y = y*10 + version2[j].charCodeAt() - '0'.charCodeAt()
            j++
        }
        j++  // 跳过 .

        if(x!==y) {
            return x > y ? 1 : -1
        }
    }
    return 0
}
// @lc code=end

