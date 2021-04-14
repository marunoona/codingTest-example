package programmers.exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreTest {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cntArr = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(s1[i%5] == answers[i]){
                cntArr[0]++;
            }
            if(s2[i%8] == answers[i]){
                cntArr[1]++;
            }
            if(s3[i%10] == answers[i]){
                cntArr[2]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(Math.max(cntArr[0], cntArr[1]), cntArr[2]);
        for(int i=0; i<3; i++) {
            if(cntArr[i] == max) {
                list.add(i+1);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        PreTest preTest = new PreTest();
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(preTest.solution(answers)));
        int[] answers2 = {1,3,2,4,2};
        System.out.println(Arrays.toString(preTest.solution(answers2)));
    }
}
