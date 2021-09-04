package programmers.crain;

import java.util.Stack;

public class Solution {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack=new Stack<>();
        int temp=0;
        int target=0;
        int comp=0;

        stack.push(0);

        for(int i=0; i<moves.length;i++){
            temp=moves[i]-1;

            for(int j=0; j< board.length; j++){
                comp=board[j][temp];

                target=stack.peek();

                if(comp!=0){
                    if(target==comp){
                        stack.pop();
                        answer+=2;
                    }else{
                        stack.push(comp);
                    }
                    board[j][temp]=0;
                    break;
                }



            }

        }

        return answer;
    }

    public static void main(String[] args){
        int[][] board= {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] move={1,5,3,5,1,2,1,4};
        int answer=solution(board,move);
        System.out.println(answer);
    }
}
