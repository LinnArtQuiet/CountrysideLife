package ui.set;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Medium.Images;
import main.APP;
import ui.father.MyFrameNext;
import user.User;

public class SetFrame extends MyFrameNext{

	public SetFrame()
	{
		setTitle("设置");
		JPanel setPanel = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		JPanel p10 = new JPanel();
		JPanel p11 = new JPanel();
		JPanel p12 = new JPanel();
	
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		p4.setOpaque(false);
		p5.setOpaque(false);
		p6.setOpaque(false);
		p7.setOpaque(false);
		p8.setOpaque(false);
		p9.setOpaque(false);
		p10.setOpaque(false);
		p11.setOpaque(false);
		p12.setOpaque(false);
		
		JLabel back = new JLabel();
		JLabel setTitle = new JLabel();
	
		JLabel oldPW = new JLabel("原密码");
		JLabel newPW = new JLabel("新密码");
		JLabel ensure = new JLabel("确认密码");
	
		JPasswordField oPW = new JPasswordField(15);
		JPasswordField nPW = new JPasswordField(15);
		JPasswordField ePW = new JPasswordField(15);
		oPW.setEchoChar('*');
		nPW.setEchoChar('*');
		ePW.setEchoChar('*');
		
		ImageIcon reset=Images.getImg("/image/resetnext.png");  //重置按钮图片
		ImageIcon confirm=Images.getImg("/image/confirm.png");  //确认按钮图片
		
		//确认按钮
		JButton button1 = new JButton(confirm);
				
		//重置按钮
		JButton button2 = new JButton(reset);
		
		this.add(setPanel);
		
		setPanel.setLayout(new GridLayout(1,1));
		setPanel.add(back);
		
		ImageIcon bg = Images.getImg("/image/DialogFrame.png");
		bg.setImage(bg.getImage().getScaledInstance(355, 400, Image.SCALE_DEFAULT));
		back.setIcon(bg);
		back.setLayout(new BorderLayout(40,10));
		back.add(p1,BorderLayout.SOUTH);
		back.add(p2,BorderLayout.WEST);
		back.add(p3,BorderLayout.EAST);
		back.add(setTitle,BorderLayout.NORTH);
		back.add(p4,BorderLayout.CENTER);
		
		p4.setLayout(new BorderLayout(10,10));
		p4.add(p5,BorderLayout.CENTER);
		p4.add(p6,BorderLayout.SOUTH);
		
		setTitle.setIcon(Images.getImg("/image/SetTitle.png"));
		
		p5.setLayout(new BorderLayout(10,20));
		p5.add(p7,BorderLayout.SOUTH);
		p5.add(p8,BorderLayout.NORTH);
		p5.add(p9,BorderLayout.CENTER);
		
		p6.setLayout(new GridLayout(0,3));
		p6.add(button1);
		p6.add(new JLabel(""));
		p6.add(button2);
		
		p9.setLayout(new GridLayout(3,1,10,25));
		p9.add(p10);
		p9.add(p11);
		p9.add(p12);
		
		p10.setLayout(new GridLayout(1,2));
		p10.add(oldPW);
		p10.add(oPW);
		
		p11.setLayout(new GridLayout(1,2));
		p11.add(newPW);
		p11.add(nPW);
		
		p12.setLayout(new GridLayout(1,2));
		p12.add(ensure);
		p12.add(ePW);
		
		
		//修改密码文字
		oldPW.setFont(new Font("楷体",Font.PLAIN, 20));
		newPW.setFont(new Font("楷体",Font.PLAIN, 20));
		ensure.setFont(new Font("楷体",Font.PLAIN, 20));
		
		
		button1.setFocusPainted(false);//除去焦点的框  
		button1.setBorderPainted(false); //除去button的边框
		button1.setContentAreaFilled(false);	
		button2.setFocusPainted(false);//除去焦点的框  
		button2.setBorderPainted(false); //除去button的边框
		button2.setContentAreaFilled(false);
		
		button1.addActionListener(new ActionListener() {  //改用户密码
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String yuan = new String(oPW.getPassword());
				String xin = new String(nPW.getPassword());
				String again = new String(ePW.getPassword());
				
				if(yuan.equals(""))  //未输入原密码
				{
					if(!xin.equals(""))  //输入了新密码
					{
						JOptionPane.showMessageDialog(null,"请先输入原密码！");
					}
					else  //新密码也没有输入
					{
						SetFrame.this.dispose();
					}
				}
				else  //输入了原密码
				{
					if(!xin.equals(""))   //输入了新密码
					{
						if(!xin.equals(""))  //确认了密码
						{
							if(!yuan.equals(User.getPassword(APP.user)))  //原密码输入错误
							{
								JOptionPane.showMessageDialog(null,"原密码输入错误！");
							}
							//原密码输入正确
							else if(!xin.equals(again))  //新密码与确认密码不一致
							{
								JOptionPane.showMessageDialog(null,"两次输入新密码不一致，请检查！");
							}
							else //新密码与确认密码一致
							{
								if(yuan.length()<3 || yuan.length()>10)
								{
									JOptionPane.showMessageDialog(null,"密码长度应为3~10");
								}
								else
								{
									int is = JOptionPane.showConfirmDialog(null, "您真的要修改密码吗？");
									if(is == JOptionPane.OK_OPTION)
									{
										JOptionPane.showMessageDialog(null,"新密码修改成功！");
										User.setPassword(APP.user,xin);
										SetFrame.this.dispose();
									}
								}
								
							}
						}
						else  //未确认密码
						{
							JOptionPane.showMessageDialog(null,"请确认新密码！");
						}
					}
					else
					{
						SetFrame.this.dispose();
					}
				}
			}
		});
		
		 button2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					oPW.setText("");
					nPW.setText("");
					ePW.setText("");
				}
			});
		
		}
}
