import java.util.HashSet;
import java.util.Iterator;

public class Set_HashSet {
	
	public int hashCode() {
		return 1;
	}
	/*
	public boolean equals(Object o) {
		return true;
	}
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("첫번째");
		hs.add("두번째");
		hs.add("세번째");
		hs.add("네번째");
		
		Iterator itr = hs.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		Set_HashSet t = new Set_HashSet();
		Set_HashSet t2 = new Set_HashSet();
		
		System.out.println(t.hashCode());
		System.out.println(t2.hashCode());
		
		System.out.println(t.equals(t2));
		//인스턴스 참조값이 다르기 때문에 false 출력
	}

}
