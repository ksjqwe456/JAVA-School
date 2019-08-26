package midtest1602100346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOTest1 {
	public static void main(String[] args) throws IOException {

		// 문자단위로 데이터를 읽는다
		// 데이터를 버퍼에 넣고 한번에 읽는다.
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);// 2바이트 문자처리가능
		BufferedReader br = new BufferedReader(isr);// 버퍼에 데이타 저장
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

		// 자바 1바이트 단위로 읽고쓰기
		// while(true) {
		// InputStream is = System.in;//스트림을 통한 입력
		// int a = is.read();
		// if((a==13)||(a==10))break;
		// System.out.println((char)a);

		// 자바의 표준입출력을 이용한것
		// while(true) {
		// int a = System.in.read();//자바 표준입력
		// if((a==13)||(a==10)) break;//개행제어 엔터값
		// System.out.write(a);// a out 은 표준 출력
		// System.out.println(a);// 97
		// }
		// }
	}
}
