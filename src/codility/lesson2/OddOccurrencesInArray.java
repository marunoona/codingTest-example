package codility.lesson2;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray oddArray = new OddOccurrencesInArray();
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(oddArray.solution(A));
    }
}
