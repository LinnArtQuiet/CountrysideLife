package ui.father;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame()
	{
		setTitle("CountrysideLife");  //窗口名称
		setSize(1067, 629);  //窗口大小
		setResizable(false);  //窗口大小不允许更改
		setLocationRelativeTo(null);  //相对于屏幕左上角居中
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //关闭窗口界面同时关闭程序
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
}
