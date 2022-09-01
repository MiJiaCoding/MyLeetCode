package java语法基础;

public class demo2 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n;
        int[] temp = new int[k];
        for (int pos1=0,pos2=0,index=0;index<k;index++){
            if(pos1>m-1){
                // 别忘了指针要移动
                temp[index]=nums2[pos2++];
            }else if (pos2>n-1){
                temp[index]=nums1[pos1++];
            }else if(nums1[pos1]<nums2[pos2]){
                temp[index]=nums1[pos1];
                pos1++;
            }else{
                temp[index]=nums2[pos2];
                pos2++;
            }
        }
        for (int i=0;i<k;i++){
            nums1[i]=temp[i];
    }
}
    
public static void merge2(int[] nums1, int m, int[] nums2, int n) {
    int k=m+n;
    for (int pos1=m-1,pos2=n-1,index=k-1;index>=0;index--){
        if (pos1<0){
            // 数组一已经取完了，直接把数组2粘过来
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


    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
        for (int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
    }
}
