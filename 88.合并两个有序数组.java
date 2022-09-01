import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
// m>
class Solution {

    //有问题的
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int stored_num=0;
//         for(int i=0;i<nums1.length-1;i++){
//             for(int j=0;j<n;j++){
//                 if (nums2[j]>nums1[i])
//                 i++;
//             else{
//                 stored_num++;
//                 for (int k=m-1-1+stored_num;k<m-1-i;k--){
//                     nums1[k+1]=nums1[k];
//                 }
//                 nums1[i]=nums2[j];
//             }
//         }
//     }
// }
    /*
     * 直接合并后排序
     */
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         for (int i=0;i<n;i++){
//             nums1[m+i]=nums2[i];
//         }
//         Arrays.sort(nums1);
// }



    /*
     * 双指针 正序插入 需要开辟一个m+n的空间 
     * 时间复杂度 O(m+n)
     */
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int k=m+n;
//         int[] temp = new int[k];
//         for (int pos1=0,pos2=0,index=0;index<k;index++){
//             if(pos1>m-1){
//                 temp[index]=nums2[pos2++];
//             }else if (pos2>n-1){
//                 temp[index]=nums1[pos1++];
//             }else if(nums1[pos1]<nums2[pos2]){
//                 temp[index]=nums1[pos1];
//                 pos1++;
//             }else{
//                 temp[index]=nums2[pos2];
//                 pos2++;
//             }
//         }
//         for (int i=0;i<k;i++){
//             nums1[i]=temp[i];
//     }
// }




    /*
     * 双指针 逆序插入，不需要重新开一个m+n的空间
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n;
        for (int pos1=m-1,pos2=n-1,index=k-1;index>=0;index--){
            if (pos1<0){
                // 数组一已经取完了，直接把数组2粘过来
                // 别忘记指针的移动
                nums1[index]=nums2[pos2--];
            }else if (pos2<0){
                // 数组二空了 ，则数组1已经排好了
                break;
            }else if (nums2[pos2]>nums1[pos1]){
                nums1[index]=nums2[pos2];
                pos2--;
            }else {
                nums1[index]=nums1[pos1];
                pos1--;
            }
        }
    }
 }

// @lc code=end

