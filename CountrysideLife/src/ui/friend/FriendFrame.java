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
	//�����ͱ���ͼ
	private JPanel FriendPanel;
	private JLabel back;  //����ͼ����
	
	//������
	private JPanel ex;
		
	//����Ϊ��ʾ�Ĳ���
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
	
	//�ɲ����İ�ť
	private JLabel harvest;
	private JLabel water;
	
	//����
	private FriendLandLabel Land1;
	private FriendLandLabel Land2;
	private FriendLandLabel Land3;
	private FriendLandLabel Land4;
	private FriendLandLabel Land5;
	private FriendLandLabel Land6;
	
	//С���
	MoveBird aBird;
	
	//ʱ���л�
	private JLabel time;
	private JLabel timeSHI;
	private JLabel timeHOUR;
	private long outTime;
	private int nowHour;
	private String nowTime;
	
	//���ص�ͼ��ť
	private JButton goback;
	
	//������ֵ
	public int mouseCursorIcon;
	
	//����id
	private static String friend;
	
	/*���캯��*/
	public FriendFrame(String friend) {
		super();
		
		this.friend = friend;
		outTime = Long.parseLong(FileData.get(friend, "user","outTime"));
		nowHour = (int)((outTime/15000)%24);
		nowTime = GameTimer.timeList.get(nowHour);
		
		initGUI();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		//������ֵ
		mouseCursorIcon = 0;
		MyMouse();
	}
	
	/* ��ȡ��ǰ׵������ı�־*/
	public int getMouseCursorIcon() {
		return mouseCursorIcon;
	}
	/*���õ�ǰ׵������ı�־*/
	public void setMouseCursorIcon(int mouseCursorIcon) {
		this.mouseCursorIcon = mouseCursorIcon;
	}
	
	//���������
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
			
	//�ͷŵ�ǰ���ֵ
	public class MyBACKGROUNDLis extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel jb = (JLabel) e.getSource();
			if (jb == back) {
				// ���Ҽ�ʱ�ͷ�
				int flag = e.getModifiers();
				if (flag == InputEvent.BUTTON3_MASK) {
					FriendFrame.this.setCursor(null);
					setMouseCursorIcon(0);
				}
			}
		}	
	}
			
	private void MyMouse() {
		//�����������
		MyMouseListener mouseClick = new MyMouseListener();
		harvest.addMouseListener(mouseClick);
		water.addMouseListener(mouseClick);
				
		MyBACKGROUNDLis mb = new MyBACKGROUNDLis();
		back.addMouseListener(mb);
	}
	
	//JFrame����
	private void initGUI() {
				
//		try {					
			FriendPanel = new JPanel();
			getContentPane().add(FriendPanel, BorderLayout.CENTER);
			FriendPanel.setLayout(null);
			FriendPanel.setPreferredSize(new java.awt.Dimension(1067, 600));
			
			//�����汳��
			back = new JLabel();
			back.setBounds(0, 0, 1067, 600);
			if(6<=nowHour && nowHour<18) {
				back.setIcon(Images.getImg("/image/GameFrame.png"));
			}
			else {
				back.setIcon(Images.getImg("/image/NightBack.png"));
			}
		    FriendPanel.add(back);
			
			//С���
			aBird=new MoveBird();
			back.add(aBird);
			aBird.setBackground(null);
			aBird.setOpaque(false);
			aBird.setBounds(767, 321, 300, 250);
			
			//����
			JLabel butterfly=new JLabel();;
			butterfly.setIcon(new ImageIcon(this.getClass().getResource("/image/butterfly.gif")));
			butterfly.setBounds(590, 510, 96, 54);
			back.add(butterfly);
			
			//��ֻ��
			JLabel twobirds=new JLabel();;
			twobirds.setIcon(Images.getImg("/image/twobirds.gif"));
			twobirds.setBounds(15, 95, 52, 39);
			back.add(twobirds);
			
			//�ջ�ũ���ﰴť
			harvest = new JLabel();
			harvest.setIcon(Images.getImg("/image/button_harvest(release).png"));
			harvest.setBounds(100, 530, 55, 57);
			back.add(harvest);
			
			//��ˮ��ť
			water = new JLabel();
			water.setIcon(Images.getImg("/image/button_water(release).png"));
			water.setBounds(20, 530, 55, 57);
			back.add(water);
					
			//ʱ����ʾ
			time = new JLabel();
			time.setIcon(Images.getImg("/image/Time.png"));
			time.setBounds(595, 18, 45, 64);
			back.add(time);
			//ʮ��ʱ������ʾ
			timeHOUR = new JLabel(nowTime);
			time.add(timeHOUR);
			timeHOUR.setFont(new Font("����", Font.BOLD, 20));
			timeHOUR.setForeground(Color.BLACK);
			timeHOUR.setBounds(13, 7, 30, 30);
			//��ʱ��
			timeSHI = new JLabel("ʱ");
			time.add(timeSHI);
			timeSHI.setFont(new Font("����", Font.BOLD, 20));
			timeSHI.setForeground(Color.BLACK);
			timeSHI.setBounds(13, 30, 30, 30);
					
			//����ͷ����ʾ
			head = new JLabel();
			head.setIcon(Images.getImg(FileData.get(friend, "user", "photopath")));
			head.setBounds(20, 20, 55, 57);
			back.add(head);
					
			//������Ϣ��ʾ
			//������Ϣ��
			friendImfor = new JLabel();
			friendImfor.setIcon(Images.getImg("/image/RecFrameUp.png"));
			friendImfor.setBounds(85, 20, 150, 58);
			back.add(friendImfor);
					
			//����ID
			friendName = new JLabel(FileData.get(friend, "user", "userID"));//��ȡ������Ϣ
			friendImfor.add(friendName);
			friendName.setFont(new Font("����", Font.BOLD, 20));
			friendName.setForeground(Color.BLACK);
			friendName.setBounds(10, 5, 150, 20);
			//���ѵȼ�
			friendClass = new JLabel("�ȼ�"+":"+FileData.get(friend, "user", "level"));//��ȡ�����Ϣ
			friendImfor.add(friendClass);
			friendClass.setFont(new Font("����", Font.BOLD, 20));
			friendClass.setForeground(Color.BLACK);
			friendClass.setBounds(10, 30, 150, 20);
			//������
			ex = new JPanel();
			ex.setBounds(85,78,(int)150*User.getEx(friend)/5000,5);
			ex.setVisible(true);
			ex.setBackground(Color.GREEN);
			back.add(ex);
			
			//�����еĽ����ʾ
			//���ͼ��
			money = new JLabel();
			money.setIcon(Images.getImg("/image/Money.png"));
			money.setBounds(820, 19, 44, 55);
			back.add(money);
			//���ͼ��
			moneyLabel = new JLabel();
			moneyLabel.setIcon(Images.getImg("/image/RecFrameUp.png"));
			moneyLabel.setBounds(810, 20, 150, 58);
			back.add(moneyLabel);
			//��ʾ�������
			DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //��ø�ʽ�������
			dt.applyPattern("0.0");//����С����λ��(��λ) ���µĻ���������
			moneyText = new JLabel(dt.format(User.getMoney(friend)));//��ȡ��������
			moneyLabel.add(moneyText);
			moneyText.setFont(new Font("����", Font.BOLD, 20));
			moneyText.setForeground(Color.BLACK);
			moneyText.setBounds(60, 10, 100, 50);
					
			//�����е�������ʾ
			//����ͼ��
			power = new JLabel();
			power.setIcon(Images.getImg("/image/Power.png"));
			power.setBounds(660, 17, 48, 56);
			back.add(power);
			//����ͼ��
			powerLabel = new JLabel();
			powerLabel.setIcon(Images.getImg("/image/RecFrameUp.png"));
			powerLabel.setBounds(650, 20, 150, 58);
			back.add(powerLabel);
			//��ʾ��������
			powerText = new JLabel(FileData.get(friend, "user", "energy")+"/60");//��ȡ��������
			powerLabel.add(powerText);
			powerText.setFont(new Font("����", Font.BOLD, 20));
			powerText.setForeground(Color.BLACK);
			powerText.setBounds(60, 10, 100, 50);
					
			//��һ������
			Land1 = new FriendLandLabel(FriendFrame.this, friend, 1);
			Land1.setBounds(125, 360, 225, 80);
			back.add(Land1);
					
			//�ڶ�������
			Land2 = new FriendLandLabel(FriendFrame.this, friend, 2);
			Land2.setBounds(275, 360, 225, 80);
			back.add(Land2);
					
			//����������
			Land3 = new FriendLandLabel(FriendFrame.this, friend, 3);
			Land3.setBounds(425, 360, 225, 80);
			back.add(Land3);
				
			//���Ŀ�����
			Land4 = new FriendLandLabel(FriendFrame.this, friend, 4);
			Land4.setBounds(0, 440, 225, 80);
			back.add(Land4);
					
			//���������
			Land5 = new FriendLandLabel(FriendFrame.this, friend, 5);
			Land5.setBounds(150, 440, 225, 80);
			back.add(Land5);
					
			//����������
			Land6 = new FriendLandLabel(FriendFrame.this, friend, 6);
			Land6.setBounds(300, 440, 225, 80);
			back.add(Land6);
			
			//�ص�ͼ
			goback = new JButton();
			goback.setBounds(917, 383, 61, 38);
			back.add(goback);
			goback.setFocusPainted(false);//��ȥ����Ŀ�  
			goback.setBorderPainted(false); //��ȥbutton�ı߿�
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
//			e.printStackTrace();//��ʾ�쳣·��
//		}
		
	}
	
  
}
