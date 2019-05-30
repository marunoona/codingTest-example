package question06;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class MujiFood {
    class Food{
        int time;
        int idx;
        Food(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
    }

    private Comparator<Food> CompTime = new Comparator<Food>(){
        public int compare(Food a, Food b){
            //음식을 먹는데 소요되는 시간을 기준으로 오름차순
            return a.time - b.time;
        }
    };

    private Comparator<Food> CompIdx = new Comparator<Food>(){
        public int compare(Food a, Food b){
            //음식의 번호를 기준으로 오름차순
            return a.idx - b.idx;
        }
    };

    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<>();
        int n = food_times.length;
        //파라미터로 들어온 food_times와 음식의 번호를 linkedList에 저장
        for(int i = 0; i < n; i ++){
            foods.add(new Food(food_times[i], i+1));
        }
        //음식을 다 먹는 순서가 짧은 순으로 오름차순 정렬
        foods.sort(CompTime);
        //시간 계산
        int pretime = 0;
        int i = 0;
        for(Food f : foods){
            long diff = f.time - pretime;
            if(diff != 0){
                long spend = diff * n;
                if(spend <= k){
                    k -= spend;
                    pretime = f.time;
                }else{ //음식을 먹는데에 소비되는 시간이 남은 시간보다 클 경우
                    //남은 음식의 수로 남은 시간을 나눈 나머지를 구함
                    k %= n;
                    //원래 음식의 순서대로 정렬을 한다
                    foods.subList(i,food_times.length).sort(CompIdx);
                    //앞서 구한 나머지를 더한 음식의 번호를 가져온다.
                    return foods.get(i+(int)k).idx;
                }
            }
            i++;
            --n;
        }
        return -1;
    }
}

