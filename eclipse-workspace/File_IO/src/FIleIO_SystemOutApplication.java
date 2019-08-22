import java.io.*;
public class FIleIO_SystemOutApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//OutputStream out = new FileOutputStream("println.txt");
		//FilterOutputStream pOut = new FilterOutputStream(out);
		
		PrintStream pS = new PrintStream("println.txt");
		pS.println("이것은?");
		pS.close();
		//println.txt 파일에 "이것은?"이 입력됨 개 나이스 ㅅㅅ
	}

}
