package basic.day7._11724번;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] A;
    private static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            if(!visit[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int i) {
        if(visit[i]) return;

        visit[i] = true;

        for(int x : A[i]) {
            if(!visit[x]) {
                DFS(x);
            }
        }
    }
}
