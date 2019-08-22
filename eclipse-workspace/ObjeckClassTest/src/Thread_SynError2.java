class NewsPaper {
	String todayNews;
	boolean isTodayNews = false;
	
	public void setTodayNews(String news) {
		todayNews = news;
		isTodayNews = true;
		
		synchronized(this) {
			//notify(); ������ 1���� �����
			notifyAll(); //��ü �����带 ����� 
		}
	}
	
	public String getTodayNews() {
		if(isTodayNews == false) {	
			try {
				synchronized(this) {
				wait(); // ���� ������ ���� ���Ѳ�
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return todayNews;
	}
}

class NewsWriter extends Thread {
	NewsPaper nP;
	
	public NewsWriter(NewsPaper news) {
		nP = news;
	}
	public void run() {
		nP.setTodayNews("�̰��� �ڹ� �����Դϴ�.");
	}
}

class NewsReader extends Thread {
	NewsPaper nP;
	
	public NewsReader(NewsPaper news) {
		nP = news;
	}
	public void run() {
		System.out.println("������ ���� : " + nP.getTodayNews());
	}
}
public class Thread_SynError2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewsPaper news1 = new NewsPaper();
		
		NewsWriter nW = new NewsWriter(news1);
		NewsReader nR = new NewsReader(news1);
		NewsReader nR2 = new NewsReader(news1);
		
		nR.start();
		nR2.start();
		nW.start();

		try {
			nR.join();
			nW.join();
			nR2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
