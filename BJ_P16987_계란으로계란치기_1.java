//난 틀렸어......2


package hw;

import java.util.Scanner;

public class BJ_P16987_계란으로계란치기_1 {
	
	static int n, max_c, cnt;
	static int[][] egg;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//계란 수 
		n =sc.nextInt();
		//계란 내구도, 무게
		egg = new int[n][2];
		for(int i=0; i<n; i++) {
			egg[i][0]=sc.nextInt();
			egg[i][1]=sc.nextInt();
		}
		
		max_c=0;
		
		b(0);
		
		System.out.println(max_c);
		
	}
	
	private static void b(int k) {
		//끝 도달
		if(k==n) {
			if(cnt>max_c) max_c = cnt;
			cnt =0;
			return;
		}
		
		//깨진 계란 넘어가기
		if(egg[k][0]<=0) 
			b(k+1);
		
		for(int i=0; i<n; i++) {
			//칠 계란
			if(i != k && egg[i][0] >0) {
				//치기
				egg[k][0] = egg[k][0]-egg[i][1];
				egg[i][0] = egg[i][0]-egg[k][1];
				
				if(egg[k][0]<=0) cnt++;
				if(egg[i][0]<=0) cnt++;
				//다음
				b(k+1);
			}
		}
	}

}
