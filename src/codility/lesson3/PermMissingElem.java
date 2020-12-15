package codility.lesson3;

import java.util.Arrays;

public class PermMissingElem {
    public int solution(int[] A) {

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i + 1 != A[i])
                return i + 1;
        }
        return A.length + 1;
    }

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        int[] A = {1, 2, 3, 5};
        System.out.println(permMissingElem.solution(A));
    }
}
