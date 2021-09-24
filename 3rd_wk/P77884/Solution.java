package programmers.P77884;

public class Solution {

    public static int yaksu(int n){
        if(n<=1) return 1;
        if(n<=3) return 2;

        int res=2;//1,자기자신
        int i=2;

        while(i<n-1){
            if(n%i==0){
                res++;
            }
            i++;
        }
        return res;
    }

    public static int solution(int left, int right) {
        int answer = 0;
        int flag=0;

        for(int i=left;i<=right;i++){
            flag=yaksu(i);

            if(flag%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(13,17));
        System.out.println(solution(24,27));
    }
}
