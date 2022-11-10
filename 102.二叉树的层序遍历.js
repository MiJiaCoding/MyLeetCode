/*
 * @lc app=leetcode.cn id=102 lang=javascript
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
//  var levelOrder = function(root) {
//     let res = [];
//     if(root === null) return res;
//     let list = [];
//     list.push(root);
//     while(list.length) {
//         let curLen = list.length;//上一轮剩下的节点，全属于下一层
//         let newLevel = [];
//         for(let i = 0; i < curLen; i++) {//同层所有节点
//             let node = list.shift();//出列
//             newLevel.push(node.val);//push进newLevel数组
//             //左右子节点push进队列
//             if(node.left) list.push(node.left);
//             if(node.right) list.push(node.right);
//         }
//         res.push(newLevel);//push到res数组
//     }
//     return res;
// };


// /* @return {number[][]}
// */
// var levelOrder = function(root) {
//  if (!root) return [];
//  const items = []; // 存放所有节点
//  const queue = [root, null]; // null 简化操作
//  let levelNodes = []; // 存放每一层的节点

//  while (queue.length > 0) {
//    const t = queue.shift();

//    if (t) {
//      levelNodes.push(t.val)
//      if (t.left) {
//        queue.push(t.left);
//      }
//      if (t.right) {
//        queue.push(t.right);
//      }
//    } else { // 一层已经遍历完了
//      items.push(levelNodes);
//      levelNodes = [];
//      if (queue.length > 0) {
//        queue.push(null)
//      }
//    }
//  }

//  return items;
// };

// bfs
var levelOrder = function(root) {
    let res=[]
    let queue=[]
    if(root!==null){
        queue.push(root)
    }
    while(queue.length){
        let level=[]
        let l=queue.length // 这个是必须的 下一层的len有上一层确定，不能收下一层的影响
        for(let i=0;i<l;i++){
            let n=queue.shift()
            level.push(n.val)
            if(n.left){
                queue.push(n.left)
            }
            if(n.right){
                queue.push(n.right)
            }
        }
        res.push(level)
    }
    return res
};

//dfs
var levelOrder = function (root) {
    if(root===null) return []
    let res=[]
    dfs(root,res,0) // 从第0层开始
    return res
}

const dfs=(root,res,level)=>{
    if (res.length<level+1) res.push([])//每当第一次深入的时候 添加一个[]
    res[level].push(root.val)
    if(root.left) dfs(root.left,res,level+1)
    if(root.right) dfs(root.right,res,level+1)
}

// @lc code=end