import java.math.*;
import java.util.Scanner;

public class BigDecimal_Bignteger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�Ǽ�1 : ");
		String d1 = scan.nextLine();
		//scan.nextLine();
		BigDecimal bci = new BigDecimal(d1); 
		
		System.out.print("�Ǽ�2 : ");
		String d2 = scan.nextLine();
		//scan.nextLine();
		BigDecimal bci2 = new BigDecimal(d2);
		
		System.out.println("���� �� : "+(bci.subtract(bci2)).abs());
		
	}

}
