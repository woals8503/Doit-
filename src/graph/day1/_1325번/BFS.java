package graph.day1._1325번;

import java.io.*;
import java.util.*;

public class BFS {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            BFS(i);
        }
        int max = Arrays.stream(answer).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(answer[i] == max)
                sb.append(i + " ");
        }
        System.out.println(sb.toString());

    }

    private static void BFS(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        visited[index] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int x : list[tmp]) {
                if(!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                    answer[x]++;
                }
            }
        }
    }
}
