/*
 * @lc app=leetcode.cn id=141 lang=javascript
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    if (head===null) return false
    let fastp=head,slowp=head
    while(fastp.next!==null&&fastp.next.next!==null){
        fastp=fastp.next.next
        slowp=slowp.next
        if(fastp===slowp) return true
    }
    return false
};

// @lc code=end

