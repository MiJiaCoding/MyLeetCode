package java语法基础;

public class demo11 {
    public static void main(String[] args) {
        // 新建数组后 元素初始默认是0
        int [][]dp=new int[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.println(dp[i][j]);
            }
        }
    }
}
