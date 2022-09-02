/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    // public ListNode deleteDuplicates(ListNode head) {
        
    //     /*
    //      * 因为链表是有序的，所以我们只需要判断相邻的是不是一样，一样就删除 (next=next.next)
    //      */
    //     if (null == head){
    //         return head;
    //     }
    //     ListNode currentNode=head;
    //     while(null != currentNode.next){
    //         if (currentNode.val == currentNode.next.val){
    //             currentNode.next=currentNode.next.next;
    //         }else{
    //             currentNode = currentNode.next;
    //         }
    //     }
    //     return head;
    // }
    
    public ListNode deleteDuplicates(ListNode head) {
    /*
     * 优雅的递归，本质上就是将链表压栈后倒叙处理了
     * 例如： 1->1->2->3->3
     * 从1 开始压栈 到 最后一个3
     * 然后开始 return 从3到1
     */
        // 终止条件
        if (head == null || head.next == null){
            return head ;
            // 相当于是 压栈后，最后一个3先return出来， 然后和倒数第二个比较
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head ;
        

    }

}
// @lc code=end

