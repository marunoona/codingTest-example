package codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);
        int lastIndex = A.length - 1;
        int firstCase = A[lastIndex] * A[lastIndex - 1] * A[lastIndex - 2];  //양*양*양
        int secondCase = A[lastIndex] * A[0] * A[1]; //양*음*음

        return firstCase > secondCase ? firstCase : secondCase;
    }

    public static void main(String[] args) {
        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
        int[] A = {-3, 1, 2, -2, 5, 6};
        System.out.println(maxProductOfThree.solution(A));
    }
}
