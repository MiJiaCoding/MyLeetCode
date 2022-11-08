/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    const n=grid.length,m=grid[0].length
    let count=0
    for (let i=0;i<n;i++){
        for (let j=0;j<m;j++){
            if(grid[i][j]==="1"){
                dfs(grid,i,j)
                count++
            }
        }
    }
    return count
};
const dfs=(grid,r,c)=>{
    if(!inArea(grid,r,c)) return 0
    if(grid[r][c]==="0") return 0
    grid[r][c]="0"//海岛沉没， 当然也可以换成其他值 比如'2'
    dfs(grid,r-1,c)
    dfs(grid,r+1,c)
    dfs(grid,r,c-1)
    dfs(grid,r,c+1)

}
const inArea=(grid,r,c)=>{
    return r>=0&&r<grid.length && c>=0&&c<grid[0].length
}
// @lc code=end

