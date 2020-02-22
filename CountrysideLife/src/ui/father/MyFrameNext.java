package ui.father;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrameNext extends JFrame{

	public MyFrameNext() {
		
		setSize(355, 400);  //窗口大小
		setResizable(false);  //窗口大小不允许更改
		setLocationRelativeTo(null);  //相对于屏幕左上角居中
		setLayout(new BorderLayout());
		setVisible(true);
	}
}
