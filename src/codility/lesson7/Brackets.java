package codility.lesson7;

import java.util.Stack;

public class Brackets {
    public int solution(String S){
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            char lastChar = c;
            if(c =='(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return 0;
                }
                lastChar = stack.pop();
            }

            if(c == ')' && lastChar != '(') return 0;
            if(c == '}' && lastChar != '{') return 0;
            if(c==']' && lastChar != '[') return 0;
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        String S = "{[()()]}";
        System.out.println(brackets.solution(S));
    }
}
