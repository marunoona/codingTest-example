package programmers;

public class RecommendId {

    public String solution(String new_id) {
        String answer = "";
        answer = step1(new_id);
        answer = step2(answer);
        answer = step3(answer);
        answer = step4(answer);
        answer = step5(answer);
        answer = step6(answer);
        answer = step7(answer);
        return answer;
    }

    private String step1(String id){
        id = id.toLowerCase();
        return id;
    }

    private String step2(String id){
        String pattern = "[^a-z0-9-_\\.]*";
        return id.replaceAll(pattern, "");
    }

    private String step3(String id){
        String pattern = "[\\.]+";
        return id.replaceAll(pattern, ".");
    }

    private String step4(String id){
        if(id.length() >= 1 && id.charAt(0) == '.'){
            id = id.replaceFirst(".","");
        }

        id = sliceLastString(id);
        return id;
    }

    private String sliceLastString(String id){
        if(id.length() >= 1 && id.charAt(id.length()-1) == '.'){
            id = id.substring(0, id.length()-1);
        }
        return id;
    }

    private String step5(String id){
        if(id.length() == 0){
           id = "a";
        }
        return id;
    }

    private String step6(String id){
        if (id.length() >= 16) {
            id = id.substring(0, 15);
        }

        id = sliceLastString(id);
        return id;
    }

    private String step7(String id){
        if (id.length() <= 2) {
            char ch = id.charAt(id.length() - 1);

            StringBuilder idBuilder = new StringBuilder(id);
            for (; idBuilder.length() != 3;) {
                idBuilder.append(ch);
            }
            id = idBuilder.toString();
        }
        return id;
    }


    public static void main(String[] args) {
        RecommendId recommendId = new RecommendId();
        String new_id =  "=.=";
        System.out.println(recommendId.solution(new_id));
    }
}
