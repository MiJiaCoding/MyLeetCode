import java.util.List;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
     * 时间O(n) 空间O(1)
     * 用到翻转列表的方法，注意奇数个的时候,slowPtr舍去中间值，跳过)
     * 即slowPtr=slowPtr.next
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slowPtr = head , fastPtr = head ;
        /*
         *  偶数的时候，fastPtr 指向null 退出
         *  奇数的时候，fastPtr.next=null 退出
         */
        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next ;
            slowPtr = slowPtr.next ;
        }
        // 奇数个的时候slowPtr 跳过中间的那个 向后移动一个
        if (fastPtr != null ){
            slowPtr = slowPtr.next ;
        }

        // 从slowPtr开始的链表进行反转，然后再去和head开始比较
        slowPtr = reverseList(slowPtr);
        fastPtr = head ;
        while (slowPtr != null){
            if (slowPtr.val != fastPtr.val){
                return false ;
            }
            slowPtr = slowPtr.next ;
            fastPtr = fastPtr.next ;
        }
        return true ;
    }

    public ListNode reverseList(ListNode head){
        // 递归结束条件 head.next = null
        if (head == null || head.next == null){
            return head ;
        }
        ListNode newNode = reverseList(head.next) ;
        head.next.next = head ;
        head.next = null ;
        return newNode ;
    }
}
// @lc code=end

