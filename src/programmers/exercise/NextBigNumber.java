package programmers.exercise;

public class NextBigNumber {

    public int solution(int n) {
        int answer = 0;
        //n의 2진수 1의 개수
        int bitCount = Integer.bitCount(n);

        while(true){
            n++;
            if(bitCount == Integer.bitCount(n)){
                return n;
            }
        }
    }

    public static void main(String[] args) {
        NextBigNumber number = new NextBigNumber();
        int result1 = number.solution(78);
        System.out.println("result = " + result1);

        int result2 = number.solution(15);
        System.out.println("result = " + result2);
    }
}
