// https://programmers.co.kr/learn/courses/30/lessons/42576
// 완주하지 못한 선수
package week02;

import java.util.HashMap;
import java.util.Map;

public class P42576 {

    static String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        String answer = "";

        for (String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);

        for (String c : completion) map.put(c, map.get(c) - 1);

        for (String key : map.keySet()) {

            if (map.get(key) != 0) {
                answer = key;
                break;
            }

        }

        return answer;
    }

    public static void main(String[] args) {

        String[] p1 = {"leo", "kiki", "eden"};
        String[] p2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] p3 = {"mislav", "stanko", "mislav", "ana"};

        String[] c1 = {"eden", "kiki"};
        String[] c2 = {"josipa", "filipa", "marina", "nikola"};
        String[] c3 = {"stanko", "ana", "mislav"};

//        System.out.println(solution(p1, c1));
//        System.out.println(solution(p2, c2));
        System.out.println(solution(p3, c3));
    }

}
