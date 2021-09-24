package programmers.P42889;

import java.util.*;

public class Solution {

    public static int[] solution(int N, int[] stages) {
        int[] answers=new int[N];
        int flag=0;
        int cur=0;
        double fail=0;
        Map<Integer,Double> record=new HashMap<>();

        //스테이지별 실패율 계산
        for(int i=1; i<=N;i++){
            flag=0;
            cur=0;//현재 분모
            //각 스테이지 숫자와 같으면 분자 카운트
            for(int j=0;j< stages.length;j++){
                if(stages[j]==i){
                    flag++;
                }
                if(stages[j]>=i){
                    //현재 스테이지 도전자
                    cur++;
                }
            }
            //flag==0일때는 그냥 0넣기(NaN, INF등 고려)
            if(flag==0 || cur==0){
                fail=0;
            }else if(flag!=0 && cur!=0){
                fail=(double)flag/(double)cur;
            }
      //      System.out.println("flag: "+flag+", fail: "+fail+",total: "+cur);

            record.put(i,fail);
        }

     //   System.out.println(record);

        //value(double 실패율) 기준으로 정렬시키기
        for(int i=0; i<N;i++){
            double max=-1;
            int maxKey=0;
            for(int j: record.keySet()){
                if(max<record.get(j)){
                    max= record.get(j);
                    maxKey=j;
                }
            }
            answers[i]=maxKey;
            record.remove(maxKey);//실패율에서 제거(최댓값)
        }
        return answers;
    }


    public static void main(String[] args){

        int[] stages1={2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages2={4,4,4,4,4};

        int[] res1=solution(5,stages1);
        int[] res2=solution(4,stages2);
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));


    }
}
