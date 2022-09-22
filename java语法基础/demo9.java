package java语法基础;
import java.util.*;
public class demo9 {
    public static boolean isValid(String s) {
        int len=s.length();
        if (len%2!=0 || s==null){
            return false;
        }
        Deque<Character> stack = new LinkedList<Character>();
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()){
                stack.push(ch);
            }else{
            if (ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
                System.out.println("进一个后："+stack.peek());
    
            }else if((ch==')'&& stack.getLast()=='(' )||(ch=='}'&&stack.getLast()=='{')||(ch==']'&&stack.getLast()=='[')){
                stack.pop();
                System.out.println(" 出一个后"+stack.peek());
            }
        }
    }
        System.out.println("最后"+stack.getLast());
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s="{[]}";
        System.err.println();
        System.out.println(isValid(s));
    }
}
