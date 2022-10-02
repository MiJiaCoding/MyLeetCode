package java语法基础;

import java.util.*;
public class demo12 {
    public static void main(String[] args) {
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque <Integer> path= new LinkedList<>();
        dfs(root,targetSum,path,res);
        return res;
    }
    private static void dfs(TreeNode root,int targetSum,Deque<Integer>path,List<List<Integer>>res){
        if (root==null) return ;
        path.push(root.val);
        targetSum-=root.val;
        if (root.left==null&&root.right==null&&targetSum==0){
            res.add(new ArrayList<>(path));
            
        }
        
        dfs(root.left,targetSum,path,res);
        dfs(root.right,targetSum,path,res);
        path.pop();
    }

    public class TreeNode {
            int val;
            TreeNode left;
           TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    
}
