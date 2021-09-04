package programmers.P42840;

import java.util.*;

public class Solution {

    public static ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] pattern1={1,2,3,4,5};//i%5
        int[] pattern2={2,1,2,3,2,4,2,5};//i%8
        int[] pattern3={3,3,1,1,2,2,4,4,5,5};//i%10


        int one=0;
        int two=0;
        int three=0;

        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);

        for(int i=0; i<answers.length;i++){

            if(i==0){
                one=two=three=0;
            }else{
                one=i%5;
                two=i%8;
                three=i%10;
            }

            //답과 찍은 것이 같은지 비교
            if(answers[i]==pattern1[one]){
                map.put(1,map.get(1)+1);
            }
            if(answers[i]==pattern2[two]){
                map.put(2,map.get(2)+1);
            }
            if(answers[i]==pattern3[three]){
                map.put(3,map.get(3)+1);
            }

        }

       List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        int max=0;
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int val1=o1.getValue();
                int val2=o2.getValue();
                int diff=val1-val2;

                if(diff<0){
                    return 1;
                }

                return -1;
            }
        });

        max=list.get(0).getValue();
        answer.add(list.get(0).getKey());

        //maximum값이 여러개인지 체크
        for(int i=1;i<3;i++){
            int comp=list.get(i).getValue();

            if(comp==max){
                answer.add(list.get(i).getKey());
            }
        }


        Collections.sort(answer);

        System.out.println(list);
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args){
        int[] answers={1,3,2,4,2};
        System.out.println(solution(answers));
    }
}
