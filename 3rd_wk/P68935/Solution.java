package programmers.P68935;

import java.util.Stack;

public class Solution {

    //10진수->3진수
    public static String makeTh(int n){
        Stack<Integer> stack=new Stack<>();
        String three="";

        while(true){
            if(n<3){
                stack.push(n);
                break;
            }
            stack.push(n%3);
            n=n/3;//n도 바뀌어야 함
        }

        //pop
        while(!stack.isEmpty()){
            three+=stack.pop();
        }


        return three;
    }

    public static int makeTen(String n){
        int res=0;
        int i=0;
        int temp=0;
        int size=n.length();
        while(i<size){
            temp=n.charAt(size-1-i)-'0';
            res+=Math.pow(3,i)*temp;
            i++;
        }

        return res;
    }

    //문자열 중간을 나누어서 뒤집는 작업
    public static String confuse(String s){
        if(s.length()==1){
            return s;
        }
        int mid=s.length()/2;
        String s1=s.substring(0,mid);
        String s2=s.substring(mid);
        return confuse(s2)+confuse(s1);
    }


    public static int solution(int n) {
        int answer = 0;
        String three=makeTh(n);//10진수->3진수
        //System.out.println("three: "+three);

        String renew=confuse(three);
        //System.out.println("renew: "+renew);
        //3진수->10진수
        answer=makeTen(renew);
        return answer;
    }

    public static void main(String[] args){
        int n1=45;
        int n2=125;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }
}
