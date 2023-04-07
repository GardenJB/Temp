//시간 초과
package d0407;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_P11651_좌표정렬하기2_1 {
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
		
		LinkedList<int[]> list = new LinkedList<>();
		//리스트에 첫 원소 넣기
		list.add(map[0]);
		//list 크기가 1일 경우 대소비교만
		if(list.peek()[1]==map[1][1]) {
			if(list.peek()[0]>map[1][0])
				list.addFirst(map[1]);
			else
				list.addLast(map[1]);
		}else if(list.peek()[1]>map[1][1]){
			list.addFirst(map[1]);
		}else
			list.addLast(map[1]);
		
		//list에서 순서 정하기
		for(int i=2; i<n; i++) {
			//가장 작은 경우 앞으로
			if(list.peekFirst()[1]>map[i][1])
				list.addFirst(map[i]);
			else if(list.peekFirst()[1]==map[i][1] && list.peekFirst()[0]>map[i][0])
				list.addFirst(map[i]);
			//가장 큰 경우 뒤로
			else if(list.peekLast()[1]<map[i][1])
				list.addLast(map[i]);
			else if(list.peekLast()[1]==map[i][1] && list.peekLast()[0]<map[i][0])
				list.addLast(map[i]);
			//중간
			else {
				for(int j=list.size()-1; j>=0; j--) {
					if(map[i][1]==list.get(j)[1]) {
						if(list.get(j-1)[1]<map[i][1] || list.get(j-1)[0]<map[i][0])
							list.add(j, map[i]);
					}else if(map[i][1]<list.get(j)[1] && map[i][1]>list.get(j-1)[1])
						list.add(j, map[i]);
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
