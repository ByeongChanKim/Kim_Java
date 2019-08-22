class sum extends Thread {
	int num;
	public sum(int num) {
		this.num = num; 
	}
	public int add(int s, int e) {
		int start = s;
		int end = e;
		int result=num;
		for(int i = start;i<end+1;i++) {
			result+=i;
			try {
				sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}
	public void run(){
		int i = add(1,50);	
		int i2 = add(51,100);
		num = i+i2;
		System.out.println(num);
	}
}
public class Thread_Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sum s = new sum(0);
		s.start();
		try {
			s.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.num+1);
	}

}
