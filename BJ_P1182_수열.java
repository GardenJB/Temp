import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_P1182_수열 {
	
	static int n, s, cnt, sum;
	static int[] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//정수 수 n, 목표 정수 s
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		//정수 배열
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i]= Integer.parseInt(st.nextToken());
		}
		
		cnt=0;
		sum=0;
		back(0);
		if(s==0) cnt-=1;
		System.out.println(cnt);
	}
	
	private static void back(int k) {
		if(k==n) {
			cnt = sum == s ? cnt+1: cnt;
			return;
		}
		
		sum+=num[k];
		back(k+1);
		sum-=num[k];
		back(k+1);
		
	}

}
