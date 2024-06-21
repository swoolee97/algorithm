import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main1043 {
    static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N];
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int[] people = new int[a];
        for (int i = 0; i < a; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = i + 1; j < people.length; j++) {
                if (find(people[i]) != find(people[j])) {
                    union(people[i], people[j]);
                }
            }
        }

        List<List<Integer>> party = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            party.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                party.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < party.size(); i++) {
            List<Integer> p = party.get(i);
            for (int j = 0; j < p.size(); j++) {
                boolean flag = false;
                for (int k = 0; k < people.length; k++) {
                    if (p.get(j) == people[k]) {
                        flag = true;
                    }
                }
                if (flag) {
                    
                }
            }
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int a = parent[x];
        int b = parent[y];
        parent[b] = a;
    }
}
