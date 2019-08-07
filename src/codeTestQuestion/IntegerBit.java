package codeTestQuestion;

public class IntegerBit {

    private int solutionUseSift(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        IntegerBit integerBit = new IntegerBit();
        int randomValue = (int) (Math.random() * 100) + 1;
        System.out.println(randomValue + "의 비트 수: " +
                integerBit.solutionUseSift(randomValue));
    }
}
