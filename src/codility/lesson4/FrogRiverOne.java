package codility.lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                set.add(A[i]);
            }
            if (set.size() == X) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        int[] A = {1, 3, 1, 4, 2, 4, 5, 4};
        int X = 5;
        System.out.println(frogRiverOne.solution(X, A));

    }

}
