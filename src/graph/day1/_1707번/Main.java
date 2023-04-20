package graph.day1._1707번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] check;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list = new ArrayList[a+1];
            check = new int[a+1];
            for(int y=0; y<=a; y++)
                list[y] = new ArrayList<>();

            for(int j=0; j<b; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }

            visited = new boolean[a+1];
            flag = false;

            for(int k=1; k<=a; k++) {
                if(!flag) DFS(k);
                else break;
            }

            if(flag) System.out.println("NO");
            else System.out.println("YES");
        }



    }

    private static void DFS(int index) {
        visited[index] = true;

        for(int x : list[index]) {
            if(!visited[x]) {
                check[x] = (check[index] + 1) % 2;
                DFS(x);
            }
            else if(check[x] == check[index]) {
                flag = true;
            }
        }
    }

}
