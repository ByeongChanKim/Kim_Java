import java.io.*;

public class FileIO_ByteFileCopy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream in;
		OutputStream out;
		try {
			in = new FileInputStream("C:\\Users\\dkdlx\\eclipse-workspace\\File_IO\\bin\\IO_Files\\cpyFile.txt");
			out = new FileOutputStream("C:\\Users\\dkdlx\\eclipse-workspace\\File_IO\\bin\\IO_Files\\\\cpiedFiled.txt");
			
			int copyByte = 0;
			int readLen;
			byte bData[]=new byte[1024*1024*2]; // 1KB
			long start = System.currentTimeMillis();
			while(true) {
				readLen=in.read(bData);
				if(readLen==-1)
					break;
				out.write(bData);
				copyByte++;
			}
			in.close();
			out.close();
			
			System.out.println("복사된 데이터의 크기 : "+copyByte);
			long end = System.currentTimeMillis();
			System.out.println("소요된 시간 : "+ (end-start));
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
	}
}
