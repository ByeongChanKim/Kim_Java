import java.util.Iterator;
import java.util.Comparator;
import java.util.TreeSet;

class StrLenComparator implements Comparator<String> {
	
	public int compare(String str1, String str2) {
		return str1.length() - str2.length();
	}
}

public class Set_TreeSet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeSet<String> ts = new TreeSet<String>();
		TreeSet<String> ts = new TreeSet<String>(new StrLenComparator());
		//TreeSet 생성자에 Comparator 인터페이스를 구현하는 인스턴스를 넣으면 compare메소드를 호출하여 정렬을 진행한다
		//안하면 위에 사전편찬순서로 정렬됨 ㅎㅎ
		ts.add("김병찬");
		ts.add("나는몇글자냐");
		ts.add("강감찬122223");
		ts.add("나는누구냐");
		ts.add("난누구냐");
		ts.add("가");
		ts.add("나다");
		ts.add("다라마");
		
		
		Iterator<String> itr = ts.descendingIterator();
		//ts.descendingIterator(); 이 메소드는 기존의 오름차순을 내림차순으로 변경해준다
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
