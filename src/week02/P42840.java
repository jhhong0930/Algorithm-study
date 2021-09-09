// https://programmers.co.kr/learn/courses/30/lessons/42840
// 모의고사
package week02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42840 {

    static int[] solution(int[] answers) {

        int[] p1 = { 1, 2, 3, 4, 5 };
        int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] arr = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (p1[i % p1.length] == answers[i])
                arr[0]++;
            if (p2[i % p2.length] == answers[i])
                arr[1]++;
            if (p3[i % p3.length] == answers[i])
                arr[2]++;
        }

        int max = Math.max(Math.max(arr[0], arr[1]), arr[2]);
        ArrayList<Integer> list = new ArrayList<>();

        if (max == arr[0]) list.add(1);
        if (max == arr[1]) list.add(2);
        if (max == arr[2]) list.add(3);

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answers1)));
        System.out.println(Arrays.toString(solution(answers2)));

    }

}
