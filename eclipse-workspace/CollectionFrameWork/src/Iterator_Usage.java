import java.util.Iterator;
import java.util.LinkedList;
public class Iterator_Usage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");

		Iterator<String> itr = list.iterator();
		
		System.out.println("��� 1 : ");
		int i =0;
		while(itr.hasNext()) {
			String curStr=itr.next();
			System.out.println(curStr);
			if(curStr.compareTo("third")==0) {
				itr.remove();
			}
				System.out.println(list.get(2));
				System.out.println("���� ������;ߵǳ�");
		}
		/*
		 * iterator�� list�� ������ ��ȸ�ϱ� ���� ���δ�
		 * Iterator<T> itr = list.iterator() �� ���� iterator()�޼ҵ尡 ȣ��Ǹ�, itr�� list�� ������ ��ġ '����'�ǵ��� ���ٰ� �����ض�
		 * �׸��� ������ Iterator�������̽��� �ִ� hasNext, next, remove�� �̿��ϸ�Ǵ°Ŵ�.
		 * ó�� next�� ���� ���� ù��° �ν��Ͻ��� ���°Ű�,
		 * ���� �ȴٰ� remove�� �ϰ� �ʹٸ�, �ݵ�� next �ڿ� �;ߵǰ� �װ� �����ϸ� �����ϴ� �ν��Ͻ��� ������°Ŵ�!
		 * ���⼭�� third String �ν��Ͻ��� �����ȴ�. ���� ������ list���� �ٽ� ȣ���� �� ���� ����
		 * iterator�� ������ ����Ǿ��� ������, ȣ�� ���� �� ȣ���ϰ� ��������
		 */
		
		System.out.println("��� 2 : ");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("��� 3 : ");
		itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
