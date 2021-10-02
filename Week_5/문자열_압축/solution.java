package Week_5.문자열_압축;

public class solution {

    public static void main(String[] args) {
        System.out.println(solution("a"));
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String unit = s.substring(0, i);
            int count = 1;
            String union = "";
            String remainder = "";
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    remainder = s.substring(j);
                    continue;
                }
                if (unit.equals(s.substring(j, j + i))) {
                    count++;
                } else {
                    union += unit;
                    if (count != 1) {
                        union = count + union;
                    }
                    unit = s.substring(j, j + i);
                    count = 1;
                }
            }
            union += unit + remainder;
            if (count != 1) {
                union = count + union;
            }

            answer = Math.min(answer, union.length());
        }

        return answer;
    }

}
