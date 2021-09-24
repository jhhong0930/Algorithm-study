package programmers.P12982;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum=0;

        //정렬(오름차순)
        Arrays.sort(d);

        //누적합 진행하고, 초과하는 경우에만 그 케이스 저장 후 탈출
        for(int i=0 ; i< d.length;i++){
            sum+=d[i];
            if(sum>budget){
                answer=i;//해당 케이스를 저장 후 종료<-그 이전 케이스까지 담겨져 있을 것이므로
                break;
            }
        }
        //누적합<=예산 이면 최대
        if(sum<=budget){
            answer=d.length;
        }

        return answer;
    }

    public static void main(String[] args){
        int[] d1={1,3,2,5,4};
        int[] d2={2,2,3,3};

        System.out.println(solution(d1,9));
        System.out.println(solution(d2,10));
    }

}
