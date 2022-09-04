package java语法基础;

public class demo6 {
  public class ListNode {
    
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
    }

    /*
     * 双指针，第一个指针fast先走k-1，然后fast和slow一起走next
     * 直到fast.next=null, return slow即可
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast=head,slow=head;
        while (k-1 !=0){fast=fast.next;k--;};
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}
