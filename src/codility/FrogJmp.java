package codility;

public class FrogJmp {
    /**
     *
     * @param X 점프 시작위치
     * @param Y 기준값
     * @param D 점프할 수 있는 거리
     * @return
     */
    public int solution(int X, int Y, int D){
        return (Y-X)/D + ((Y-X)%D == 0 ? 0 : 1);
    }

    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(10,85,30));
    }
}
