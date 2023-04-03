package hw;

import java.util.Arrays;
import java.util.Scanner;

public class SW_P5656_벽돌깨기 {
	
	static int[] dx = { 0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int n, w, h, min_c;
	static int[][] map, temp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case 반복
		int t = sc.nextInt();
		for(int tc =1; tc<=t; tc++) {
			
			//구슬 수 n
			n = sc.nextInt();
			//배열 크기 w, h
			w = sc.nextInt();
			h = sc.nextInt();
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			min_c = Integer.MAX_VALUE;
			//구슬 던지기
			b(0);
//			for(int i=0; i<w; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
			
			System.out.printf("#%d %d\n", tc, min_c);
		}
		sc.close();
	}
	//*******위치
//	temp = new int[h][w];
//	for(int i=0; i<h; i++) {
//		temp[i] = map[i].clone();
//	}
	//구슬 던지기
	private static void b(int k) {
		
		//n번 던지면 남은 블록 수 비교
		if(k==n) {
			int cnt=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(temp[i][j] !=0 )
						cnt++;
				}
			}
			min_c = min_c<cnt ? min_c : cnt;
			return;
		}
		
		boolean ch = false;
		//블록이 있는 맨 윗줄 한 칸씩 치면서 비교
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(temp[i][j]!=0) {
					ch = true;
					bl(i, j, temp[i][j]);
					ar();
					b(k+1);
				}
			}
		}
		if(!ch) {
			min_c=0;
			return;
		}
	}
	//블록 제거
	private static void bl(int i, int j, int k) {
		//제거
		temp[i][j]=0;
		//대상 칸의 범위 내에서
		for(int b=0; b<k; b++) {
			//상하좌우
			for(int a =0; a<4; a++) {
				if(i+dx[a]*b<0 || i+dx[a]*b>=h || j+dy[a]*b<0 || j+dy[a]*b>=w ) continue;
				if(temp[i+dx[a]*b][j+dy[a]*b]==0) continue;
				//블록 값이 있는 경우 다시 시작
				bl(i+dx[a]*b, j+dy[a]*b, temp[i+dx[a]*b][j+dy[a]*b]);
			}
		}
	}
	
	//정렬*****0이 중간에 있으면 안됨
	private static void ar() {
		
		for(int j=0; j<w; j++) {
			//아래부터 비교하면서 값이 있으면 채워준다
			int idx = h-1;
			for(int i=h-1; i>=0; i--) {
				if(temp[i][j]!=0) {
					temp[idx][j]=temp[i][j];
					idx--;
				}
			}
			
			//한 열을 다돌면 마지막 채운 위에 부분은 모두 0으로 바꾸기
			if(idx>=0) {
				for(int i=idx; i>=0; i--) {
					temp[i][j]=0;
				}
			}
			
		}
	}

}
