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
	
	//容器和背景图
	private JPanel GamePanel;
	private JLabel back;  //背景图容器
	
	//经验条
	private JPanel ex;
	
	//仅作为显示的部分
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
	
	//可操作的按钮
	private JLabel inventory;
	private JLabel harvest;
	private JLabel move;
	private JLabel water;
	private JLabel set;
	
	//时间切换
	public GameTimer gameTimer;
	private JLabel time;
	private JLabel timeSHI;
	private JLabel timeHOUR;
	
	//实现睡眠功能
	private JButton gotoSleep;//点击房屋进入睡眠状态
	private JButton goback;//回地图
	
	//土地
	private LandLabel Land1;
	private LandLabel Land2;
	private LandLabel Land3;
	private LandLabel Land4;
	private LandLabel Land5;
	private LandLabel Land6;
	
	public int mouseCursorIcon;//鼠标的图标
	private MoveBird aBird;

	/**
	 * 带参的构造函数
	 */
	public GameFrame() {
		super();
		//时间系统
		gameTimer=new GameTimer();
		
		
		//设置鼠标跟随值
		mouseCursorIcon = 0;

		initGUI();
		MyMouse();
		if(User.getHelpTimes(APP.user)!=0)//下线期间被帮助
		{
			if(User.getStoleTimes(APP.user)!=0)//下线期间被小偷光顾
			{
				JOptionPane.showMessageDialog(null, "哎！当今世道鱼龙混杂！");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "听说有人做了好事未留名！");
			}
		}
		else
		{
			if(User.getStoleTimes(APP.user)!=0)//下线期间被小偷光顾
			{
				JOptionPane.showMessageDialog(null, "难道最近田地风水比较好？");
			}
		}
	}
	/**
	 * 获取当前椎鼠标跟随的标志
	 * 
	 * @return int 鼠标跟随的标志
	 */
	public int getMouseCursorIcon() {
		return mouseCursorIcon;
	}
	/**
	 * 设置当前椎鼠标跟随的标志
	 * 
	 * @param mouseCursorIcon
	 *            鼠标跟随的标志
	 */
	public void setMouseCursorIcon(int mouseCursorIcon) {
		this.mouseCursorIcon = mouseCursorIcon;
	}
	
	
	/**
	 * 监听器
	 * 
	 */
	
	
	//点击监听器
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
	
	//换图监听器
	private class MyChangeImage extends MouseAdapter{

		@Override
		public void mouseEntered(MouseEvent e){
			JLabel jLabel = (JLabel) e.getSource();
			// 得到图象文件名称
			String s = ((ImageIcon) jLabel.getIcon()).getDescription();
			String sub = s.substring(s.indexOf('_')+1, s.indexOf('('));
			ImageIcon icon = Images.getImg("/image/button_" + sub + "(press).png");
			jLabel.setIcon(icon);
			jLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel jLabel = (JLabel) e.getSource();
			// 得到图象文件名称
			String s = ((ImageIcon) jLabel.getIcon()).getDescription();
			String sub = s.substring(s.indexOf('_')+1, s.indexOf('('));
			ImageIcon icon = Images.getImg("/image/button_" + sub + "(release).png");
			jLabel.setIcon(icon);
			jLabel.setSize(icon.getIconWidth(), icon.getIconHeight());

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
					GameFrame.this.setCursor(null);
					setMouseCursorIcon(0);
				}
			}
		}
		
	}
	
	private void MyMouse() {
		//鼠标点击监听器
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
		//鼠标
		MyChangeImage mouseChange = new MyChangeImage();
		inventory.addMouseListener(mouseChange);
		set.addMouseListener(mouseChange);
		harvest.addMouseListener(mouseChange);
		move.addMouseListener(mouseChange);
		water.addMouseListener(mouseChange);
		
		MyBACKGROUNDLis mb = new MyBACKGROUNDLis();
		back.addMouseListener(mb);
	}
		
	//JFrame布局
	private void initGUI() {
		
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//没有实现进程关闭
			
			GamePanel = new JPanel();
			getContentPane().add(GamePanel, BorderLayout.CENTER);
			GamePanel.setLayout(null);
			GamePanel.setPreferredSize(new java.awt.Dimension(1067, 600));
			
			//新建家
			APP.room = new MainRoom();
			APP.room.setVisible(false);
			
			//主界面背景
			back = new JLabel();
			back.setBounds(0, 0, 1067, 600);
			GamePanel.add(back);
			
			
			//小天鹅
			aBird=new MoveBird();
			back.add(aBird);
			aBird.setBackground(null);
			aBird.setOpaque(false);
			aBird.setBounds(767, 321, 300, 250);
			
			//蝴蝶
			//前往下一张地图
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
						JOptionPane.showMessageDialog(null, "境外洞天10级开放，敬请期待哦~");
					}
					else
					{
						if(User.getState(APP.user) == 0) //正在睡觉
						{
							JOptionPane.showMessageDialog(null, "天大地大，睡觉最大~");
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
								int is = JOptionPane.showConfirmDialog(null,"今日您已进过一次境外洞天辽~您愿意花50金币再进一次吗？");
								if(is == JOptionPane.OK_OPTION){
								//user金币减20
									int i=User.moneyMinus(APP.user, 50);
									//金币减少成功
									if(i==1)
									{
										GameFrame.this.setVisible(false);
										new NPC();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "超级可惜，今天见不到想见的人了~");
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
			
			//两只鸟
			JLabel twobirds=new JLabel();;
			twobirds.setIcon(Images.getImg("/image/twobirds.gif"));
			twobirds.setBounds(15, 95, 52, 39);
			back.add(twobirds);
			
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
					GameFrame.this.setVisible(false);
				}
			});
	        
			//库存背包按钮
			inventory = new JLabel();
			inventory.setIcon(Images.getImg("/image/button_Inventory(release).png"));
			inventory.setBounds(980, 530, 56, 58);
			back.add(inventory);
			
			
			//收获农作物按钮
			harvest = new JLabel();
			harvest.setIcon(Images.getImg("/image/button_harvest(release).png"));
			harvest.setBounds(100, 530, 55, 57);
			back.add(harvest);
			
			//移除农作物按钮
			move = new JLabel();
			move.setIcon(Images.getImg("/image/button_move(release).png"));
			move.setBounds(180, 530, 55, 57);
			back.add(move);
			
			//浇水按钮
			water = new JLabel();
			water.setIcon(Images.getImg("/image/button_water(release).png"));
			water.setBounds(20, 530, 55, 57);
			back.add(water);
			
			//设置按钮
			set = new JLabel();
			set.setIcon(Images.getImg("/image/button_Set(release).png"));
			set.setBounds(970, 20, 56, 57);
			back.add(set);
			
			//时间显示
			time = new JLabel();
			time.setIcon(Images.getImg("/image/Time.png"));
			time.setBounds(595, 18, 45, 64);
			back.add(time);
			//十二时辰的显示
			timeHOUR = new JLabel(gameTimer.getNow());
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
			
			//玩家头像显示
			head = new JLabel();
			head.setIcon(Images.getImg(User.getPhoto(APP.user)));
			head.setBounds(20, 20, 55, 57);
			back.add(head);
			
			//玩家信息显示
			//玩家信息框
			playerImfor = new JLabel();
			playerImfor.setIcon(Images.getImg("/image/RecFrameUp.png"));
			playerImfor.setBounds(85, 20, 150, 58);
			back.add(playerImfor);
			//玩家ID
			playerName = new JLabel("ID"+":"+APP.user);//获取玩家信息
			playerImfor.add(playerName);
			playerName.setFont(new Font("楷体", Font.BOLD, 20));
			playerName.setForeground(Color.BLACK);
			playerName.setBounds(10, 5, 150, 20);
			//玩家等级
			playerClass = new JLabel("等级"+":"+User.getClasses(APP.user));//获取玩家信息
			playerImfor.add(playerClass);
			playerClass.setFont(new Font("楷体", Font.BOLD, 20));
			playerClass.setForeground(Color.BLACK);
			playerClass.setBounds(10, 30, 150, 20);
			
			//经验条
			ex = new JPanel();
			ex.setBounds(85,78,(int)150*User.getEx(APP.user)/5000,5);
			ex.setVisible(true);
			ex.setBackground(Color.GREEN);
			back.add(ex);
			
			//点击房屋进入，只有晚上可以睡觉
			gotoSleep = new JButton();
			gotoSleep.setBackground(Color.BLACK);
			gotoSleep.setBounds(0, 150, 300, 200);
			back.add(gotoSleep);
			gotoSleep.setBorderPainted(false);//不打印边框  
			gotoSleep.setBorder(null);//除去边框  
			gotoSleep.setFocusPainted(false);//除去焦点的框  
			gotoSleep.setContentAreaFilled(false);//除去默认的背景填充
			
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
			moneyText = new JLabel();//调取用户数据
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
			
			powerText = new JLabel();//调取用户数据
			powerLabel.add(powerText);
			powerText.setFont(new Font("楷体", Font.BOLD, 20));
			powerText.setForeground(Color.BLACK);
			powerText.setBounds(60, 10, 100, 50);
			
			
			//界面刷新
			Timer timer = new Timer();
			DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //获得格式化类对象
			dt.applyPattern("0.0");//设置小数点位数(两位) 余下的会四舍五入
			timer.schedule(new TimerTask() {
			public void run() {
				
				try {
					//白天黑夜转换
					if(gameTimer.getState().equals("day")){
						back.setIcon(Images.getImg("/image/GameFrame.png"));//白天
						}
					else {
						back.setIcon(Images.getImg("/image/NightBack.png"));//夜晚
					}
					
					//金币及体力显示刷新
					powerText.setText(User.getEnergy(APP.user)+"/60");
					moneyText.setText(String.valueOf(dt.format(User.getMoney(APP.user))));
					
					//玩家等级刷新
					playerClass.setText(String.valueOf("等级"+":"+User.getClasses(APP.user)));
					
					//小时显示刷新
					timeHOUR.setText(gameTimer.getNow());
					
					//经验值刷新
					ex.setBounds(85,78,(int)150*User.getEx(APP.user)/5000,5);
					
					repaint();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			},0,1111);
			
			//第一块土地
			Land1 = new LandLabel(1);
			Land1.setBounds(125, 360, 225,80);
			back.add(Land1);
			
			//第二块土地
			Land2 = new LandLabel(2);
			Land2.setBounds(275, 360, 225,80);
			back.add(Land2);
			
			//第三块土地
			Land3 = new LandLabel(3);
			Land3.setBounds(425, 360, 225,80);
			back.add(Land3);
			
			//第四块土地
			Land4 = new LandLabel(4);
			Land4.setBounds(0, 440, 225,80);
			back.add(Land4);
			
			//第五块土地
			Land5 = new LandLabel(5);
			Land5.setBounds(150, 440, 225,80);
			back.add(Land5);
			
			//第六块土地
			Land6 = new LandLabel(6);
			Land6.setBounds(300, 440, 225,80);
			back.add(Land6);
			
			
			//随机事件
			JButton towel = new JButton();
			towel.setBounds(983, 210, 54, 61);
			back.add(towel);
			towel.setFocusPainted(false);//除去焦点的框  
			towel.setBorderPainted(false); //除去button的边框
			towel.setContentAreaFilled(false);
			repaint();
			
			towel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(User.getClasses(APP.user)>=3)  //等级足够
				{
					if(User.getState(APP.user) == 0) //正在睡觉
					{
						JOptionPane.showMessageDialog(null, "睡觉呢，别闹~");
					}
					else
					{
						if(RandomEvent.getisHappen() == false ){  //仍然有进入机会
							RandomHouseFrame window = new RandomHouseFrame();
							RandomEvent.setisHappen(true);
							APP.random=window;
							GameFrame.this.setVisible(false);
							}
						else{
							//是返回0，否返回1
							int n = JOptionPane.showConfirmDialog(null,"今日您已进过一次随意塔辽~您愿意花20金币再进一次吗？","wait",JOptionPane.YES_NO_OPTION);
							if(n==0){
							//user金币减20
								int i=User.moneyMinus(APP.user, 20);
								//金币减少成功
								if(i==1)
								{
									RandomHouseFrame window = new RandomHouseFrame();
									APP.random=window;
									GameFrame.this.setVisible(false);
									RandomEvent.setisHappen(true);
								}
								else
								{
									JOptionPane.showMessageDialog(null, "超级可惜，不打折哦!");
								}
							}
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "随意塔3级以后开放，您还需要加油！");
				}
				
			}
		});
		
			pack();
		} catch (Exception e) {
			e.printStackTrace();//显示异常路径
		}
		
	}
	
	
}
