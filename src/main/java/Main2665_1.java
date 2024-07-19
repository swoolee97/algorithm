import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2665_1 {
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int INF = 100_000_000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] count = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(count[i], INF);
        }
        count[0][0] = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        boolean[][] visited = new boolean[n][n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n) {
                    if (map[nextX][nextY] == 1) {
                        if (count[nextX][nextY] > count[x][y]) {
                            count[nextX][nextY] = count[x][y];
                            q.add(new Node(nextX, nextY));
                        }
                    } else {
                        if (count[nextX][nextY] > count[x][y] + 1) {
                            count[nextX][nextY] = count[x][y] + 1;
                            q.add(new Node(nextX, nextY));
                        }
                    }

                }
            }
        }
        System.out.println(count[n - 1][n - 1]);
    }

    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
