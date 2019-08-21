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
		//TreeSet �����ڿ� Comparator �������̽��� �����ϴ� �ν��Ͻ��� ������ compare�޼ҵ带 ȣ���Ͽ� ������ �����Ѵ�
		//���ϸ� ���� �������������� ���ĵ� ����
		ts.add("�躴��");
		ts.add("���¸���ڳ�");
		ts.add("������122223");
		ts.add("���´�����");
		ts.add("��������");
		ts.add("��");
		ts.add("����");
		ts.add("�ٶ�");
		
		
		Iterator<String> itr = ts.descendingIterator();
		//ts.descendingIterator(); �� �޼ҵ�� ������ ���������� ������������ �������ش�
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
