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
		super("�߸��� ������ �̷������ϴ�.");
		wrongNum = num;
	}
	public void showWrongChoice() {
		System.out.println(wrongNum + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
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

	//�����ؾߵǴ� ��
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst() {
		if(inst == null)
			inst = new PhoneBookManager();
		return inst;
	}
	private PhoneInfo readFriendInfo() {
		System.out.println("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String num = MenuViewer.scan.nextLine();
		return new PhoneInfo(name,num);
	}
	private PhoneInfo readUnivFriendInfo() {
		System.out.println("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String num = MenuViewer.scan.nextLine();
		System.out.println("�а� : ");
		String major = MenuViewer.scan.nextLine();
		System.out.println("�г� : ");
		int year = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		return new PhoneUnivInfo(name,num,major,year);
	}
	private PhoneInfo readCompanyFriendInfo() {
		System.out.println("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String num = MenuViewer.scan.nextLine();
		System.out.println("ȸ�� : ");
		String company = MenuViewer.scan.nextLine();
		return new PhoneCompanyInfo(name,num,company);
	}
	
	public void inputData() throws MenuChoiceException {
		//���ܸ� ������
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		System.out.println("����>> ");
		int choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine(); // Enter�� �þ���� ����
		PhoneInfo info = null;
		
		if(choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY) {
			throw new MenuChoiceException(choice);
			//���ܰ� �߻�.
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
			System.out.println("�̹� ����� �������Դϴ�.");
		} else {
			hs.add(info);
			System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	public void searchData() {
		System.out.println("������ �˻��� �����մϴ�.");
		System.out.println("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		PhoneInfo searchInfo = search(name);
		if(searchInfo == null) {
			System.out.println("��ġ�ϴ� �����͸� ��ȸ�� �� �����ϴ�.");
		}
		else {
			System.out.println("������ ��ȸ�� �Ϸ��߽��ϴ�.");
			//pInfo[compNum].ShowInfo();
			searchInfo.ShowInfo();
			
		}
	}
	
	public void deleteData() {
		System.out.println("������ ������ �����մϴ�.");
		System.out.println("�̸� : ");
		String name = MenuViewer.scan.nextLine();
		PhoneInfo delInfo = search(name);
		if(delInfo == null)
			System.out.println("��ġ�ϴ� �����͸� ��ȸ�� �� �����ϴ�.");
		else {
			/*for(int i =compNum;i<curCnt;i++) {
				pInfo[compNum] = pInfo[compNum+1];		
			}
			curCnt--;
			System.out.println("������ ������ �Ϸ��߽��ϴ�.");
			*/
			hs.remove(delInfo);
			System.out.println("������ ������ �Ϸ��߽��ϴ�.");
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
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ������ ���");
		System.out.println("5. ���α׷� ����");
		System.out.println("���� >> ");	
		
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
					System.out.println("���α׷��� �����մϴ�.");
					return;
				}
			}
			catch(MenuChoiceException e) {
				e.showWrongChoice();
				e.printStackTrace();
				System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.\n");
			}
		}

	}

}
