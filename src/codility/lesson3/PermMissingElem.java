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

    public int solution2(int[] A) {
        long lastNum = A.length + 1;
        long sum = 0;
        for (int n : A) {
            sum += n;
        }
        return (int)((1 + lastNum) * lastNum / 2 - sum);
    }


    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        int[] A = {1, 2, 3, 5};

        long startStream = System.currentTimeMillis();
        System.out.println(permMissingElem.solution(A));
        long endStream = System.currentTimeMillis();
        System.out.println("1 실행 시간 : " + (endStream - startStream)/1000.0);

        long startLoop = System.currentTimeMillis();
        System.out.println(permMissingElem.solution2(A));
        long endLoop = System.currentTimeMillis();
        System.out.println("2 실행 시간 : " + (endLoop - startLoop)/1000.0);

    }
}
