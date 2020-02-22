package RandomHouse;

import javax.swing.*;

import Medium.Images;
import main.APP;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class RandomHousePanel extends JPanel{
	private JLabel back,limit;
	private JButton next,lab2,b,b1,b2,b3;
	private JPanel margin,center; 
	private int j=0;
	Random random1 = new Random();
	int n1=random1.nextInt(2);
	Random random2 = new Random();
	int n2=random2.nextInt(1);
	private ArrayList<String> talk = new ArrayList<String>(){{add("欢迎来到随机屋~");add(RandomEvent.helloGet(String.valueOf(n1), "talk1"));add(RandomEvent.helloGet(String.valueOf(n2), "talk2"));}};
	
	public RandomHousePanel() {
		
		//背景
		back = new JLabel();
		back.setIcon(Images.getImg("/image/randomHouse.png"));
		back.setBounds(0, 0, 1067,629);
		add(back);
		
		//
		ImageIcon dialogpic = Images.getImg("/image/dialog.png");
		dialogpic.setImage(dialogpic.getImage().getScaledInstance(1067,90, Image.SCALE_DEFAULT));
		limit = new JLabel();
		limit.setBounds(0, 460,1067,90);
		limit.setIcon(dialogpic);
		back.add(limit);
		
		margin = new JPanel();
		center = new JPanel();
		limit.setLayout(new BorderLayout(5,0));
		limit.add(margin,BorderLayout.NORTH);
		limit.add(center,BorderLayout.CENTER);
		center.setLayout(new GridLayout(1,3));
		center.add(new JLabel(""));
		
		margin.setOpaque(false);
		center.setOpaque(false);
		
		//对话
		lab2 = new JButton();
		lab2.setFont(new Font("楷体",Font.PLAIN,20));
		lab2.setForeground(Color.black);
		lab2.setFocusPainted(false);//除去焦点的框  
		lab2.setBorderPainted(false); //除去button的边框
		lab2.setContentAreaFilled(false);
		
		b = new JButton();
		
		center.add(lab2);
		center.add(b);
		b.setBorderPainted(false);
		b.setBorder(null);
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
		
		//按钮
		next = new JButton();
		ImageIcon icon1 = Images.getImg("/image/next.png");
		next.setIcon(icon1);
		next.setBounds(515, 554, icon1.getIconWidth(), icon1.getIconHeight());
		next.setBorderPainted(false);
		next.setBorder(null);
		next.setFocusPainted(false);
		next.setContentAreaFilled(false);
		back.add(next);
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lab2.setText(talk.get(j));
				repaint();
				j++;
				if(j==3) {
					ImageIcon icon2 = Images.getImg("/image/jinnang small.png");
					b.setIcon(icon2);
					repaint();
				}
			}
		});
		
		
		
		
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				back.add(b1);
				back.add(b2);
				back.add(b3);
				repaint();
			}
		});
		
		ImageIcon icon3 = Images.getImg("/image/jinnang big.png");
		b1 = new JButton();
		b1.setIcon(icon3);
		b1.setBounds(250, 100, icon3.getIconWidth(), icon3.getIconHeight());
		b1.setBorderPainted(false);
		b1.setBorder(null);
		b1.setFocusPainted(false);
		b1.setContentAreaFilled(false);
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Random random = new Random();
				int number = random.nextInt(21);
				String string = RandomEvent.eventGet(String.valueOf(number));
				lab2.setText(string);
				b1.hide();
				b2.hide();
				b3.hide();
				repaint();
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						APP.random.dispose();
						APP.gf.setVisible(true);
					}
				}, 3000);
			}
		});
		
		b2 = new JButton();
		b2.setIcon(icon3);
		b2.setBounds(450, 100, icon3.getIconWidth(), icon3.getIconHeight());
		b2.setBorderPainted(false);
		b2.setBorder(null);
		b2.setFocusPainted(false);
		b2.setContentAreaFilled(false);
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Random random = new Random();
				int number = random.nextInt(21);
				String string = RandomEvent.eventGet(String.valueOf(number));
				lab2.setText(string);
				b1.hide();
				b2.hide();
				b3.hide();
				repaint();
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						APP.random.dispose();
						APP.gf.setVisible(true);
					}
				}, 3000);
				
			}
		});
		
		b3 = new JButton();
		b3.setIcon(icon3);
		b3.setBounds(650, 100, icon3.getIconWidth(), icon3.getIconHeight());
		b3.setBorderPainted(false);
		b3.setBorder(null);
		b3.setFocusPainted(false);
		b3.setContentAreaFilled(false);
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Random random = new Random();
				int number = random.nextInt(21);
				String string = RandomEvent.eventGet(String.valueOf(number));
				lab2.setText(string);
				b1.hide();
				b2.hide();
				b3.hide();
				repaint();
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						APP.random.dispose();
						APP.gf.setVisible(true);
					}
				}, 3000);
			}
		});
	}
	
}
