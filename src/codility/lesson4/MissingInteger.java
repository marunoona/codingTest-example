package codility.lesson4;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public int solution(int[] A) {
        //Arrays.sort(A);

        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        int[] A = {1,2,3,6,1,2};
        System.out.println(missingInteger.solution(A));
    }
}
