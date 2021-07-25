package programmers.dfsAndBfs;

public class TargetNumber {
    private int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(0,0,target, numbers);

        return count;
    }

    private void dfs(int x, int index, int target, int[] numbers){
        if(index == numbers.length){
            if(x == target){
                count++;
            }
            return;
        }

        dfs(x + numbers[index], index + 1, target, numbers);
        dfs(x - numbers[index], index + 1, target, numbers);

    }

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(targetNumber.solution(numbers, target));
    }
}
