package hw;

import java.util.Scanner;

public class BJ_P9084_동전_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case 반복
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			
			//동전 가지수 
			int n = sc.nextInt();
			int[] coin =  new int[n];
			for(int i=0; i<n; i++) {
				coin[i]=sc.nextInt();
			}
			
			//만들 금액
			int m = sc.nextInt();
			
			//dp
			int[] dp = new int[m+1];
			dp[0]=1;
			for(int i=0; i<n; i++) {
				for(int j=1; j<=m; j++) {
					if(j-coin[i]>=0)
						dp[j]+=dp[j-coin[i]];
				}
			}
			
			System.out.println(dp[m]);
		}
	}

}
