package question09;

public class Block {
    private int N;
    private int[][] Board;

    private boolean canFill(int row, int col){
        for(int i = 0; i < row; ++i){
            if(Board[i][col] != 0) return false;
        }
        return true;
    }

    private boolean find(int row, int col, int h, int w){
        int emptyCnt = 0;   //빈공간
        int lastValue = -1; //빈공간을 제외한 다른 블럭은 같은 값
        for(int r = row; r < row+h; ++r){
            for(int c = col; c < col+w; ++c){
                if(Board[r][c] == 0){   //빈공간일 때
                    if(!canFill(r,c))   //채울 수 있는 빈공간인지 확인
                        return false;
                    if(++emptyCnt > 2)
                        return false;
                }else{
                    if(lastValue != -1 && lastValue != Board[r][c])
                        return false;
                    lastValue = Board[r][c];
                }
            }
        }
        for(int r = row; r < row+h; ++r){
            for(int c = col; c < col+w; ++c){
                Board[r][c] = 0;
            }
        }
        return true;
    }

    public int solution(int[][] board) {
        Board = board;
        N = board.length;
        int answer = 0;
        int cnt; //지울 수 있는 블럭 수
        do{
            cnt = 0;
            for(int i = 0; i < N; ++i){
                for(int j = 0; j < N; ++j){
                    if(i<=N-2 && j<=N-3 && find(i, j, 2, 3)){
                        ++cnt;
                    }else if(i<=N-3 && j<=N-2 && find(i, j, 3, 2)){
                        ++cnt;
                    }
                }
            }
            answer += cnt;
        }while(cnt != 0);
        return answer;
    }
}
