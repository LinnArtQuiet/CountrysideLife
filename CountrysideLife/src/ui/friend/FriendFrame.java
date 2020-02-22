package ui.friend;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.*;

import Data.FileData;
import Medium.Images;
import main.APP;
import ui.father.MyFrame;
import ui.game.GameTimer;
import ui.move.MoveBird;
import ui.pregame.MapFrame;
import user.User;


public class FriendFrame extends MyFrame{
	//容器和背景图
	private JPanel FriendPanel;
	private JLabel back;  //背景图容器
	
	//经验条
	private JPanel ex;
		
	//仅作为显示的部分
	private JLabel head;
	private JLabel friendImfor;
	private JLabel friendName;
	private JLabel friendClass;
	private JLabel money;
	private JLabel moneyLabel;
	JLabel moneyText;
	private JLabel power;
	private JLabel powerLabel;
	private JLabel powerText;
	
	//可操作的按钮
	private JLabel harvest;
	private JLabel water;
	
	//土地
	private FriendLandLabel Land1;
	private FriendLandLabel Land2;
	private FriendLandLabel Land3;
	private FriendLandLabel Land4;
	private FriendLandLabel Land5;
	private FriendLandLabel Land6;
	
	//小天鹅
	MoveBird aBird;
	
	//时间切换
	private JLabel time;
	private JLabel timeSHI;
	private JLabel timeHOUR;
	private long outTime;
	private int nowHour;
	private String nowTime;
	
	//返回地图按钮
	private JButton goback;
	
	//鼠标跟随值
	public int mouseCursorIcon;
	
	//好友id
	private static String friend;
	
	/*构造函数*/
	public FriendFrame(String friend) {
		super();
		
		this.friend = friend;
		outTime = Long.parseLong(FileData.get(friend, "user","outTime"));
		nowHour = (int)((outTime/15000)%24);
		nowTime = GameTimer.timeList.get(nowHour);
		
		initGUI();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		//鼠标跟随值
		mouseCursorIcon = 0;
		MyMouse();
	}
	
	/* 获取当前椎鼠标跟随的标志*/
	public int getMouseCursorIcon() {
		return mouseCursorIcon;
	}
	/*设置当前椎鼠标跟随的标志*/
	public void setMouseCursorIcon(int mouseCursorIcon) {
		this.mouseCursorIcon = mouseCursorIcon;
	}
	
	//点击监听器
	private class MyMouseListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//changeUserImfor();
			int flag = e.getModifiers();
			JLabel jb = (JLabel) e.getSource();
			if (flag == InputEvent.BUTTON1_MASK)
			{
				if (jb == harvest) {
					ImageIcon icon1 = Images.getImg("/image/button_harvest(mouse).png");
					Cursor cursor1 = FriendFrame.this.getToolkit().createCustomCursor(icon1.getImage(),new Point(0, 0), "");
					FriendFrame.this.setCursor(cursor1);
					setMouseCursorIcon(100);
					}
				if(jb == water) {
					ImageIcon icon2 = Images.getImg("/image/button_water(mouse).png");
					Cursor cursor2 = FriendFrame.this.getToolkit().createCustomCursor(icon2.getImage(),new Point(0, 0), "");
					FriendFrame.this.setCursor(cursor2);
					setMouseCursorIcon(200);
				}
				}
			}
		}
			
	//释放当前鼠标值
	public class MyBACKGROUNDLis extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel jb = (JLabel) e.getSource();
			if (jb == back) {
				// 点右键时释放
				int flag = e.getModifiers();
				if (flag == InputEvent.BUTTON3_MASK) {
					FriendFrame.this.setCursor(null);
					setMouseCursorIcon(0);
				}
			}
		}	
	}
			
	private void MyMouse() {
		//鼠标点击监听器
		MyMouseListener mouseClick = new MyMouseListener();
		harvest.addMouseListener(mouseClick);
		water.addMouseListener(mouseClick);
				
		MyBACKGROUNDLis mb = new MyBACKGROUNDLis();
		back.addMouseListener(mb);
	}
	
	//JFrame布局
	private void initGUI() {
				
//		try {					
			FriendPanel = new JPanel();
			getContentPane().add(FriendPanel, BorderLayout.CENTER);
			FriendPanel.setLayout(null);
			FriendPanel.setPreferredSize(new java.awt.Dimension(1067, 600));
			
			//主界面背景
			back = new JLabel();
			back.setBounds(0, 0, 1067, 600);
			if(6<=nowHour && nowHour<18) {
				back.setIcon(Images.getImg("/image/GameFrame.png"));
			}
			else {
				back.setIcon(Images.getImg("/image/NightBack.png"));
			}
		    FriendPanel.add(back);
			
			//小天鹅
			aBird=new MoveBird();
			back.add(aBird);
			aBird.setBackground(null);
			aBird.setOpaque(false);
			aBird.setBounds(767, 321, 300, 250);
			
			//蝴蝶
			JLabel butterfly=new JLabel();;
			butterfly.setIcon(new ImageIcon(this.getClass().getResource("/image/butterfly.gif")));
			butterfly.setBounds(590, 510, 96, 54);
			back.add(butterfly);
			
			//两只鸟
			JLabel twobirds=new JLabel();;
			twobirds.setIcon(Images.getImg("/image/twobirds.gif"));
			twobirds.setBounds(15, 95, 52, 39);
			back.add(twobirds);
			
			//收获农作物按钮
			harvest = new JLabel();
			harvest.setIcon(Images.getImg("/image/button_harvest(release).png"));
			harvest.setBounds(100, 530, 55, 57);
			back.add(harvest);
			
			//浇水按钮
			water = new JLabel();
			water.setIcon(Images.getImg("/image/button_water(release).png"));
			water.setBounds(20, 530, 55, 57);
			back.add(water);
					
			//时间显示
			time = new JLabel();
			time.setIcon(Images.getImg("/image/Time.png"));
			time.setBounds(595, 18, 45, 64);
			back.add(time);
			//十二时辰的显示
			timeHOUR = new JLabel(nowTime);
			time.add(timeHOUR);
			timeHOUR.setFont(new Font("楷体", Font.BOLD, 20));
			timeHOUR.setForeground(Color.BLACK);
			timeHOUR.setBounds(13, 7, 30, 30);
			//“时”
			timeSHI = new JLabel("时");
			time.add(timeSHI);
			timeSHI.setFont(new Font("楷体", Font.BOLD, 20));
			timeSHI.setForeground(Color.BLACK);
			timeSHI.setBounds(13, 30, 30, 30);
					
			//好友头像显示
			head = new JLabel();
			head.setIcon(Images.getImg(FileData.get(friend, "user", "photopath")));
			head.setBounds(20, 20, 55, 57);
			back.add(head);
					
			//好友信息显示
			//好友信息框
			friendImfor = new JLabel();
			friendImfor.setIcon(Images.getImg("/image/RecFrameUp.png"));
			friendImfor.setBounds(85, 20, 150, 58);
			back.add(friendImfor);
					
			//好友ID
			friendName = new JLabel(FileData.get(friend, "user", "userID"));//获取好友信息
			friendImfor.add(friendName);
			friendName.setFont(new Font("楷体", Font.BOLD, 20));
			friendName.setForeground(Color.BLACK);
			friendName.setBounds(10, 5, 150, 20);
			//好友等级
			friendClass = new JLabel("等级"+":"+FileData.get(friend, "user", "level"));//获取玩家信息
			friendImfor.add(friendClass);
			friendClass.setFont(new Font("楷体", Font.BOLD, 20));
			friendClass.setForeground(Color.BLACK);
			friendClass.setBounds(10, 30, 150, 20);
			//经验条
			ex = new JPanel();
			ex.setBounds(85,78,(int)150*User.getEx(friend)/5000,5);
			ex.setVisible(true);
			ex.setBackground(Color.GREEN);
			back.add(ex);
			
			//所持有的金币显示
			//金币图标
			money = new JLabel();
			money.setIcon(Images.getImg("/image/Money.png"));
			money.setBounds(820, 19, 44, 55);
			back.add(money);
			//金币图框
			moneyLabel = new JLabel();
			moneyLabel.setIcon(Images.getImg("/image/RecFrameUp.png"));
			moneyLabel.setBounds(810, 20, 150, 58);
			back.add(moneyLabel);
			//显示金币数量
			DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //获得格式化类对象
			dt.applyPattern("0.0");//设置小数点位数(两位) 余下的会四舍五入
			moneyText = new JLabel(dt.format(User.getMoney(friend)));//调取好友数据
			moneyLabel.add(moneyText);
			moneyText.setFont(new Font("楷体", Font.BOLD, 20));
			moneyText.setForeground(Color.BLACK);
			moneyText.setBounds(60, 10, 100, 50);
					
			//所持有的体力显示
			//体力图标
			power = new JLabel();
			power.setIcon(Images.getImg("/image/Power.png"));
			power.setBounds(660, 17, 48, 56);
			back.add(power);
			//体力图框
			powerLabel = new JLabel();
			powerLabel.setIcon(Images.getImg("/image/RecFrameUp.png"));
			powerLabel.setBounds(650, 20, 150, 58);
			back.add(powerLabel);
			//显示体力数量
			powerText = new JLabel(FileData.get(friend, "user", "energy")+"/60");//调取好友数据
			powerLabel.add(powerText);
			powerText.setFont(new Font("楷体", Font.BOLD, 20));
			powerText.setForeground(Color.BLACK);
			powerText.setBounds(60, 10, 100, 50);
					
			//第一块土地
			Land1 = new FriendLandLabel(FriendFrame.this, friend, 1);
			Land1.setBounds(125, 360, 225, 80);
			back.add(Land1);
					
			//第二块土地
			Land2 = new FriendLandLabel(FriendFrame.this, friend, 2);
			Land2.setBounds(275, 360, 225, 80);
			back.add(Land2);
					
			//第三块土地
			Land3 = new FriendLandLabel(FriendFrame.this, friend, 3);
			Land3.setBounds(425, 360, 225, 80);
			back.add(Land3);
				
			//第四块土地
			Land4 = new FriendLandLabel(FriendFrame.this, friend, 4);
			Land4.setBounds(0, 440, 225, 80);
			back.add(Land4);
					
			//第五块土地
			Land5 = new FriendLandLabel(FriendFrame.this, friend, 5);
			Land5.setBounds(150, 440, 225, 80);
			back.add(Land5);
					
			//第六块土地
			Land6 = new FriendLandLabel(FriendFrame.this, friend, 6);
			Land6.setBounds(300, 440, 225, 80);
			back.add(Land6);
			
			//回地图
			goback = new JButton();
			goback.setBounds(917, 383, 61, 38);
			back.add(goback);
			goback.setFocusPainted(false);//除去焦点的框  
			goback.setBorderPainted(false); //除去button的边框
	        goback.setContentAreaFilled(false);
	        goback.addActionListener(new ActionListener() {
				
		    @Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MapFrame();
				FriendFrame.this.dispose();
			}
		});
//			pack();
//		} catch (Exception e) {
//			e.printStackTrace();//显示异常路径
//		}
		
	}
	
  
}
