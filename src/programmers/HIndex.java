package programmers;

import java.util.Arrays;

public class HIndex {
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    public static int solution2(int[] citations){
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int first = citations[i];
            int second = citations.length-i;
            int min = (int)Math.min(first, second);
            if(max < min) max = min;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
        int[] citations2 = {15,16,17,18,2,4,6};
        System.out.println(solution2(citations2));
        int[] citations3 = {0,1,1,1,1};
        System.out.println(solution(citations3));

    }
}
