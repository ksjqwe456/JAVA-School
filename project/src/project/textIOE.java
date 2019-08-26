package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 class Recordg  {
	String a;
	int b;
	Recordg(){
		
	}
	
	Recordg(String a,int b)
	{
		this.a=a;
		this.b=b;
		
	}
}

public class textIOE {

	public Recordg[] nums2;
	public Recordg[] nums;

	textIOE() {
		// public static void main(String[] args) {
		nums = new Recordg[5];
		nums2 = new Recordg[5];
		for (int i = 0; i < 5; i++) {
			nums[i] = new Recordg("**", 0);
			nums[i].a="**";
		}
		for (int i = 0; i < 5; i++) {
			nums2[i] = new Recordg("**", 0);
		}

		try {

			// ArrayList<Integer> a = new ArrayList<Integer>();
			//Recordg[] nums = new Recordg[5];

			// 파일 객체 생성
			File file = new File("d:\\nums.txt");
			// 입력 스트림 생성
			FileReader filereader = new FileReader("d:\\nums.txt");
			BufferedReader br = new BufferedReader(filereader);

			String s = "";
			int x = 0;int k=0;
			while ((s = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s, " ");
				if (x % 2 == 0) {
					nums[k].a = s;

				}
				if (x % 2 == 1) {
					while(st.hasMoreTokens()) {
					nums[k].b = Integer.parseInt(st.nextToken());
					}
					k++;
				}
				x++;
				
			}

			//br.close();
			// Arrays.sort(list, comparator.reversed());

			// int num[] = {55,10,60};
			// Arrays.sort(nums,Collections.reverseOrder());

			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i].b < nums[j].b) {
						Recordg temp = nums[j];
						nums[j] = nums[i];
						nums[i] = temp;
					} else {
						break;
					}
				}

			}
			for (int i = 0; i < nums.length; i++) {
				nums2[i] = nums[i];
				System.out.println(nums[i].a+nums[i].b);
			}

			// System.out.println("check:"+nums[0]+"1");

			
			filereader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {

		}

	
	}

	
	void textIOE2(String name ,int scored){
		for(int i=0; i<nums2.length;i++){
			if(nums2[i].b<scored) {   String d=nums2[i].a;int d2=nums2[i].b;    nums2[i].a=name; nums2[i].b=scored; 
			for(int j=0;j<4-i;j++){
			if(j==0) {nums2[i+1+j].a=d;nums2[i+1+j].b=d2;}
			else	
			{nums2[i+1+j]=nums2[i+j];}
			}
			i=2900;
			}
			
			
		}
		for(int i=0; i<nums2.length;i++){
			System.out.println(nums2[i].a+nums2[i].b+" ");
			
			
		}
		
		
		
		try {

			// BufferedWriter out = new BufferedWriter(new FileWriter("d:\\d.out.txt"));
			OutputStream output = new FileOutputStream("d:\\nums.txt");
			PrintWriter pw = new PrintWriter(output);
			// String[] str = new String[num.length];
			byte[] by = new byte[150];

			for (int i = 0; i < nums.length; i++) {

				// str[i] = num[i] + "";
				// by= str[i].getBytes();
				pw.print(nums2[i].a + "\r\n");
				pw.print(nums2[i].b + "\r\n");
				pw.flush();

			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}

}
