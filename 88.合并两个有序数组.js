/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */


// 双指针
var merge = function(nums1, m, nums2, n) {
    let k=m+n
    let pos1=m-1
    let pos2=n-1
    for(let i=k-1;i>=0;i--){
        if(pos1<0){
            //数组一取完了 直接粘数组2
            nums1[i]=nums2[pos2]
            pos2--
        }else if (pos2<0){
            //数组二取完了 直接return结果
            break 
        }else if (nums1[pos1]<nums2[pos2]){
            nums1[i]=nums2[pos2]
            pos2--
        }else{
            nums1[i]=nums1[pos1]
            pos1--
        }
    }
    return nums1
}
// @lc code=end

