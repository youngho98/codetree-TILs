import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] p = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int sum = p[i] / 2 + s[i];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                pq.add(p[j] + s[j]);
            }

            while (sum <= b && !pq.isEmpty()) {
                cnt++;
                sum += pq.poll();
            }

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}