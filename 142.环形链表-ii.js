/*
 * @lc app=leetcode.cn id=142 lang=javascript
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */

/*
fast f  slow s  直 a   环 b
相遇： f=s+nb    f=2s
两个式子相 减  s=nb  所以 f=2nb
环位置是 a+nb
让f 走a 此 f=a+2nb  让s 重置到head 同时走a 相遇就是
或者 让 s走a 此时 s=a+nb 让f 重置到head 同时走a 相遇就是
*/
var detectCycle = function(head) {
    if (head===null||head.next===null) return null
    let isCycle=false
    let f=head,s=head
    while(f.next!==null&&f.next.next!==null){
        f=f.next.next
        s=s.next
        if(f===s){
            isCycle=true
            break
        }
    }
    f=head
    if(isCycle){
        while(f!==s){
            f=f.next
            s=s.next
            
        }
        return s
    }



    return null
};
// @lc code=end

