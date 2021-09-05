// https://programmers.co.kr/learn/courses/30/lessons/76501
// 음양 더하기
package week02;

public class P76501 {

    static int solution(int[] absolutes, boolean[] signs) {

        int answer = 0;

        for (int i=0; i<absolutes.length; i++) {

            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }

        }

//        for (int i=0; i<signs.length; i++) {
//            answer += absolutes[i] * (signs[i]? 1: -1);
//        }

        return answer;
    }

    public static void main(String[] args) {

        int[] absolutes1 = {4, 7, 12};
        int[] absolutes2 = {1, 2, 3};

        boolean[] signs1 = {true, false, true};
        boolean[] signs2 = {false, false, true};

        System.out.println(solution(absolutes1, signs1));
        System.out.println(solution(absolutes2, signs2));
    }

}
