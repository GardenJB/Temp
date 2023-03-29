package hw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SW_P7465_차용마을무리수 {
	
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case 반복
		int t = sc.nextInt();
		for(int tc =1; tc<=t; tc++) {
			//사람 수 n
			int n = sc.nextInt();
			//관계 수 m
			int m = sc.nextInt();
			
			//관계 
			List<int[]> list = new LinkedList<int[]>();
			for(int i=0; i<m; i++) {
				int[] temp = new int[2];
				temp[0]=sc.nextInt();
				temp[1] = sc.nextInt();
				
				list.add(temp);
			}
			
			//대표배열
			arr = new int[n+1];
			for(int i=1; i<n+1; i++) {
				arr[i]=i;
			}
			
			//무리 찾기
			for(int i=0; i<list.size(); i++) {
				int x = list.get(i)[0];
				int y = list.get(i)[1];
				
				f(x, y);
				
			}
			
			int aa=0;
			for(int a : arr) {
				a=h(a);
				//바꾼 값 넣기 ******
				arr[aa]=a;
				aa++;
				//System.out.println(a);
			}
			
			
			//무리 대표
			Set<Integer> set = new HashSet<>();
			for(int a : arr) {
				if(a !=0 )
					set.add(a);
			}
			
			//System.out.println(set.toString());
			System.out.printf("#%d %d\n", tc, set.size());
			
		}
	}
	
	private static void f (int x, int y) {
		
		//대표의 크기를 비교해야 함 ********
		//대표의 수가 작은 쪽으로 몰기.....
		
		x = h(x);
		y = h(y);
		
		if(x == y) return;
		
		if(x<y) {
			arr[y]=x;
		}else {
			arr[x]=y;
		}

	}
	
	private static int h (int x) {
		if(arr[x]==x) return x;
		
		return h(arr[x]);
	}
	
	
}
