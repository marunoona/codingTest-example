package codility.lesson7;

import java.util.Stack;

public class Fish {
    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int lastFishSize;
        int aliveCount = 0;
        for (int i = 0; i < A.length; i++) {
          if(B[i] == 1){
              stack.push(A[i]);
          }else{
              while(!stack.isEmpty()){
                  lastFishSize = stack.peek();
                  if(lastFishSize > A[i]){
                      break;
                  }else{
                      stack.pop();
                  }
              }
              if(stack.isEmpty()){
                  aliveCount++;
              }
          }
        }
        return aliveCount + stack.size();
    }

    public static void main(String[] args) {
        Fish fish =new Fish();
        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};
        System.out.println(fish.solution(A,B));
    }
}
