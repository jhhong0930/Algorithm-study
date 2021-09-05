// https://programmers.co.kr/learn/courses/30/lessons/70128
// 내적
package week02;

public class P70128 {

    static int solution(int[] a, int[] b) {

        int answer = 0;

        for (int i=0; i<a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {-1, 0, 1};

        int[] b1 = {-3, -1, 0, 2};
        int[] b2 = {1, 0, -1};

        System.out.println(solution(a1, b1));
        System.out.println(solution(a2, b2));
    }

}
