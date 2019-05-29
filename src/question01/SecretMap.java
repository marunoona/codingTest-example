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

        printArray(operateArray());
    }

    private void scanNumber() {
        System.out.println("정수를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        number = scan.nextInt();
        System.out.println(number);
    }

    private void makeArray(){
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

    private int[] operateArray() {
        int[] opArray = new int[number];
        for (int i = 0; i < number; i++) {
            int opNum = array1[i] | array2[i];
            opArray[i] = opNum;
        }
        return opArray;
    }

    private void printArray(int[] array) {
        String[] result = new String[number];
        int index = 0;
        for (int num : array) {
            String string = String.format("%05d", Integer.parseInt(Integer.toBinaryString(num)));
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '0') {
                    string = string.replace("0", " ");
                } else if (string.charAt(i) == '1') {
                    string = string.replace("1", "#");
                }
            }
            result[index] = string;
            index++;
        }
        System.out.println(Arrays.toString(result));
    }
}
