import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_P1912_연속합_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		//수 n
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(sc.nextLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		for(int i=1; i<n; i++) {
			dp[i] = arr[i]> arr[i]+dp[i-1] ? arr[i] : arr[i]+dp[i-1];
		}
		
		int max_s= Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(max_s<dp[i]) max_s=dp[i];
		}
		
		System.out.println(max_s);
	}

}
