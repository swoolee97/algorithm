import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1261 {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] count = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(count[i], 100_000_000);
        }
        count[0][0] = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                    if (map[nextX][nextY] == 1) { // 가려는 방이 벽일 때
                        if (count[nextX][nextY] > count[x][y] + 1) {
                            count[nextX][nextY] = count[x][y] + 1;
                            q.add(new Node(nextX, nextY));
                        }
                    } else { // 가려는 방이 빈 방일 때
                        if (count[nextX][nextY] > count[x][y]) {
                            count[nextX][nextY] = count[x][y];
                            q.add(new Node(nextX, nextY));
                        }
                    }
                }
            }
        }
        System.out.println(count[N - 1][M - 1]);

    }

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
