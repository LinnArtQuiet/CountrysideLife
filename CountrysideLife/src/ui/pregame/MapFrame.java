package ui.pregame;
/**YJX
 * 20191215*/
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Medium.Images;
import main.APP;
import ui.father.MyFrame;
import ui.friend.FriendListFrame;
import ui.game.GameFrame;
import ui.store.ShopFrame;

public class MapFrame extends MyFrame{
	public MapFrame() {
		//初始化UI
		initUI();
	}
	/**初始化UI*/
	public void initUI() {
		//加入动船图片及大小位置
		JLabel boat=new JLabel();
		boat.setIcon(Images.getImg("/image/boat.jpg"));
		boat.setBounds(450, 230, 400, 400);
		boat.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}	
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MapFrame.this.dispose();
				try {
					new InformationFrame();
					APP.gf.dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		this.add(boat);
		
		//加入去主界面的按钮
		JLabel toGameFrame=new JLabel("归家");
		ImageIcon icon1=Images.getImg("/image/toGameFrame.jpg");
		toGameFrame.setIcon(icon1);
//		toGameFrame.setIcon(new ImageIcon(Map.class.getResource("/image/toGameFrame.jpg")));
		toGameFrame.setBounds(160,30, icon1.getIconWidth(), icon1.getIconHeight());
		toGameFrame.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}	
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//去主界面的方法
				if(APP.gf==null)
				{
					APP.gf = new GameFrame();
				}
				else
				{
					APP.gf.setVisible(true);
				}
				//关闭当前窗体
				MapFrame.this.dispose();
			}
		});
		this.add(toGameFrame);
		
		//加入去商店界面的按钮
		JLabel toShop=new JLabel("市集");
		ImageIcon icon2=Images.getImg("/image/toShop.jpg");
		toShop.setIcon(icon2);
		toShop.setBounds(480,30,icon2.getIconWidth(),icon2.getIconHeight());
		toShop.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}	
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//去商店的方法	
				new ShopFrame();
			}
		});
		this.add(toShop);
		
		//加入去好友家的按钮
		JLabel toFriend=new JLabel("访友");
		ImageIcon icon3=Images.getImg("/image/toFriend.jpg");
		toFriend.setIcon(icon3);
		toFriend.setBounds(800,30,icon3.getIconWidth(), icon3.getIconHeight());
		toFriend.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}	
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//新建一个好友列表
				FriendListFrame aFrame=new FriendListFrame(MapFrame.this);
			}
		});
		this.add(toFriend);
		
		//加入移动背景
		MoveBack backJPanel=new MoveBack();
		this.add(backJPanel);
		backJPanel.setBackground(null);
		backJPanel.setOpaque(false);
	}
	
}
class MoveBack extends JPanel{
	//装载移动的背景图
	private River river1;
	public MoveBack(){
		setBounds(0,0,1067,600);//设置面板大小
		river1=new River(this);
		river1.start();
	}
	 public void paint(Graphics g){
	        super.paint(g);
	        g.drawImage(river1.RiverImage1, river1.x1, river1.y1, this.getWidth(), this.getHeight(), this);
	        g.drawImage(river1.RiverImage2, river1.x2, river1.y2, this.getWidth(), this.getHeight(), this);
	 }
}
class River extends Thread{
	//装载背景图
	public Image RiverImage1;
	public Image RiverImage2;
	//背景图坐标
	public int x1,y1;
	public int x2,y2;
	//依附的面板
	public JPanel jp;
	//移动速度
	public int movesp=1;
	//移动的距离
	public int movedistance=0;
	//记录启动位置
	public int startX1,startY1;
	public int startX2,startY2;
	
	/**构造方法，输入依附的面板对象*/
	public River(JPanel jp) {
		this.jp=jp;	
		this.startX1=0;
		this.startY1=0;
		this.startX2=jp.getWidth()-18;//为了让两张图无缝衔接
		this.startY2=0;
		x1=startX1;
		y1=startY1;
		x2=startX2;
		y2=startY2;
	}
	
	/**背景的移动逻辑*/
	/**从设置的初始位置坐标向左移动面板的宽度后
	 * 再次回到初始位置*/
	public void move() {
		x1-=movesp;
		x2-=movesp;
		movedistance+=movesp;
		if(movedistance==jp.getWidth()) {
			x1=startX1;
			y1=startY1;
			x1=startX2;
			y1=startY2;
		}
	}
	
	/**重载线程run方法*/
	public void run() {
		RiverImage1=new ImageIcon(this.getClass().getResource("/image/moveback.jpg")).getImage();
		RiverImage2=new ImageIcon(this.getClass().getResource("/image/moveback.jpg")).getImage();
		 while(true){
			 move();
			 jp.repaint();
			 try {
	                Thread.sleep(100);//0.1秒刷新一次
	            }catch (InterruptedException e) {
	                e.printStackTrace();
	         }
		 }
	}
}