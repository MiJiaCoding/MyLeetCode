/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    private Map<Integer,Integer> storeMap=new HashMap<>();
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        if (null != storeMap.get(n))
        return storeMap.get(n);
        else{
            int result=climbStairs(n-1)+climbStairs(n-2);
            storeMap.put(n,result);
            return result;
        }
    }
}
// @lc code=end

