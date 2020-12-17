package codility.lesson6;

import java.util.Arrays;

public class NumberOfDiscIntersections {
    public int solution(int[] A){
        int result = 0;
        int N = A.length;
        long[] lower = new long[N];
        long[] upper = new long[N];

        for(int i = 0; i< N; i++){
            lower[i] = i - (long)A[i];
            upper[i] = i + (long)A[i];
        }
        Arrays.sort(upper);
        Arrays.sort(lower);
        //System.out.println(Arrays.toString(lower));
        //System.out.println(Arrays.toString(upper));

        int intersectionCount = 0;
        int currentUpper = 0;

        for(long lowerValue : lower){
            while(lowerValue > upper[currentUpper]){
                intersectionCount--;
                currentUpper++;
            }
            result += intersectionCount;
            intersectionCount++;
            if(result > 10000000){
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfDiscIntersections test = new NumberOfDiscIntersections();
        int[] A = {1,5,2,1,4,0};
        System.out.println(test.solution(A));
    }
}
