package programmers.P60057;

public class Solution {

    public static int solution(String s) {
        int answer = s.length();
        //문자열 길이를 다르게 하면서 그 때 문자열패턴을
        //이전에 등장횟수를 카운트하고, 그때 카운트갯수가 1이 아니면 StringBuilder에 카운트값을 저장해두면서
        //최솟값을 비교(문자열 길이 이용)

        //문자열 입력 절반까지만 압축가능
        for(int i=1;i<=s.length()/2;i++){
            StringBuilder sb=new StringBuilder();
            String temp="";//이전값 담을 곳
            int cnt=1;

            for(int j=0;j<Math.ceil((double)s.length()/i);j++){
                //패턴
                String str=s.substring(j*i,(j*i)+i>=s.length()?s.length():(j*i)+i);

                if(!temp.equals(str)){
                    //이전기록이 없다면
                    if(cnt!=1){
                        //그런데 카운트값이 1이 아닌경우,새로이 들어왓으므로
                        //카운트를 1로 하고 stringbuilder에 저장
                        sb.append(cnt);
                        cnt=1;
                    }
                    //문자열도 저장해주고, temp업데이트
                    sb.append(temp);//1인경우는 1a가 아닌 a이기 때문
                    temp=str;
                }else{
                    cnt++;
                }
            }
            //모두 순회 후에 cnt값이 1이 아니라면
            if(cnt!=1){
                sb.append(cnt);
            }
            sb.append(temp);
            answer=Math.min(answer,sb.toString().length());
        }

        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }
}
