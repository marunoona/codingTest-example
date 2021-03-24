package programmers;

import java.util.HashSet;

public class FindPrimeNumber2 {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    private void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")){
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++){
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }

    public static void main(String[] args) {
        FindPrimeNumber2 solution = new FindPrimeNumber2();
        String numbers = "17";
        System.out.println(solution.solution(numbers));
    }
}
