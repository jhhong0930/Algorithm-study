// https://programmers.co.kr/learn/courses/30/lessons/12906
// 같은 숫자는 싫어
package week04;

import java.util.*;

public class P12906 {

    static int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();

        int temp = 10;

        for (int i : arr) {
            if (i != temp) list.add(i);
            temp = i;
        }

        int[] answer = new int[list.size()];

        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }
}
