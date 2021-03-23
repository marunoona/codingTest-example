package codility.lesson5;

public class CountDiv {
    public int solution(int A, int B, int K) {
        int result = (B / K) - (A / K);
        if (A % K == 0) {
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        System.out.println(countDiv.solution(6, 11, 2));
    }
}
