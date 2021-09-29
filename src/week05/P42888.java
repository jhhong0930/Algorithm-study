// https://programmers.co.kr/learn/courses/30/lessons/42888
// 오픈채팅방
package week05;

import java.util.*;

public class P42888 {

    static String[] solution(String[] record) {

        Map<String, String> uid = new HashMap<>();
        List<String[]> list = new ArrayList<>();

        for (int i=0; i< record.length; i++) {

            String[] str = record[i].split(" ");

            if (str[0].equals("Enter")) {
                uid.put(str[1], str[2]); // 들어오면 uid와 이름을 저장
                list.add(str);
            } else if (str[0].equals("Change")) {
                uid.put(str[1], str[2]); // 닉네임 변경
            } else {
                list.add(str);
            }
        }

        String[] answer = new String[list.size()];

        int index = 0;

        for (String[] key : list) {

            String name = uid.get(key[1]);

            if (key[0].equals("Enter")) {
                answer[index++] = name + "님이 들어왔습니다.";
            } else {
                answer[index++] = name + "님이 나갔습니다.";
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));

//        String[][] str = new String[record.length][3];
//
//        String[] temp;
//
//        for (int i=0; i<record.length; i++) {
//
//            temp = record[i].split(" ");
//
//            for (int j=0; j<=2; j++) {
//
//                if (temp.length == 2) {
//                    str[i][0] = temp[0];
//                    str[i][1] = temp[1];
//                } else {
//                    str[i][j] = temp[j];
//                }
//            }
//        }
//
//        for (int i=0; i<record.length; i++) {
//
//            if (str[i][0].equals("Enter")) {
//                list.add(str[i][2] + "님이 들어왔습니다.");
//            } else if (str[i][0].equals("Leave")) {
//                list.add(str[i][2] + "님이 나갔습니다.");
//            }
//        }
//
//        for (String l : list) {
//            System.out.println(l);
//        }

    }
}
