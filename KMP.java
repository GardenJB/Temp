package d0414;

public class KMP {
	public static void main(String[] args) {
		String text = "ABABABACABABABACACA";
		String patter = "ABABACA";
		
		
	}

	
	// 실패 테이블
	public static int[] getPi(String pt) {
		int[]pi = new int[pt.length()];
		
		int j=0;
		
		for(int i=1; i<pt.length(); i++) {
			while(j>0 && pt.charAt(i) != pt.charAt(j)) {
				j=pi[j-1];
			}
			if(pt.charAt(i) == pt.charAt(j)) {
				pi[i]=++j;
			}
		}
		return pi;
	}
	
	public void kmp(String text, String pt) {
		int[] pi = getPi(pt);
		
		int j=0;
		for(int i=0; i<text.length(); i++) {
			while(j>0 && text.charAt(i) != pt.charAt(j)) {
				j=pi[j-1];
			}
			if(text.charAt(i) == pt.charAt(j)) {
				if(j==pt.length()-1) {
					System.out.println("찾");
					j=pi[j];
				}else {
					j++;
				}
			}
		}
		
	}

}
