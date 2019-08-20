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
		
		System.out.println("출력 1 : ");
		int i =0;
		while(itr.hasNext()) {
			String curStr=itr.next();
			System.out.println(curStr);
			if(curStr.compareTo("third")==0) {
				itr.remove();
			}
				System.out.println(list.get(2));
				System.out.println("나는 몇번나와야되냐");
		}
		/*
		 * iterator는 list의 값들을 조회하기 위해 쓰인다
		 * Iterator<T> itr = list.iterator() 를 통해 iterator()메소드가 호출되면, itr에 list의 값들이 마치 '복사'되듯이 들어간다고 생각해라
		 * 그리고 나서는 Iterator인터페이스에 있는 hasNext, next, remove만 이용하면되는거다.
		 * 처음 next를 했을 때는 첫번째 인스턴스가 들어가는거고,
		 * 값을 훑다가 remove를 하고 싶다면, 반드시 next 뒤에 와야되고 그걸 삭제하면 참조하는 인스턴스가 사라지는거다!
		 * 여기서는 third String 인스턴스가 삭제된다. 따라서 기존에 list에서 다시 호출할 수 없음 ㅎㅎ
		 * iterator의 다음은 복사되었기 때문에, 호출 가능 쭉 호출하고 마무으리
		 */
		
		System.out.println("출력 2 : ");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("출력 3 : ");
		itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
