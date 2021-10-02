package programmers.P42888Re;

import java.util.*;

public class Solution {
    public static String[] solution(String[] record) {
        /*메시지만 완성시켜준 후 아이디->닉네임으로 변경*/
        ArrayList<String> msg=new ArrayList<>();
        HashMap<String,String> map=new HashMap<>();//아이디,닉네임
        for(int i=0;i< record.length;i++) {
            StringTokenizer st=new StringTokenizer(record[i]," ");
            String cmd="";
            String uid="";
            String nick="";
            int j=0;
            while(st.hasMoreTokens()){
                if(j==0){
                    cmd=st.nextToken();
                }else if(j==1){
                    uid=st.nextToken();
                }else{
                    nick=st.nextToken();
                }
                j++;
            }
            if(cmd.equals("Enter")){
                msg.add(uid+"님이 들어왔습니다.");
                map.put(uid,nick);
            }else if(cmd.equals("Leave")){
                msg.add(uid+"님이 나갔습니다.");
            }else{
                map.put(uid,nick);
            }
        }
      //  System.out.println(map);
        String[] answer= new String[msg.size()];

        for(int i=0;i< msg.size();i++){
            //i번째 메시지에서 "님"을 기준으로 앞의 값을 key-value를 이용해서 바꿔주기
            String now=msg.get(i);//현재 메시지
            int idx=now.indexOf("님");//"님" 인덱스 찾기
            String key=now.substring(0,idx);//유저아이디
            String value=map.get(key);//닉네임
            answer[i]=value+now.substring(idx);
        }
        return answer;
    }
    public static void main(String[] args){
        String[] arr={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] res=solution(arr);
        System.out.println(Arrays.toString(res));
    }
}
