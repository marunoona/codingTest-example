package question03;

import java.util.*;

public class ChatMain {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234"
                , "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        ChatMain chatMain = new ChatMain();
        System.out.println(Arrays.toString(chatMain.mappingArray(record)));
    }

    private String[] mappingArray(String[] record) {
        Map<String, String> nickNames = new HashMap<>();
        List<String[]> tempList = new LinkedList<>();
        for (String string : record) {
            String[] split = string.split(" ");
            if (split[0].equals("Enter")) {
                nickNames.put(split[1], split[2]);
                tempList.add(split);
            } else if (split[0].equals("Change")) {
                nickNames.put(split[1], split[2]);
            } else {
                tempList.add(split);
            }
        }

        String[] resultList = new String[tempList.size()];
        int i = 0 ;
        for (String[] word : tempList) {
            String nickname = nickNames.get(word[1]);
            if(word[0].equals("Enter")){
                resultList[i] = nickname+"님이 들어왔습니다.";
            }else{
                resultList[i] = nickname+"님이 나갔습니다.";
            }
            i++;
        }
        return resultList;
    }
}
