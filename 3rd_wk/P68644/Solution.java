package programmers.P68644;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static ArrayList<Integer> solution(int[] numbers) {
        Set<Integer> answer = new HashSet<>();//중복없고 키값없고

        for(int i=0;i< numbers.length-1;i++){
            for(int j=i+1;j< numbers.length;j++){
                answer.add(numbers[i]+numbers[j]);
            }
        }

        //정렬
        ArrayList<Integer> list=new ArrayList<>(answer);
        Collections.sort(list);

        return list;
    }

    public static void main(String[] args){
        int[] arr1={2,1,3,4,1};
        int[] arr2={5,0,2,7};

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }
}
