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
            }else if (ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
                System.out.println("进一个后："+stack.peek());
            }else if((ch==')'&& stack.peek()=='(' )||(ch=='}'&&stack.peek()=='{')||(ch==']'&&stack.peek()=='[')){
                stack.pop();
                System.out.println(" 出一个后"+stack.peek());
            }
        }
        System.out.println("最后"+stack.peek());
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        int len =s.length();
        Deque<Character> stack = new LinkedList<>();
        for (int i=0;i<len;++i){
            char ch=s.charAt(i);
            if (stack.isEmpty()){
                stack.push(ch);
                System.out.println("栈空了，加元素： "+stack.peek());
                System.out.println("栈： "+stack);
                continue;
            }
            char top=stack.peek();
            if (ch == '}' && top == '{')
            {
                // System.out.println(""+stack);
                stack.pop();
                System.out.println("此时是} 去掉{： "+stack.peek());
                System.out.println("栈： "+stack);
                continue;
            }
            else if (ch == ']' && top == '[')
            {   
                stack.pop();
                System.out.println("此时是] 去掉[： "+stack.peek());
                System.out.println("栈： "+stack);
                continue;
            }
            else if (ch == ')' && top == '(')
            {
                stack.pop();
                System.out.println("此时是) 去掉(： "+stack.peek());
                System.out.println("栈： "+stack);
                continue;
            }
            stack.push(ch);
            System.out.println("增加 push： "+stack.peek());
            System.out.println("栈： "+stack);
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s="{[]}";
        // String s="()[]{}";
       
        System.out.println(isValid2(s));
    }   


    
}
