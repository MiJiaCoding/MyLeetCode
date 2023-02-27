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
// var merge = function(nums1, m, nums2, n) {
//     let k=m+n
//     let pos1=m-1
//     let pos2=n-1
//     for(let i=k-1;i>=0;i--){
//         if(pos1<0){
//             //数组一取完了 直接粘数组2
//             nums1[i]=nums2[pos2]
//             pos2--
//         }else if (pos2<0){
//             //数组二取完了 直接return结果
//             break 
//         }else if (nums1[pos1]<nums2[pos2]){
//             nums1[i]=nums2[pos2]
//             pos2--
//         }else{
//             nums1[i]=nums1[pos1]
//             pos1--
//         }
//     }
//     return nums1
// }

// var merge = function(nums1, m, nums2, n) {
//     let pos1 = m-1
//     let pos2 = n-1
//     // let res = new Array(m+n).fill(0) 这样做之后push都得改成具体下标赋值如 res[i+j-1] = xxx
//     let res = new Array()
//     let i = 0, j = 0
//     let cur
//     while(i < m || j < n) { //当两者只要有一个没走到最后
//         if (i === m) { // nums1完了，把nums2添加进去
//             res.push(nums2[j])
//             j++
//         } else if (j === n) {
//             res.push(nums1[i])
//             i++
//         } else if (nums1[i] < nums2[j]) {
//             res.push(nums1[i])
//             i++
//         } else {
//             res.push(nums2[j])
//             j++
//         }
//     }
//     for (let i = 0; i < m+n; i++) {
//         nums1[i] = res[i]
//     }
//     return nums1
// }


var merge = function(nums1, m, nums2, n) {
    let k = m+n-1 //逆向 先排大的
    let pos1 = m-1
    let pos2 = n-1
    while( k >= 0 ) {
        if (pos1 < 0) {
            nums1[k--] = nums2[pos2--]
        } else if(pos2 < 0) {
            nums1[k--] = nums1[pos1--]
        } else if(nums1[pos1] > nums2[pos2]) {
            nums1[k--] = nums1[pos1--]
        } else {
            nums1[k--] = nums2[pos2--]
        }
    }
    return nums1
}
// @lc code=end

