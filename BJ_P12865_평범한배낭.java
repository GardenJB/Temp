///틀림......어디야???

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		
		//Arrays.sort(bag, (o1, o2) -> o1[1] - o2[1]);
		//dp
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++) {
			//*****물건을 담는 순서에 주의!! 누적은 중복될 수 있음
			for(int j=k; j>=0; j--) {
				//무게 초과
				if(bag[i][0]+j>k) continue;
				//무게 가능 경우 비교
				dp[bag[i][0]+j]= dp[j]+bag[i][1]> dp[bag[i][0]+j] ? dp[j]+bag[i][1] : dp[bag[i][0]+j];
			}
		}
		//최대 가치
		int max_v = Integer.MIN_VALUE;
		for(int d : dp) {
			if(max_v<d) max_v=d;
		}
		System.out.println(max_v);
	}

}
