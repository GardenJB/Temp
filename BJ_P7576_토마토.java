package hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_P7576_토마토 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		//상자 크기 m, n
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		//토마토 상태 체크
		boolean all=false;
		//상자 배열
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//안 익은 토마토
				if(map[i][j]==0) all=true;
			}
		}
		outer:
		if(all) {
			//안 익은 토마토 존재
			boolean[][] ch = new boolean[n][m];
			Queue<int[]> q = new LinkedList<int[]>();
			int max_d=0;
			//bfs
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					//익은 토마토 존재
					if(map[i][j] ==1 && !ch[i][j]) {
						ch[i][j]=true;
						
						q.add(new int[] {i, j, 0});
						
					}
				}
			}
			//델타
			int[] dx = {0, -1, 0, 1};
			int[] dy = {-1, 0, 1, 0};
			
			//탐색
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				for(int d=0; d<4; d++) {
					int x = temp[0]+dx[d];
					int y = temp[1]+dy[d];
					
					if(x<0 || y<0 || x>=n ||y>=m) continue;
					if(map[x][y]==0 && !ch[x][y]) {
						ch[x][y]=true;
						int[] arr = new int[3];
						arr[0]=x;
						arr[1]=y;
						arr[2]=temp[2]+1;
						if(max_d<arr[2]) max_d=arr[2];
						q.add(arr);
					}
				}
				
			}

	
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==0 && !ch[i][j]) {
						System.out.println(-1);
						break outer;
					}
				}
			}
			System.out.println(max_d);
		}else {
			//처음부터 토마토 모두 익어있는 상태
			System.out.println(0);
		}
	}
}
