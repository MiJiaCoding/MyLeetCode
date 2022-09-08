/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /*
     * 两两出队的队列
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (root == null || (l==null && r ==null)){
            return true;
        }
        q.offer(l);
        q.offer(r);
        while (!q.isEmpty()){
            l=q.poll();
            r=q.poll();
            if (l==null && r==null){
                continue;
            }
            if ((l==null ||r==null)|| (l.val != r.val)){
                return false;
            }

                q.offer(l.left);
                q.offer(r.right);
                
                q.offer(l.right);
                q.offer(r.left);
            }

            // 低配的写法
            // if (( (l==null && r!=null)||(l!=null && r==null) )|| (l!=null &&r!=null)&&(l.val!= r.val)){
            //     return false ;
            // }else if (l== null &&r==null) {
            //     // 注意不是break，continue 是跳出当前循环，队列不为空就一直两两出队。
            //     continue;
            // }else{
            //     q.offer(l.left);
            //     q.offer(r.right);
                
            //     q.offer(l.right);
            //     q.offer(r.left);
            // }
        return true;
    }
    


     // 递归
    public boolean isSymmetric(TreeNode root) {
       if (root ==null){
           return true;
       }
       return deepCheck(root.left,root.right);
   }


   boolean deepCheck (TreeNode left ,TreeNode right ){
       if (left ==null && right == null){
           return true;
       }
       // if( (left == null||right == null)||(left.val!=right.val)){
       //     return false ;
       // }
       if(left ==null || right == null){
           return false;
       }
       if(left.val!=right.val){
           return false ;
       }
       return deepCheck(left.left,right.right) && deepCheck(left.right, right.left);
   }
}