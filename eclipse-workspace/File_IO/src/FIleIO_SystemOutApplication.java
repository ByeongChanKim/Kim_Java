import java.io.*;
public class FIleIO_SystemOutApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//OutputStream out = new FileOutputStream("println.txt");
		//FilterOutputStream pOut = new FilterOutputStream(out);
		
		PrintStream pS = new PrintStream("println.txt");
		pS.println("�̰���?");
		pS.close();
		//println.txt ���Ͽ� "�̰���?"�� �Էµ� �� ���̽� ����
	}

}
