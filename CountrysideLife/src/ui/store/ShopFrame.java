package ui.store;

/**
 * @author ZYN
 * @updateTime 2019.12.15
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import Medium.Images;
import main.APP;
import ui.bag.BagFrame;

public class ShopFrame extends JFrame{
	public ShopFrame() {
		initGUI();
	}
	public void initGUI() {
		try {
		setSize(730, 550);  //窗口大小
		setResizable(false);  //窗口大小不允许更改
		setLocationRelativeTo(null);  //相对于屏幕左上角居中
		setLayout(new BorderLayout());
		setVisible(true);
		
		ImageIcon bg = Images.getImg("/image/uistore.png");  //写入图片地址
//		bg.setImage(bg.getImage().getScaledInstance(714,500, Image.SCALE_DEFAULT));
		
		JPanel jpanel = new JPanel();
		JLabel bottom = new JLabel();
		seedPanel seed = new  seedPanel();
		seed.setBackground(null);
		seed.setOpaque(false);
		
		foodPanel food = new foodPanel();
		food.setBackground(null);
		food.setOpaque(false);
	
		ImageIcon close=Images.getImg("/image/close.png");
		JButton button=new JButton(close);
		button.setBorderPainted(false);//不打印边框  
        button.setBorder(null);//除去边框  
        button.setFocusPainted(false);//除去焦点的框  
        button.setContentAreaFilled(false);//除去默认的背景填充
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
//		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p1.setOpaque(false);
		p2.setOpaque(false);
//		p3.setOpaque(false);
		p4.setOpaque(false);
		
		this.add(jpanel);
		jpanel.setLayout(new GridLayout(1,1));
		jpanel.add(bottom);
		bottom.setIcon(bg);
		
		//设置透明
//		jpanel.setBackground(null);
//		jpanel.setOpaque(false);
		
		//网络布局设置透明
		UIManager.put("TabbedPane.contentOpaque", false);
		JTabbedPane jtp = new JTabbedPane();
		
		bottom.setLayout(new BorderLayout(10,10));
		bottom.add(p1,BorderLayout.WEST);
		bottom.add(p2,BorderLayout.EAST);
//		bottom.add(p3,BorderLayout.SOUTH);
		bottom.add(p4,BorderLayout.NORTH);
		bottom.add(jtp,BorderLayout.CENTER);
		
		p4.setLayout(new BorderLayout());
		p4.add(button,BorderLayout.EAST);
		
		jtp.add("种子", seed);
		jtp.add("食物", food);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ShopFrame.this.dispose();
			}
		});
	}catch (Exception e) {
		e.printStackTrace();
	}
}}
