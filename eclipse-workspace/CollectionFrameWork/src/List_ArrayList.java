import java.util.ArrayList;

public class List_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� 22-1(p617) Ǯ������ �ۼ�
		// ����뷮�� �ڵ����� �þ�� ArrayList������, �ݺ��Ǵ� ������ ���ʿ��� �� �ִ�.
		// ���� �뷮�� ó������ �����ϴ� ������ �غ���
		
		ArrayList<Integer> ary = new ArrayList<Integer>(500);
		//�뷮�� 500���� ����!
		System.out.println(ary);
		ary.ensureCapacity(1000);
		//�뷮�� 2��� ��������
		System.out.println(ary);
	}

}
