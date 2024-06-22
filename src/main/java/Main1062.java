import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1062 {
    static Set<Character> characters;
    static boolean[] visited;
    static int target;
    static Set<Character> words[];
    static int max;
    static List<Character> list;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        words = new HashSet[N];
        characters = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
                characters.add(c);
            }
            words[i] = set;
        }
        list = new ArrayList<>(characters);

        visited = new boolean[list.size()];
        target = K - 5;
        if (target < 0) {
            System.out.println(0);
            return;
        }
        max = 0;

        bt(0, 0, new char[target]);
        System.out.println(max);
    }

    public static void bt(int depth, int start, char[] arr) {
        if (depth == target) {
            int count = 0;

            for (int i = 0; i < words.length; i++) {
                Set<Character> targetSet = new HashSet<>();
                for (char c : arr) {
                    targetSet.add(c);
                }
                targetSet.addAll(List.of('a', 'n', 't', 'i', 'c'));
                if (targetSet.containsAll(words[i])) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            visited[i] = true;
            arr[depth] = list.get(i);
            bt(depth + 1, i, arr);
            visited[i] = false;
        }
    }

}
