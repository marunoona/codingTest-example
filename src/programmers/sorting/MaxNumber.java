package programmers.sorting;

import java.util.Arrays;

public class MaxNumber {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] number = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            number[i] = String.valueOf(numbers[i]);
        }

        // 정렬
		/*Arrays.sort(number, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return ((o2 + o1).compareTo(o1 + o2));
			}
		});*/

        Arrays.sort(number, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
        if (number[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자 하나로 합치기
        for (String a : number) {
            answer.append(a);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(maxNumber.solution(numbers));
    }
}
