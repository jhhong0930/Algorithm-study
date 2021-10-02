// https://programmers.co.kr/learn/courses/30/lessons/60057
// 문자열 압축
package week05;

public class P60057 {

    static int solution(String s) {

        int answer = s.length();

        StringBuilder sb;

        for (int i=1; i<=s.length()/2; i++) {

            sb = new StringBuilder();

            // 문자열을 i까지 자르기
            String str = s.substring(0, i);

            int count = 1;

            // j는 i까지 자른 만큼 반복해서 증가
            for (int j=i; j<s.length(); j+=i) {

                // 뒷 문자열을 잘라서 앞 문자열과 비교
                String temp = s.substring(j, Math.min(j + i, s.length()));

                if (temp.equals(str)) {
                    count++;
                } else {

                    if (count == 1) {
                        sb.append(str);
                    } else {
                        sb.append(count);
                        sb.append(str);
                    }

                    count = 1;
                    str = temp;
                }
            }

            if (count == 1) {
                sb.append(str);
            } else {
                sb.append(count);
                sb.append(str);
            }

            if (sb.length() < answer) {
                answer = sb.length();
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
        System.out.println(solution(s5));
    }

}
