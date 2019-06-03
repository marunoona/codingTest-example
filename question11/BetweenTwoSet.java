package question11;

public class BetweenTwoSet {

    /**
     * 최대 공약수
     * @param m
     * @param n
     * @return
     */
    private int getGCD(int m, int n) {
        if (n == 0)
            return m;
        else
            return getGCD(n, m % n);
    }

    private int getGCDByArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = getGCD(result, arr[i]);
        }
        return result;
    }

    /**
     * 최소 공배수
     * @param m
     * @param n
     * @return
     */
    private int getLCM(int m, int n) {
        return m * n / getGCD(m, n);
    }

    private int getLCMByArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = getLCM(result, arr[i]);
        }
        return result;
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        int lcm = getLCMByArray(a);
        int gcd = getGCDByArray(b);

        int j = 2;
        for (int i = lcm; i <= gcd; j++) {
            if (gcd % i == 0) {
                answer++;
            }
            i = lcm * j;
        }
        return answer;
    }

    public static void main(String[] args) {
        BetweenTwoSet betweenTwoSet = new BetweenTwoSet();
        int[] a = {2, 4};
        int[] b = {16, 32, 96};
        System.out.println(betweenTwoSet.solution(a, b));
    }
}
