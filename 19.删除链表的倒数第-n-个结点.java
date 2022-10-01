/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 前后双指针，前指针先走k-1
        // 定义一个pre是防止删去了第一个节点然后没法返回链表了
        // 给指针pre初始化指向元素0
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast= pre ,slow=pre;
        while(n!=0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        // pre是我们初始化的0，真正的链表是从pre.next开始返回的。
        return pre.next;
    }
}
// @lc code=end

