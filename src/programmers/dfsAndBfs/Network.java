package programmers.dfsAndBfs;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];   //n 갯수만큼 boolean 배열을 만듬

        for(int i = 0; i < n; i++){
            if(!check[i]){
                dfs(computers, i, check);
                answer++;
            }
        }

        return answer;
    }

    private boolean[] dfs(int[][] computers, int i, boolean[] check){
        check[i] = true;

        for(int j = 0; j < computers.length; j++){
            /**본인 인덱스가 아니고 (i != j)
             * 해당 네트워크에 연결된 네트워크 중에서 (computers[i][j] == 1)
             * 아직 확인이 안된 네트워크 일 경우 (check[j] == false)
             * dfs 함수 실행 */
            if(i != j && computers[i][j] == 1 && check[j] == false){
                check = dfs(computers, j, check);
            }
        }
        return check;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Network network = new Network();
        System.out.println(network.solution(n, computers));

        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(network.solution(n2, computers2));
    }
}
