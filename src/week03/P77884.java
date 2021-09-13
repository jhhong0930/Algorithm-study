// https://programmers.co.kr/learn/courses/30/lessons/77884
// 약수의 개수와 덧셈
package week03;

public class P77884 {

    static int solution(int left, int right) {

        int answer = 0;
        int count;

        for (int i=left; i<=right; i++) {

            count = 0;

            for (int j=1; j<=i; j++) {
                if (i % j == 0) count ++;
            }

            if (count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int left1 = 13;
        int left2 = 24;

        int right1 = 17;
        int right2 = 27;

        System.out.println(solution(left1, right1));
        System.out.println(solution(left2, right2));
    }

}
