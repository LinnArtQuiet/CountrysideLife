package ui.pregame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Data.FileData;
import Medium.Images;
import main.APP;
import ui.father.MyFrame;
import ui.game.GameFrame;
import user.User;


public class InformationFrame extends MyFrame{
	
	public InformationFrame() throws Exception
	{
		super();

		JLabel bottom=new JLabel();
		
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(new GridLayout(1,1));
		panel.add(bottom);
		
		ImageIcon bg=Images.getImg("/image/informationpage.png");  //背景图
		ImageIcon zhuxiao=Images.getImg("/image/zhuxiao.png");  //注销
		ImageIcon next=Images.getImg("/image/continue.png");  //继续游戏
		ImageIcon restart=Images.getImg("/image/restart.png");  //重新开始游戏
		ImageIcon ID=Images.getImg("/image/ID.png");  //用户名
		ImageIcon capital=Images.getImg("/image/capital.png");  //持有资本
		ImageIcon hp=Images.getImg("/image/hp.png");  //体力
		ImageIcon level=Images.getImg("/image/level.png");  //等级
		ImageIcon brief=Images.getImg("/image/brief.png");  //游戏简介
		
		
		
		bg.setImage(bg.getImage().getScaledInstance(1067,600, Image.SCALE_DEFAULT));
		zhuxiao.setImage(zhuxiao.getImage().getScaledInstance(zhuxiao.getIconWidth(),zhuxiao.getIconHeight(), Image.SCALE_DEFAULT));
		next.setImage(next.getImage().getScaledInstance(next.getIconWidth(),next.getIconHeight(), Image.SCALE_DEFAULT));
		restart.setImage(restart.getImage().getScaledInstance(restart.getIconWidth(),restart.getIconHeight(), Image.SCALE_DEFAULT));
		ID.setImage(ID.getImage().getScaledInstance(ID.getIconWidth(),ID.getIconHeight(), Image.SCALE_DEFAULT));
		capital.setImage(capital.getImage().getScaledInstance(capital.getIconWidth(),capital.getIconHeight(), Image.SCALE_DEFAULT));
		hp.setImage(hp.getImage().getScaledInstance(hp.getIconWidth(),hp.getIconHeight(), Image.SCALE_DEFAULT));
		level.setImage(level.getImage().getScaledInstance(hp.getIconWidth(),hp.getIconHeight(), Image.SCALE_DEFAULT));
		brief.setImage(brief.getImage().getScaledInstance(brief.getIconWidth(),brief.getIconHeight(), Image.SCALE_DEFAULT));
		
		JPanel margin1 = new JPanel();
		JPanel margin2 = new JPanel();
		JPanel p = new JPanel();
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
		
		JButton button1 = new JButton(next);   //继续游戏
		JButton button2 = new JButton(restart);   //开始新游戏
		JButton button3 = new JButton(brief);   //玩法介绍
		JButton button4 = new JButton(zhuxiao);   //注销
		
		JLabel title1 = new JLabel(ID);  //用户名
		JLabel title2 = new JLabel(APP.user);  //用户名的值，从数据库中获取
		JLabel title3 = new JLabel(capital);  //玩家金币
		DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //获得格式化类对象
		dt.applyPattern("0.0");//设置小数点位数(两位) 余下的会四舍五入
		JLabel title4 = new JLabel(dt.format(User.getMoney(APP.user))+"");//金币数量，从数据库中获取
		JLabel title5 = new JLabel(hp);  //玩家精力
		JLabel title6 = new JLabel(User.getEnergy(APP.user)+""); //精力值，从数据库中获取
		JLabel title7 = new JLabel(level);  //玩家精力
		JLabel title8 = new JLabel(User.getClasses(APP.user)+""); //精力值，从数据库中获取
		
		
		bottom.setIcon(bg);
		bottom.setLayout(new BorderLayout(20,20));
		bottom.add(margin1,BorderLayout.SOUTH);
		bottom.add(margin2,BorderLayout.NORTH);
		margin1.setOpaque(false);
		margin2.setOpaque(false);
		margin1.setLayout(new BorderLayout());
		margin1.add(button3,BorderLayout.EAST);
		
		bottom.add(p,BorderLayout.CENTER);
		p.setOpaque(false);
		p.setLayout(new GridLayout(1,2,50,50));
		p.add(new JLabel(""));
		p.add(p1);
		
		
		p1.setOpaque(false);
		p1.setLayout(new BorderLayout(20,50));
		p1.add(p2,BorderLayout.NORTH);
		p1.add(p3,BorderLayout.CENTER);
		p1.add(p4,BorderLayout.SOUTH);
		
		p2.setOpaque(false);
		p2.setLayout(new BorderLayout());
		p2.add(button4,BorderLayout.EAST);
		button4.setFocusPainted(false);//除去焦点的框  
		button4.setBorderPainted(false); //除去button的边框
        button4.setContentAreaFilled(false);
		
        p3.setOpaque(false);
        p3.setLayout(new BorderLayout(50,50));
        p3.add(p5,BorderLayout.EAST);
        p3.add(p6,BorderLayout.WEST);
        p3.add(p7,BorderLayout.CENTER);
        
        p7.setLayout(new GridLayout(4,1,10,10));
        p7.add(p8);
        p7.add(p9);
        p7.add(p10);
        p7.add(p11);
        p8.setLayout(new GridLayout(1,2));
        p8.add(title1);
        p8.add(new JLabel("                    "));
        p8.add(title2);
        p9.setLayout(new GridLayout(1,2));
        p9.add(title3);
        p9.add(new JLabel("                    "));
        p9.add(title4);
        p10.setLayout(new GridLayout(1,2));
        p10.add(title5);
        p10.add(new JLabel("                    "));
        p10.add(title6);
        p11.setLayout(new GridLayout(1,2));
        p11.add(title7);
        p11.add(new JLabel("                    "));
        p11.add(title8);
        
		p4.setOpaque(false);
		p4.add(button1);
		p4.add(new JLabel("     "));
		p4.add(button2);
		
		p5.setOpaque(false);
		p6.setOpaque(false);
		p7.setOpaque(false);
		p8.setOpaque(false);
		p9.setOpaque(false);
		p10.setOpaque(false);
		p11.setOpaque(false);
		
		title2.setFont(new Font("Kristen ITC", Font.PLAIN, 20)); 
		title4.setFont(new Font("Kristen ITC", Font.PLAIN, 20)); 
		title6.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		title8.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		
		button1.setFocusPainted(false);//除去焦点的框  
		button1.setBorderPainted(false); //除去button的边框
        button1.setContentAreaFilled(false);
        button2.setFocusPainted(false);//除去焦点的框  
		button2.setBorderPainted(false); //除去button的边框
        button2.setContentAreaFilled(false);
        button3.setFocusPainted(false);//除去焦点的框  
		button3.setBorderPainted(false); //除去button的边框
        button3.setContentAreaFilled(false);
        button4.setFocusPainted(false);//除去焦点的框  
		button4.setBorderPainted(false); //除去button的边框
        button4.setContentAreaFilled(false);
		
		
		button1.addActionListener(new ActionListener()  //继续游戏
		{
			public void actionPerformed(ActionEvent e)
			{
				if(User.getState(APP.user)==2)
				{
					JOptionPane.showMessageDialog(null, "非常遗憾，您已经死亡，请重新开始游戏");
				}
				else
				{
					//在该用户数据下进入游戏界面，在数据库中保持实时更新
					InformationFrame.this.dispose();  //关闭当前信息界面
					new MapFrame();
				}
				
				}
		});
		
		button2.addActionListener(new ActionListener()  //重新开始游戏
		{
			public void actionPerformed(ActionEvent e)
			{
				int is = JOptionPane.showConfirmDialog(null,"您此前的游戏记录将被清空，您确认初始化游戏吗？");
				if(is==JOptionPane.OK_OPTION)
				{
					//数据初始化，进入游戏界面
						FileData.initialize(APP.user, User.getPassword(APP.user));//初始化
						Random rd = new Random();
						int index = rd.nextInt(6)+1;
						String path="/image/Photo/photo"+index+".png";
						FileData.update(APP.user, "user", "photopath", path);  //将初始化后的头像路径进行存储
						InformationFrame.this.dispose();  //信息界面关闭
						try {
							new InformationFrame();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
	         }
		});
		
		button3.addActionListener(new ActionListener()  //查看玩法简介
		{
			public void actionPerformed(ActionEvent e)
	        {
				InformationFrame.this.dispose();
				new IntroductionFrame();
	         }
		});
		
		button4.addActionListener(new ActionListener()  //注销
				{
			public void actionPerformed(ActionEvent e)
			{
				int is = JOptionPane.showConfirmDialog(null,"您的账户及游戏记录将被消除，您确认注销账户吗？");  //弹出询问窗口
				if(is==JOptionPane.OK_OPTION)  //若再次肯定则注销该账户
				{
					//在数据库中消除该账户
					try {
						FileData.delete(APP.user);  //删除该用户id文件夹下的所有信息
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					APP.user=null;
					new StartFrame();  //返回初始界面	
					InformationFrame.this.dispose();  //信息界面关闭
				}
			}
				});			
	}


}
