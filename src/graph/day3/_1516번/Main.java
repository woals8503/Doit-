package graph.day3._1516번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        int[] time = new int[N+1];
        // time { 10, 10, 4, 4, 3 }
        int[] indegree = new int[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                list.get(a).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // q [ 1 ]
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        int[] result = new int[N+1];
        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : list.get(now)) { // now가 1이라면 2,3,4가 나올텐데 이 값은 1을 무조건 거쳐가야 한다는 의미이다. 그래서 result 배열에 기록한다.
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + time[now]);
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            System.out.println(result[i] + time[i]);
        }

    }
}
