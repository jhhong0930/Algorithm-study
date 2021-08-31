package programmers.digitStrEng;

//숫자 문자열과 영단어
public class Solution {
    public static int solution(String s) {
        int answer = 0;
        String[] digits={"zero","one","two","three","four",
                        "five","six","seven","eight","nine"};

        for(int i=0;i<s.length();i++){
            for(int j=0; j<digits.length;j++){
                s=s.replace(digits[j],String.valueOf(j));
            }
        }

        answer=Integer.valueOf(s);

        return answer;
    }

    public static void main(String[] args){
        String s1="one4seveneight";
        String s2="23four5six7";
        String s3="2three45sixseven";
        String s4="123";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }

}
