// https://programmers.co.kr/learn/courses/30/lessons/64061
// 크레인 인형뽑기 게임
package week01;

import java.util.Stack;

public class P64061 {


    static int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack();

        int answer = 0;

        for (int i=0; i<moves.length; i++) {

            for (int j=0; j< board.length; j++) {

                // 1행부터 순차적으로 접근
                if (board[j][moves[i] - 1] == 0) { // 인형이 없을 떄(0일 때)
                    continue;
                } else { // 인형이 있을 때

                    if (stack.isEmpty()) { // EmptyStackException 방지
                        stack.push(board[j][moves[i] - 1]);
                    } else {

                        // 담겨있는 번호와 넣으려는 번호가 일치하면
                        if (stack.peek() == board[j][moves[i] - 1]) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[j][moves[i] - 1]);
                        }

                    }

                    // 인형이 있던 위치를 0으로 바꾸기
                    board[j][moves[i] - 1] = 0;

                    break;
                }

            }

        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] board1 = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };

        int[] moves1 = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board1, moves1));
    }

}
