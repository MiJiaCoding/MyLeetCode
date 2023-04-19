/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
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
 * @return {ListNode}
 */
// var reverseList = function (head) {
//   //递归 入栈思想，最后一个开始返回，从倒数第二个开始， 注意此时的节点的指针式相互指的
//   //例子1->2->3->4->5
//   if (head == null) return head;
//   if (head.next == null) return head; // 5的时候直接返回
//   let newNode = reverseList(head.next);
//   head.next.next = head; //1->2->3->4<->5
//   head.next = null; //1->2->3->4<-5
//   return newNode;
// };
var reverseList = function (head) {
  let pre = null;
  let cur = head;
  while (cur) {
    let temp = cur.next;
    cur.next = pre;
    pre = cur;
    cur = temp;
  }
  return pre;
};
// @lc code=end
