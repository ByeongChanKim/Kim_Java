import java.util.ArrayList;

public class List_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문제 22-1(p617) 풀기위해 작성
		// 저장용량이 자동으로 늘어나는 ArrayList이지만, 반복되는 연산이 불필요할 수 있다.
		// 따라서 용량을 처음부터 설정하는 연습을 해보자
		
		ArrayList<Integer> ary = new ArrayList<Integer>(500);
		//용량을 500개로 설정!
		System.out.println(ary);
		ary.ensureCapacity(1000);
		//용량을 2배로 증가시켜
		System.out.println(ary);
	}

}
