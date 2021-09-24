package programmers.P12910;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                answer.add(arr[i]);
            }
        }

        if(answer.isEmpty()){
            answer.add(-1);
            return answer;//바로 종료
        }

        Collections.sort(answer);
        return answer;
    }
    public static void main(String[] args){
        int[] arr1={5, 9, 7, 10};
        int[] arr2={2, 36, 1, 3};
        int[] arr3={3,2,6};

        int d1=5;
        int d2=1;
        int d3=10;

        System.out.println(solution(arr1,d1));
        System.out.println(solution(arr2,d2));
        System.out.println(solution(arr3,d3));
    }
}
