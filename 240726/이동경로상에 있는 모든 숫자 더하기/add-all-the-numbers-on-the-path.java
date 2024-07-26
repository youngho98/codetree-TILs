import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        char[] cmd = br.readLine().toCharArray();

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n / 2;
        int y = n / 2;
        int d = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int sum = map[x][y];
        for (int i = 0; i < t; i++) {
            if (cmd[i] == 'F') {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (inMap(nx, ny)) {
                    x = nx;
                    y = ny;
                    sum += map[x][y];
                }
            } else if (cmd[i] == 'R') {
                d = (d + 1) % 4;
            } else if (cmd[i] == 'L') {
                d = (d + 3) % 4;
            }
        }

        System.out.println(sum);
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}