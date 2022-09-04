import java.util.List;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    // 暴力
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     for(ListNode node1 = headA ;node1!=null;node1 =node1.next){
    //         for(ListNode node2 = headB ;node2!=null;node2 = node2.next){
    //             if(node1==node2){
    //                return node2;
    //             }
    //         }
    //     }
    //     return null;
    // }


    /*
     * 双指针 追击：“两个有关的人即使刚开始错过了，到后面还是可以相遇”
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode ptrA=headA,ptrB=headB;
        while ( ptrA != ptrB){
    
            if (ptrA == null){
                ptrA=headB;
            }else{
                ptrA=ptrA.next;
            }
            if (ptrB == null){
                ptrB=headA;
            }else{
                ptrB=ptrB.next;
            }    
        }
        // 不相交那么都是最后是null 同样返回ptrA就行  
        return ptrA;
    }

    // 简洁一点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode ptrA=headA,ptrB=headB;
        while ( ptrA != ptrB){
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        return ptrA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la=0,lb=0,diff=0;
        ListNode pa=headA,pb=headB;
        while(pa!=null){la++;pa=pa.next;}
        while(pb!=null){lb++;pb=pb.next;}
        if (la>lb){
            diff=la-lb;
            // 我们将 pa 用来记录长的
            pa = headA;
            pb = headB;
        }else{
            diff=lb-la;
            pa = headB;
            pb = headA;
        }
        while(diff!=0){
            pa=pa.next;
            diff--;
        }
        while(pa != null && pb != null){
            if (pa==pb){
                return pa;
            }
            pa=pa.next;
            pb=pb.next;
        }
        return null;
    }
}
// @lc code=end

