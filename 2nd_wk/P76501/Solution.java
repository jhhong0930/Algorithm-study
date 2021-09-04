package programmers.P76501;

public class Solution {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int now=0;

        for(int i=0; i < absolutes.length; i++){
            now=absolutes[i];
            //양음
            if(signs[i]==true){
                answer+=now;
            }else{
                answer-=now;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[] absolutes={4,7,12};
        boolean[] signs={true,false,true};

        int ans=solution(absolutes,signs);
        System.out.println(ans);

    }
}
