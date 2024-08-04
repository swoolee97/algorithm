import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10844 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(9);
            return;
        }
//        if (N == 2) {
//            System.out.println(17);
//            return;
//        }
        long[][] dp = new long[N + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % 1_000_000_000;
                    continue;
                }
                if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % 1_000_000_000;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i] % 1_000_000_000;
        }
        System.out.println(sum);
    }
}
