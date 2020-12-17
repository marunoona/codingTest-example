package codility.lesson6;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        Arrays.sort(A);
        if (3 > A.length) return 0;

        for (int i = 0; i < A.length-2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(triangle.solution(A));
    }
}
