import java.util.List;

/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
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
    /*
     * 一次loop 就用快慢双指针
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head , slow = head ;
        while (fast != null && fast.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
        }
        return slow;
    }
}
// @lc code=end

