package codeTestQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PriceIndex {

    private int solutionUseLoop(List<Integer> priceList, int price){
        int result = 0;

        for(int i = 0; i < priceList.size(); i++){
            if(priceList.get(i) == price){
                result = i;
                break;
            }
        }

        return result;
    }
    private int solutionUseStream(List<Integer> priceList, int price) {

        int result;

        if (priceList == null || priceList.size() == 0) {
            return -1;
        }

        result = IntStream.range(0, priceList.size())
                .filter(i -> price == priceList.get(i))
                .findFirst().orElse(-1);

        return result;
    }

    public static void main(String[] args) {
        PriceIndex priceIndex = new PriceIndex();
        List<Integer> priceList = new ArrayList<>();
        for(int i = 0 ; i <10000; i++){
            priceList.add(i);
        }

        int price =  (int) (Math.random() * 10000) + 1;
        long startStream = System.currentTimeMillis();
        System.out.println(priceIndex.solutionUseStream(priceList, price));
        long endStream = System.currentTimeMillis();
        System.out.println("Stream 실행 시간 : " + (endStream - startStream)/1000.0);

        long startLoop = System.currentTimeMillis();
        System.out.println(priceIndex.solutionUseLoop(priceList, price));
        long endLoop = System.currentTimeMillis();
        System.out.println("Loop 실행 시간 : " + (endLoop - startLoop)/1000.0);
    }
}
