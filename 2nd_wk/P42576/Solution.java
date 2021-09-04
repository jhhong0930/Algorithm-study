package programmers.P42576;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();

        //participants을 map에 넣기
        for(int i=0; i< participant.length;i++){
            String name=participant[i];
            if(map.containsKey(name)){
                int bef=map.get(name);
                map.put(name,bef+1);
            }else{
                map.put(name,1);
            }
        }

        //completion도  map으로 관리
        for(int i=0;i< completion.length;i++){
            String name=completion[i];
            if(map2.containsKey(name)){
                int temp=map2.get(name);
                map2.put(name,temp+1);
            }else{
                map2.put(name,1);
            }
        }

        //completion에서 동명이인까지 고려해서 처리
        for(int i=0; i< participant.length;i++){
          //case1:키가 없는 경우
            String name=participant[i];
            boolean flag1=map2.containsKey(name);

            if(flag1==false){
                answer=name;
                break;
            }
            //case2:value가 다른 경우==동명이인이 모두 체크되지 않은 경우
            if(flag1==true){
                int key1=map.get(name);
                int key2=map2.get(name);
                if(key1!=key2){
                    answer=name;
                    break;
                }else{
                    answer="";
                }
            }
        }
        

        return answer;
    }
    public static void main(String[] args){
        String[] parti={"leo", "kiki", "eden"};
        String[] compl={"eden", "kiki"};
        String res=solution(parti,compl);
        System.out.println(res);
    }
}
