// https://programmers.co.kr/learn/courses/30/lessons/1845
// 폰켓몬
package week03;

import java.util.HashMap;
import java.util.Map;

public class P1845 {

    static int solution(int[] nums) {

        int selectNo = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, 1);
        }

        return Math.min(map.size(), selectNo);
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
        System.out.println(solution(nums3));
    }
}
