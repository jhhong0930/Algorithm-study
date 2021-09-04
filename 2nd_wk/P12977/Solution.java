package programmers.P12977;

public class Solution {
    public static boolean isSosu(int k){
        int cnt=2;//1,자기자신
        int i=2;

        if(k<=1) return false;
        if(k==2 || k==3) return true;

        while(i<k){
            if(k%i==0){
                cnt++;
                return false;//소수가 아님
            }
            i++;
        }
        return true;
    }
    public static int solution(int[] nums) {
        int answer = 0;

        //3개씩이므로 nums.length-3이 되는 인덱스까지가 시작점이 될 수 있다!
        int temp=0;
        boolean flag=false;

        for(int i=0; i< nums.length-2;i++){
            for(int j=i+1; j<nums.length-1;j++){
                for(int k=j+1; k<nums.length;k++){
                    temp=0;
                    temp+=nums[i];
                    temp+=nums[j];
                    temp+=nums[k];

                    flag=isSosu(temp);
                    if(flag==true){
                        answer=answer+1;
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        int[] nums={1,2,7,6,4};
        System.out.println(solution(nums));
    }
}
