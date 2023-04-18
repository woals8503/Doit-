package review.day5_DFS_BFS._11724번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> [] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void DFS(int i) {

        visited[i] = true;

        for(int x : arr[i]) {
            if(!visited[x])
                DFS(x);
        }
    }
}
