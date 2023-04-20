package graph.day1._2251번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,2,0,2,0,1};
    static boolean[][] visit = new boolean[201][201];
    static boolean[] answer = new boolean[201];
    static int[] now = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<3; i++) now[i] = Integer.parseInt(st.nextToken());

        BFS();
        for(int i=0; i<answer.length; i++) {
            if(answer[i]) System.out.print(i + " ");
        }

    }
    static void BFS() {
        Queue<AB> q = new LinkedList<>();
        q.offer(new AB(0, 0));
        visit[0][0] = true;
        answer[now[2]] = true;

        while(!q.isEmpty()) {
            AB tmp = q.poll();
            int A = tmp.A;
            int B = tmp.B;
            int C = now[2] - A - B;

            for(int i=0; i<6; i++) {
                int[] next = {A, B, C};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;

                if(next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }
                
                if(!visit[next[0]][next[1]]) {
                    visit[next[0]][next[1]] = true;
                    q.offer(new AB(next[0], next[1]));
                    if(next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

class AB {
    int A;
    int B;
    public AB(int a, int b) {
        A = a;
        B = b;
    }
}
