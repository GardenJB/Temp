package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_P2468_안전영역 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//배열 크기 n
		int n = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max_c =0;
		Queue<int[]> q = new LinkedList<int[]>();
		
		
		for(int i=0; i<100; i++) {
			int cnt=0;
			boolean[][] ch = new boolean[n][n];
			for(int a=0; a<n; a++) {
				for(int b=0; b<n; b++) {
					if(map[a][b]>i && !ch[a][b]) {
						ch[a][b]=true;
						cnt++;					
						int[] temp = new int[2];
						temp[0]=a;
						temp[1]=b;
						q.add(temp);
						
						int[]dx = {0, -1, 0, 1};
						int[] dy = {-1, 0, 1, 0};
						while(!q.isEmpty()) {
							temp = q.poll();
							for(int k=0; k<4; k++) {
								int x = temp[0]+dx[k];
								int y = temp[1]+dy[k];
								if(x<0 || y<0 || x>=n || y>=n) continue;
								if(map[x][y]>i && !ch[x][y]) {
									ch[x][y]=true;
									int[] arr = new int[2];
									arr[0]=x;
									arr[1]=y;
									q.add(arr);
								}
							}
						}
					}
				}
			}
			if(cnt==0)break;
			max_c = max_c > cnt ? max_c : cnt;
		}
		System.out.println(max_c);
	}

}
