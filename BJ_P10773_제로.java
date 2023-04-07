package d0407;

import java.util.Scanner;
import java.util.Stack;

public class BJ_P10773_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정수 k
		int k = sc.nextInt();
		
		//수 배열
		int[] arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i]= sc.nextInt();
		}
		
		Stack<Integer> st = new Stack<>();
		for(int a : arr) {
			if(a==0) st.pop();
			else st.add(a);
		}
		
		int sum=0;
		while(!st.isEmpty()) {
			sum+=st.pop();
		}
		
		System.out.println(sum);
	}

}
