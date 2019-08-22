import java.io.*;
public class FileIO_FilterStream {

	public static void main(String[] args) throws IOException {
		
		/* *****************************
		 * Filter �� Buffer�� ��� �Բ� ��� �ϴ� ���!
		 * *****************************
		 */
		OutputStream Out = new FileOutputStream("C:\\Users\\dkdlx\\eclipse-workspace\\File_IO\\bin\\IO_Files\\Stringout.bin");
		BufferedOutputStream bOut = new BufferedOutputStream(Out);
		DataOutputStream DataFilterOut = new DataOutputStream(bOut);
		
		DataFilterOut.writeInt(275);
		DataFilterOut.writeDouble(45.79);
		
		DataFilterOut.close();
		
		InputStream In = new FileInputStream("C:\\Users\\dkdlx\\eclipse-workspace\\File_IO\\bin\\IO_Files\\Stringout.bin");
		BufferedInputStream bIn = new BufferedInputStream(In);
		DataInputStream DataFilterIn = new DataInputStream(bIn);
		
		int num5 = DataFilterIn.readInt();
		double num6 = DataFilterIn.readDouble();
	
		DataFilterIn.close();
		
		/* ****************
		 * Filter�� �ϴ� ���!!!
		 * ****************
		OutputStream Out = new FileOutputStream("C:\\Users\\dkdlx\\eclipse-workspace\\File_IO\\bin\\IO_Files\\Stringout.txt");
		DataOutputStream FilterOut = new DataOutputStream(Out);
		
		FilterOut.writeInt(275);
		FilterOut.writeDouble(45.79);
		
		InputStream In = new FileInputStream("C:\\Users\\dkdlx\\eclipse-workspace\\File_IO\\bin\\IO_Files\\Stringout.txt");
		DataInputStream FilterIn = new DataInputStream(In);
		
		int num1 = FilterIn.readInt();
		double num2 = FilterIn.readDouble();
		
		FilterIn.close();
		FilterOut.close();
		
		* ������ �����, ������� ���Ͽ� Int�� ������ Double�� �Ǽ��� �����ϰ� �ִ�.
		* �� ��, InputStream�� ����, ���ϳ��� �����͸� Int���¿� Double���·� �ҷ��� num1,2�� �����ϰ� ����ϰ� �ִ�.
		*/
		
		System.out.println(num5 +"  "+ num6);
	}

}
