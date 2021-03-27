package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Progress {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> workDayQueue = new LinkedList<>();  //남은 작업일 저장하는 큐
        for(int i = 0; i < progresses.length; i++){
            workDayQueue.offer((100-progresses[i])/speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
        }

        ArrayList<Integer> tempLst = new ArrayList<>();
        int previousFunc = workDayQueue.poll();  //이전 작업
        int deployFuncCount = 1;
        while(!workDayQueue.isEmpty()){
            int currentFunc = workDayQueue.poll();   //현재 작업을 꺼낸다
            if(previousFunc >= currentFunc){
                deployFuncCount++;  //배포가능기능수 증가
            }else{
                tempLst.add(deployFuncCount);   //배포가능기능수를 리스트에 담는다.
                deployFuncCount = 1;    //배포가능기능수 초기화
                previousFunc = currentFunc;
            }
        }
        tempLst.add(deployFuncCount);

        int[] answer = new int[tempLst.size()];
        for(int i =0;i<tempLst.size();i++){
            answer[i] = tempLst.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Progress progress = new Progress();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(progress.solution(progresses,speeds)));
    }
}
