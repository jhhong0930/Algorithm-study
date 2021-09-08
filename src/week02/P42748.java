// https://programmers.co.kr/learn/courses/30/lessons/42748
// K번째수
package week02;

import java.util.Arrays;

public class P42748 {

    static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int i=0; i<commands.length; i++) {

            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];

            int[] temp = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(temp);
            answer[i] = temp[target - 1];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));
    }

}
