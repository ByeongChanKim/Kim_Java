import java.io.*;
public class FileIO_FilterStream {

	public static void main(String[] args) throws IOException {
		
		/* *****************************
		 * Filter 와 Buffer를 모두 함께 사용 하는 경우!
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
		 * Filter만 하는 경우!!!
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
		
		* 파일을 만들고, 만들어진 파일에 Int형 정수와 Double형 실수를 저장하고 있다.
		* 그 후, InputStream를 통해, 파일내에 데이터를 Int형태와 Double형태로 불러와 num1,2에 저장하고 출력하고 있다.
		*/
		
		System.out.println(num5 +"  "+ num6);
	}

}
