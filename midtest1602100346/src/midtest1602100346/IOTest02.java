package midtest1602100346;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest02 {
	public static void main(String[] args) throws IOException {
//���Ͽ� ����
		FileInputStream fis = new FileInputStream("d:\\a.png");
		FileOutputStream fos = new FileOutputStream("d:\\aa.png");
		while(true)
		{
			int i=fis.read();
			if(i==-1)break;
			fos.write(i);//����


		}
		fos.close();//�ݱ�	
			
			
				
		
		
//		// stream���
//		int data[] = { 97, 98, 99, 100, 101,13,10 };// a,b,c,d,e
//		char cdata[] = { 'h', 'e', 'l', 'l', 'o' };
//
//		FileOutputStream fis = new FileOutputStream("d:\\d.out.txt");
//		DataOutputStream dos = new DataOutputStream(fis);
//		for(int i=0;i<data.length;i++)
//		{
//			dos.write(data[i]);
//			
//			
//		}
//		for(int i=0;i<cdata.length;i++) {
//			dos.write(cdata[i]);
	


		
		
		
		// ������ ���ڷ��д´�
		// FileReader fr = new FileReader("d:\\a.txt");
		// while(true) {
		// int i=fr.read();
		// if(i==-1)break;
		// System.out.print((char)i);
		//
		// }

		// ������ ��Ʈ������ �д´�
		// FileInputStream fis = new FileInputStream("d:\\a.txt");
		// while(true) {
		// int i=fis.read();
		// if(i==-1)break;
		// System.out.print((char)i);
		// ������ ��Ʈ������ �д´�
	}
}

