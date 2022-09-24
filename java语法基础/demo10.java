package java语法基础;

public class demo10 {
    public static void main(String[] args) {
        int [][] array={{1,2,3},{4,5,6},{7,8,9}};
        rotate(array);
        
        return ;
    }
    public static void  myprint(int[][] array){
        for(int row=0;row<array.length;row++){
            for(int col=0;col<array[row].length;col++){
                System.out.print(array[row][col]+",");
            }
            System.out.println();
        }

    }

    public static void rotate(int[][] matrix) {
        /*
         * 从左下角开始旋转，只需要一个temp保存左上角的元素即可
         */
        int gap=matrix.length-1;
        int begin=0;
        while(gap>0){
            for (int i=0;i<gap;i++){
                int temp=matrix[begin][begin+1];
                // 左下-> 左上
                matrix[begin][begin+i]=matrix[begin+gap-i][begin];
                // 右下-> 左下
                matrix[begin+gap-i][begin]=matrix[begin+gap][begin+gap-i];
                // 右上 -> 右下
                matrix[begin+gap][begin+gap-i]=matrix[begin+i][begin+gap];
                // 左上-> 右上 使用temp
                matrix[begin+i][begin+gap]=temp;
                myprint(matrix);
            }
            begin++;
            gap-=2;
        }
    }
}
