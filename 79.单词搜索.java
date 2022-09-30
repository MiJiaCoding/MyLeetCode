/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    // private int r;
    // private int c;
    public boolean exist(char[][] board, String word) {
        int r=board.length;
        int c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if (dfs(board,word,i,j,0,r,c)) return true;
            }
        }   
        return false;
    }
  
    private boolean dfs(char [][] board,String word,int i,int j,int idx,int r,int c){
        // 找到了
        if (board[i][j]==word.charAt(idx) &&idx==word.length()-1) return true;
        // 没找到,终止循环
        if (board[i][j]!=word.charAt(idx)) return false;
        // 继续搜索
        char temp=board[i][j];
        board[i][j]='-';
        if (!crossBorder(i-1, j, r, c)&&dfs(board,word,i-1,j,idx+1,r,c)) return true;
        if (!crossBorder(i, j-1, r, c)&&dfs(board,word,i,j-1,idx+1,r,c)) return true;
        if (!crossBorder(i, j+1, r, c)&&dfs(board,word,i,j+1,idx+1,r,c)) return true;
        if (!crossBorder(i+1, j, r, c)&&dfs(board,word,i+1,j,idx+1,r,c)) return true;
        board[i][j]=temp;
        return false;

    }

    private boolean crossBorder(int x,int y,int r,int c){
        if(x<0||x>=r||y<0||y>=c) return true;
        return false;
    }
}
// @lc code=end

