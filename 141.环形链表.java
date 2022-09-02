/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
     * 哈希表 需要一个O(n)的空间复杂度
     * 我们可以使用哈希表来存储所有已经访问过的节点。每次我们到达一个节点，
     * 如果该节点已经存在于哈希表中，则说明该链表是环形链表，否则就将该节点
     * 加入哈希表中。重复这一过程，直到我们遍历完整个链表即可。
     */

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashset = new HashSet<ListNode>();
        while ( head != null) {
            // 如果hashset中存再改head节点，那么则返回false ，不存在 则add成功，返回的时true
            if ( !hashset.add(head)){ // 添加失败,说明有环
                return true;
            }
            head = head.next ;
        }
        return false;
    }



    /*
     * 快慢双指针, 快指针走两个结点，慢指针走一个。
     * 主要注意while中的循环条件，用快指针来判断，而且注意&&
     */
    public boolean hasCycle(ListNode head) {
        if (null == head){
            return false;
        }
        ListNode slowPtr = head , fastPtr = head ;
        // while 条件不能写反了
        while (fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

