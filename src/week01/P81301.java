// https://programmers.co.kr/learn/courses/30/lessons/81301
// 숫자 문자열과 영단어
package week01;

public class P81301 {

    static int solution(String s) {

//        s = s.replaceAll("zero", "0");
//        s = s.replaceAll("one", "1");
//        s = s.replaceAll("two", "2");
//        s = s.replaceAll("three", "3");
//        s = s.replaceAll("four", "4");
//        s = s.replaceAll("five", "5");
//        s = s.replaceAll("six", "6");
//        s = s.replaceAll("seven", "7");
//        s = s.replaceAll("eight", "8");
//        s = s.replaceAll("nine", "9");

        String[] strings = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for (int i=0; i<10; i++) {
            s = s.replaceAll(strings[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {

        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }

}
