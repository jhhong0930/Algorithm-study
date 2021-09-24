// https://programmers.co.kr/learn/courses/30/lessons/12915
// 문자열 내 마음대로 정렬하기
package week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P12915 {

    static String[] solution(String[] strings, int n) {

        String[] answer = {};
        List<String> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(list);

        answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] strings1 = {"sun", "bed", "car"};
        String[] strings2 = {"abce", "abcd", "cdx"};

        int n1 = 1;
        int n2 = 2;

        System.out.println(Arrays.toString(solution(strings1, n1)));
        System.out.println(Arrays.toString(solution(strings2, n2)));
    }

}
