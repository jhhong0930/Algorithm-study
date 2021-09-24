package programmers.P12915;

import java.util.*;

public class Solution {

    public static String[] solution(String[] strings, int n) {
        String[] answer =new String[strings.length];

        Map<String,String> map=new HashMap<>();

        for(int i=0; i< strings.length;i++){
            String str=strings[i];
            String c=String.valueOf(str.charAt(n));

            map.put(str,c);
        }

        ArrayList<Map.Entry<String,String>> list=new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                String val1=o1.getValue();
                String val2=o2.getValue();

                String key1=o1.getKey();
                String key2=o2.getKey();
                //그런데 val1과 val2가 같은 경우는 단어 자체 사전순 배열
                if(val1.equals(val2)){
                  //  System.out.println("key1: "+key1+",key2: "+key2);
                    return key1.compareTo(key2);
                }
                return val1.compareTo(val2);
            }
        });

      //  System.out.println("sorted: "+list);

        for(int i=0; i< list.size();i++){
            answer[i]=list.get(i).getKey();
        }

        return answer;
    }

    public static void main(String[] args){
        String[] str1={"sun", "bed", "car"};
        String[] str2={"abce", "abcd", "cdx"};

        System.out.println(Arrays.toString(solution(str1,1)));
        System.out.println(Arrays.toString(solution(str2,2)));
    }

}
