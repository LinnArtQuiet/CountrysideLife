package ui.bed;
/**
 * @author ZYN
 * @updateTime 2019/12/13
 */
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Medium.Images;
import main.APP;
import ui.father.MyFrame;
import user.User;


public class MainRoom extends MyFrame{
	
	//主界面房子添加JButton,添加监听(button.addActionListener(new ActionListener())
	JButton jb1=new JButton();
	JButton jb2=new JButton();
	JLabel sleep=new JLabel();
	public MainRoom() {
		
		
		setTitle("田园小舍");
		
		ImageIcon bg=Images.getImg("/image/bedroom.png");  //写入图片地址
		bg.setImage(bg.getImage().getScaledInstance(1067,600, Image.SCALE_DEFAULT));
		ImageIcon sleeppic=Images.getImg("/image/evening.png");  //写入睡觉图片地址
		sleeppic.setImage(sleeppic.getImage().getScaledInstance(151,146, Image.SCALE_DEFAULT));
		ImageIcon uppic=Images.getImg("/image/day.png");  //写入醒着图片地址
		sleeppic.setImage(sleeppic.getImage().getScaledInstance(151,146, Image.SCALE_DEFAULT));
		
		JPanel jpanel=new JPanel();
		jpanel.setOpaque(false);
		this.add(jpanel);
		
		JLabel background= new JLabel();//大背景
		background.setBounds(0,0,1067,600);
		background.setIcon(bg);
		background.setLayout(null);
		
		
		jb1.setBounds(825, 350, 242, 195);
		jb2.setBounds(425,0,200,425);
		sleep.setBounds(879,102,151,146);
		
		//按钮设置透明
		jb1.setBorderPainted(false);//不打印边框  
		jb1.setBorder(null);//除去边框  
		jb1.setFocusPainted(false);//除去焦点的框  
		jb1.setContentAreaFilled(false);//除去默认的背景填充
		
		jb2.setBorderPainted(false);//不打印边框  
		jb2.setBorder(null);//除去边框  
		jb2.setFocusPainted(false);//除去焦点的框  
		jb2.setContentAreaFilled(false);//除去默认的背景填充
		
		jpanel.add(background);
		background.add(jb1);
		background.add(jb2);
		background.add(sleep);//在原来的基础上加上睡觉（ZZZ）符号
		
		if(User.getState(APP.user)==0)
		{
			sleep.setIcon(sleeppic);
			repaint();
			new SleepTimer();
		}
		else if(User.getState(APP.user)==1)
		{
			sleep.setIcon(uppic);
			repaint();
		}
		
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(User.getState(APP.user)==1)  //不在休息
				{
					if (APP.gf.gameTimer.getState().equals("night")) {//只有晚上才能进入睡眠状态
						MainRoom.this.sleep.setIcon(sleeppic);
						repaint();
						new SleepTimer();
					}
					else {
						JOptionPane.showMessageDialog(null, "未入夜，不能眠");
					}
				}
				else  //已经在休息了
				{
					JOptionPane.showMessageDialog(null, "正在休息，请勿打扰！");
				}
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainRoom.this.setVisible(false);
				APP.gf.setVisible(true);
			}
			
		});
	}

}
