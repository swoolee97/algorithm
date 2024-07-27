import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main14888_1 {
    static int N;
    static int[] answer;
    static List<Integer> operators;
    static int max, min;
    static int[] arr;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[N - 1];
        visited = new boolean[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                operators.add(i);
            }
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        bt(0, 0);
        System.out.println(max);
        System.out.println(min);
    }

    public static void bt(int depth, int start) {
        if (depth == N - 1) {
            int num = arr[0];
            for (int i = 0; i < answer.length; i++) {
                switch (answer[i]) {
                    case 0: {
                        num += arr[i + 1];
                        break;
                    }
                    case 1: {
                        num -= arr[i + 1];
                        break;
                    }
                    case 2: {
                        num *= arr[i + 1];
                        break;
                    }
                    case 3: {
                        num /= arr[i + 1];
                        break;
                    }
                }
            }
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                answer[depth] = operators.get(i);
                visited[i] = true;
                bt(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

}
