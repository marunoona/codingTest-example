package question04;

import java.util.*;

public class FailRateMain {
    class Fail{
        int stage;
        double rate;
        //Constructor
        Fail(int stage, double rate){
            this.stage = stage;
            this.rate = rate;
        }
    }
    private Comparator<Fail> comp = (a, b) -> {
        if(a.rate < b.rate){
            return 1;
        }else if(a.rate > b.rate){
            return -1;
        }else{
            return Integer.compare(a.stage, b.stage);
        }
    };

    private int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Fail> fails = new ArrayList<>();
        int total = stages.length;

        int[] users = new int[N+1];
        for(int s : stages){
            users[s-1]++;
        }

        for(int i = 0; i <N; i ++){
            if(users[i] == 0){
                fails.add(new Fail(i+1, 0));
            }else{
                fails.add(new Fail(i+1, (double)users[i]/total));
                total -= users[i];
            }
        }

        Collections.sort(fails, comp);
        for(int i = 0; i <N; i ++){
            answer[i] = fails.get(i).stage;
        }
        return answer;
    }

    public static void main(String[] args) {
        FailRateMain failRate = new FailRateMain();
        int n = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(failRate.solution(n, stages)));
    }
}
