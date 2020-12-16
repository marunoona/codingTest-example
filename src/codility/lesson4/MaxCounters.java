package codility.lesson4;

import java.util.Arrays;

public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int currentMaxCount = 0;
        int lastMaxCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                /**
                 * A 배열의 값이 주어진 N +1 과 같으면 카운터배열의 모든 값을
                 * 카운터값 만큼 증가하기 위해 저장하는 부분
                 */
                lastMaxCount = currentMaxCount;
            }else{
                int counter = A[i] -1;
                if(counters[counter] < lastMaxCount){
                    counters[counter] = lastMaxCount + 1;
                }else{
                    // 카운터배열의 값 1 증가
                    counters[counter]++;
                }

                if(counters[counter] > currentMaxCount){
                    currentMaxCount = counters[counter];
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(counters[i] < lastMaxCount){
                counters[i] = lastMaxCount;
            }
        }
        return counters;
    }

    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
        int[] A = {3,4,4,6,1,4,4};
        int N = 5;
        System.out.println(Arrays.toString(maxCounters.solution(N, A)));
    }
}
