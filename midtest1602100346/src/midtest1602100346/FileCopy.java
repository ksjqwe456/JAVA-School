package midtest1602100346;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Ȯ���ڸ� ������ ���������� �Է��ϼ���");
		Scanner s = new Scanner(System.in);
		String source = s.next();

		System.out.println("���������� �����̸��� �Է��ϼ���");
		Scanner t = new Scanner(System.in);
		String target = t.next();
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos = new FileOutputStream(target);
		while(true) {
			int i= fis.read();
			if(i==-1)break;
			fos.write(i);
		}
		
	}

}
