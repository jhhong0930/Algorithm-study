// https://programmers.co.kr/learn/courses/30/lessons/12901
// 2016년
package week04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class P12901 {

    static String solution(int a, int b) {

        Calendar cal = Calendar.getInstance();

        cal.set(2016, a-1, b);

        Date date = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);

        return sdf.format(date).toUpperCase();
    }

    public static void main(String[] args) {

        System.out.println(solution(5, 24));
    }

}
