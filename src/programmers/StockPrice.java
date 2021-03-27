package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> priceQueue = new LinkedList<>();
        for(int p : prices){
            priceQueue.offer(p);
        }
        int aIdx = 0;
        while(!priceQueue.isEmpty()){
            int time = 0;
            //큐에서 peek한 주식가격과 배열의 주식가격을 비교
            // 이때 배열에서 가져올 가격 인덱스를 주의하여 설정
            for(int i = aIdx + 1; i < prices.length; i++){
                if(priceQueue.peek() <= prices[i]){
                    time++;
                }else{
                    time++;
                    break;
                }
            }
            //비교를 다 했으면 큐에서 꺼낸다.
            priceQueue.poll();
            answer[aIdx] = time;
            aIdx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(stockPrice.solution(prices)));
    }
}
