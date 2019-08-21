import java.util.HashSet;
import java.util.Iterator;

class Person {
	String name;
	int age;
	
	public Person(String name , int age) {
		this.name =name;
		this.age =age;
	}
	public String toString() {
		return name+"("+age+"세)";
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age%100;
	}
	
	public boolean equals(Object o) {
		Person impl = (Person)o;
		if(impl.name.compareTo(name)==0 && this.age==impl.age)
			return true;
		else return false;
	}
}

public class Set_HashSet2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Person> hs = new HashSet<Person>();
		
		hs.add(new Person("이진호",10));
		hs.add(new Person("이진호",10));
		hs.add(new Person("이진호",20));
		hs.add(new Person("정형돈",15));
		hs.add(new Person("정형돈",30));
		hs.add(new Person("정형돈",30));
		
		System.out.println("HashSet에 저장된 데이터 수 : "+hs.size());
		
		Iterator itr = hs.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
