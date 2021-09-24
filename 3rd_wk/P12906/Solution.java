package programmers.P12906;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {



    public static ArrayList<Integer> solution(int []arr) {

        Queue<Integer> queue=new LinkedList<>();
        //스택에 하나씩 넣기
        for(int i=0;i<arr.length;i++){
            queue.add(arr[i]);
        }
        ArrayList<Integer> list=new ArrayList<>();
        //처음 들어갔던 것은 일단 빼서 넣기
        int start=queue.poll();
        list.add(start);

        //그 다음부터는 하나씩 빼면서 시작인덱스의 값과 같은지 비교해서
        //같으면 그냥 pop, 아니라면 기록
        while(!queue.isEmpty()){
            int temp=queue.poll();

            if(temp!=start){
                //기록
                list.add(temp);
                //시작값도 바뀔 것
                start=temp;
            }
        }

    //    System.out.println("list: "+list);
        return list;
    }

    public static void main(String[] args){
        int[] arr=new int[]{1,1,3,3,0,1,1};
        int[] arr2=new int[]{4,4,4,3,3};
        System.out.println(solution(arr));
        System.out.println(solution(arr2));
    }
}
