package graph.day1._18352번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited;
    static  ArrayList<Integer>[] list;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        answer = new ArrayList<>();
        visited = new int[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        BFS(X);
        for(int i=1; i<=N; i++) {
            if(visited[i] == K) {
                answer.add(i);
            }
        }

        if(answer.isEmpty())
            System.out.println("-1");
        else {
            Collections.sort(answer);
            for(int x : answer) {
                System.out.println(x);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]++;

        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int x : list[tmp]) {
                if(visited[x] == -1) {
                    visited[x] = visited[tmp] + 1;
                    q.offer(x);
                }
            }
        }
    }
}
