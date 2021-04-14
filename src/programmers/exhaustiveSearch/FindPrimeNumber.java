package programmers.exhaustiveSearch;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {
    public int solution(String numbers) {
        int answer = 0;
        //문자열을 배열에 저장
        char[] charArray = numbers.toCharArray();
        //반복횟수 - 입력값이 "1234"면 1자리수부터 4자리수까지 나올 수 있기에 반복
        int length = charArray.length;
        //순열을 저장할 Set
        Set<Integer> numberSet = new HashSet<>();
        for(int i = 1; i <= length; i++){
            doPerm(charArray, 0, i, numberSet);
        }

        System.out.println(numberSet);
        answer = getPrimeCount(numberSet);
        return answer;
    }

    private void doPerm(char[] arr, int depth, int length, Set<Integer> numberSet){
        if(depth == length){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(arr[i]);
            }

            int number = Integer.parseInt(sb.toString());
            if (number > 1) {
                numberSet.add(number);
            }

            return;
        }

        for(int i = depth; i< arr.length; i++){
            swap(arr, i, depth);
            doPerm(arr, depth+1, length, numberSet);
            swap(arr, i, depth);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int getPrimeCount(Set<Integer> numberSet){
        int result = 0;
        for(int i : numberSet){
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                ++result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindPrimeNumber findPrimeNumber = new FindPrimeNumber();
        String numbers = "17";
        System.out.println(findPrimeNumber.solution(numbers));
    }
}
