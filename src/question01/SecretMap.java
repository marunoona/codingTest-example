package question01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class SecretMap {
    private int number = 0;
    private int[] array1;
    private int[] array2;

    void init() {
        scanNumber();

        makeArray();

        System.out.println(Arrays.toString(printArray()));
    }

    private void scanNumber() {
        System.out.println("정수를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        number = scan.nextInt();
        System.out.println(number);
    }

    private void makeArray() {
        array1 = fillArray();
        array2 = fillArray();
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    private int[] fillArray() {
        int[] array = new int[number];
        Random rand = new Random();
        int max = number;
        int i = 0;
        do {
            int randomNum = rand.nextInt(100);
            String binary = Integer.toBinaryString(randomNum);
            if (binary.length() <= max) {
                array[i] = randomNum;
                i++;
            }
        } while (i != number);
        return array;
    }


    private String[] printArray() {
        String[] result = new String[number];
        for (int i = 0; i < number; i++) {
            result[i] = Integer.toBinaryString(array1[i] | array2[i]);
        }

        for (int i = 0; i < number; i++) {
            result[i] = String.format("%" + number + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
