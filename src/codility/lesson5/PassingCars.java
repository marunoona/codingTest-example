package codility.lesson5;

public class PassingCars {
    public int solution(int[] A){
        int sum = 0;
        int result = 0;
        for(int i : A){
            if( i ==0){
                sum ++;
            }else{
                result += sum;
            }
        }
        if(result > 1000000000 || result < 0){
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        PassingCars passingCars = new PassingCars();
        int[] A = {0,1,0,1,1};
        System.out.println(passingCars.solution(A));
    }
}
