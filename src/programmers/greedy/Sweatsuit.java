package programmers.greedy;

public class Sweatsuit {

    public int solution1(int n, int[] lost, int[] reserve) {
        int count = 0;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                //여벌이 있는 학생이 도난 당한 경우를 체크함
                if (lost[i] == reserve[j]) {
                    lost[i] = reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }

        for (int l : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (l == reserve[i] - 1 || l == reserve[i] + 1) {
                    reserve[i] = -1;
                    count++;
                    break;
                }
            }
        }

        return n - lost.length + count;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = n;

        //1. 전체 학생 수를 만큼의 플래그 값을 담을 수 있는 배열을 선언
        int[] people = new int[n];

        /**
         * 2. 체육복 소지 유무의 플래그 값을 0/1/-1로 구분지어 플래그값을 설정하여 선언
         * 0 : 본인의 체육복만 가지고 있음
         * 1 : 여벌의 체육복을 가지고 있음
         * -1 : 체육복 도난당함
         *
         */

        for (int l : lost)
            people[l - 1]--;

        for (int r : reserve)
            people[r - 1]++;

        for (int i = 0; i < people.length; i++) {
            // 3. 도난당한 학생 기준으로 체육복을 배분하고 플래그 값을 변경해줌
            if (people[i] == -1) {
                if (i - 1 >= 0 && people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                } else if (i + 1 < people.length && people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                } else
                    answer--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {3};

        int result1 = new Sweatsuit().solution1(n, lost1, reserve1);
        System.out.println("result = " + result1);

        int[] lost2 = {2, 4};
        int[] reserve2 = {1,3,5};

        int result2 = new Sweatsuit().solution2(n, lost2, reserve2);
        System.out.println("result2 = " + result2);
    }
}
