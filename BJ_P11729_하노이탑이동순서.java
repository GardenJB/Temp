package d0405;

import java.util.Scanner;

public class BJ_P11729_하노이탑이동순서 {
	
	static int cnt=0;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		//원판 수 
		int n = sc.nextInt();
		
		ha(n, 1, 3, 2);
		System.out.println(cnt+"\n"+sb);
	}
	
	private static void ha(int n, int from, int to, int bl) {
		if(n==1) {
			sb.append(from+" "+to+"\n");
			cnt++;
			return;
		}
		
		ha(n-1, from, bl, to);
		sb.append(from+" "+to+"\n");
		cnt++;
		ha(n-1, bl, to, from);
	}
}
