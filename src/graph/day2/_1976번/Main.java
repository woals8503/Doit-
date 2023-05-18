package graph.day2._1976번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] city = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] route = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(city[i][j] == 1) union(i, j);
            }
        }

        int idx = find(route[1]);
        for(int i=2; i<route.length; i++) {
            if(idx != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int i, int j) {
        i = find(i);
        j = find(j);
        if(i != j) {
            parent[j] = i;
        }
    }

    private static int find(int a) {
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}