package programmers.P42862Re;

import java.util.Arrays;

public class Solution {

    public static int solution(int n, int[] lost, int[] reserve) {
       int answer=0;
       int[] students=new int[n];
      /*
      * 0:체육복없음
      * 1:빌려줄 수 없음. 자기가 입음
      * 2:빌려주고 본인도 입을 수 있음
      * */
        //1.모든 학생들은 원래는 체육복이 기본 1개씩 있었다
        for(int i=0;i<n;i++){
            students[i]=1;
        }

        //2.lost는 다 0로
        for(int i=0; i< lost.length;i++){
            int temp=lost[i];
            students[temp-1]=0;
        }

        //3.reserve는 2로 초기화하자
        //하지만 그 전에 lost기록이 있어서 0이었다면 1로 초기화
        for(int i=0;i<reserve.length;i++){
            int temp=reserve[i];
            if(students[temp-1]==0){
                students[temp-1]=1;
            }else{
                students[temp-1]=2;
            }
        }

//        System.out.println("students: "+ Arrays.toString(students));
        for(int i=0;i<n;i++){
            //01.지금 체육복이 없는 학생인 경우, 전이나 후 학생에게 요청 후,
            //빌려준 학생은 1로 두고 answer++;
            if(students[i]==0){
                if(i>=1 && students[i-1]==2){
                    answer++;
                    students[i-1]=1;
                    students[i]=1;
                }
                if(i< n-1&&students[i+1]==2){
                    answer++;
                    students[i+1]=1;
                    students[i]=1;
                }
            }else if(students[i]==1){
                //본인이 입을 체육복만 있으면 빌려줄 수 없음
                answer++;
            }else if(students[i]==2){
                //이전 혹은 이후의 학생이 0개 이면 빌려주고 본인은 1로,빌린 학생을 1로
                answer++;
                if(i>=1 && students[i-1]==0){
                    students[i]=1;
                    students[i-1]=1;
                }
                if(i<n-1&&students[i+1]==0){

                    students[i]=1;
                    students[i+1]=1;
                }
            }

        }
//        System.out.println("students: "+ Arrays.toString(students));
//        System.out.println("---");
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
        System.out.println("---");
        System.out.println("ans2: "+ans2);
        System.out.println("---");
        System.out.println("ans3: "+ans3);
    }
}
