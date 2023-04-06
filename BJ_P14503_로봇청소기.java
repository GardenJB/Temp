import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 그냥 구현하면 될 듯??
 * 틀림....;;;;
 */
public class BJ_P14503_로봇청소기 {
	
	static int n, m, cnt;
	static int[][] map;
	static boolean[][] ch;
	static int[] dx, dy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//방 크기 n *m
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//로봇 좌표 r, c, 방향 d
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		//방 배열
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//델타
		dx = new int[] {-1, 0, 1, 0};
		dy = new int[] {0, 1, 0, -1};
		ch = new boolean[n][m];
		
		//청소 칸 수 ***여기서 반복
		cnt =0;
		f(r, c, d);
		
		System.out.println(cnt);
		
	}
	
	private static void f(int r, int c, int d) {
		//현재 칸 청소
		if(!ch[r][c]) {
			ch[r][c]=true;
			cnt++;
		}
		
		
		//주변 4칸 상태 확인
		boolean ch_cur = false;
		for(int i=0; i<4; i++) {
			int x = r+dx[i];
			int y = c+dy[i];
			if(x<0 || y<0 || x>=n || y>=m) continue;
			//청소할 칸이 있는 경우
			if(map[x][y]==0 && !ch[x][y]) {
				ch_cur = true;
				break;
			}
		}
		if(ch_cur) cl(r, c, d);
		else fin(r, c, d);
	}
	
	//청소 가능 칸 있는 경우
	private static void cl(int r, int c, int d) {
		while(true) {
			//방향 회전 
			d = (d+3)%4;
			//앞쪽 청소  가능 전진
			int x = r+dx[d];
			int y = c+dy[d];
			if(map[x][y]==0 && !ch[x][y]) {
				f(x, y, d);
				break;
			}
		}
	}
	
	//청소 불가 경우
	private static void fin(int r, int c, int d) {
		
		int x = r+dx[(d+2)%4];
		int y = c+dy[(d+2)%4];
		//후진하기 가능
		if(x>=0 && y>=0 && x<n && y<m && map[x][y]==0) {
			f(x, y, d);
		}else {
			//후진 불가능 종료
			return;
		}
		
		
		
	}
}
