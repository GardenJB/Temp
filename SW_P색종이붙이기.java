package d0405;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_P색종이붙이기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		//test case반복
		int t = Integer.parseInt(st.nextToken());
		for(int tc =1; tc<=t; tc++) {
			
			boolean c = false;
			// 종이 배열 10*10
			int[][] map = new int[10][10];
			for(int i=0; i<10; i++) {
				st = new StringTokenizer(sc.nextLine());
				for(int j=0; j<10; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) c = true;
				}
			}
			int min_c = Integer.MAX_VALUE;
			boolean[][] ch = new boolean[10][10];
			//색종이 수
			int[] pap = new int[6];
			
			if(c) {
				for(int i=0; i<10; i++) {
					for(int j=0; j<10; j++) {
						//자리 찾으면 탐색
						if(map[i][j]==1 && !ch[i][j]) {
							//bfs를 돌면서 연결된 종이 자리의 시작 좌표와 끝 좌표를 일단 구해볼 것
							ch[i][j]= true;
							int[] start = new int[2];
							start[0]= i;
							start[1] = j;
							Queue<int[]> q = new LinkedList<int[]>();
							q.add(start);
							
							int[]dx = { 0, -1, 0, 1};
							int[] dy = {-1, 0, 1, 0};
							
							while(!q.isEmpty()) {
								int[] temp = q.poll();
								for(int d =0; d<4; d++) {
									int x = temp[0]+dx[d];
									int y = temp[1]+dy[d];
									
									if(x<0 || y<0 || x>=10 || y >=10) continue;
									if(map[x][y]==1 && !ch[x][y]) {
										ch[x][y]= true;
										int[] arr = new int[2];
										arr[0]=x;
										arr[1]=y;
										q.add(arr);
									}
									if(q.isEmpty()) {
										int[] end = new int[2];
										end[0]= temp[0];
										end[1]= temp[1];
									}
										
								}
								
							}
							//시작점과 끝점을 구한다면 그 부분만 따로 보내서 필요 색종이 수를 비교해 볼 것
							f(i, j, x, y, map, ch, pap);
							
						}
					}
				}
			
			}else {
				System.out.printf("#%d %d\n", tc, 0);
			}
			
		}
	}
	
	//각 구간 별 최소 필요 색종이 수 찾기
	private static void f(int x1, int y1, int x2, int y2, int[][] map, boolean[][] ch, int[] pap) {
		if(x1==x2 && y1==y2) {
			
			return;
		}
		
		//내가 하고 싶은 방법
		//백트레킹을 하면서 좌표가 끝날 때까지 비교를 하는데
		//종이가 큰 순으로 시작해서
		//공간을 모두 돌면서
		//종이가 자리에 들어갈 수 있다면 넣고 종이 수를 세고, 자리를 체크하고 넘긴다 
		//** 종이수배열과 자리체크배열을 넘길것
		//종이가 들어갈 수 없다면 **돌아가서 종이 사이즈가 하나 작아지면서 반복
		//넘기고 다시 자리가 시작되는 부분에서 반복
		//모든 공간을 돌았다면 최소값을 비교해서 돌려준다.
		for(int i=x1; i<=x2; i++) {
			for(int j=y1; j<=y2; j++) {
				//각 색종이 크기와 자리 크기를 비교
				for(int p=5; p>0; p--) {
					//***여기서 부터 반복....
					
					int a = x1+p-1;
					int b = y1+p-1;
					if(a>=10 || b>=10) continue;
					//각 꼭지점 존재하면
					if(map[a][b]==1 && map[x1][b]==1 && map[a][y1]==1) {
						if(s()) {
							//색종이 세기
							pap[p]++;
							//다음 순서로 넘어가면서 반복?????체크표시
							re();
							f(x1+p, y1, x2, y2, temp, ch, pap);
				
						}
					}
				}
			}
		}
		
	}
	
	private static boolean s() {
		//종이 크기만큼 공간이 있는 지 확인
		boolean c1 = true;
		outer:
		for(int k=0; k<p; k++) {
			for(int l=0; l<p; l++) {
				if(map[x1+k][y1+l]==0) {
					c1=false;
					break outer;
				}
			}
			
		}
	}
	
	//자리 체크 바꿔주기
	private static void re() {
		int[][] temp = new int[x2-x1+1][y2-y1+1];
		int a =0; int b=0;
		for(int i=x1; i<=x2; i++) {
			for(int j=y1; j<=y2; j++) {
				temp[a][b] = map[i][j];
				b++;
			}
			a++;
		}	
	}

}
