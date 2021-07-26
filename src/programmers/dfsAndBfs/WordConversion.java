package programmers.dfsAndBfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WordConversion {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] isVisited = new boolean[words.length]; // 노드방문기록

        //1. word에 target 단어가 없으면 0 리턴
        if(!Arrays.stream(words).anyMatch(target::equals)){
            return 0;
        }

        //bfs 탐색으로 접근하기 위해 큐 선언
        Queue<Word> queue = new LinkedList<>();
        //큐의 루트 노드에 begin 단어를 넣어준다
        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word currentWord = queue.poll();
            if(currentWord.word.equals(target)){
                answer = currentWord.cnt;
                break;
            }
            for(int i = 0; i < words.length; i++){
                /**
                 * 아직 방문하지 않은 노드이며 변환 가능한 단어일 경우
                 * 방문 플래그를 true로 변경하고 큐에 단어를 넣어준다.
                 */
                if(!isVisited[i] && isConvert(currentWord.word, words[i])){
                    isVisited[i] = true;
                    queue.offer(new Word(words[i], currentWord.cnt + 1));
                }
            }
        }

        return answer;
    }

    // 현재단어에서 단어 변경 하나만 할 수 있는 경우만 변환 가능
    private boolean isConvert(String word, String convertWord) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != convertWord.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }


    static class Word {
        String word; // 단어
        int cnt; // 변경한 횟수

        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = new WordConversion().solution(begin, target, words);
        System.out.println("result = " + result);
    }
}
