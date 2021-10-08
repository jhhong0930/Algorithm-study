public class Solution {
    
    public String solution(int n) {
        int remainder = 0;
        StringBuilder answer = new StringBuilder();
        
        while(n > 0) {
            remainder = n % 3;
            n /= 3;
            
            if(remainder == 0) {
                remainder = 4;
                --n;
            }
            
            answer.insert(0, remainder);
        }
        
        System.out.println(answer);        
        return answer.toString();
    }
 
}
