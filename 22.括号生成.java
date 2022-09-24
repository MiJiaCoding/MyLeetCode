import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    // 想错了
    // public List<String> generateParenthesis(int n) {
    //     Deque<Character>stack= new LinkedList<>();
    //     List<String<Character>>res = new ArrayList<>();
    //     int cnt = 2*n;
    //     dfs(n,cnt);
    // }
    // private void dfs(int n,int cnt , Deque<Characte  r>stack){
    //     if (cnt == 1){

    //     }
    //     for (int i = 2*n-cnt;i<2*n;i++){
    //         if ( cnt !=1 && stack.isEmpty){
    //             stack.push()
    //         }
    //     }
    // }


    /*
     * 回溯通用写法
     */
    public List<String> generateParenthesis(int n) {
        List<String>res= new ArrayList<>();
        if (n==0){
            return res;
        }
        StringBuilder path = new StringBuilder();
        // left 和 right 表示左括号和右括号已经用了几个
        dfs(n,0,0,path,res);
        return res;
    }
    private void dfs(int n,int left,int right,StringBuilder path,List<String>res){
        if (left==n&&right==n){
            res.add(path.toString());
        }
        
        if (left <right){
            // 使用的右括号多于左括号，剪枝
            return;
        }
        if (left <n){
            path.append('(');
            dfs(n,left +1,right,path,res);
            path.deleteCharAt(path.length()-1);
        }
        if (right <n){
            path.append(')');
            dfs(n,left,right+1,path,res);
            path.deleteCharAt(path.length()-1);
        }
    }




    // // 做减法

    // public List<String> generateParenthesis(int n) {
    //     List<String> res = new ArrayList<>();
    //     // 特判
    //     if (n == 0) {
    //         return res;
    //     }

    //     // 执行深度优先遍历，搜索可能的结果
    //     dfs("", n, n, res);
    //     return res;
    // }

    // /**
    //  * @param curStr 当前递归得到的结果
    //  * @param left   左括号还有几个可以使用
    //  * @param right  右括号还有几个可以使用
    //  * @param res    结果集
    //  */
    // private void dfs(String curStr, int left, int right, List<String> res) {
    //     // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
    //     // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
    //     if (left == 0 && right == 0) {
    //         res.add(curStr);
    //         return;
    //     }

    //     // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
    //     if (left > right) {
    //         return;
    //     }

    //     if (left > 0) {
    //         dfs(curStr + "(", left - 1, right, res);
    //     }

    //     if (right > 0) {
    //         dfs(curStr + ")", left, right - 1, res);
    //     }
    // }

    //  // 做加法

    //  public List<String> generateParenthesis(int n) {
    //     List<String> res = new ArrayList<>();
    //     // 特判
    //     if (n == 0) {
    //         return res;
    //     }

    //     dfs("", 0, 0, n, res);
    //     return res;
    // }

    // /**
    //  * @param curStr 当前递归得到的结果
    //  * @param left   左括号已经用了几个
    //  * @param right  右括号已经用了几个
    //  * @param n      左括号、右括号一共得用几个
    //  * @param res    结果集
    //  */
    // private void dfs(String curStr, int left, int right, int n, List<String> res) {
    //     if (left == n && right == n) {
    //         res.add(curStr);
    //         return;
    //     }

    //     // 剪枝
    //     if (left < right) {
    //         return;
    //     }

    //     if (left < n) {
    //         dfs(curStr + "(", left + 1, right, n, res);
    //     }
    //     if (right < n) {
    //         dfs(curStr + ")", left, right + 1, n, res);
    //     }
    // }


}

// @lc code=end

