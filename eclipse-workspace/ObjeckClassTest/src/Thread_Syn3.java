import java.util.Scanner;
class IntComm {
	int num =0;
	boolean isNum = false;
	
	public int getNum() {
		if(isNum == false) {
			synchronized(this) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				notify();
				isNum=false;
			}
		}
		return num;
	}
	public void setNum(int num) {
		synchronized(this) {
			if(isNum == true) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			this.num = num;
			this.isNum = true;
		
			notify();
		}
	}
}
class Add_Num extends Thread {
	IntComm iC;
	int sum=0;
	public Add_Num(IntComm iC) {
		this.iC = iC;
	}
	public int Add() {
		for(int i = 0 ; i < 5; i++) {
			sum += iC.getNum();
		}
		return sum;
	}
	public void run() {
		sum = Add();
		System.out.println("5개 정수 합 : " + sum);
	}
}

public class Thread_Syn3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		IntComm iC = new IntComm();
		Add_Num aN = new Add_Num(iC);
		
		aN.start();
		System.out.println("정수 5개 ");
		for(int i=0; i<5;i++) {
			
			iC.setNum(scan.nextInt());
		}
		
		try {
			aN.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
