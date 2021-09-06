// https://programmers.co.kr/learn/courses/30/lessons/12977
// 소수 만들기
package week02;

public class P12977 {

    static int solution(int[] nums) {

        int answer = 0;

        for (int i=0; i<nums.length; i++) {

            for (int j=i+1; j<nums.length; j++) {

                for (int k=j+1; k<nums.length; k++) {

                    int num = nums[i] + nums[j] + nums[k];

                    if (isPrime(num)) answer++;
                }

            }

        }

        return answer;
    }

    static boolean isPrime(int n) {

        boolean prime = true;

        for (int i=2; i<=(int)Math.sqrt(n); i++) {

            if (n % i == 0) {
                prime = false;
                break;
            }

        }

        return prime;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
    }

}
