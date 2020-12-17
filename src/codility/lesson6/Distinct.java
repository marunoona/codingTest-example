package codility.lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public int solution(int[] A){
        Set<Integer> nums = new HashSet<>();
        for (int a : A) {
            nums.add(a);
        }
        return nums.size();
    }

    public static void main(String[] args) {
        Distinct distinct = new Distinct();
        int[] A = {-1,2,1,1,3,4,5,4,6,7};
        System.out.println(distinct.solution(A));
    }
}
