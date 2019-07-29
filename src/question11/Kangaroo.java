package question11;

public class Kangaroo {
    public String solution(int x1, int v1, int x2, int v2) {
        if (x2 > x1 && v2 > v1) {
            return "NO";
        } else {
            while (x2 > x1) {
                x2 = x2 + v2;
                x1 = x1 + v1;

                if (x1 == x2) {
                    return "YES";
                }
                if (x1 > x2) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Kangaroo kangaroo = new Kangaroo();
        System.out.println(kangaroo.solution(14, 4, 98, 2));
    }
}
