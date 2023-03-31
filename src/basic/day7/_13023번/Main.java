package basic.day7._13023번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arrive = false;

        visited = new boolean[N];
        arr = new ArrayList[N];
        for(int i=0; i<N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        for(int i=0; i<N; i++) {
            DFS(i, 1);
            if(arrive) break;
        }
        if(arrive) System.out.println("1");
        else System.out.println("0");
    }

    private static void DFS(int now, int depth) {

        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;

        for(int x : arr[now]) {
            if(!visited[x]) {
                DFS(x, depth+1);
            }
        }
        visited[now] = false;
    }
}
