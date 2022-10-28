/*
 * @lc app=leetcode.cn id=20 lang=javascript
 *
 * [20] 有效的括号
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */

// // // 错误
// var isValid = function(s) {
//     if (s[0]!=='('||s[0]!=='{'||s[0]!=='[') return false
//     let stack = []
//     for (let i=0;i<s.length;i++){
//         stack.push(s[i])
//         if(s[i]===')'&&stack[stack.length-2]==='('){
//             stack.pop()
//             stack.pop()
//         }else if(s[i]==='}'&&stack[stack.length-2]==='{'){
//             stack.pop()
//             stack.pop()
//         }else if(s[i]===']'&&stack[stack.length-2]==='['){
//             stack.pop()
//             stack.pop()
//     }
//     return stack.length===0
// }
// };

// 正确
// var isValid = function(s) {
//     if (s.length%2!==0) return false
//     let stack=[]
//     for (let i=0;i<s.length;i++){
//         if(s[i]==='('||s[i]==='['||s[i]==='{'){
//             stack.push(s[i])
//         }else if(s[i]===')'&&stack[stack.length-1]==='('||s[i]==='}'&&stack[stack.length-1]==='{'||s[i]===']'&&stack[stack.length-1]==='['){
//             stack.pop()
//         }else{
//             return false
//         }
//     }
//     return !stack.length
// };




//字典1
const dict={
    '(':')',
    '{':'}',
    '[':']'
}
var isValid = function(s){
    if(s.length%2!==0) return false
    const stack=[]
    for(let i=0;i<s.length;i++){
        if(dict[s[i]]){
            // 如果是开头符号 入栈。
            //定义的变量，赋值为空字符串在if中认为是假，赋值为其他的字符串，也就是是字符串中有字符就认为是真
            stack.push(s[i])
        }else
            if (s[i]===dict[stack[stack.length-1]]) {
                //如果是终止符号
                stack.pop()
            }else{
                return false
            }
        }
    return stack.length===0;
}

// //字典2 优化了一点 多了一个if
// const dict={
//     '(':')',
//     '{':'}',
//     '[':']'
// }
// var isValid = function(s){
//     if(s.length%2!==0) return false
//     const stack=[]
//     for(let i=0;i<s.length;i++){
//         if(dict[s[i]]){
//             // 如果是开头符号 入栈。
//             //定义的变量，赋值为空字符串在if中认为是假，赋值为其他的字符串，也就是是字符串中有字符就认为是真
//             stack.push(s[i])
//         }else{
//             if(stack.length===0) return false
//             if (s[i]===dict[stack[stack.length-1]]) {
//                 //如果是终止符号
//                 stack.pop()
//             }else{
//                 return false
//             }
//         }
//     }
//     return stack.length===0;
// }



// @lc code=end

