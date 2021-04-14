package programmers.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

    public static boolean solution(String[] phone_book) {

        boolean result = true;


        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(phone_book));

        for(String phone : phone_book){
            for(int i = 0; i < phone.length(); i++){
                if(set.contains(phone.substring(0,i))){
                    result = false;
                    return result;
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }


}
