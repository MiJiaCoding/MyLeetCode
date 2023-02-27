/*
 * @lc app=leetcode.cn id=349 lang=javascript
 *
 * [349] 两个数组的交集
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
/* 使用hashset！ 
1.将两个数组转set去重
2.结果先用一个set来保存，最后转成数组
2.遍历两个之中长度较小的set，判断其中的每个元素是否在另一个集合中，如果元素也在另一个集合中，则将该元素添加到返回值。
3. hashset 可在O(1) 的时间内判断一个元素是否在集合中 最终复杂度 O(m+n)
*/
var intersection = function(nums1, nums2) {
    const set1 = new Set(nums1)
    const set2 = new Set(nums2)
    return set_intersection(set1, set2)
};
function set_intersection(shorter, longer) {
    if(shorter.size > longer.size) {
        return set_intersection(longer, shorter)
    }
    const res = new Set()
    for(let item of shorter) {
        if(longer.has(item)) {
            res.add(item)
        }
    }
    return Array.from(res)
}
// @lc code=end
