package question05;

import java.util.*;

public class CandidatesMain {
    private Comparator<Integer> comp = new Comparator<Integer>() {
        int countBits(int n) {
            int ret = 0;
            while (n != 0) {
                if ((n & 1) != 0)
                    ++ret;
                n = n >> 1;
            }
            return ret;
        }

        public int compare(Integer a, Integer b) {
            int x = countBits(a), y = countBits(b);
            return Integer.compare(x, y);
        }
    };

    private boolean check(String[][] relation, int rowsize, int colsize, int subset) {
        //조합 만드는 이중 for문
        for (int a = 0; a < rowsize - 1; ++a) {
            for (int b = a + 1; b < rowsize; ++b) {
                boolean isSame = true;
                for (int k = 0; k < colsize; ++k) {
                    //subset에 속하는 속성만 비교
                    if ((subset & 1 << k) == 0)
                        continue;
                    if (!(relation[a][k].equals(relation[b][k]))) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame)
                    return false;
            }
        }
        return true;
    }

    private int solution(String[][] relation) {
        int answer = 0;
        int rowsize = relation.length;
        int colsize = relation[0].length;
        List<Integer> candidates = new LinkedList<Integer>();

        for (int i = 1; i < 1 << colsize; i++) {
            //유일성 만족하는지 체크
            if (check(relation, rowsize, colsize, i)) {
                candidates.add(i);
            }
        }

        //candidates 정렬
        Collections.sort(candidates, comp);

        //순회하면서 있는거 지움
        while (candidates.size() != 0) {
            int n = candidates.remove(0);
            ++answer;
            candidates.removeIf(c -> (n & c) == n);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] tuples = new String[][]
                {{"100", "ryan", "music", "2"}
                        , {"200", "apeach", "math", "2"}
                        , {"300", "tube", "computer", "3"}
                        , {"400", "con", "computer", "4"}
                        , {"500", "muzi", "music", "3"}
                        , {"600", "apeach", "music", "2"}};
        CandidatesMain candidatesMain = new CandidatesMain();
        System.out.println(candidatesMain.solution(tuples));
    }
}
