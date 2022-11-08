/*
 * @lc app=leetcode.cn id=695 lang=javascript
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
    const m=grid.length,n=grid[0].length
    let res=0
    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            if(grid[i][j]===1){
                let a=dfs(grid,i,j)
                res=Math.max(res,a)
            }
        }
    }
    return res
};
const dfs=(grid,r,c)=>{
    if(!inArea(grid,r,c)) return 0
    if(grid[r][c]===0) return 0
    grid[r][c]=0
    return 1+dfs(grid,r-1,c)+dfs(grid,r+1,c)+dfs(grid,r,c-1)+dfs(grid,r,c+1)
}
const inArea=(grid,r,c)=>{
    return r>=0&&r<grid.length&&c>=0&&c<grid[0].length
}

// @lc code=end

