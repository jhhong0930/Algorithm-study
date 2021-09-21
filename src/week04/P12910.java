// https://programmers.co.kr/learn/courses/30/lessons/12910
// 나누어 떨어지는 숫자 배열
package week04;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P12910 {

    static int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (i % divisor == 0) list.add(i);
        }

        if (list.isEmpty()) list.add(-1);

        Collections.sort(list);

        int[] answer = new int[list.size()];

        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

//        return Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
    }

    public static void main(String[] args) {

        int[] arr1 = {5, 9, 7, 10};
        int[] arr2 = {2, 36, 1, 3};
        int[] arr3 = {3, 2, 6};

        int divisor1 = 5;
        int divisor2 = 1;
        int divisor3 = 10;

        System.out.println(Arrays.toString(solution(arr1, divisor1)));
        System.out.println(Arrays.toString(solution(arr2, divisor2)));
        System.out.println(Arrays.toString(solution(arr3, divisor3)));
    }

}
