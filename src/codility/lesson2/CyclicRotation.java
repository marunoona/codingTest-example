package codility.lesson2;

import java.util.Arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[(i + K) % A.length] = A[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        System.out.println(Arrays.toString(cyclicRotation.solution(A, K)));
    }
}
