
public class Wrapper_Boxing {

	public static void main(String[] args) {
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		
		Integer i3 = Integer.valueOf(10);
		Integer i4 = Integer.valueOf(10);
		Integer i5 = i3;
		i3 = 20;
		//String�̶� �Ȱ��� ���� ������ ������ �ν��Ͻ��� �����Ѵ�!!
		
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		

		if(true) {
			System.out.println("������ �ν��Ͻ� ����");
		}else System.out.println("�ٸ� �ν��Ͻ� ����");
		
	}

}
