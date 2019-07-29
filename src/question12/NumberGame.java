package question12;

public class NumberGame {
    private char[] convert(int num, int n) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rest = num % n;
            sb.append(rest >= 10 ? String.valueOf((char) ('A' + (rest - 10))) : rest);
            num /= n;
        }
        return sb.reverse().toString().toCharArray();
    }

    public String solution(int n, int t, int m, int p) {
        char[] arr = new char[t * m];
        arr[0] = '0';
        int num = 1;
        int index = 1;

        while (index < arr.length) {
            char[] converted = convert(num, n);
            for (char c : converted) {
                if (index > arr.length - 1) break;
                arr[index++] = c;
            }
            num++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i % m == (p - 1)) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        System.out.println(numberGame.solution(2, 4, 2, 1));
    }
}
