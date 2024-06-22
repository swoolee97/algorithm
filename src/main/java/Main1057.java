import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1057 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 10 15
        // 5 8
        // 3 4
        // ok

        int count = 0;
        while (a != b) {
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = a / 2 + 1;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else {
                b = b / 2 + 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
