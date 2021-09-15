// https://programmers.co.kr/learn/courses/30/lessons/12982
// 예산
package week03;

import java.util.Arrays;

public class P12982 {

    static int solution(int[] d, int budget) {

        int answer = 0;

        Arrays.sort(d);

        for (int i=0; i<d.length; i++) {

            budget -= d[i];

            if (budget < 0) break;

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] d1 = {1, 3, 2, 5, 4};
        int[] d2 = {2, 2, 3, 3};

        int budget1 = 9;
        int budget2 = 10;

        System.out.println(solution(d1, budget1));
        System.out.println(solution(d2, budget2));
    }

}
