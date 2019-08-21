import java.util.*;

interface INIT_MENU {
	
	int INPUT=1, SEARCH=2, DELETE=3, SHOW=4, EXIT=5;
}

interface INPUT_SELECT {
	int NORMAL=1, UNIV=2, COMPANY=3;
}

class MenuChoiceException extends Exception {
	int wrongNum;
	public MenuChoiceException(int num) {
		super("잘못된 선택이 이뤄졌습니다.");
		wrongNum = num;
	}
	public void showWrongChoice() {
		System.out.println(wrongNum + "에 해당하는 선택은 존재하지 않습니다.");
	}
}

class PhoneInfo {
	String name;
	String phoneNum;
	
	public PhoneInfo(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	public void ShowInfo() {
		System.out.println("name : " + name);
		System.out.println("phoneNum : " + phoneNum);
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	public boolean equals(String name) {
		if(this.name.equals(name))
			return true;
		else return false;
	}
}

class PhoneUnivInfo extends PhoneInfo {
	String major;
	int year;
	
	public PhoneUnivInfo(String name, String num, String major, int year) {
		super(name,num);
		this.major=major;
		this.year=year;
	}
	
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("major : " + major);
		System.out.println("year : " + year);
	}
}

class PhoneCompanyInfo extends PhoneInfo {
	String company;
	
	public PhoneCompanyInfo(String name, String num, String company) {
		super(name,num);
		this.company=company;
	}
	
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("company : " + company);
	}
}

class PhoneBookManager {
	// int MAX_CNT=100;
	//PhoneInfo[] pInfo = new PhoneInfo[MAX_CNT];
	//int curCnt = 0;

	HashSet<PhoneInfo> hs = new HashSet<PhoneInfo>();

	//이해해야되는 점
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst() {
		if(inst == null)
			inst = new PhoneBookManager();
		return inst;
	}
	private PhoneInfo readFriendInfo() {
		System.out.println("이름 : ");
		String name = MenuViewer.scan.nextLine();
		System.out.println("전화번호 : ");
		String num = MenuViewer.scan.nextLine();
		return new PhoneInfo(name,num);
	}
	private PhoneInfo readUnivFriendInfo() {
		System.out.println("이름 : ");
		String name = MenuViewer.scan.nextLine();
		System.out.println("전화번호 : ");
		String num = MenuViewer.scan.nextLine();
		System.out.println("학과 : ");
		String major = MenuViewer.scan.nextLine();
		System.out.println("학년 : ");
		int year = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		return new PhoneUnivInfo(name,num,major,year);
	}
	private PhoneInfo readCompanyFriendInfo() {
		System.out.println("이름 : ");
		String name = MenuViewer.scan.nextLine();
		System.out.println("전화번호 : ");
		String num = MenuViewer.scan.nextLine();
		System.out.println("회사 : ");
		String company = MenuViewer.scan.nextLine();
		return new PhoneCompanyInfo(name,num,company);
	}
	
	public void inputData() throws MenuChoiceException {
		//예외를 던진다
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.println("선택>> ");
		int choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine(); // Enter를 씹어먹자 ㅎㅎ
		PhoneInfo info = null;
		
		if(choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY) {
			throw new MenuChoiceException(choice);
			//예외가 발생.
		}
		
		switch(choice) {
			case INPUT_SELECT.NORMAL :
				info = readFriendInfo();
				break;
			case INPUT_SELECT.UNIV : 
				info = readUnivFriendInfo();
				break;
			case INPUT_SELECT.COMPANY :
				info = readCompanyFriendInfo();
				break;
		}
		if(hs.contains(search(info.name))) {
			System.out.println("이미 저장된 데이터입니다.");
		} else {
			hs.add(info);
			System.out.println("데이터 입력이 완료되었습니다.");
		}
	}
	
	public void searchData() {
		System.out.println("데이터 검색을 시작합니다.");
		System.out.println("이름 : ");
		String name = MenuViewer.scan.nextLine();
		PhoneInfo searchInfo = search(name);
		if(searchInfo == null) {
			System.out.println("일치하는 데이터를 조회할 수 없습니다.");
		}
		else {
			System.out.println("데이터 조회를 완료했습니다.");
			//pInfo[compNum].ShowInfo();
			searchInfo.ShowInfo();
			
		}
	}
	
	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.println("이름 : ");
		String name = MenuViewer.scan.nextLine();
		PhoneInfo delInfo = search(name);
		if(delInfo == null)
			System.out.println("일치하는 데이터를 조회할 수 없습니다.");
		else {
			/*for(int i =compNum;i<curCnt;i++) {
				pInfo[compNum] = pInfo[compNum+1];		
			}
			curCnt--;
			System.out.println("데이터 삭제를 완료했습니다.");
			*/
			hs.remove(delInfo);
			System.out.println("데이터 삭제를 완료했습니다.");
		}
	}
	
	public void showInfoList() {
		Iterator<PhoneInfo> itr = hs.iterator();
		while(itr.hasNext()) {
			PhoneInfo impl = itr.next();
			impl.ShowInfo();
			System.out.println();
		}	
	}
	
	public PhoneInfo search(String compName) {
		/*for(int i = 0 ; i < curCnt; i++) {
			if(pInfo[i].name.compareTo(compName) == 0)
				return i;
		}
		return -1;
		*/
		Iterator<PhoneInfo> itr = hs.iterator();
		while(itr.hasNext()) {
			PhoneInfo implInfo = itr.next();
			if(implInfo.equals(compName))
				return implInfo;
		}
		return null;
	}
}

class MenuViewer {
	public static Scanner scan = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 데이터 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("선택 >> ");	
		
	}
}
public class PhoneBookVer06 {

	public static void main(String[] args) {
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		int choice;
		
		while(true) {
			try {
				MenuViewer.showMenu();
				choice=MenuViewer.scan.nextInt();
				MenuViewer.scan.nextLine();
				
				switch(choice) {
				case INIT_MENU.INPUT :
					manager.inputData();
					break;
				case INIT_MENU.SEARCH :
					manager.searchData();
					break;
				case INIT_MENU.DELETE :
					manager.deleteData();
					break;
				case INIT_MENU.SHOW :
					manager.showInfoList();
					break;
				case INIT_MENU.EXIT :
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
			catch(MenuChoiceException e) {
				e.showWrongChoice();
				e.printStackTrace();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
			}
		}

	}

}
