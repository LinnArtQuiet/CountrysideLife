package ui.father;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrameNext extends JFrame{

	public MyFrameNext() {
		
		setSize(355, 400);  //���ڴ�С
		setResizable(false);  //���ڴ�С���������
		setLocationRelativeTo(null);  //�������Ļ���ϽǾ���
		setLayout(new BorderLayout());
		setVisible(true);
	}
}
