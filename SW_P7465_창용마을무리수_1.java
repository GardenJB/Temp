package hw;

import java.util.Scanner;

public class SW_P7465_창용마을무리수_1 {
	
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case 반복
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			
			//마을 사람 수 n
			int n = sc.nextInt();
			//관계 수 m
			int m = sc.nextInt();
			
			//대표 배열
			arr = new int[n+1];
			for(int i=1; i<n+1; i++) {
				arr[i]=i;
			}
			//관계수
			int cnt=0;
			
			for(int i=0; i<m; i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				
				if(f(x, y)) cnt++;
			}
			
			System.out.printf("#%d %d\n", tc, n-cnt);			
		}
	}
	private static boolean f(int x, int y) {
		x = h(x);
		y = h(y);
		
		if(x == y) return false;
		
		if(x<y) arr[y]=x;
		else arr[x]=y;
		return true;
	}
	
	private static int h (int k) {
		if(arr[k]==k) return k;
		else return h(arr[k]);
	}
}
