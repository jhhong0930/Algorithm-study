package rhs_algo.dp.P12899;

public class Main {

    static String rec(int n){
        if(n==1){
            return "1";
        }else if(n==2){
            return "2";
        }else if(n==3){
            return "4";
        }else{
            //3배수일때
            if(n%3==0){
                return rec((n-1)/3)+rec(3);
            }else{
                return rec(n/3)+rec(n%3);
            }
        }
    }


    public static String solution(int n) {
        String answer = "";

        answer=rec(n);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
}
