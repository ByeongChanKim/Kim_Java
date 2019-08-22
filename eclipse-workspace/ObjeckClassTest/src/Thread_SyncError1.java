
import java.lang.Runtime;
class Increment {
	int num = 0;
	public void increment() {
		num++;
	}
	public int getNum() {
		return num;
	}
}

class IncThread extends Thread {
	Increment inc;
	
	public IncThread(Increment inc) {
		this.inc = inc;
	}
	
	public void run() {
		for(int i = 0; i<1;i++) {
			for(int j = 0; i<10;j++)
				inc.increment();
		}
	}
}

public class Thread_SyncError1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Chapter 23 , p681
		
		Increment inc = new Increment();
		IncThread inT1 = new IncThread(inc);
		//IncThread inT2 = new IncThread(inc);
		//IncThread inT3 = new IncThread(inc);
		
		inT1.start();
		System.out.println("Thread1 stared : " +Runtime.getRuntime().toString());
		System.out.println(inc.getNum());
		
		/*
		inT2.start();
		System.out.println("Thread2 stared");
		System.out.println(inc.getNum());
		
		inT3.start();
		System.out.println("Thread3 stared");
		System.out.println(inc.getNum());
		*/
		try {
			//inT1.join();
			inT1.sleep(1);
			System.out.println("T1 joined");
			
			/*inT2.join();
			System.out.println("T2 joined");
			inT3.join();
			System.out.println("T3 joined");
			*/
		}catch(InterruptedException e) {
			e.getStackTrace();
		}
		
		System.out.println(inc.getNum());
	}

}

/*
 * 오류가 짱만항요 실행이 되지 않습니다...
 */
