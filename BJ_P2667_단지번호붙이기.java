package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_P2667_단지번호붙이기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//지도 크기 n
		int n = Integer.parseInt(st.nextToken());
		//지도 배열
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]= (int) (str.charAt(j)-'0');
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] ch = new boolean[n][n];
		int cnt =0;
		List<Integer> list = new LinkedList<>();
		//bfs
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				//집 발견
				if(map[i][j]==1 && !ch[i][j]) {
					int size =1;
					ch[i][j]=true;
					cnt++;
					int[] temp = new int[2];
					temp[0]=i;
					temp[1]=j;
					q.add(temp);
					
					//델타
					int[] dx = {0, -1, 0, 1};
					int[] dy = {-1, 0, 1, 0};
					//탐색
					while(!q.isEmpty()) {
						temp = q.poll();
						for(int a=0; a<4; a++) {
							int x = temp[0]+dx[a];
							int y = temp[1]+dy[a];
							
							if(x<0 || y<0 || x>=n || y>=n) continue;
							if(map[x][y]==1 && !ch[x][y]) {
								ch[x][y]=true;
								size++;
								int[] arr = new int[2];
								arr[0]=x;
								arr[1]=y;
								q.add(arr);
							}
						}
					}
					list.add(size);
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(int k : list) {
			System.out.println(k);
		}
	}
}
