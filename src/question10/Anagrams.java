package question10;

import java.util.Arrays;
import java.util.LinkedList;

public class Anagrams {

     private int isAnagrams(String s, int i, int j, int length) {
        String s1 = s.substring(i, i+length);
        String s2 = s.substring(j, j+length);

        if (s1.length() != s2.length()) return 0;

        char[] char1 = s1.toLowerCase().toCharArray();
        char[] char2 = s2.toLowerCase().toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        s1 = new String(char1);
        s2 = new String(char2);
        if(s1.equals(s2)){
            return 1;
        }
        return 0;
    }

    public int solution(String word) {
        int answer = 0;
        int n = word.length();
        int length = 0;
        while(++length < n){
            int numSubStr = n - length + 1;
            for(int i = 0; i < numSubStr-1; i++){
                for(int j = i + 1; j < numSubStr; j++){
                    answer += isAnagrams(word, i, j, length);
                }
            }
        }
        return answer;
    }
}
