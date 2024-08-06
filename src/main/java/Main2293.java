import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2293 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] w = new int[n + 1];
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++) { // 동전
            for (int j = 1; j <= k; j++) { // dp
                if (j - w[i] >= 0) {
                    dp[j] += dp[j - w[i]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
