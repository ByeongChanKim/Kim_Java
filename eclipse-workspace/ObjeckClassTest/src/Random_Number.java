import java.util.Random;

public class Random_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		System.out.println((rand.ints(10,1, 5)));
		rand.ints(10,-2, 10).forEach(System.out::println);
		//¿Í¿ì...
	}

}
