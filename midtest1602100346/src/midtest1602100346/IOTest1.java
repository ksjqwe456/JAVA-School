package midtest1602100346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOTest1 {
	public static void main(String[] args) throws IOException {

		// ���ڴ����� �����͸� �д´�
		// �����͸� ���ۿ� �ְ� �ѹ��� �д´�.
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);// 2����Ʈ ����ó������
		BufferedReader br = new BufferedReader(isr);// ���ۿ� ����Ÿ ����
		String s = br.readLine();
		System.out.println(s);

		//
		// while(true) {
		// int a=isr.read();
		// if((a==13)||(a==10));
		//
		// System.out.print(a);
		//
		// }

		// �ڹ� 1����Ʈ ������ �а���
		// while(true) {
		// InputStream is = System.in;//��Ʈ���� ���� �Է�
		// int a = is.read();
		// if((a==13)||(a==10))break;
		// System.out.println((char)a);

		// �ڹ��� ǥ��������� �̿��Ѱ�
		// while(true) {
		// int a = System.in.read();//�ڹ� ǥ���Է�
		// if((a==13)||(a==10)) break;//�������� ���Ͱ�
		// System.out.write(a);// a out �� ǥ�� ���
		// System.out.println(a);// 97
		// }
		// }
	}
}
