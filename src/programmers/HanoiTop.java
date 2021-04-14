package programmers;

import java.util.ArrayList;
import java.util.Arrays;


public class HanoiTop {

    ArrayList<int[]> seq;

    public int[][] solution(int n) {
        seq = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[seq.size()][2];
        for(int i = 0 ; i < seq.size() ; ++i){
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }

        return answer;
    }

    private void hanoi(int n, int from, int to, int via){
        int[] move = {from, to};

        if(n == 1) {
            seq.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            seq.add(move);
            hanoi(n - 1, via, to, from);
        }
    }

    public static void main(String[] args) {
        HanoiTop hanoiTop = new HanoiTop();
        int n = 2;
        int[][] result = hanoiTop.solution(n);
        for(int[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
        //System.out.println(Arrays.toString(hanoiTop.solution(n)));
    }
}
