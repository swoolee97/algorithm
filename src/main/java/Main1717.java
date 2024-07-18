import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1717 {
    static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (r == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

}
