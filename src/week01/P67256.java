// https://programmers.co.kr/learn/courses/30/lessons/67256
// 키패드 누르기
package week01;

public class P67256 {

    static String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();

        int leftFinger = 10;  // 왼손 위치
        int rightFinger = 12; // 오른손 위치
        int leftDistance;     // 타겟 번호로부터 왼손까지의 거리
        int rightDistance;    // 타겟 번호로부터 오른손까지의 거리

        for (int n : numbers) {

            if (n == 0) n = 11;

            if (n % 3 == 1) { // 1, 4, 7
                sb.append("L");
                leftFinger = n;
            } else if (n % 3 == 0) { // 3, 6, 9
                sb.append("R");
                rightFinger = n;
            } else { // 2, 5, 8, 0

                leftDistance = (Math.abs(n - leftFinger)) / 3 + (Math.abs(n - leftFinger)) % 3;
                rightDistance = (Math.abs(rightFinger - n)) / 3 + (Math.abs(rightFinger - n)) % 3;

                if (leftDistance == rightDistance) { // 양손의 거리가 같을 때

                    if (hand.equals("right")) {
                        sb.append("R");
                        rightFinger = n;
                    } else {
                        sb.append("L");
                        leftFinger = n;
                    }

                } else if (leftDistance > rightDistance) { // 오른손이 더 가까울 때
                    sb.append("R");
                    rightFinger = n;
                } else { // 왼손이 더 가까울 때
                    sb.append("L");
                    leftFinger = n;
                }

            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {

        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        String hand1 = "right";
        String hand2 = "left";
        String hand3 = "right";

        System.out.println(solution(numbers1, hand1));
        System.out.println(solution(numbers2, hand2));
        System.out.println(solution(numbers3, hand3));
    }

}
