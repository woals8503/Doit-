package review.day5_DFS_BFS._13023번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> [] arr;
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++)
            arr[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i=0; i<N; i++) {    // 시간복잡도 : O(N) * O(V+E)
            DFS(i, 1);
            if(flag) break;
        }

        if(flag)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static void DFS(int num, int depth) {

        if(depth == 5) {
            flag = true;
            return;
        }

        visited[num] = true;

        for(int x : arr[num]) {
            if(!visited[x]) {
                DFS(x, depth+1);
            }
        }

        visited[num] = false;
    }
}
