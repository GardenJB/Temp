package d0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_P1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//보드  n, m
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//보드배열
		char[][] map = new char[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j]= s.charAt(j);
			}
		}
		
		int min_c= Integer.MAX_VALUE;
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				int cnt1=0;
				int cnt2=0;
				//비교값 시작값
				char temp1=map[i][j];
				char temp2 = temp1=='W'? 'B' : 'W';
				//체스판만큼 확인 temp1
				for(int r=i; r<i+8; r++) {
					for(int c=j; c<j+8; c++) {
						if(r==i && c==j) continue;
						else {
							//색칠 필요부분
							if(temp1==map[r][c]) {
								cnt1++;
								//***다음 순서에 맞게 맞추기//행의 마지막 부분에서 비교값 유지****
								if(c==j+7) continue;
								else temp1= temp1=='W'? 'B' : 'W';
								continue;
							}
							//행의 마지막 부분에서 비교값 유지****
							if(c==j+7) continue;
							//비교값 갱신
							else temp1=map[r][c];
						}
					}
				}
				//체스판만큼 확인 temp2
				for(int r=i; r<i+8; r++) {
					for(int c=j; c<j+8; c++) {
						//색칠 필요부분***다를 경우
						if(temp2!=map[r][c]) {
							cnt2++;
						}
						//행의 마지막 부분에서 비교값 유지****
						if(c==j+7) continue;
						//비교값 갱신
						else temp2= temp2=='W'? 'B' : 'W';
					}
				}
				if(min_c>cnt1) min_c=cnt1;
				if(min_c>cnt2) min_c=cnt2;
			}
		}
		
		System.out.println(min_c);
	}

}
