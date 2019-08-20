class Person implements Cloneable {
	private String name;
	private int age;
	
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public void showPerson() {
		System.out.println("name : "+name);
		System.out.println("age : "+age);
	}
	public void reName(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Object clone() throws CloneNotSupportedException {
		Person pCpy = (Person)super.clone();
		//pCpy.name = new String(name);
		//pCpy.age = new Integer(pCpy.age);
		return pCpy;
	}
}
public class String_Deep_Copy {

	public static void main(String[] args) {
		Person per = new Person("kim",23);
		Person perCpy;
		try {
			perCpy = (Person)per.clone();
			per.showPerson();
			
			per.reName("Chan", 50);
			per.showPerson();
			perCpy.showPerson();
			
		}catch(CloneNotSupportedException e) {
			e.getStackTrace();
		}
	}

}
