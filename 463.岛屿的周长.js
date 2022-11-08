/*
 * @lc app=leetcode.cn id=463 lang=javascript
 *
 * [463] 岛屿的周长
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function(grid) {
    const m=grid.length,n=grid[0].length
    let res=0
    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            if(grid[i][j]===1){
                return dfs(grid,i,j)
            }
        }
    }
    return res
};
const dfs=(grid,r,c)=>{
    if(!inArea(grid,r,c)) return 1
    if(grid[r][c]===0) return 1
    if(grid[r][c]===2) return 0
    grid[r][c]=2//不能写0了 不然后面的格子计算边的时候会多算
    return dfs(grid,r-1,c)+dfs(grid,r+1,c)+dfs(grid,r,c-1)+dfs(grid,r,c+1)
}
const inArea=(grid,r,c)=>{
    return r>=0&&r<grid.length&&c>=0&&c<grid[0].length
}
// @lc code=end

