
public class Wrapper_Boxing {

	public static void main(String[] args) {
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		
		Integer i3 = Integer.valueOf(10);
		Integer i4 = Integer.valueOf(10);
		Integer i5 = i3;
		i3 = 20;
		//String이랑 똑같이 값이 같으면 동일한 인스턴스를 참조한다!!
		
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		

		if(true) {
			System.out.println("동일한 인스턴스 참조");
		}else System.out.println("다른 인스턴스 참조");
		
	}

}
