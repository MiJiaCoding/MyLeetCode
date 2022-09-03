/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
     *  设 直链长a，环长b，fastPtr走了f，slowPtr走了s。f比s夺走了环的整数倍
     * （slowPtr没到的时候，fastPtr再环里面绕圈），设为nb
     *  根据数学公式推导， f=2s，f=s+nb
     *  两式子相加相减可得 ，s=nb ，f=2nb
     *  分析：如果要到达环的入口，则必须满足 路程等于a+nb （n=0、1、2...）
     *  而s=nb，这时候只要让slowPtr再走个a就可以了
     *  我们把没有用的fastPtr的f置为0，即放到原点，然后速度和slowPtr保持一致
     *  都是.next,这时候 让fastPtr走了a的时候，slowPtr的s=nb+a，正好也在环入口。
     *  两者相遇。
     * 
     */
    public ListNode detectCycle(ListNode head) {
        boolean hasloop=false;
        if (head == null || head.next == null ){
            return null;
        }
        ListNode fastPtr=head,slowPtr=head;
        while (fastPtr.next != null && fastPtr.next.next != null){
            // 说明有环
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if (slowPtr==fastPtr){
                hasloop=true;
                break;
            }
        }
        if (hasloop){
            fastPtr=head;
            while(fastPtr!=slowPtr){
                fastPtr=fastPtr.next;
                slowPtr=slowPtr.next;
            }
            return slowPtr;
        }

        // if (hasloop)
        // fastPtr=head;
        // while(hasloop){
        //     fastPtr=fastPtr.next;
        //     slowPtr=slowPtr.next;
        //     if (fastPtr==slowPtr){
        //         return slowPtr;
        //     }
        // }
        return null;
    }
}
// @lc code=end

