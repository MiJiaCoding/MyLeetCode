import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution { 

    /*
     * 没写完的。
     */
    // int res=Integer.MAX_VALUE;
    // public int coinChange(int[] coins, int amount) {
    //     if (coins.length==1){
    //         if (amount%coins[0]!=0){
    //             return -1;
    //         }else{
    //             return amount/coins[0];
    //         }
    //     }
    //     Arrays.sort(coins);
    //     int res = Integer.MAX_VALUE;
    //     int len=coins.length;
    //     int begin=len-1;
    //     Deque<Integer> path = new LinkedList<>();
    //     dfs()
    //     return res==Integer.MAX_VALUE?-1:res;

    // }

    // private int dfs(int[] coins,int begin,int amount,Deque<Integer> path,int len ){
    //     if (amount<0){
    //         return 0;
    //     }
    //     if (amount==0){
    //         return path.size();
    //     }
    //     for(int i=begin;i>=0;i--){
    //         if(amount<coins[i]){
    //             return ;
    //         }
    //         path.push(coins[i]);
    //         // 可以重复用 ，所以begin还是从i开始！
    //         dfs(coins,i,amount-coins[i],path,len);
    //         path.pop();
    //     }
    //     return -1;
    // }


    /*
     *  超时了
     *
     * 贪心加回溯剪枝！
     * 非常规的回溯，这里是用了贪心的思想快速找到一个局部最优解，然后通过这个解
     * 进行剪枝！
     */
    // int res = Integer.MAX_VALUE;
    // public int coinChange(int[] coins, int amount) {
    //     int len=coins.length;
    //     if(len==0){
    //         return 0;
    //     }
    //     Arrays.sort(coins);
    //     mincoin(coins,amount,len-1,0);
    //     return res==Integer.MAX_VALUE?-1:res;
    // }
    // private void mincoin(int[]coins,int amount,int index,int cnt){
    //     if(amount==0){
    //         res =Math.min(res,cnt);
    //         return ;
    //     }
    //     if (index<0){
    //         return ;
    //     }
    //     /*
    //      * 非常规的回溯，这里是用了贪心的思想快速找到一个局部最优解，然后通过这个解
    //      * 进行剪枝！
    //      *  假设数据是[1,3,6,7],amount=16这个i表示的就是使用几个当前前的coins[index],
    //      * 假设此时是7， 那么i=2，然后树继续向下延申，找到两个1，此时res=4
    //      * 然后i--， i=1，只用1个7，向下找到1个6和1个3，res=3
    //      */
    //     for (int i=amount/coins[index];i>=0&&i+cnt<res;i--){
    //         mincoin(coins, amount-(i*coins[index]), index-1, cnt+i);
    //     }
    // }
    
    /*
     * 解法二 ：记忆搜索
     */
    // int [] memo;
    // public int coinChange(int[] coins, int amount) {
    //     if (coins.length==0){
    //         return -1;
    //     }

    //     memo = new int[amount];
    //     return findway(coins,amount);
    // }
    // public int findway(int[]coins,int amount){
    //     if (amount<0){
    //         return -1;
    //     }

    //     if (amount==0){
    //         return 0;
    //     }
    //     // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
    //     // 直接的返回memo[n] 的最优值
    //     if(memo[amount-1]!=0){
    //         return memo[amount-1];
    //     }
    //     int min=Integer.MAX_VALUE;
    //     for (int i=0;i<coins.length;i++){
    //         int res = findway(coins, amount-coins[i]);
    //         if(res>=0&&res<min){
    //             min=res+1;
    //         };
    //     }
    //     memo[amount-1]=(min==Integer.MAX_VALUE?-1:min);
    //     return memo[amount-1];

    // }



    /*
     * dp 动态规划
     */
    public int coinChange(int[] coins, int amount) {
        int []dp=new int [amount+1];
        for (int i=1;i<amount+1;i++){
            dp[i]=i;
        }
        dp[0]=0;
        for (int i=0;i<amount+1;i++){
            for (int j =0;j<coins.length;j++){
                if(i-coins[j]<0) continue;
                dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
            }
        }
        return (dp[amount]==amount+1)?-1:dp[amount];
    }

}
// @lc code=end

