import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int len=s.length();
        if (len%2!=0 || s==null){
            return false;
        }
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()){
                stack.push(ch);
            }else{
                if (ch=='('||ch=='{'||ch=='['){
                    stack.push(ch);
                }else {
                    // 注意 ！！！ 用peek()获取栈顶元素， 不是用getLast()!!!
                    char v=stack.peek();
                    if((ch==')'&& v=='(' )||(ch=='}'&&v=='{')||(ch==']'&&v=='[')){
                   
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    // public boolean isValid(String s) {
    //     int len =s.length();
    //     Deque<Character> stack = new LinkedList<>();
    //     for (int i=0;i<len;++i){
    //         char ch=s.charAt(i);
    //         if (stack.isEmpty()){
    //             stack.push(ch);
    //             continue;
    //         }
    //         char top=stack.peek();
    //         if (ch == '}' && top == '{')
    //         {
    //             stack.pop();
    //             continue;
    //         }
    //         else if (ch == ']' && top == '[')
    //         {   
    //             stack.pop();
    //             continue;
    //         }
    //         else if (ch == ')' && top == '(')
    //         {
    //             stack.pop();
    //             continue;
    //         }

    //         stack.push(ch);
    //     }

    //     return stack.isEmpty();
    // }

}
// @lc code=end

