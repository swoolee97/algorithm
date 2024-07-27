import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11060 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 1;
        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (arr[0] == 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N; ) {
            int a = arr[i];
            int maxIndex = 0;
            int max = 0;
            if (i + a >= N - 1) {
                break;
            }
            for (int j = i + 1; j <= i + a; j++) {
                if (max + maxIndex < arr[j] + j) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            if (max == 0) {
                System.out.println(-1);
                return;
            }
            count++;
            i = maxIndex;
        }
        System.out.println(count);
    }
}
