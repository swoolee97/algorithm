import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2668_2 {
    static int[] parent;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> answer = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int result = abc(i);
                visited = new boolean[N + 1];
                if (result == i) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    set = compute(i, set);
                    answer.addAll(set);
                }
            }
        }
        List<Integer> list = new ArrayList<>(answer);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        list.forEach(i -> sb.append(i).append("\n"));
        System.out.println(sb);
    }

    private static Set<Integer> compute(int x, Set<Integer> set) {
        visited[x] = true;
        int a = parent[x];

        if (!visited[a]) {
            set.add(a);
            return compute(a, set);
        }
        return set;
    }

    private static int abc(int x) {
        int a = parent[x];
        visited[x] = true;
        if (!visited[a]) {
            return abc(a);
        }
        return a;
    }
}
