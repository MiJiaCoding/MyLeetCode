/*
 * @lc app=leetcode.cn id=48 lang=javascript
 *
 * [48] 旋转图像
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    let gap=matrix.length-1
    let begin=0
    // 相邻指针的距离是 begin+gap
    while(gap>0){
        for(let i=0;i<gap;i++){
            // 记录左上
            let temp=matrix[begin][begin+i]
            //左上<-左下 （左下空了）
            matrix[begin][begin+i]=matrix[begin+gap-i][begin]
            // 左下<-右下 (右下空了)
            matrix[begin+gap-i][begin]=matrix[begin+gap][begin+gap-i]
            // 右下<-右上 (右上空了)
            matrix[begin+gap][begin+gap-i]=matrix[begin+i][begin+gap]
            // 右上<-temp(左上)
            matrix[begin+i][begin+gap]=temp
        }
        begin++ // begin位置每次移动一个
        gap-=2 //gap相对俩指针的距离，每遍历完一圈，对于上下来说
                //上指针+1，下指针-1，两指针距离 gap-2
    }
};
// @lc code=end

