package java语法基础;

import java.lang.reflect.Array;
import java.util.HashSet;

public class demo8 {
    public static void main(String[] args) {
        int a=1,b=2;
        int []nums = new int[] {-1,0,1,2,-1,-4};    
        HashSet<Integer> hash= new HashSet<>(nums); 
        System.out.println(hash);
    }
}
