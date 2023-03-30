//난 틀렸어......

package hw;

import java.util.Scanner;

public class BJ_P14501_퇴사_1 {
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
			
			for(int j=1; j<=5; j++) {
				//이전 선택 날짜가 끝 >현재 추가
				if(table[i-j][0]+i-j<i && table[i][0]<=n-i) dp[i]=Math.max(dp[i], dp[i-j]+table[i][1]);
				if(i-j>=0 && i-j-table[i-j][0]>=0 && table[i][0]<=n-i)
					// 남아있 > 비교 이전 지우고 현재 추가 ? 현재 선택 x
					dp[i]=Math.max(dp[i], Math.max(dp[i-j], dp[i-j]-table[i-j][1]+table[i][1]));
			}
		}
		
		System.out.println(dp[n]);
	}

}
