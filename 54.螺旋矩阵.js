/*
 * @lc app=leetcode.cn id=54 lang=javascript
 *
 * [54] 螺旋矩阵
 */

// @lc code=start               
/**
 * @param {number[][]} matrix
 * @return {number[]}
 */

// 模拟
var spiralOrder = function(matrix) {
    if (matrix.length===0) return []
    let top=0
    let right=matrix[0].length-1
    let left=0
    let bottom=matrix.length-1
    let res=[]
    let direction='right'
    while(top<=bottom && left<=right){
        if(direction==='right'){
            for(i=left;i<=right;i++){
                res.push(matrix[top][i])
            }
            top++
            direction='down'
        }else if(direction==='down'){
            for(i=top;i<=bottom;i++){
                res.push(matrix[i][right])
            }
            right--
            direction='left'
        }else if(direction==='left'){
            for(i=right;i>=left;i--){
                res.push(matrix[bottom][i])
            }
            bottom--
            direction='up'
        }else if(direction==='up'){
            for(i=bottom;i>=top;i--){
                res.push(matrix[i][left])
            }
            left++
            direction='right'
        }
    }
    return res

};
// @lc code=end

