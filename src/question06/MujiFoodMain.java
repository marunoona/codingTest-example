package question06;

public class MujiFoodMain {
    public static void main(String[] args) {
        MujiFood mujiFood = new MujiFood();
        int[] foods_times = new int[]{3,1,2};
        int k = 5;
        System.out.println(mujiFood.solution(foods_times, k));
    }
}
