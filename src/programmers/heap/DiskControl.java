package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskControl {

    public int solution(int[][] jobs) {
        // 요청시점 순 오름차순 정렬
        Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));
        // 작업시간 순 오름차순 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));


        int sum = 0; // 모든 작업의 소요 합계 시간
        int count = 0;// 처리된 디스크 개수
        int now = 0;// 현재까지 작업이 끝난시간

        int i = 0;
        // 모든 작업이 끝날때까지 while문 반복
        while (count < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= now) {
                queue.add(jobs[i++]);
            }

            if(queue.isEmpty()){
                now = jobs[i][0];
            }else{
                int[] tmp = queue.poll();
                sum += tmp[1] + now - tmp[0];
                now += tmp[1];
                count++;
            }
        }

        return sum/ jobs.length;
    }

    public static void main(String[] args) {

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int result = new DiskControl().solution(jobs);
        System.out.println("result = " + result);

    }
}
