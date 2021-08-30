package programmers.newId;

import java.util.Locale;

public class Solution {
    public static String solution(String new_id) {
        String answer = "";
        //대->소 step1
        new_id=new_id.toLowerCase();

        //step2. 소문자, 숫자, _,-,. 외에는 제외시키기
        for(int i=0; i<new_id.length();i++){

            char c=new_id.charAt(i);

            if('a'<=c && c<='z'){
               answer+=String.valueOf(c);
            }else if('0'<=c && c<='9'){
                answer+=String.valueOf(c);
            }else if(c=='-' || c=='_'||c=='.'){
                answer+=String.valueOf(c);
            }

        }

        //step3-.감시

        for(int i=0; i < answer.length();i++){
            char c=answer.charAt(i);

            if(c=='.'){
                int j=i+1;
                String dot=".";
                while(j!=answer.length()&&answer.charAt(j)=='.'){
                    dot+=".";
                    j++;
                }
                if(dot.length()>1){
                    //..같은 경우
                    answer=answer.replace(dot,".");
                }
            }

        }

        //step4. 처음이나 끝에 있는 . 제거
        if(answer.startsWith(".")){
            answer=answer.substring(1);
        }else if(answer.endsWith(".")){
            answer=answer.substring(0,answer.length()-1);
        }

        //step5. 빈문자열이라면 a 대입
        if(answer.length()==0){
            answer+="a";
        }

        //step6. 길이가 16이상이면 15글자까지만 반영
        if(answer.length()>=16){
            answer=answer.substring(0,15);//[0,15)(인덱스는 크기-1까지)
        }

        //"abcdefghijklmn."처럼 15글자 맞춰도 .이 마지막에 남는 경우
        if(answer.endsWith(".")){
            answer=answer.substring(0,answer.length()-1);
        }

        //step7. 길이가 2이하라면, 마지막 글자를 복제(길이가 3이 될때까지)
        while(answer.length()<=2 && answer.length()>0){
            char end=answer.charAt(answer.length()-1);
            answer=answer+end;
        }

        return answer;
    }

    public static void main(String[] args){
        String s1="...!@BaT#*..y.abcdefghijklm";
        String s2="z-+.^.";
        String s3=	"=.=";
        String s4="123_.def";
        String s5="abcdefghijklmn.p";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
        System.out.println(solution(s5));

    }
}
