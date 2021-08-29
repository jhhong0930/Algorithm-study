# algorithm-study
각자 이름으로 브렌치 만드신 후 해당 주차 스터디 진행 전까지 푸시 하시면 됩니다  

### 1주차 문제
- 로또의 최고 순위와 최저 순위 https://programmers.co.kr/learn/courses/30/lessons/77484
- 신규 아이디 추천 https://programmers.co.kr/learn/courses/30/lessons/72410
- 숫자 문자열과 영단어 https://programmers.co.kr/learn/courses/30/lessons/81301
- 키패드 누르기 https://programmers.co.kr/learn/courses/30/lessons/67256
- 크레인 인형뽑기 게임 https://programmers.co.kr/learn/courses/30/lessons/64061



현솔

로또

로또의 최고순위와 최저순위 (20분소요)

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
       
        
        int b = min(lottos,win_nums);
        int a = max(lottos,win_nums);
        
        int[] answer = {a,b};
    
        return answer;
    }
    
    public int max(int[] lottos, int[] win_nums){
        int result=0;
        int count=0;
        for(int i=0; i<lottos.length; i++){
           
            for(int f=0; f<win_nums.length; f++){
               
                 if(lottos[i]==0){
                    lottos[i]=win_nums[i];                
                 }
                
                if(lottos[i]==win_nums[f]){
                    count+=1;
                }
            }
        }
       switch(count){
             
           case 6: result=1; break;
           case 5: result=2; break;
           case 4: result=3; break;    
           case 3: result=4; break;    
           case 2: result=5; break;
           default: result=6; break;    
       }
        return result; 
    }
    
 public int min(int[] lottos, int[] win_nums){
          int result=0;
          int count=0;
          for(int i=0; i<lottos.length; i++){
           
            for(int f=0; f<win_nums.length; f++){
                
                if(lottos[i]==win_nums[f]){
                    count+=1;
                }
            }
          }
       switch(count){
             
           case 6: result=1; break;
           case 5: result=2; break;
           case 4: result=3; break;    
           case 3: result=4; break;    
           case 2: result=5; break;
           default: result=6; break;    
       }
        return result; 
        
    }
    
}


