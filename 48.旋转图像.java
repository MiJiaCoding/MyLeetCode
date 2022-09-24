/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        /*
         * 从左下角开始旋转，只需要一个temp保存左上角的元素即可
         */
        int gap=matrix.length-1;
        int begin=0;
        while(gap>0){
            for (int i=0;i<gap;i++){
                int temp=matrix[begin][begin+i];
                // 左下-> 左上
                matrix[begin][begin+i]=matrix[begin+gap-i][begin];
                // 右下-> 左下
                matrix[begin+gap-i][begin]=matrix[begin+gap][begin+gap-i];
                // 右上 -> 右下
                matrix[begin+gap][begin+gap-i]=matrix[begin+i][begin+gap];
                // 左上-> 右上 使用temp
                matrix[begin+i][begin+gap]=temp;
    
            }
            begin++;
            gap-=2;
        }
    }
}
// @lc code=end

