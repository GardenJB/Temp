import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 이것도 그냥 구현하면 될 듯...
 */
public class BJ_P14891_톱니바퀴 {
	
	static LinkedList<LinkedList<Integer>> list;
	static int n, pre_l;
	
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
			n = Integer.parseInt(st.nextToken())-1;

			//회전 방향
			int dir = Integer.parseInt(st.nextToken());
			//***오른쪽 먼저 회전하면 왼쪽 돌 때 기존 값 필요
			pre_l = list.get(n).get(6);
			rot_r(n, dir);
			rot_l(n, dir);
		}
		
		int sum=0;
		//톱니바퀴 점수의 합 출력
		for(int i=0; i<4; i++) {
			sum += list.get(i).peek()==0 ? 0 : (int) Math.pow(2, i);
			//System.out.println(list.get(i).peek());
		}
	
		System.out.println(sum);
	}
	
	private static void rot_r(int n1, int dir) {
		//오른쪽으로 가기
		if(n1==3) {
			if(dir==1) {
				int a =list.get(n1).get(7);
				list.get(n1).removeLast();
				list.get(n1).addFirst(a);
				//System.out.println(list.get(n1).peek()+"   1");
			}else {
				int a =list.get(n1).get(0);
				list.get(n1).removeFirst();
				list.get(n1).addLast(a);
				//System.out.println(list.get(n1).peek()+"    2");
			}
			return;
		}
		
		//시계 방향 회전
		if(dir==1) {
			//앞쪽 톱니 확인
			int pre = list.get(n1).get(2);
			int nex = list.get(n1+1).get(6);
			//같으면 대상 톱니만 회전
			if(pre==nex) {
				int a =list.get(n1).get(7);
				list.get(n1).removeLast();
				list.get(n1).addFirst(a);
				//System.out.println(list.get(n1).peek()+"   3");
				return;
			}else {
				//다르면 둘 다 회전 회전 방향 반대
				int a =list.get(n1).get(7);
				list.get(n1).removeLast();
				list.get(n1).addFirst(a);
				//System.out.println(list.get(n1).peek()+"   4");
				//다음 오른쪽 톱니로 진행**반대 방향
				rot_r(n1+1, -1*dir);
			}
			
			
		}else {
			//반시계 방향 회전
			//앞쪽 톱니 확인
			int pre = list.get(n1).get(2);
			int nex = list.get(n1+1).get(6);
			//같으면 대상 톱니만 회전
			if(pre==nex) {
				int a =list.get(n1).get(0);
				list.get(n1).removeFirst();
				list.get(n1).addLast(a);
				//System.out.println(list.get(n1).peek()+"   5");
				return;
			}else {
				//다르면 둘 다 회전 회전 방향 반대
				int a =list.get(n1).get(0);
				list.get(n1).removeFirst();
				list.get(n1).addLast(a);
				//System.out.println(list.get(n1).peek()+"   6");
				//다음 오른쪽 톱니로 진행**반대 방향
				rot_r(n1+1, -1*dir);
			}
		}
		
		
	}
	//***대상 바퀴는 이미 오른쪽에서 회전 주의!!
	private static void rot_l(int n2, int dir) {
		//왼쪽으로 가기
		if(n2==0 && n2 !=n) {
			if(dir==1) {
				int a =list.get(n2).get(7);
				list.get(n2).removeLast();
				list.get(n2).addFirst(a);
				//System.out.println(list.get(n2).peek()+"   7");
			}else {
				int a =list.get(n2).get(0);
				list.get(n2).removeFirst();
				list.get(n2).addLast(a);
				//System.out.println(list.get(n2).peek()+"   8");
			}
			return;
		}else if(n2==0 && n2 == n) {
			return;
		}
		
		//시계 방향 회전
		if(dir==1) {
			//뒤쪽 톱니 확인
			int nex = n2==n? pre_l : list.get(n2).get(6);
			int pre = list.get(n2-1).get(2);
			//같으면 대상 톱니만 회전
			if(pre==nex) {
				if(n2 != n) {
					int a =list.get(n2).get(7);
					list.get(n2).removeLast();
					list.get(n2).addFirst(a);
					//System.out.println(list.get(n2).peek()+"   9");
				}
				return;
			}else {
				if(n2 !=n) {
					//다르면 둘 다 회전 회전 방향 반대
					int a =list.get(n2).get(7);
					list.get(n2).removeLast();
					list.get(n2).addFirst(a);
					//System.out.println(list.get(n2).peek()+"   10");
				}
				
				//다음 왼쪽 톱니로 진행**반대 방향
				rot_l(n2-1, -1*dir);		
			}	
		}else {
			//반시계 방향 회전
			//뒤쪽 톱니 확인
			int nex = n2==n? pre_l : list.get(n2).get(6);
			int pre = list.get(n2-1).get(2);
			//같으면 대상 톱니만 회전
			if(pre==nex) {
				if(n2 != n) {
					int a =list.get(n2).get(0);
					list.get(n2).removeFirst();
					list.get(n2).addLast(a);
					//System.out.println(list.get(n2).peek()+"   11");
				}
				
				return;
			}else {
				if(n2 !=n) {
					//다르면 둘 다 회전 회전 방향 반대
					int a =list.get(n2).get(0);
					list.get(n2).removeFirst();
					list.get(n2).addLast(a);
					//System.out.println(list.get(n2).peek()+"   12");
				}
				
				//다음 왼쪽 톱니로 진행**반대 방향
				rot_l(n2-1, -1*dir);		
			}
		}
	}

}
