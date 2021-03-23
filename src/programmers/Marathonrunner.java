package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Marathonrunner {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        //Arrays.sort(participant);
        //Arrays.sort(completion);

        HashMap<String, Integer> map = new HashMap<>();
        for(String runner : participant){
            map.put(runner, map.getOrDefault(runner, 0) + 1);
        }
        for(String runner : completion){
            map.put(runner, map.get(runner)-1);
        }

        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
//        System.out.println(solution(participant, completion));

        String[] participant2 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion2 = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant2, completion2));
    }
}
