//난 틀렸어......

package hw;

import java.util.Scanner;

public class BJ_P14501_퇴사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//남은 날 
		int n = sc.nextInt();
		int[][] table = new int[n+1][2];
		for(int i=1; i<=n; i++) {
			table[i][0] = sc.nextInt();
			table[i][1] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		dp[0]=0;
		for(int i=1; i<=n; i++) {
			//이전 선택 날짜가 끝 >현재 추가
			if(table[i-1][0]+i-1<i && table[i][0]<=n-i) dp[i]+=table[i][1];
			
			for(int j=1; j<=5; j++) {
				if(i-j>=0 && i-j-table[i-j][0]>=0 && table[i][0]<=n-i)
					// 남아있 > 비교 이전 지우고 현재 추가 ? 현재 선택 x
					dp[i]=Math.max(dp[i-j], dp[i-j-table[i-j][0]]+table[i][1]);
			}
		}
		
		System.out.println(dp[n]);
	}

}
