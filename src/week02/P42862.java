package week02;

public class P42862 {

    static int solution(int n, int[] lost, int[] reserve) {

        int answer = lost.length;
        
        for(int i = 0; i < lost.length; i++) {

            for(int j = 0; j < reserve.length; j++) {

                if(lost[i] == reserve[j]) {
                    answer--;
                    lost[i] = 100;
                    reserve[j] = 200;
                }

            }

        }

        for(int i = 0; i < lost.length; i++) {

            for(int j = 0; j < reserve.length; j++) {

                if(reserve[j] + 1 == lost[i] || reserve[j] - 1 == lost[i]) {
                    answer--;
                    lost[i] = 300;
                    reserve[j] = 400;
                }

            }

        }

        return n - answer;
    }

    public static void main(String[] args) {

        int n1 = 5;
        int n2 = 5;
        int n3 = 3;

        int[] lost1 = {2, 4};
        int[] lost2 = {2, 4};
        int[] lost3 = {3};

        int[] reserve1 = {1, 3, 5};
        int[] reserve2 = {3};
        int[] reserve3 = {1};

        System.out.println(solution(n1, lost1, reserve1));
        System.out.println(solution(n2, lost2, reserve2));
        System.out.println(solution(n3, lost3, reserve3));
    }

}
