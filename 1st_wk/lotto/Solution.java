package programmers.lotto;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeros=0;//0의 갯수 in lottos
        int eqCnt=0;//0갯수 고려 전, 일치하는 갯수 세기
        int min=0; int max=0;//min,max는 가장 못맞췄을 때!
        int[] orders={1,2,3,4,5,6,6};//순위

        //0 갯수 세기 + 일치하는 갯수 세기
        for(int i=0; i <6; i++){
            int stand=lottos[i];
            for(int j=0; j < 6;j++){
                if(win_nums[j]==stand){
                    eqCnt++;
                }
            }
            if(stand==0){
                zeros++;
            }
        }

        min=orders[6-eqCnt];//가정 전의 값
        answer[1]=min;//[0]:최고순위-max,[1]:최저순위-min(추가점수없을때)
        if(zeros==0){
            answer[0]=min;
        }else{
            //0의 갯수가 최대==zeros일때
            max=orders[6-(eqCnt+zeros)];
            answer[0]=max;
        }

        return answer;
    }

    public static void main(String[] args){
        int[] lottos={44,1,0,0,31,25};
        int[] win_nums={31,10,45,1,6,19};

        int[] answer=solution(lottos,win_nums);
        System.out.println(Arrays.toString(answer));
    }
}
