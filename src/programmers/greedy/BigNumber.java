package programmers.greedy;

import java.util.Stack;

public class BigNumber {

    public String solution(String number, int k) {

        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++){

            char c = number.charAt(i);

            /**
             * 스택이 비어있지 않고
             * 스택에 있는 값이 새로 비교할 다음 값보다 작으면
             * 스택에서 꺼내고
             * 지워야 할 숫자의 갯수를 감소시킨다
             */
            while(!stack.isEmpty() && stack.peek() < c && k > 0){
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        String result = new BigNumber().solution(number, k);
        System.out.println("result = " + result);
    }
}
