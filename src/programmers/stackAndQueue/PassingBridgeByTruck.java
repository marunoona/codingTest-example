package programmers.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class PassingBridgeByTruck {

    class Truck {
        int weight; //트럭 무게
        int entryTime;  //트럭이 다리에 진입한 시간

        Truck(int weight, int entryTime){
            this.weight = weight;
            this.entryTime = entryTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int totalWeight = 0;
        Queue<Truck> waitingQueue = new LinkedList<>();
        Queue<Truck> bridgeQueue = new LinkedList<>();

        //대기큐에 트럭무게를 넣어준다.
        for(int tw : truck_weights){
            waitingQueue.offer(new Truck(tw,0));
        }

        while (!waitingQueue.isEmpty() || !bridgeQueue.isEmpty()){
            time++;
            if(!bridgeQueue.isEmpty()){
                Truck truck = bridgeQueue.peek();
                if(time - truck.entryTime >= bridge_length){
                    totalWeight -= truck.weight;
                    bridgeQueue.poll();
                }
            }
            if(!waitingQueue.isEmpty()){
                if(totalWeight + waitingQueue.peek().weight <= weight){
                    Truck truck = waitingQueue.poll();
                    totalWeight += truck.weight;
                    bridgeQueue.offer(new Truck(truck.weight, time));
                }
            }
        }
        answer = time;
        return answer;
    }

    public static void main(String[] args) {
        PassingBridgeByTruck question = new PassingBridgeByTruck();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(question.solution(bridge_length, weight, truck_weights));
    }
}
