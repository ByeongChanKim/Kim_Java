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
	}//�̸� ���̷� ����! ���� ������ �̸��� ������ ��
	public void showData() {
		System.out.println(name+" "+age);
	}
	
}
public class Set_TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Per> ts = new TreeSet<Per>();
		
		ts.add(new Per("�躴��",23));
		ts.add(new Per("ȫ�浿",18));
		ts.add(new Per("������",35));
		ts.add(new Per("���´�����",20));
		ts.add(new Per("��������",21));
		
		Iterator<Per> itr = ts.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
	}

}
