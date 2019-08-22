import java.io.*;

public class FileIO_ByteBuffedFileCopy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		InputStream in;
		OutputStream out;
		try {
			in = new FileInputStream("C:\\Users\\dkdlx\\eclipse-workspace\\File_IO\\bin\\IO_Files\\cpyFile.txt");
			out = new FileOutputStream("C:\\Users\\dkdlx\\eclipse-workspace\\File_IO\\bin\\IO_Files\\\\cpiedFiled.txt");
			
			BufferedInputStream bIn = new BufferedInputStream(in,1024*1024*2); // ������ : 2MB / ���� 4MB
			BufferedOutputStream bOut = new BufferedOutputStream(out,1024*1024*2);
			int copyByte = 0;
			int readLen;
			
			long start1 = System.currentTimeMillis();
			while(true) {
				readLen=bIn.read();
				if(readLen==-1)
					break;
				bOut.write(readLen);
				copyByte++;
			}
			bIn.close();
			bOut.close();
			
			System.out.println("����� �������� ũ�� : "+(copyByte/(1024*1024*2)));
			long end = System.currentTimeMillis();
			System.out.println("�ҿ�� �ð� : "+ (end-start1));
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
	}
}
