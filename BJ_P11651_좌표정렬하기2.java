//시간초과
package d0407;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_P11651_좌표정렬하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		//점의 수 n
		int n = Integer.parseInt(st.nextToken());
		
		//좌표 배열
		int[][] map = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(sc.nextLine());
			map[i][0]= Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		List<int[]> list = new LinkedList<>();
		list.add(map[0]);
		for(int i=1; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(list.get(j)==null) continue;
				if(list.get(j)[1]==map[i][1]) {
					if(list.get(j)[0]>map[i][0]) {
						//System.out.println(map[i][1]+"DD");
						list.add(j, map[i]);
						break;
					}	
					else if(j==list.size()-1) {
						//System.out.println(map[i][1]+"DDD");
						list.add(j+1, map[i]);
					}
						
				}else if(list.get(j)[1]>map[i][1]) {
					//System.out.println(map[i][1]+"DDDDd");
					list.add(j, map[i]);
					break;
				//조건에 주의****원소 끝까지 가야함
				}else if(j==list.size()-1) {
					list.add(list.size(), map[i]);
					//System.out.println(map[i][1]+"DDDDDDDDD");
				}
					
			}
		}
		
		for(int[] arr : list) {
			int x = arr[0];
			int y = arr[1];
			System.out.println(x+" "+y);
		}
	}

}
