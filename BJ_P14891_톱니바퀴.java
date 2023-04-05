import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 이것도 그냥 구현하면 될 듯...
 * 틀림.....ㅜㅜ
 */
public class BJ_P14891_톱니바퀴 {
	
	static LinkedList<LinkedList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//톱니 4개의 상태 받기
		list = new LinkedList<>();
		for(int i=0; i<4; i++) {
			LinkedList<Integer> temp = new LinkedList<>();
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				temp.add(s.charAt(j)=='1' ? 1:0);
			}
			list.add(temp);
		}
		
		//회전수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			//회전 대상 톱니 번호
			int n = Integer.parseInt(st.nextToken())-1;
			//회전 방향
			int dir = Integer.parseInt(st.nextToken());
			rot_r(n, dir);
			rot_l(n, dir);
		}
		
		int sum=0;
		//톱니바퀴 점수의 합 출력
		for(int i=0; i<4; i++) {
			sum += list.get(i).peek()==0 ? 0 : Math.pow(2, i);
		}
		
		System.out.println(sum);
	}
	
	private static void rot_r(int n, int dir) {
		//오른쪽으로 가기
		if(n==3) {
			if(dir==1) {
				int a =list.get(n).get(7);
				list.get(n).removeLast();
				list.get(n).addFirst(a);
			}else {
				int a =list.get(n).get(0);
				list.get(n).removeFirst();
				list.get(n).addLast(a);
			}
			return;
		}
		
		//시계 방향 회전
		if(dir==1) {
			//앞쪽 톱니 확인
			int pre = list.get(n).get(2);
			int nex = list.get(n+1).get(6);
			//같으면 대상 톱니만 회전
			if(pre==nex) {
				int a =list.get(n).get(7);
				list.get(n).removeLast();
				list.get(n).addFirst(a);
				return;
			}else {
				//다르면 둘 다 회전 회전 방향 반대
				int a =list.get(n).get(7);
				list.get(n).removeLast();
				list.get(n).addFirst(a);
				
				//다음 오른쪽 톱니로 진행**반대 방향
				rot_l(n+1, -1*dir);
			}
			
			
		}else {
			//반시계 방향 회전
			//앞쪽 톱니 확인
			int pre = list.get(n).get(2);
			int nex = list.get(n+1).get(6);
			//같으면 대상 톱니만 회전
			if(pre==nex) {
				int a =list.get(n).get(0);
				list.get(n).removeFirst();
				list.get(n).addLast(a);
				return;
			}else {
				//다르면 둘 다 회전 회전 방향 반대
				int a =list.get(n).get(0);
				list.get(n).removeFirst();
				list.get(n).addLast(a);
				
				//다음 오른쪽 톱니로 진행**반대 방향
				rot_l(n+1, -1*dir);
			}
		}
		
		
	}
	private static void rot_l(int n, int dir) {
		//왼쪽으로 가기
		if(n==0) {
			if(dir==1) {
				int a =list.get(n).get(7);
				list.get(n).removeLast();
				list.get(n).addFirst(a);
			}else {
				int a =list.get(n).get(0);
				list.get(n).removeFirst();
				list.get(n).addLast(a);
			}
			return;
		}
		
		//시계 방향 회전
		if(dir==1) {
			//뒤쪽 톱니 확인
			int nex = list.get(n).get(6);
			int pre = list.get(n-1).get(2);
			//같으면 대상 톱니만 회전
			if(pre==nex) {
				int a =list.get(n).get(7);
				list.get(n).removeLast();
				list.get(n).addFirst(a);
				return;
			}else {
				//다르면 둘 다 회전 회전 방향 반대
				int a =list.get(n).get(7);
				list.get(n).removeLast();
				list.get(n).addFirst(a);
				
				//다음 왼쪽 톱니로 진행**반대 방향
				rot_l(n-1, -1*dir);		
			}	
		}else {
			//반시계 방향 회전
			//뒤쪽 톱니 확인
			int nex = list.get(n).get(6);
			int pre = list.get(n-1).get(2);
			//같으면 대상 톱니만 회전
			if(pre==nex) {
				int a =list.get(n).get(0);
				list.get(n).removeFirst();
				list.get(n).addLast(a);
				return;
			}else {
				//다르면 둘 다 회전 회전 방향 반대
				int a =list.get(n).get(0);
				list.get(n).removeFirst();
				list.get(n).addLast(a);
				
				//다음 왼쪽 톱니로 진행**반대 방향
				rot_l(n-1, -1*dir);		
			}
		}
	}

}
