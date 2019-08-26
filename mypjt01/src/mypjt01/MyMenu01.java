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
		mFile = new JMenu("����");
		mEdit = new JMenu("����");
		mHelp = new JMenu("����");
		abc =new JLabel("");
		
	
		

		miNew = new JMenuItem("����");
		miNew.addActionListener(this);// ����
		miNew.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		miOpen = new JMenuItem("����");
		miOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));
		miOpen.addActionListener(this);
		miSave = new JMenuItem("�����ϱ�");
		miSave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		miSave.addActionListener(this);
		miQuit = new JMenuItem("������");
		miQuit.setAccelerator(KeyStroke.getKeyStroke('Q', InputEvent.CTRL_MASK));
		miQuit.addActionListener(this);
		miCopy = new JMenuItem("�����ϱ�");
		miPaste = new JMenuItem("�ٿ��ֱ�");
		miCut = new JMenuItem("�ڸ���");
		miHelp = new JMenuItem("����");
		miHelp.addActionListener(this);
		open = new FileDialog(this, "�������翭��", FileDialog.LOAD);
		save = new FileDialog(this, "�������� ����", FileDialog.SAVE);
		// ����޴�
		mOut = new JMenu("����ϱ�");
		miPdf = new JMenuItem("PDF���");
		miPrinter = new JMenuItem("���������");
		// 2���� ����޴�
		miVer = new JMenuItem("����");
		miDir = new JMenuItem("������");
		masd = new JMenu("����");

		// �׼�
		miCalc = new JMenuItem("����");
		miCalc.addActionListener(this);
		miTime = new JMenuItem("�ð�");
		miTime.addActionListener(this);
		miCanvas = new JMenuItem("�׸���");
		miCanvas.addActionListener(this);

		ta = new JTextArea(5, 25);

	}

	void makeMenu()// �޴����� �ٿ� �ִ� �۾�����
	{
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mHelp);// �޴��ٿ� �޴��� �߰��Ѵ�
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

		setJMenuBar(mb);// �޴��ٸ� �����ӿ� �߰�

	}

	void display() {
		setTitle("���� �޴�");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(abc, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miQuit) { // ������
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
			// ��ȭ���ں�����
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
		setTitle("�������� ��ȭ����");
		
		
	}
}
