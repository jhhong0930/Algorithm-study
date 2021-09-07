package programmers.P42747;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] citations) {
        int answer=0;

       Arrays.sort(citations);

        System.out.println("sorted: "+ Arrays.toString(citations));

        for(int i=0;i< citations.length;i++){
            int h= citations.length-i;//최대부터 i를 빼서 점차 접근


            //h이상인 경우(최댓값 마지노선)
            if(citations[i]>=h){
                answer=h;
                break;
            }

        }

        return answer;
    }

    public static void main(String[] args){
        int[] test1={3, 0, 6, 1, 5};
        System.out.println(solution(test1));
    }
}
