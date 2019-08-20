class MyClass {
	public <T> void simpleMethod(T param) {
		param.showData();
		System.out.println(param);
		//컴파일 오류가 나는 이유, 아마도 param에서 toString을 호출하는데, param에 toString이 없을 수도있어서ㅋㅋㅋㅋㅋㅋㅋ개소리임
		//오류나는 이유 : showData가 없잖아 ㅄ아, param에서 toString 호출은 Object클래스가 있기 때문에 문제 X
	}
}
public class Generics_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
