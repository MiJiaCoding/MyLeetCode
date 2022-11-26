/*
 * @lc app=leetcode.cn id=17 lang=javascript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
/**
 * @param {string} digits
 * @return {string[]}
 */

let res = []
const map = ["","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
var letterCombinations = function(digits) {
    // 从0到9 （题目可以从2-9） 映射关系
    if(digits.length===0) return []
    res = []
    let path = []
    dfs(digits,path,0) // 下标从0开始 比如digits是"233"对应index 2、3、3
    return res
};
const dfs = (digits,path,index) => {
    if(path.length === digits.length){
        res.push(path.join(""))
        return 
    }
    for (const v of map[digits[index]]){
        path.push(v)
        dfs(digits,path,index+1) // 这里就可以看出index虽然可以不同，但是digits[index]可以相同，对应映射关系可以相同，允许重复
        path.pop()
    }
}
// @lc code=end

