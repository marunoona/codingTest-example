package codility;

public class TapeEquilibrium {
    public int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        int total = 0;
        int before = 0, after = 0;

        //1. 배열 원소 총합
        for (int a : A) {
            total += a;
        }

        //2. 작은거 구하기
        for(int i = 1; i < A.length; i++){
            before += A[i-1];
            after =total - before;
            min = Math.min(min, Math.abs(before - after));
        }
        return min;
    }

    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int[] A = {3,1,2,7,3};
        System.out.println(tapeEquilibrium.solution(A));
    }
}
