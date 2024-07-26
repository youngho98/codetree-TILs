import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(Integer.parseInt(st.nextToken()) - h);
        }

        int sum = 0;
        for (int i = 0; i < t; i++) {
            sum += diff[i];
        }

        int min = sum;
        for (int i = 0; i + t < n; i++) {
            sum = sum - diff[i] + diff[i + t];
            min = Math.min(sum, min);
        }

        System.out.println(min);
    }
}