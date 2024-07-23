import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {
    // 순서대로 북/동/남/서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while (true) {
            // 현재 칸 청소할때
            if (map[r][c] == 0) {
                map[r][c] = -1;
                count++;
            } else { // 이미 청소 돼있을 때
                // 반시계방향으로 순서대로 청소할 칸 확인
                int tempD = decideDirection(r, c, d);
                // 주변에 청소할 칸이 없으면 tempD = -1
                if (tempD == -1) {
                    tempD = (d + 2) % 4;
                    r += dx[tempD];
                    c += dy[tempD];
                    if (map[r][c] == 1) {
                        break;
                    }
                    continue;
                }
                r += dx[tempD];
                c += dy[tempD];
                d = tempD;
            }
        }
        System.out.println(count);
    }

    private static int decideDirection(int r, int c, int d) {
        int turnCount = 0;
        while (turnCount < 4) {
            d = ((d + 3) % 4);
            int nextR = r + dx[d];
            int nextC = c + dy[d];
            if (map[nextR][nextC] == 0) {
                return d;
            } else {
                turnCount++;
            }
        }
        return -1;
    }

}
