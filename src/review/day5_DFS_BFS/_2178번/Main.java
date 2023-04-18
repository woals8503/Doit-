package review.day5_DFS_BFS._2178번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        //배열 저장
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }
        
        BFS(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        visited[i][j] = true;

        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for(int k=0; k<4; k++) {
                int nx = tmp.x + dx[k];
                int ny = tmp.y + dy[k];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && arr[nx][ny] != 0) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
