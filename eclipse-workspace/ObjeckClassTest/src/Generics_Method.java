class MyClass {
	public <T> void simpleMethod(T param) {
		param.showData();
		System.out.println(param);
		//������ ������ ���� ����, �Ƹ��� param���� toString�� ȣ���ϴµ�, param�� toString�� ���� �����־�����������������Ҹ���
		//�������� ���� : showData�� ���ݾ� ����, param���� toString ȣ���� ObjectŬ������ �ֱ� ������ ���� X
	}
}
public class Generics_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
