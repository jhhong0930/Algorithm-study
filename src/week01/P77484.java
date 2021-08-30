// https://programmers.co.kr/learn/courses/30/lessons/77484
// 로또의 최고 순위와 최저 순위
package week01;

import java.util.Arrays;

class P77484 {

    static int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];
        int zero = 0;  // 0 개수
        int match = 0; // 일치 번호 개수

        for (int i=0; i<lottos.length; i++) {
            if (lottos[i] == 0) zero++;

            for (int j=0; j<win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    match++;
                    break;
                }
            }
        }

        answer[0] = Math.min(7 - (zero + match), 6); // 최고 순위
        answer[1] = Math.min(7 - match, 6);          // 최저 순위

        return answer;

        /* Map 이용
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zero = 0;
        int match = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zero++;
                continue;
            }
            map.put(lotto, true);
        }


        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) match++;
        }

        int maxRank = 7 - (match + zero);
        int minRank = 7 - match;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
        */
    }

    public static void main(String[] args) {

        int lottos1[] = {44, 1, 0, 0, 31, 25};
        int win_nums1[] = {31, 10, 45, 1, 6, 19};

        int lottos2[] = {0, 0, 0, 0, 0, 0};
        int win_nums2[] = {38, 19, 20, 40, 15, 25};

        int lottos3[] = {45, 4, 35, 20, 3, 9};
        int win_nums3[] = {20, 9, 3, 45, 4, 35};

        System.out.println(Arrays.toString(solution(lottos1, win_nums1)));
        System.out.println(Arrays.toString(solution(lottos2, win_nums2)));
        System.out.println(Arrays.toString(solution(lottos3, win_nums3)));
    }

}
