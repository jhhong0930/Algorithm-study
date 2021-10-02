package programmers.P1829;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    //방문해야할 곳
    static Queue<Point> queue=new LinkedList<>();

    //한 영역의 수
    static int temp=0;

    //방향
    //좌우하상
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    //좌표
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    //bfs
    static void bfs(int x, int y, int m, int n, int[][] picture,boolean[][] visited){
        //방문한적 있다면 다시 방문할 필요가 없음
        if(visited[x][y]){
            return;
        }

        //첫 방문처리
        visited[x][y]=true;
        //영역 카운팅
        temp++;

        //상하좌우 탐색
        for(int i=0; i < 4; i++){
            int nextX=x+dx[i];
            int nextY=y+dy[i];

            //영역에 들어가지 않으면 스킵
            if(nextX<0 || nextX>=m || nextY<0 || nextY>=n) continue;
            //방문한적없고, 이전값과 같으면 bfs 호출
            if(!visited[nextX][nextY] && picture[x][y]==picture[nextX][nextY]){
                bfs(nextX,nextY,m,n,picture,visited);
            }
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        //방문처리
        boolean[][] visited=new boolean[m][n];
        int[] answer = new int[2];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //원소가 0이 아니고, 방문한적없다면 영역수 늘리고, bfs 실행
                if(picture[i][j]!=0 && !visited[i][j]){
                    numberOfArea++;
                    bfs(i,j,m,n,picture,visited);
                }
                //최대 영역수 변경<-조건
                if(temp>maxSizeOfOneArea){
                    maxSizeOfOneArea=temp;
                }
                //한 영역수는 초기화
                temp=0;

            }
        }


        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args){
        int[][] arr={
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        int[] res=solution(6,4,arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
