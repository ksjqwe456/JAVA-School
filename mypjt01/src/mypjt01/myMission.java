package mypjt01;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class myMission {
	   public static void main(String[] args) {
	      
	      
	              
	      Mission m1 = new Mission();
	      m1.display();
	      m1.makeMenu();
	   }
	}

	class Mission extends JFrame {
	   
	   JMenuBar mb;
	   
	   JMenu mFile, mEdit, mOper, mView, mHelp;
	   JMenuItem miNew, miOpen, miDown, miADown, miPageset, miPrint, miQuit;
	   JMenuItem miUndo, miCut, miCopy, miPaste, miDel, miFind, miNFind, miChange, miMove, miAlSel, miDate;
	   JMenuItem miNextLine, miGol;
	   JMenuItem miState;
	   JMenuItem miHelp,miInfo;
	   

	   JTextField tf;
	   
	   
	   
	   Mission(){
	      mb = new JMenuBar();
	      mFile = new JMenu("����");
	      mEdit = new JMenu("����");
	      mOper = new JMenu("����");
	      mView = new JMenu("����");
	      mHelp = new JMenu("����");
	      miNew = new JMenuItem("���θ����");
	      miOpen = new JMenuItem("����");
	      miDown = new JMenuItem("����");
	      miADown = new JMenuItem("�ٸ��̸����� ����");
	      miPageset = new JMenuItem("����������");
	      miPrint = new JMenuItem("�μ�");
	      miQuit = new JMenuItem("������");
	      miUndo = new JMenuItem("�������");
	      miCut = new JMenuItem("�߶󳻱�");
	      miCopy = new JMenuItem("����");
	      miPaste = new JMenuItem("�ٿ��ֱ�");
	      miDel = new JMenuItem("����");
	      miFind = new JMenuItem("ã��");
	      miNFind = new JMenuItem("����ã��");
	      miChange = new JMenuItem("�ٲٱ�");
	      miMove = new JMenuItem("�̵�");
	      miAlSel = new JMenuItem("��ü����");
	      miDate = new JMenuItem("�ð�/��¥");
	      miNextLine = new JMenuItem("�ڵ��ٹٲ�");
	      miGol = new JMenuItem("�۲�");
	      miState = new JMenuItem("����ǥ����");
	      miHelp = new JMenuItem("���򸻺���");
	      miInfo = new JMenuItem("�޸�������");
	      
	      setJMenuBar(mb);
	      
	      tf = new JTextField();
	      add(tf);    
	   }

	  
	   void makeMenu(){
	      mb.add(mFile);
	      mb.add(mEdit);
	      mb.add(mOper);
	      mb.add(mView);
	      mb.add(mHelp);
	      
	      mFile.add(miNew);
	      miNew.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
	      mFile.setMnemonic(KeyEvent.VK_F);
	      mFile.add(miOpen);
	      miOpen.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
	     
	      
	     
	      miDown.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
	     
	      mFile.addSeparator();
	      mFile.add(miPageset);
	      mFile.add(miPrint);
	      miPrint.setAccelerator(KeyStroke.getKeyStroke('P',InputEvent.CTRL_MASK));
	      mFile.addSeparator();
	      mFile.add(miQuit);
	   
	      mEdit.add(miUndo);
	      miUndo.setEnabled(false);
	      miUndo.setAccelerator(KeyStroke.getKeyStroke('Z',InputEvent.CTRL_MASK));
	      mEdit.setMnemonic(KeyEvent.VK_Z);
	      mEdit.addSeparator();
	      mEdit.add(miCut);
	      miCut.setEnabled(false);
	      miCut.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
	      mEdit.add(miCopy);
	      miCopy.setEnabled(false);
	      miCopy.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_MASK));
	      mEdit.add(miPaste);
	      miPaste.setAccelerator(KeyStroke.getKeyStroke('V',InputEvent.CTRL_MASK));
	      mEdit.add(miDel);
	      miDel.setEnabled(false);
	      miDel.setAccelerator(KeyStroke.getKeyStroke('D',InputEvent.BUTTON1_MASK));
	      mEdit.addSeparator();
	      mEdit.add(miFind);
	      miFind.setEnabled(false);
	      miFind.setAccelerator(KeyStroke.getKeyStroke('F',InputEvent.CTRL_MASK));
	      mEdit.add(miNFind);
	      miNFind.setEnabled(false);
	      mEdit.add(miChange);
	      miChange.setAccelerator(KeyStroke.getKeyStroke('H',InputEvent.CTRL_MASK));
	      mEdit.add(miMove);
	      miMove.setEnabled(false);
	      miMove.setAccelerator(KeyStroke.getKeyStroke('G',InputEvent.CTRL_MASK));
	      mEdit.addSeparator();
	      mEdit.add(miAlSel);
	      miAlSel.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.CTRL_MASK));
	      mEdit.add(miDate);

	      mOper.add(miNextLine);

	      mOper.add(miGol);

	      
	      mView.add(miState);
	      miState.setEnabled(false);

	      
	      mHelp.add(miHelp);

	      mHelp.add(miInfo);
	      miInfo.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.BUTTON1_MASK));
	      
	   }
	   

	   
	   void display() {
	      
	      Toolkit kit = Toolkit.getDefaultToolkit();
	      Image img = kit.getImage("C:\\Users\\GG201305000009\\Desktop\\grim.jpg");
	              setIconImage(img);
	      
	      setResizable(false);
	      setSize(600,400);
	      setVisible(true);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setTitle("MEMO1");
	   }
	}
