package programmers.greedy;

import java.util.Arrays;

public class Lifeboat {

    public int solution(int[] people, int limit) {
        int answer = 0;

        //몸무게 오름차순 정렬
        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit){
                min++;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int result = new Lifeboat().solution(people, limit);
        System.out.println("result = " + result);
    }
}
