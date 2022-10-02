package java语法基础;
import java.util.*;
public class demo13 {
    public static void main(String[] args) {
        Deque<Integer>path1=new LinkedList<>();


        Deque<Integer>path2=new LinkedList<>();
        // push() pop()
        for (int i=1;i<5;i++)
        {
            path1.push(i);
            System.out.println(path1);
        }
            // path1.push(i);
            // System.out.println(path1);
            path1.pop();
            System.out.println(path1);
        // offerLast pollLast
        System.out.println("#############################");
        for (int i=1;i<5;i++){
            path2.offerLast(i);
            System.out.println(path2);
        }
            // path2.offerLast(i);
            // System.out.println(path1);
            path2.pollLast();
            System.out.println(path2);
    }
    
}
