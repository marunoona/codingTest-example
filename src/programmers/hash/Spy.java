package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;

public class Spy {

    public static int solution2(String[][] clothes){
        int result = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<clothes.length; i++){
            //의상종류, 갯수
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }

        for(String key : map.keySet()){
            result *= (map.get(key) + 1);
        }
        return result-1;
    }

    public static int solution3(String[][] clothes){
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution2(clothes));
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution3(clothes2));
    }
}
