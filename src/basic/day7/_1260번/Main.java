package basic.day7._1260번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++)
            arr[i] = new ArrayList<>();

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        for(int i=1; i<=N; i++)
            Collections.sort(arr[i]);

        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);
    }

    private static void BFS(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            System.out.print(tmp + " ");
            for(int x : arr[tmp]) {
                if(!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }

    public static void DFS(int index) {
        if(visited[index]) return;
        System.out.print(index + " ");
        visited[index] = true;

        for(int x : arr[index]) {
            if(!visited[x]) {
                DFS(x);
            }
        }
    }
}
