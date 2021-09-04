package programmers.P42748;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start=0;
        int end=0;
        int size=0;
        //1.commands 길이만큼 반복
        for(int i=0;i< commands.length;i++){
           start=commands[i][0]-1;
           end=commands[i][1]-1;
           size=end-start+1;
            int[] temp=new int[size];
           //step1.배열 자르기
            System.arraycopy(array,start,temp,0,size);
            //step2.정렬
            Arrays.sort(temp);
            //step3.k번째 수 가져오기
            answer[i]=temp[commands[i][2]-1];
        }

        return answer;
    }
    public static void main(String[] args){
        int[] arr={1, 5, 2, 6, 3, 7, 4};
        int[][] cmd={
                {2, 5, 3},
                {4, 4, 1},
                {1,7,3}
        };
        int[] res=solution(arr,cmd);
        System.out.println(Arrays.toString(res));
    }
}
