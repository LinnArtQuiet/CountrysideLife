package ui.bag;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import Medium.Images;
import main.APP;

public class BagFrame extends JFrame{
	
	
	public BagFrame() {
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setSize(410, 439);  //窗口大小
			setResizable(false);  //窗口大小不允许更改
			setLocationRelativeTo(null);  //相对于屏幕左上角居中
			setLayout(new BorderLayout());
			setVisible(true);
			
			ImageIcon bg = Images.getImg("/image/DialogFrame.png");  //写入图片地址
			JPanel jpanel = new JPanel();
			JLabel bottom = new JLabel();
			
			JButton button = new JButton("关闭");
			
			seedPanel seed = new seedPanel();
			seed.setBackground(null);
			seed.setOpaque(false);
			
			fruitPanel fruit = new  fruitPanel();
			fruit.setBackground(null);
			fruit.setOpaque(false);
			
			foodPanel food = new foodPanel();
			food.setBackground(null);
			food.setOpaque(false);
			
			UIManager.put("TabbedPane.contentOpaque", false);
			JTabbedPane jtp = new JTabbedPane();
			
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			p1.setOpaque(false);
			p2.setOpaque(false);
			p3.setOpaque(false);
			p4.setOpaque(false);
			
			this.add(jpanel);
			jpanel.setLayout(new GridLayout(1,1));
			jpanel.add(bottom);
			bottom.setIcon(bg);
			
			bottom.setLayout(new BorderLayout(10,10));
			bottom.add(p1,BorderLayout.WEST);
			bottom.add(p2,BorderLayout.EAST);
			bottom.add(p3,BorderLayout.SOUTH);
			bottom.add(p4,BorderLayout.NORTH);
			bottom.add(jtp,BorderLayout.CENTER);
			
			p4.setLayout(new BorderLayout());
			p4.add(button,BorderLayout.EAST);
			
			jtp.add("种子", seed);
			jtp.add("果实", fruit);
			jtp.add("食物", food);
			
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					BagFrame.this.dispose();
				}
			});
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
