package programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        //1. 우선순위 큐 오름차순으로 선언
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        //2. 우선순위 큐 내림차순으로 선언
        PriorityQueue<Integer> maxPQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] split = operation.split(" ");
            switch (split[0]){
                case "I":
                    minQueue.offer(Integer.valueOf(split[1]));
                    maxPQueue.offer(Integer.valueOf(split[1]));
                    break;
                case "D":
                    if(split[1].equals("1")){
                        if(maxPQueue.isEmpty()){
                            continue;
                        }
                        //최대값 삭제
                        Integer max = maxPQueue.poll();
                        minQueue.remove(max);
                    }else{
                        if(minQueue.isEmpty()){
                            continue;
                        }
                        //최소값 삭제
                        Integer min = minQueue.poll();
                        maxPQueue.remove(min);
                    }
                    break;
            }

        }
        // 값이 있을 경우 최대값과 최소값 반환
        if(!minQueue.isEmpty()){
            answer[0] = maxPQueue.peek(); // 최대값
            answer[1] = minQueue.peek(); // 최소값
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};
        int[] result = new DoublePriorityQueue().solution(operations);
        System.out.println("result = " + Arrays.toString(result));
    }

}
