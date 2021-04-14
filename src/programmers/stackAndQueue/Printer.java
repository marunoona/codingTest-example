package programmers.stackAndQueue;

import java.util.*;

public class Printer {

    public int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities){
            priorityQueue.offer(priority);
        }

        while(!priorityQueue.isEmpty()){
            for(int i = 0; i <priorities.length; i++){
                int priority = priorities[i];
                int peekNum = priorityQueue.peek();
                if(priority == peekNum){
                    if(location == i){
                        return answer;
                    }
                    answer++;
                    priorityQueue.poll();
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(printer.solution(priorities,location));

        int[] priorities2 = {2, 1, 3, 2};
        int location2 = 2;
        System.out.println(printer.solution(priorities2,location2));
    }
}
