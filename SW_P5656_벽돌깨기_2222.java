package hw;

import java.util.Scanner;

public class SW_P5656_벽돌깨기_2222 {
	
	static int n, w, h, min_c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case 반복
		int t = sc.nextInt();
		for(int tc =1; tc<=t; tc++) {
			
			//구슬 수 n
			n = sc.nextInt();
			//배열 가로 w, 세로 h
			w = sc.nextInt();
			h = sc.nextInt();
			
			//게임 배열
			int[][] map = new int[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			min_c = Integer.MAX_VALUE;
			
			for(int c=0; c<w; c++) {
				for(int r=0; r<h; r++) {
					if(map[r][c]>0) {
						ball(r, c, 0, map);
						break;
					}
				}
			}
			if(min_c==Integer.MAX_VALUE) min_c=0;
			System.out.printf("#%d %d\n", tc, min_c);
		}
	}
	
	private static void ball(int r, int c, int k, int[][] arr) {
		if(k==n) {
			int cnt=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(arr[i][j]>0) cnt++;
				}
			}

			if(min_c > cnt) min_c = cnt;
			return;
		}
		
		int[][] temp = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				temp[i][j]=arr[i][j];
			}
		}
		
		br(r, c, temp);
		ar(temp);
		
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				if(temp[j][i]>0) {
					ball(j, i, k+1, temp);
					break;
				}
			}
		}
	}
	
	private static void br(int r, int c, int[][] temp) {
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		int num = temp[r][c];
		temp[r][c]=0;
		for(int i=1; i<num; i++) {
			for(int j=0; j<4; j++) {
				int x = r+dx[j]*i;
				int y = c+dy[j]*i;
				if(x<0 || y<0 || x>=h || y>=w) continue;
				if(temp[x][y]==1) {
					temp[x][y]=0;
					continue;
				}
				
				br(x, y, temp);
			}
		}
	}
	
	private static void ar(int[][] temp) {
		
		for(int j=0; j<w; j++) {
			int idx=h-1;
			for(int i=h-1; i>=0; i--) {
				if(temp[i][j]!=0) {
					temp[idx][j]=temp[i][j];
					idx--;
				}
			}
			for(int i=idx; i>=0; i--) {
				temp[i][j]=0;
			}
		}
	}

}
