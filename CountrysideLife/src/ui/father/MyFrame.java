package ui.father;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame()
	{
		setTitle("CountrysideLife");  //��������
		setSize(1067, 629);  //���ڴ�С
		setResizable(false);  //���ڴ�С���������
		setLocationRelativeTo(null);  //�������Ļ���ϽǾ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //�رմ��ڽ���ͬʱ�رճ���
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
}
