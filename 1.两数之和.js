/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// var twoSum = function(nums, target) {
//     for (var i=0;i<nums.length-1;i++){
//         for (var j=i+1;j<nums.length;j++){
//             if (nums[j]+nums[i]===target){
//                 return [i,j]
//             }
//         }
//     }
// };

var twoSum = function(nums,target){
    const map = new Map()
    for (let i = 0;i<nums.length;i++){
        let complement = target - nums[i];
        if (map.has(complement)){
            // map.has（）检查有没有key
            return [map.get(complement),i]
        }else{
            map.set(nums[i],i)
        }
    }
    return []
};
// @lc code=end

