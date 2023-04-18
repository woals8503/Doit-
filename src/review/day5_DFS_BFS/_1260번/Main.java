package review.day5_DFS_BFS._1260번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];

        for(int i=0; i<=N; i++)
            arr[i] = new ArrayList<>();

        // 인접 리스트 양방향 저장
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        // list 오름차순 정렬 ( default )
        for(int i=1; i<=N; i++) 
            Collections.sort(arr[i]);

        visited = new boolean[N+1];
        sb = new StringBuilder();
        DFS(V);
        System.out.println(sb.toString());

        visited = new boolean[N+1];
        sb = new StringBuilder();
        BFS(V);
        System.out.println(sb.toString());
    }

    private static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            sb.append(tmp + " ");
            for(int x : arr[tmp]) {
                if(!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                }

            }
        }
    }

    private static void DFS(int v) {
        sb.append(v + " ");
        visited[v] = true;

        for(int x : arr[v]) {
            if(!visited[x]) {
                DFS(x);
            }
        }
    }
}
