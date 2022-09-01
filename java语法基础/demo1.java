package java语法基础;

import java.util.HashMap;


public class demo1 {
    public static void main(String[] args) {
        double x= 4;
        double y=Math.sqrt(x);
        System.out.println(y);

        final double CHANGLIANG=2.99;
        // CHANGLIANG =4; //error 最终局部变量不能赋值

        System.out.println(CHANGLIANG);
        HashMap<Integer, String> people= new HashMap<>();
        people.put(1,"mijia");
        people.put(2,"nihao");
        people.put(3,"woaini");
        System.out.println(people);
        System.out.println(people.get(2));
        
        people.remove(2);
        System.out.println(people);

        people.clear();
        System.out.println(people);
    }
}
