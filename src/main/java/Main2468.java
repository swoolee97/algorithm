import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    static int[][] map;
    static boolean[][] isSafe;
    static int N;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isSafe = new boolean[N][N];
        visited = new boolean[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int max = 0;
        for (int h = 0; h <= maxHeight; h++) {

            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
                Arrays.fill(isSafe[i], false);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    isSafe[i][j] = h < map[i][j] ? true : false;
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isSafe[i][j] && !visited[i][j]) {
                        bfs(i, j, h);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);

    }

    public static void bfs(int x, int y, int h) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.x;
            y = node.y;
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !visited[nextX][nextY]
                        && isSafe[nextX][nextY]) {
                    q.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
