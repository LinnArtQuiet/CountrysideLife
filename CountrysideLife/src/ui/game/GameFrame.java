package ui.game;

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
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Land.LandLabel;
import Medium.Images;
import RandomHouse.RandomEvent;
import RandomHouse.RandomHouseFrame;
import main.APP;
import ui.NPC.NPC;
import ui.bag.BagFrame;
import ui.bed.MainRoom;
import ui.father.MyFrame;
import ui.move.MoveBird;
import ui.pregame.MapFrame;
import ui.set.SetFrame;
import user.User;

public class GameFrame extends MyFrame{
	
	//�����ͱ���ͼ
	private JPanel GamePanel;
	private JLabel back;  //����ͼ����
	
	//������
	private JPanel ex;
	
	//����Ϊ��ʾ�Ĳ���
	private JLabel head;
	private JLabel playerImfor;
	private JLabel playerName;
	private JLabel playerClass;
	private JLabel money;
	private JLabel moneyLabel;
	private JLabel moneyText;
	private JLabel power;
	private JLabel powerLabel;
	private JLabel powerText;
	
	//�ɲ����İ�ť
	private JLabel inventory;
	private JLabel harvest;
	private JLabel move;
	private JLabel water;
	private JLabel set;
	
	//ʱ���л�
	public GameTimer gameTimer;
	private JLabel time;
	private JLabel timeSHI;
	private JLabel timeHOUR;
	
	//ʵ��˯�߹���
	private JButton gotoSleep;//������ݽ���˯��״̬
	private JButton goback;//�ص�ͼ
	
	//����
	private LandLabel Land1;
	private LandLabel Land2;
	private LandLabel Land3;
	private LandLabel Land4;
	private LandLabel Land5;
	private LandLabel Land6;
	
	public int mouseCursorIcon;//����ͼ��
	private MoveBird aBird;

	/**
	 * ���εĹ��캯��
	 */
	public GameFrame() {
		super();
		//ʱ��ϵͳ
		gameTimer=new GameTimer();
		
		
		//����������ֵ
		mouseCursorIcon = 0;

		initGUI();
		MyMouse();
		if(User.getHelpTimes(APP.user)!=0)//�����ڼ䱻����
		{
			if(User.getStoleTimes(APP.user)!=0)//�����ڼ䱻С͵���
			{
				JOptionPane.showMessageDialog(null, "�������������������ӣ�");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "��˵�������˺���δ������");
			}
		}
		else
		{
			if(User.getStoleTimes(APP.user)!=0)//�����ڼ䱻С͵���
			{
				JOptionPane.showMessageDialog(null, "�ѵ������ط�ˮ�ȽϺã�");
			}
		}
	}
	/**
	 * ��ȡ��ǰ׵������ı�־
	 * 
	 * @return int ������ı�־
	 */
	public int getMouseCursorIcon() {
		return mouseCursorIcon;
	}
	/**
	 * ���õ�ǰ׵������ı�־
	 * 
	 * @param mouseCursorIcon
	 *            ������ı�־
	 */
	public void setMouseCursorIcon(int mouseCursorIcon) {
		this.mouseCursorIcon = mouseCursorIcon;
	}
	
	
	/**
	 * ������
	 * 
	 */
	
	
	//���������
	public class MyMouseListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
//			flushUserImfor();
			int flag = e.getModifiers();
			JLabel jb = (JLabel) e.getSource();
			if (flag == InputEvent.BUTTON1_MASK)
			{
//				
				if (jb == inventory) {
					BagFrame bagFrame = new BagFrame();
					APP.bf = bagFrame;
				}
				else if (jb == set) {
					new SetFrame();
				}
				else if (jb == water) {
					ImageIcon icon3 = Images.getImg("/image/button_water(mouse).png");
					Cursor cursor3 = GameFrame.this.getToolkit().createCustomCursor(icon3.getImage(),new Point(0, 0), "");
					GameFrame.this.setCursor(cursor3);
					setMouseCursorIcon(300);
				}
				else if (jb == move) {
					ImageIcon icon2 = Images.getImg("/image/button_move(mouse).png");
					Cursor cursor2 = GameFrame.this.getToolkit().createCustomCursor(icon2.getImage(),new Point(0, 0), "");
					GameFrame.this.setCursor(cursor2);
					setMouseCursorIcon(200);
				}
				else if (jb == harvest) {
					ImageIcon icon1 = Images.getImg("/image/button_harvest(mouse).png");
					Cursor cursor1 = GameFrame.this.getToolkit().createCustomCursor(icon1.getImage(),new Point(0, 0), "");
					GameFrame.this.setCursor(cursor1);
					setMouseCursorIcon(100);
					}
				}
				
				
			}
			
		}
	
	//��ͼ������
	private class MyChangeImage extends MouseAdapter{

		@Override
		public void mouseEntered(MouseEvent e){
			JLabel jLabel = (JLabel) e.getSource();
			// �õ�ͼ���ļ�����
			String s = ((ImageIcon) jLabel.getIcon()).getDescription();
			String sub = s.substring(s.indexOf('_')+1, s.indexOf('('));
			ImageIcon icon = Images.getImg("/image/button_" + sub + "(press).png");
			jLabel.setIcon(icon);
			jLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel jLabel = (JLabel) e.getSource();
			// �õ�ͼ���ļ�����
			String s = ((ImageIcon) jLabel.getIcon()).getDescription();
			String sub = s.substring(s.indexOf('_')+1, s.indexOf('('));
			ImageIcon icon = Images.getImg("/image/button_" + sub + "(release).png");
			jLabel.setIcon(icon);
			jLabel.setSize(icon.getIconWidth(), icon.getIconHeight());

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
					GameFrame.this.setCursor(null);
					setMouseCursorIcon(0);
				}
			}
		}
		
	}
	
	private void MyMouse() {
		//�����������
		MyMouseListener mouseClick = new MyMouseListener();
//		store.addMouseListener(mouseClick);
		inventory.addMouseListener(mouseClick);
		set.addMouseListener(mouseClick);
		harvest.addMouseListener(mouseClick);
		move.addMouseListener(mouseClick);
		water.addMouseListener(mouseClick);
		gotoSleep.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				APP.room.setVisible(true);
				GameFrame.this.setVisible(false);
			}
		});
		//���
		MyChangeImage mouseChange = new MyChangeImage();
		inventory.addMouseListener(mouseChange);
		set.addMouseListener(mouseChange);
		harvest.addMouseListener(mouseChange);
		move.addMouseListener(mouseChange);
		water.addMouseListener(mouseChange);
		
		MyBACKGROUNDLis mb = new MyBACKGROUNDLis();
		back.addMouseListener(mb);
	}
		
	//JFrame����
	private void initGUI() {
		
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//û��ʵ�ֽ��̹ر�
			
			GamePanel = new JPanel();
			getContentPane().add(GamePanel, BorderLayout.CENTER);
			GamePanel.setLayout(null);
			GamePanel.setPreferredSize(new java.awt.Dimension(1067, 600));
			
			//�½���
			APP.room = new MainRoom();
			APP.room.setVisible(false);
			
			//�����汳��
			back = new JLabel();
			back.setBounds(0, 0, 1067, 600);
			GamePanel.add(back);
			
			
			//С���
			aBird=new MoveBird();
			back.add(aBird);
			aBird.setBackground(null);
			aBird.setOpaque(false);
			aBird.setBounds(767, 321, 300, 250);
			
			//����
			//ǰ����һ�ŵ�ͼ
			JLabel butterfly=new JLabel();;
			butterfly.setIcon(Images.getImg("/image/butterfly.gif"));
			butterfly.setBounds(590, 510, 96, 54);
			back.add(butterfly);
			butterfly.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(User.getClasses(APP.user)<10)
					{
						JOptionPane.showMessageDialog(null, "���ⶴ��10�����ţ������ڴ�Ŷ~");
					}
					else
					{
						if(User.getState(APP.user) == 0) //����˯��
						{
							JOptionPane.showMessageDialog(null, "���ش�˯�����~");
						}
						else
						{
							if(User.getNPC(APP.user) == false)
							{
								GameFrame.this.setVisible(false);
								User.setNPC(APP.user, true);
								new NPC();
							}
							else
							{
								int is = JOptionPane.showConfirmDialog(null,"�������ѽ���һ�ξ��ⶴ����~��Ը�⻨50����ٽ�һ����");
								if(is == JOptionPane.OK_OPTION){
								//user��Ҽ�20
									int i=User.moneyMinus(APP.user, 50);
									//��Ҽ��ٳɹ�
									if(i==1)
									{
										GameFrame.this.setVisible(false);
										new NPC();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "������ϧ��������������������~");
									}
								}
							}
						}
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
				}
			});
			
			//��ֻ��
			JLabel twobirds=new JLabel();;
			twobirds.setIcon(Images.getImg("/image/twobirds.gif"));
			twobirds.setBounds(15, 95, 52, 39);
			back.add(twobirds);
			
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
					GameFrame.this.setVisible(false);
				}
			});
	        
			//��汳����ť
			inventory = new JLabel();
			inventory.setIcon(Images.getImg("/image/button_Inventory(release).png"));
			inventory.setBounds(980, 530, 56, 58);
			back.add(inventory);
			
			
			//�ջ�ũ���ﰴť
			harvest = new JLabel();
			harvest.setIcon(Images.getImg("/image/button_harvest(release).png"));
			harvest.setBounds(100, 530, 55, 57);
			back.add(harvest);
			
			//�Ƴ�ũ���ﰴť
			move = new JLabel();
			move.setIcon(Images.getImg("/image/button_move(release).png"));
			move.setBounds(180, 530, 55, 57);
			back.add(move);
			
			//��ˮ��ť
			water = new JLabel();
			water.setIcon(Images.getImg("/image/button_water(release).png"));
			water.setBounds(20, 530, 55, 57);
			back.add(water);
			
			//���ð�ť
			set = new JLabel();
			set.setIcon(Images.getImg("/image/button_Set(release).png"));
			set.setBounds(970, 20, 56, 57);
			back.add(set);
			
			//ʱ����ʾ
			time = new JLabel();
			time.setIcon(Images.getImg("/image/Time.png"));
			time.setBounds(595, 18, 45, 64);
			back.add(time);
			//ʮ��ʱ������ʾ
			timeHOUR = new JLabel(gameTimer.getNow());
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
			
			//���ͷ����ʾ
			head = new JLabel();
			head.setIcon(Images.getImg(User.getPhoto(APP.user)));
			head.setBounds(20, 20, 55, 57);
			back.add(head);
			
			//�����Ϣ��ʾ
			//�����Ϣ��
			playerImfor = new JLabel();
			playerImfor.setIcon(Images.getImg("/image/RecFrameUp.png"));
			playerImfor.setBounds(85, 20, 150, 58);
			back.add(playerImfor);
			//���ID
			playerName = new JLabel("ID"+":"+APP.user);//��ȡ�����Ϣ
			playerImfor.add(playerName);
			playerName.setFont(new Font("����", Font.BOLD, 20));
			playerName.setForeground(Color.BLACK);
			playerName.setBounds(10, 5, 150, 20);
			//��ҵȼ�
			playerClass = new JLabel("�ȼ�"+":"+User.getClasses(APP.user));//��ȡ�����Ϣ
			playerImfor.add(playerClass);
			playerClass.setFont(new Font("����", Font.BOLD, 20));
			playerClass.setForeground(Color.BLACK);
			playerClass.setBounds(10, 30, 150, 20);
			
			//������
			ex = new JPanel();
			ex.setBounds(85,78,(int)150*User.getEx(APP.user)/5000,5);
			ex.setVisible(true);
			ex.setBackground(Color.GREEN);
			back.add(ex);
			
			//������ݽ��룬ֻ�����Ͽ���˯��
			gotoSleep = new JButton();
			gotoSleep.setBackground(Color.BLACK);
			gotoSleep.setBounds(0, 150, 300, 200);
			back.add(gotoSleep);
			gotoSleep.setBorderPainted(false);//����ӡ�߿�  
			gotoSleep.setBorder(null);//��ȥ�߿�  
			gotoSleep.setFocusPainted(false);//��ȥ����Ŀ�  
			gotoSleep.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
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
			moneyText = new JLabel();//��ȡ�û�����
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
			
			powerText = new JLabel();//��ȡ�û�����
			powerLabel.add(powerText);
			powerText.setFont(new Font("����", Font.BOLD, 20));
			powerText.setForeground(Color.BLACK);
			powerText.setBounds(60, 10, 100, 50);
			
			
			//����ˢ��
			Timer timer = new Timer();
			DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //��ø�ʽ�������
			dt.applyPattern("0.0");//����С����λ��(��λ) ���µĻ���������
			timer.schedule(new TimerTask() {
			public void run() {
				
				try {
					//�����ҹת��
					if(gameTimer.getState().equals("day")){
						back.setIcon(Images.getImg("/image/GameFrame.png"));//����
						}
					else {
						back.setIcon(Images.getImg("/image/NightBack.png"));//ҹ��
					}
					
					//��Ҽ�������ʾˢ��
					powerText.setText(User.getEnergy(APP.user)+"/60");
					moneyText.setText(String.valueOf(dt.format(User.getMoney(APP.user))));
					
					//��ҵȼ�ˢ��
					playerClass.setText(String.valueOf("�ȼ�"+":"+User.getClasses(APP.user)));
					
					//Сʱ��ʾˢ��
					timeHOUR.setText(gameTimer.getNow());
					
					//����ֵˢ��
					ex.setBounds(85,78,(int)150*User.getEx(APP.user)/5000,5);
					
					repaint();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			},0,1111);
			
			//��һ������
			Land1 = new LandLabel(1);
			Land1.setBounds(125, 360, 225,80);
			back.add(Land1);
			
			//�ڶ�������
			Land2 = new LandLabel(2);
			Land2.setBounds(275, 360, 225,80);
			back.add(Land2);
			
			//����������
			Land3 = new LandLabel(3);
			Land3.setBounds(425, 360, 225,80);
			back.add(Land3);
			
			//���Ŀ�����
			Land4 = new LandLabel(4);
			Land4.setBounds(0, 440, 225,80);
			back.add(Land4);
			
			//���������
			Land5 = new LandLabel(5);
			Land5.setBounds(150, 440, 225,80);
			back.add(Land5);
			
			//����������
			Land6 = new LandLabel(6);
			Land6.setBounds(300, 440, 225,80);
			back.add(Land6);
			
			
			//����¼�
			JButton towel = new JButton();
			towel.setBounds(983, 210, 54, 61);
			back.add(towel);
			towel.setFocusPainted(false);//��ȥ����Ŀ�  
			towel.setBorderPainted(false); //��ȥbutton�ı߿�
			towel.setContentAreaFilled(false);
			repaint();
			
			towel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(User.getClasses(APP.user)>=3)  //�ȼ��㹻
				{
					if(User.getState(APP.user) == 0) //����˯��
					{
						JOptionPane.showMessageDialog(null, "˯���أ�����~");
					}
					else
					{
						if(RandomEvent.getisHappen() == false ){  //��Ȼ�н������
							RandomHouseFrame window = new RandomHouseFrame();
							RandomEvent.setisHappen(true);
							APP.random=window;
							GameFrame.this.setVisible(false);
							}
						else{
							//�Ƿ���0���񷵻�1
							int n = JOptionPane.showConfirmDialog(null,"�������ѽ���һ����������~��Ը�⻨20����ٽ�һ����","wait",JOptionPane.YES_NO_OPTION);
							if(n==0){
							//user��Ҽ�20
								int i=User.moneyMinus(APP.user, 20);
								//��Ҽ��ٳɹ�
								if(i==1)
								{
									RandomHouseFrame window = new RandomHouseFrame();
									APP.random=window;
									GameFrame.this.setVisible(false);
									RandomEvent.setisHappen(true);
								}
								else
								{
									JOptionPane.showMessageDialog(null, "������ϧ��������Ŷ!");
								}
							}
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "������3���Ժ󿪷ţ�������Ҫ���ͣ�");
				}
				
			}
		});
		
			pack();
		} catch (Exception e) {
			e.printStackTrace();//��ʾ�쳣·��
		}
		
	}
	
	
}
