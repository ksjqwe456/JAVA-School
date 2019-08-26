package mypjt01;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MyMenu01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu01 me = new Menu01();
		me.display();
		me.makeMenu();

	}

}

class Menu01 extends JFrame implements ActionListener {

	JMenuBar mb;
	JMenu mFile, mEdit, mHelp;
	JMenuItem miNew, miOpen, miSave, miQuit;
	JMenuItem miHelp, MiCopy, miPaste, miCut, miCopy;
	JMenu mOut, masd;
	JMenuItem miPdf, miPrinter, miVer, miDir;
	JMenuItem miCalc, miCanvas,miTime;
	JTextArea ta;
	FileDialog open, save;
	JLabel abc;

	Menu01() {
		mb = new JMenuBar();   
		mFile = new JMenu("파일");
		mEdit = new JMenu("편집");
		mHelp = new JMenu("도움말");
		abc =new JLabel("");
		
	
		

		miNew = new JMenuItem("새글");
		miNew.addActionListener(this);// 새글
		miNew.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		miOpen = new JMenuItem("열기");
		miOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));
		miOpen.addActionListener(this);
		miSave = new JMenuItem("저장하기");
		miSave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		miSave.addActionListener(this);
		miQuit = new JMenuItem("나가기");
		miQuit.setAccelerator(KeyStroke.getKeyStroke('Q', InputEvent.CTRL_MASK));
		miQuit.addActionListener(this);
		miCopy = new JMenuItem("복사하기");
		miPaste = new JMenuItem("붙여넣기");
		miCut = new JMenuItem("자르기");
		miHelp = new JMenuItem("도움말");
		miHelp.addActionListener(this);
		open = new FileDialog(this, "내가만든열기", FileDialog.LOAD);
		save = new FileDialog(this, "내가만든 저장", FileDialog.SAVE);
		// 서브메뉴
		mOut = new JMenu("출력하기");
		miPdf = new JMenuItem("PDF출력");
		miPrinter = new JMenuItem("프린터출력");
		// 2번쨰 서브메뉴
		miVer = new JMenuItem("버전");
		miDir = new JMenuItem("만든이");
		masd = new JMenu("정보");

		// 액션
		miCalc = new JMenuItem("계산기");
		miCalc.addActionListener(this);
		miTime = new JMenuItem("시간");
		miTime.addActionListener(this);
		miCanvas = new JMenuItem("그림판");
		miCanvas.addActionListener(this);

		ta = new JTextArea(5, 25);

	}

	void makeMenu()// 메뉴들을 붙여 넣는 작업정의
	{
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mHelp);// 메뉴바에 메뉴를 추가한다
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miQuit);
		mEdit.add(miCopy);
		mEdit.add(miPaste);
		mFile.add(mOut);
		mOut.add(miPdf);
		mOut.add(miPrinter);

		mEdit.add(miCut);
		mHelp.add(miHelp);
		masd.add(miDir);
		masd.add(miVer);
		mHelp.add(masd);
		mHelp.add(miCalc);
		mHelp.add(miCanvas);
		mHelp.add(miTime);
		add(ta);
		add(abc);

		setJMenuBar(mb);// 메뉴바를 프레임에 추가

	}

	void display() {
		setTitle("나의 메뉴");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(abc, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miQuit) { // 나가기
			System.exit(0);
		}
		// TODO Auto-generated method stub

		if (e.getSource() == miNew) {
			ta.setText("");

		}
		if (e.getSource() == miOpen) {
			open.setVisible(true);
		}
		if (e.getSource() == miSave) {
			save.setVisible(true);
		}
		if (e.getSource() == miHelp) {
			
			MyHelp dial = new MyHelp();
			// 대화상자보여줌
		}
		if(e.getSource()==miCanvas) {
			
			MyDrawFrame md = new MyDrawFrame();
			md.display();
		}
		if(e.getSource()==miCalc) {
			Calc cc = new Calc();
			cc.display();
	
			
		}
		if(e.getSource()==miTime) {
			
			MycountDown1 mf = new MycountDown1();
			mf.display();
		}
		if(e.getSource()==abc) {
			
			MycountDown1 mf = new MycountDown1();
			mf.display();
		}
	}
}

class MyHelp extends JDialog {
	
	
	JButton btn;
	MyHelp()
	{
		btn= new JButton("Close");
		add(btn);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				
			}
			
		});
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(200,100);
		setTitle("내가만든 대화상자");
		
		
	}
}
