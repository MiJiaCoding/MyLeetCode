package java语法基础;

import java.util.HashSet;

public class demo4 {
    public static void main(String[] args) {
        HashSet<String> hashset=new HashSet<>();
        hashset.add("mijia");
        System.out.println(hashset);
        System.out.println(hashset.add("mijia"));// return : false 因为mijia已经存在再hashset中了
        System.out.println(hashset.add("kkk")); // return :true 应为hashset里面没有kkk

    }
    
}
