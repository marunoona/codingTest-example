package question11;

import java.util.Arrays;

public class Grade {

    public int[] gradingStudents(int[] grades){
        int[] answer = new int[grades.length];
        int nextGrade;
        int finalGrade;
        int i = 0;
        for(Integer grade : grades){
            finalGrade = grade;
            nextGrade = ((grade /5 ) +1) * 5;  //다음 5배수 값
            if(nextGrade < 40){
                answer[i] = finalGrade;
                i++;
                continue;
            }
            if ((nextGrade - grade) < 3) {
                finalGrade = nextGrade;
            }
            answer[i] = finalGrade;
            i++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] grades = {73,67,38,33};
        Grade grade = new Grade();
        System.out.println(Arrays.toString(grade.gradingStudents(grades)));
    }
}
