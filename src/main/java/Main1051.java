import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1051 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int answer = 0;
        int max = Math.max(N, M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = answer; k < max; k++) {
                    if (i + k < N && j + k < M) {
                        if (map[i][j] == map[i + k][j] && map[i][j] == map[i][j + k] && map[i][j] == map[i + k][j
                                + k]) {
                            answer = Math.max(answer, k);
                        }
                    }

                }
            }
        }
        System.out.println((answer + 1) * (answer + 1));
    }
}
