/*
 * @lc app=leetcode.cn id=19 lang=javascript
 *
 * [19] 删除链表的倒数第 N 个结点
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
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
  let vnode = new ListNode(-1, head);
  let f = vnode,
    s = vnode;
  while (n--) f = f.next;
  while (f.next) {
    f = f.next;
    s = s.next;
  }
  s.next = s.next.next;
  return vnode.next;
};
// @lc code=end
