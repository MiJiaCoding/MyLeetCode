/*
 * @lc app=leetcode.cn id=143 lang=javascript
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */

/*
找到中间节点getMidNode
翻转 reverse
合并 merge
*/
var reorderList = function(head) {
    let mid = getMidNode(head)
    let next = reverse(mid.next)
    mid.next=null    // 防止有环
    merge(head,next)
};
function getMidNode(head){
    let f=head,s=head
    while(f.next && f.next.next){
        f=f.next.next
        s=s.next
    }
    return s
}
function reverse(head){
    let cur=head,pre=null
    while(cur){
        let next=cur.next
        cur.next=pre
        pre=cur
        cur=next
    }
    return pre
}
function merge(l1,l2){
    while(l1&&l2){
        let n1=l1.next,n2=l2.next//保存一下两个链表的下一节点
        l1.next=l2,l2.next=n1
        l1=n1,l2=n2
    }
}

// @lc code=end

