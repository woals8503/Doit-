package graph.day2._1043번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] real;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int partyNum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        //진실을 아는사람
        int r = Integer.parseInt(st.nextToken());
        real = new int[r];
        for(int i=0; i<r; i++)
            real[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[partyNum];
        for(int i=0; i<partyNum; i++) {
            list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            //파티 참가 인원 수
            int n = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                list[i].add(a);
            }
        }

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<partyNum; i++) {
            int a = list[i].get(0);
            for(int j=1; j<list[i].size(); j++) {
                union(a, list[i].get(j));
            }
        }
        int count = 0;
        for(int i=0; i<partyNum; i++) {
            int a = list[i].get(0);
            boolean flag = true;
            for(int j=0; j<real.length; j++) {
                if(find(a) == find(real[j])) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        System.out.println(count);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    private static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

}
