package question12;

import java.util.*;

public class Compression {
    public int[] solution(String msg) {
        Map<String, Integer> dicMap = new HashMap<>();
        char c = 'A';
        int n = 1;
        while (dicMap.size() < 26) {
            dicMap.put(String.valueOf(c++), n++);
        }

        List<Integer> resultList = new ArrayList<>();
        while (!msg.isEmpty()) {
            for (int i = msg.length(); i > 0; i--){
                if (dicMap.containsKey(msg.substring(0, i))) {
                    String key = msg.substring(0, i);
                    String nextKey;
                    if (msg.length() > i + 1) {
                        nextKey = msg.substring(i, i + 1);
                    } else {
                        nextKey = "";
                    }
                    resultList.add(dicMap.get(key));
                    if (!nextKey.isEmpty() && !dicMap.containsKey(key + nextKey)) {
                        dicMap.put(key + nextKey, dicMap.size() + 1);
                    }
                    msg = msg.substring(key.length());
                    break;
                }
            }
        }

        int[] answer = new int[resultList.size()];
        int i = 0;
        for(Integer integer:resultList){
            answer[i] = integer;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Compression compression = new Compression();
        System.out.println(Arrays.toString(compression.solution("KAKAO")));
    }
}
