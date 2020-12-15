package codility.lesson1;

public class BinaryGap {
    public int solution(int N) {
        String string = Integer.toBinaryString(N);
        int strLength = string.length();
        int result = 0;
        int cnt = 0;

        for (int i = 1; i < strLength; i++) {
            if (string.charAt(i) == '0') {
                cnt++;
            } else {
                if ((strLength / 2) <= cnt) {
                    result = cnt;
                    break;
                }
                result = (result > cnt) ? result : cnt;
                cnt = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(9));
    }
}
