package programmers.heap;

import java.util.PriorityQueue;

public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        int count = 0;

        //1. 우선순위 큐 선언
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //2. 큐에 값 삽입
        for (int num : scoville) {
            priorityQueue.offer(num);
        }

        //3. 큐의 원소가 K보다 작으면 반복
        while(priorityQueue.peek() < K){

            if (priorityQueue.size() == 1) {
                return -1;
            }

            //4. 큐에서 첫번째 원소를 꺼냄
            int first = priorityQueue.poll();
            //5. 큐에서 두번째 원소를 꺼냄
            int second = priorityQueue.poll();

            //6. 첫번째 원소와 두번째 원소를 섞어 계산한 새로운 값을 얻어냄
            int calculatedNumber = calculate(first, second);
            // 7. 새로운 값을 큐에 삽입
            priorityQueue.offer(calculatedNumber);
            count++;

            if (priorityQueue.peek() >= K) {
                break;
            }
        }
        return count;
    }

    private int calculate(int first, int second){
        return first + (second * 2);
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int result = new MoreSpicy().solution(scoville, K);
        System.out.println("result = " + result);
    }
}
