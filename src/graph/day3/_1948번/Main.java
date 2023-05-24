package graph.day3._1948번;

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
        int M = Integer.parseInt(br.readLine());;

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverse = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        int[] indegree = new int[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list.get(S).add(new Node(E, time));
            reverse.get(E).add(new Node(S, time));
            indegree[E]++;
        }

        Queue<Integer> Q = new LinkedList<>();
        int[] result = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Q.add(S);
        while(!Q.isEmpty()) {
            int now = Q.poll();

            for(Node next : list.get(now)) {
                indegree[next.target]--;
                result[next.target] = Math.max(result[next.target], result[now] + next.value);
                if(indegree[next.target] == 0) {
                    Q.add(next.target);
                }
            }
        }

        Q = new LinkedList<>();
        Q.add(E);
        int count = 0;
        boolean[] visited = new boolean[N+1];
        visited[E] = true;
        while(!Q.isEmpty()) {
            int now = Q.poll();
            for(Node next : reverse.get(now)) {
                if(result[now] == result[next.target] + next.value) {
                    count++;
                    System.out.println("타겟 : " + next.target);
                    System.out.println(count);
                    if(visited[next.target] == false) {
                        System.out.println("타겟 : " + next.target);
                        visited[next.target] = true;
                        Q.add(next.target);
                    }

                }
            }
        }
        System.out.println(result[E]);
        System.out.println(count);

    }

    static class Node {
        int target;
        int value;

        Node(int target, int value) {
            this.target = target;
            this.value = value;
        }
    }
}
