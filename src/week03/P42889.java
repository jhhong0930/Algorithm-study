// https://programmers.co.kr/learn/courses/30/lessons/42889
// 실패율
package week03;

import java.util.*;

public class P42889 {

    static int[] solution(int N, int[] stages) {

        /*
        // 스테이지를 도전한 사람 수
        Map<Integer, Integer> challenge = new HashMap<>();
        // 스테이지를 실패한 사람 수
        Map<Integer, Integer> fail = new HashMap<>();
        // 실패율
        Map<Integer, Double> ratio = new HashMap<>();

        // 스테이지를 도전한 사람 수 구하기
        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=0; j<stages.length; j++) {
                if (stages[j] >= i) {
                    count++;
                }
            }
            challenge.put(i, count);
        }

        // 스테이지를 실패한 사람 수 구하기
        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=0; j<stages.length; j++) {
                if (stages[j] == i) {
                    count++;
                }
            }
            fail.put(i, count);
        }

        // 실패율 계산
        for (int i=1; i<=n; i++) {
            ratio.put(i, (double) fail.get(i) / challenge.get(i));
        }

        // 내림차순 정렬
        ArrayList<Integer> sorted = new ArrayList<>(ratio.keySet());
        sorted.sort((o1, o2) -> ratio.get(o2).compareTo(ratio.get(o1)));

        int[] answer = sorted.stream().mapToInt(i -> i).toArray();

        return answer;
        */

        //스테이지별 실패율 기록 배열
        Double[] successRate = new Double[N];

        //스테이지는 1부터 시작함으로 1~N
        //각 스테이지의 실패율을 계산에 배열에 입력
        for (int i = 1; i <= N; i++) {
            double success = 0.0;
            double fail = 0.0;
            for (int stage : stages) {
                if (i == stage) fail++;
                else if (i < stage) success++;
            }
            if (success == 0 && fail == 0) successRate[i - 1] = 0.0;
            else successRate[i - 1] = fail / success;
        }


        //스테이지 순서에 따른 실패율을 저장하기위한 Map
        Map<Integer, Double> result = new HashMap<>();
        //key값을 스테이지로 정의. 스테이지 1부터 계산된 실패율을 저장
        for (int i = 1; i <= successRate.length; i++)
            result.put(i, successRate[i - 1]);


        //스테이지를 실패율로 내림차순 정렬
        ArrayList<Integer> keySetList = new ArrayList<>(result.keySet());
        keySetList.sort((o1, o2) -> result.get(o2).compareTo(result.get(o1)));

        //실패율로 내림차순 정렬된 ArrayList를 int[]로 변환
        int[] result2 = keySetList.stream().mapToInt(i -> i).toArray();

        return result2;
    }

    public static void main(String[] args) {

        int n = 5;
        int[] steps = {2, 1, 2, 6, 2, 4, 3, 3};

        System.out.println(Arrays.toString(solution(n, steps)));
    }

}
