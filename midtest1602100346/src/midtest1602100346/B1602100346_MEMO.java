package midtest1602100346;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.FileInputStream;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class B1602100346_MEMO {

	public static void main(String[] args) {
		Menu02 ma = new Menu02();
		ma.display();
		ma.makeMenu();

	}

}

class Menu02 extends JFrame implements ActionListener {

	JMenuBar mb;
	JMenu mFile, mEdit, mHelp, miPaste;
	JMenuItem miNew, miOpen, migave, miQuit;
	JMenuItem miHelp, MiCopy, miCut, miCopy;
	JMenu mOut;
	JMenuItem myNum, myName;
	JMenuItem miCalc, miCanvas, masd;
	JTextArea ta;
	FileDialog open, save;
	JLabel Fighting;

	Menu02() {
		mb = new JMenuBar();
		open = new FileDialog(this, "12345", FileDialog.LOAD);
		save = new FileDialog(this, "12345", FileDialog.SAVE);
		mFile = new JMenu("FILE");

		mEdit = new JMenu("NOTICE");

		mHelp = new JMenu("Add");

		miNew = new JMenuItem("New");
		// ����
		miNew.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		miNew.addActionListener(this);
		miOpen = new JMenuItem("Open");
		miOpen.addActionListener(this);
		miOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));

		migave = new JMenuItem("SAVE");
		migave.addActionListener(this);
		migave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));

		miQuit = new JMenuItem("QUIT");
		miQuit.setAccelerator(KeyStroke.getKeyStroke('Q', InputEvent.CTRL_MASK));
		miQuit.addActionListener(this);

		miCopy = new JMenuItem("Notice");
		miCopy.addActionListener(this);

		miPaste = new JMenu("inFo");
		myNum = new JMenuItem("1602100346");
		myName = new JMenuItem("�̽�ö");

		// �׼�
		miCalc = new JMenuItem("Calc");
		miCalc.addActionListener(this);
		miCanvas = new JMenuItem("Paint");
		miCanvas.addActionListener(this);
		masd = new JMenuItem("QUiz");

		ta = new JTextArea(5, 25);

	}

	void makeMenu()// �޴����� �ٿ� �ִ� �۾�����
	{
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mHelp);// �޴��ٿ� �޴��� �߰��Ѵ�
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(migave);
		mFile.add(miQuit);
		mEdit.add(miCopy);
		mEdit.add(miPaste);

		miPaste.add(myNum);
		miPaste.add(myName);

		mHelp.add(miCalc);

		mHelp.add(miCanvas);
		mHelp.add(masd);
		add(ta);

		setJMenuBar(mb);// �޴��ٸ� �����ӿ� �߰�

	}

	void display() {
		setTitle("���� �޴�");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
			String fileName = open.getDirectory() + open.getFile();
			String File_text = "";
			try {
				FileInputStream fis = new FileInputStream(fileName);
				while (true) {
					int i = fis.read();
					if (i == -1)
						break;
					File_text += (char) i;

				}
			} catch (Exception i) {
				i.printStackTrace();
			}
			ta.setText(File_text);
		}
		if (e.getSource() == migave) {
			save.setVisible(true);
		}
		if (e.getSource() == miCopy) {

			MyHelp dial = new MyHelp();
			// ��ȭ���ں�����
		}
		if (e.getSource() == miCalc) {
			Calc cc = new Calc();
			cc.display();

		}
		if (e.getSource() == miNew) {
			ta.setText("");

		}
		if (e.getSource() == miCanvas) {

			MyDrawFrame md = new MyDrawFrame();
			md.display();

		}
	}

	class MyHelp extends JDialog {

		JLabel fig;

		MyHelp() {
			fig = new JLabel("FIGHTING");
			add(fig);

			setLayout(new FlowLayout());
			setVisible(true);
			setSize(200, 100);
			setTitle("FIGHTING");

		}
	}
}
