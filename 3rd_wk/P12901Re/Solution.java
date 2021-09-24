package programmers.P12901Re;

import java.util.Calendar;
import java.util.Locale;

public class Solution {

    //calendar는 매달-1
//윤년
    static String[] days={"","SUN","MON","TUE","WED","THU","FRI","SAT"};

    public static String solution(int a, int b) {
        String answer = "";
        Calendar cal=Calendar.getInstance();
        cal.set(2016,a-1,b);
        answer=cal.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT_FORMAT, Locale.US).toUpperCase(Locale.ROOT);

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(5,24));
    }

}
