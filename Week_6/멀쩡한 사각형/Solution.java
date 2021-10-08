class Solution {
    public long solution(long w, long h) {
        long answer = 0;
        
        for(int i=1; i<w; i++) {
            answer += ((h*i)/w * 2 ) ;
        }
        
        return answer;
    }
}
