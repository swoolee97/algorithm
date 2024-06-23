import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1138 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        answer[arr[0]] = 1;
        int n = 0;
        while (n < N) {
            n++;
            int count = arr[n];
            for (int i = 0; i < N; i++) {
                if (answer[i] == 0) {
                    if (count == 0) {
                        answer[i] = n + 1;
                        break;
                    } else {
                        count--;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
