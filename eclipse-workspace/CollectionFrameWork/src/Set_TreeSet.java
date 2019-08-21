import java.util.Iterator;
import java.util.TreeSet;

class Per implements Comparable<Per> {
	String name;
	int age;
	
	public Per(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Per p) {
		if(this.name.length()==p.name.length())
			return 0;
		else if(this.name.length()>p.name.length())
			return 1;
		else return -1;
		/*
		 * return this.name.length() - p.name.lenght();
		 */
	}//이름 길이로 정렬! 같은 길이의 이름은 씹힌다 ㅎ
	public void showData() {
		System.out.println(name+" "+age);
	}
	
}
public class Set_TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Per> ts = new TreeSet<Per>();
		
		ts.add(new Per("김병찬",23));
		ts.add(new Per("홍길동",18));
		ts.add(new Per("강감찬",35));
		ts.add(new Per("나는누구냐",20));
		ts.add(new Per("난누구냐",21));
		
		Iterator<Per> itr = ts.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
	}

}
