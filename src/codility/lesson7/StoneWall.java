package codility.lesson7;

import java.util.Stack;

public class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i : H) {
            while (!stack.empty() && i < stack.peek()) {
                stack.pop();
            }
            if (stack.empty() || i > stack.peek()) {
                stack.push(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        StoneWall stoneWall = new StoneWall();
        int[] H = {8,8,5,7,9,8,7,4,8};
        System.out.println(stoneWall.solution(H));
    }
}
