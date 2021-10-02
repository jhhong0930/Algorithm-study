package programmers.P42888;

import java.util.*;

public class Solution {
    public static String[] solution(String[] record) {

        //1.유저아이디의 닉네임 맵으로 관리(해시값 바꾸기)
        Map<String,String> map=new HashMap<>();
        //2.명령어
        Queue<String> cmd=new LinkedList<>();
        //2-1.유저 아이디 리스트->순서
        Queue<String> ord=new LinkedList<>();
        //change 외의 명령어 카운트
        int size=0;
        StringTokenizer st=null;

        //명령어큐와 유저아이디-닉네임 체계 정돈시키기
        for(int i=0;i< record.length;i++){
            st=new StringTokenizer(record[i]," ");
            String t="";
            String uid="";//아이디
            //닉네임
            String n="";
            int j=0;
            while(st.hasMoreTokens()){
                if(j==0){
                    t=st.nextToken();
                }else if(j==1){
                    uid=st.nextToken();
                }else{
                    n=st.nextToken();
                }
                j++;
            }
            if(!t.equals("Change")){
                size++;
            }
            cmd.add(t);//명령어 넣기
            //유저아이디 넣기
            ord.add(uid);
            map.put(uid,n);
        }
     //   System.out.println(cmd);//[Enter, Enter, Leave, Enter, Change]
    //    System.out.println(map);//{uid1234=[Muzi, , Prodo], uid4567=[Prodo, Ryan]}
   //     System.out.println(ord);
        //명령어를 돌면서 명령어가 Change가 아닌 경우에만 String[] 배열을 채울 수 있도록 하기
        //3.결과 출력을 담을 배열
        String[] answer = new String[size];
        for(int i=0;i< record.length;i++){
            String now=cmd.poll();
            String pick="";
            if(now.equals("Change")){
                //change의 경우 user 순서 큐에서도 팝해주어야!
                ord.poll();
               continue;
            }else if(now.equals("Enter")){
                //입장!
                //map에서 유저아이디값으로 큐를 접근해서 peek 값을 가져오기
                String temp=ord.poll();//user id가져온 것
                pick=map.get(temp);//최근 닉네임 가져온것
                answer[i]=pick+"님이 들어왔습니다.";
            }else if(now.equals("Leave")){
                //퇴장!
                //map에서 유저아이디값으로 큐를 접근해서 pop한 값을 가져오기
                String temp=ord.poll();//user id가져온 것
                pick=map.get(temp);//최근 닉네임 가져온것
                answer[i]=pick+"님이 나갔습니다.";
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String[] arr={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] res=solution(arr);
        System.out.println(Arrays.toString(res));
    }
}
