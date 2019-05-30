package question02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartsGame {
    void init() {
        System.out.println("점수를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        splitString(input);
    }
    public int splitString(String text) {
        List<String> scoreList = new ArrayList<>();
        Pattern p = Pattern.compile("([0-9]+)([a-zA-Z])([*]|#?)");
        Matcher m = p.matcher(text);
        while (m.find()) {
            scoreList.add(m.group());
        }
        System.out.println(scoreList);
        int result = 0;
        int pow = 0;
        int empty;
        for (int i = 0; i < scoreList.size(); i++) {
            String score = scoreList.get(i);
            int first = Integer.parseInt(score.replaceAll("[^0-9]",""));
            String second = score.replaceAll("[^a-zA-z]", "");
            empty = pow;
            switch (second) {
                case "S":
                    pow = (int) Math.pow(first, 1);
                    break;
                case "D":
                    pow = (int) Math.pow(first, 2);
                    break;
                case "T":
                    pow = (int) Math.pow(first, 3);
                    break;
            }
            if(score.contains("#")) {
                pow *= (-1);
            }
            if (i == 0 && score.contains("*")) {
                pow *= 2;
            }
            if ((i == 1 || i == 2) && score.contains("*")) {
                result -= empty;
                empty *= 2;
                pow *= 2;
                pow += empty;
            }
            result += pow;
        }
        System.out.println(result);
        return result;
    }
}
