import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 배열을 모두 돌면서
 * cctv를 발견하면 90도 씩 회전for(<4) 문 시작
 * 	현재 방향에서 보이는 곳 표시하고
 * 	다시 배열을 돌면서 cctv발견하면 반복...
 * 	경우를 바꿔가면서 배열에 남은 사각지대 비교
 * 	최소값 비교
 * 
 * 이게 가능할까???
 */
public class BJ_P15683_감시 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//방 크기 n*m
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//cctv
		LinkedList<int[]> list = new LinkedList<>();
		//방 배열
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//cctv인 경우 저장
				if(map[i][j]>0 && map[i][j]!=6) {
					int[] temp = new int[3];
					temp[0]=i;
					temp[1]=j;
					temp[2]=map[i][j];
					list.add(temp);
				}
			}
		}
		int min_b = Integer.MAX_VALUE;
		int num = list.size();
		boolean[][] ch = new boolean[n][m];
		
		//델타 
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		cctv(0, ch);
	}
	
	//또또또 배열을 복사해서 넘겨주고 싶다.......ㅜㅜ;;;;;
	private static void cctv(int k, boolean[][] arr) {
		if(k==n) {
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(!arr[i][j] && map[i][j]==0)
						cnt++;
				}
			}
			min_b = min_b<cnt ? cnt : min_b;
			return;
		}
		
		//표시할 배열
		boolean[][] arr1 = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr1[i][j] = arr[i][j];
			}
		}
		
		//카메라 방향 결정
		for(int i=0; i<4; i++) {
			//카메라 종류에 따른 방향 표시
			switch(list.get(k).get(2)) {
			case 1 :
				int mul=0;
				while(true) {
					int x = list.get(k).get(0)+dx[i]*mul;
					int y = list.get(k).get(1)+dy[i]*mul;
					mul++;
					if(x<0 ||y<0||x>=n ||y>=m ||map[x][y]==6) break;
					arr1[x][y]=true;
				}
				break;
			case 2 :
				
				break;
			case 3 :
				break;
			case 4 :
				break;
			case 5 :
				break;
			}
			
			//다음 카메라로
			cctv(k+1, arr1);
			//2번 카메라는 2가지 경우
			if(list.get(k).get(2)==2 && i==1)
				break;
			//5번 카메라는 1가지
			if(list.get(k).get(2)==5 && i==0)
				break;
		}
	}
}
