package codility.lesson7;

import java.util.Stack;

public class Nesting {
    public int solution(String S){
        Stack<Character> stack = new Stack<>();

        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.pop() == c){
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Nesting nesting = new Nesting();
        String S = "(()(())())";
        System.out.println(nesting.solution(S));
        String S2 = "())";
        System.out.println(nesting.solution(S2));
    }
}
