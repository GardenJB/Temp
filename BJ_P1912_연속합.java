import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_P1912_연속합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		//정수 수 n
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(sc.nextLine());
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		//최대합 
		int max_s = nums[0];
		int sum= 0;
		for(int i=1; i<n; i++) {
			if(nums[i]<=0) {
				
				if(nums[i-1]>0 && i+1<n && nums[i+1]>=0 && Math.abs(nums[i]) >Math.abs(nums[i+1]) && max_s<sum) {
					max_s=sum;
					sum=0;
				}
				else if(nums[i-1]>0 && i+1<n && nums[i+1]>=0 && Math.abs(nums[i]) <=Math.abs(nums[i+1])) {
					sum+=nums[i];
				} else {
					max_s = max_s>nums[i] ? max_s : nums[i];
				}
				
			}else {
				sum+=nums[i];
			}
			
		}
		System.out.println(max_s);
		
	}

}

// 연속된 수의 합이 최대 경우 구하기
//양수에서 시작> 연속된 수가 양수면 더하기 / 음수면 멈추고 임시 sum=0
//*****음수인 경우 연속된 수가 양수일 때 절대값으로 크기 비교하기
//음수에서 시작 > 연속된 수와 대소비교 큰 수로 바꾸기

