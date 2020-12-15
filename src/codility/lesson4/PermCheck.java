package codility.lesson4;

import java.util.Arrays;

public class PermCheck {
    public int solution(int[] A) {

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i + 1 != A[i])
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();
        int[] A = {4,3,2,1};
        System.out.println(permCheck.solution(A));
    }
}
