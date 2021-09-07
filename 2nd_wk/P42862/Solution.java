package programmers.P42862;

public class Solution {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int lSize=lost.length;
        int rSize= reserve.length;
        int cnt=0;


        //추가케이스1
        //lost길이가 0이면 전체가 다 갖고 있을 수 있음
        if(lSize==0){
            return answer;
        }

        //추가케이스2
        //lSize+rSize==n이면 n반환
        if(n==lSize+rSize){
            return answer;
        }

        //추가케이스3
        //reserve길이가 0이면 n-lSize가 해당될 것
        if(rSize==0){
            return n-lSize;
        }

        //step01.도난당한케이스가 포함될 수 있도록&&더이상 도난당하면 빌려줄 수 없도록
        for(int i=0;i<lSize;i++){
            for(int j=0; j<rSize;j++){
                if(lost[i]==reserve[j]){
                    cnt++;//여벌이 있다가 잃어버리면 1개는 갖고 있으므로
                    lost[i]=-1;
                    reserve[j]=-1;
                    break;
                }
            }
        }

        //step02. reserve+1 -1이 lost이면 reserve를 -1로 만들어서
        //더이상 빌려줄 수 없도록 하고, 빌려준 케이스를 카운트
        for(int i=0; i<lSize;i++){
            for(int j=0; j<rSize;j++){
                if(lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1){
                    cnt++;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        //lost가 모두 여분도 못받았을 경우가 최악의 케이스
        answer=n-lSize+cnt;

       return answer;
    }

    public static void main(String[] args){
        int[] lost1={2, 4};
        int[] lost2={2, 4};
        int[] lost3={3};

        int[] res1={1,3,5};
        int[] res2={3};
        int[] res3={1};

        int ans1=solution(5,lost1,res1);
        int ans2=solution(5,lost2,res2);
        int ans3=solution(3,lost3,res3);

        System.out.println("ans1: "+ans1);
        System.out.println("ans2: "+ans2);
        System.out.println("ans3: "+ans3);
    }
}
