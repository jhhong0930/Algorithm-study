package programmers.keyPad;

public class Solution {

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        int leftRoot=10;
        int rightRoot=12;

        int lDist=0;
        int rDist=0;

        for(int i=0; i< numbers.length;i++){
            int n=numbers[i];

            if(n==1 || n==4||n==7){
                sb.append("L");
                leftRoot=n;
            }else if(n==3||n==6||n==9){
                sb.append("R");
                rightRoot=n;
            }else{
                //가운데
                if(n==0) n+=11;//0은 11로 간주
                lDist=(Math.abs(n-leftRoot))/3+(Math.abs(n-leftRoot))%3;
                rDist=(Math.abs(n-rightRoot))/3+(Math.abs(n-rightRoot))%3;

                if(lDist==rDist){
                    if(hand.equals("left")){
                        sb.append("L");
                        leftRoot=n;
                    }else{
                        sb.append("R");
                        rightRoot=n;
                    }
                }else if(lDist<rDist){
                    sb.append("L");
                    leftRoot=n;
                }else{
                    sb.append("R");
                    rightRoot=n;
                }

            }

        }

        answer=sb.toString();
        return answer;
    }


    public static void main(String[] args){
        int[] arr={7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String answer=solution(arr,"left");
        System.out.println("answer: "+answer);//LRLL RRLL LRR
    }

}
