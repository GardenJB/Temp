package d0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_P12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//물품의 수  n
		int n = Integer.parseInt(st.nextToken());
		//최대 무게 k
		int k = Integer.parseInt(st.nextToken());
		
		//물건 배열 무게 , 가치
		int[][] bag = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//dp
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=k; j++) {
				if(bag[i][0]+j<=k) {
					dp[bag[i][0]+j]= dp[j]+bag[i][1]> dp[bag[i][0]+j] ? dp[j]+bag[i][1] : dp[bag[i][0]+j];
				}
			}
		}
		System.out.println(dp[k]);
	}

}
