class NewsPaper {
	String todayNews;
	boolean isTodayNews = false;
	
	public void setTodayNews(String news) {
		todayNews = news;
		isTodayNews = true;
		
		synchronized(this) {
			//notify(); 쓰레드 1개만 깨운다
			notifyAll(); //전체 쓰레드를 깨운다 
		}
	}
	
	public String getTodayNews() {
		if(isTodayNews == false) {	
			try {
				synchronized(this) {
				wait(); // 뉴스 없으면 눕방 개ㅡ꿀
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
		nP.setTodayNews("이것은 자바 뉴스입니다.");
	}
}

class NewsReader extends Thread {
	NewsPaper nP;
	
	public NewsReader(NewsPaper news) {
		nP = news;
	}
	public void run() {
		System.out.println("오늘의 뉴스 : " + nP.getTodayNews());
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
