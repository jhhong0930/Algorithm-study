package programmers.P42746;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static String solution(int[] numbers) {
        String answer = "";

        //맨 앞자리 가 큰 순서대로 정렬, 앞자리가 같다면 그 다음 자릿수로 정렬
        String[] temp=new String[numbers.length];

        for(int i=0;i< numbers.length;i++){
            temp[i]=String.valueOf(numbers[i]);
        }

       //합친 결과를 기준으로 비교
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);//(o1+o2).(o2+o1)으로 하면 예시와 맞지 않음
                //게다가 o2+o1이 더크면 앞을 기준으로 바꿔줄 수 있음
            }
        });

        int zeros=0;

        for(int i=0;i<temp.length;i++){
            answer+=temp[i];
            if(temp[i].equals("0")){
                zeros++;
            }
        }

        //원소가 0으로만 구성된 경우
        if(zeros==temp.length){
            return "0";
        }

        return answer;
    }

    public static void main(String[] args){
        int[] arr1={3, 30, 34, 5, 9};
        String ans=solution(arr1);
        System.out.println(ans);
    }

}
