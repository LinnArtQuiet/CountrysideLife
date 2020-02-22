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
		//��ʼ��UI
		initUI();
	}
	/**��ʼ��UI*/
	public void initUI() {
		//���붯��ͼƬ����Сλ��
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
		
		//����ȥ������İ�ť
		JLabel toGameFrame=new JLabel("���");
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
				//ȥ������ķ���
				if(APP.gf==null)
				{
					APP.gf = new GameFrame();
				}
				else
				{
					APP.gf.setVisible(true);
				}
				//�رյ�ǰ����
				MapFrame.this.dispose();
			}
		});
		this.add(toGameFrame);
		
		//����ȥ�̵����İ�ť
		JLabel toShop=new JLabel("�м�");
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
				//ȥ�̵�ķ���	
				new ShopFrame();
			}
		});
		this.add(toShop);
		
		//����ȥ���Ѽҵİ�ť
		JLabel toFriend=new JLabel("����");
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
				//�½�һ�������б�
				FriendListFrame aFrame=new FriendListFrame(MapFrame.this);
			}
		});
		this.add(toFriend);
		
		//�����ƶ�����
		MoveBack backJPanel=new MoveBack();
		this.add(backJPanel);
		backJPanel.setBackground(null);
		backJPanel.setOpaque(false);
	}
	
}
class MoveBack extends JPanel{
	//װ���ƶ��ı���ͼ
	private River river1;
	public MoveBack(){
		setBounds(0,0,1067,600);//��������С
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
	//װ�ر���ͼ
	public Image RiverImage1;
	public Image RiverImage2;
	//����ͼ����
	public int x1,y1;
	public int x2,y2;
	//���������
	public JPanel jp;
	//�ƶ��ٶ�
	public int movesp=1;
	//�ƶ��ľ���
	public int movedistance=0;
	//��¼����λ��
	public int startX1,startY1;
	public int startX2,startY2;
	
	/**���췽��������������������*/
	public River(JPanel jp) {
		this.jp=jp;	
		this.startX1=0;
		this.startY1=0;
		this.startX2=jp.getWidth()-18;//Ϊ��������ͼ�޷��ν�
		this.startY2=0;
		x1=startX1;
		y1=startY1;
		x2=startX2;
		y2=startY2;
	}
	
	/**�������ƶ��߼�*/
	/**�����õĳ�ʼλ�����������ƶ����Ŀ�Ⱥ�
	 * �ٴλص���ʼλ��*/
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
	
	/**�����߳�run����*/
	public void run() {
		RiverImage1=new ImageIcon(this.getClass().getResource("/image/moveback.jpg")).getImage();
		RiverImage2=new ImageIcon(this.getClass().getResource("/image/moveback.jpg")).getImage();
		 while(true){
			 move();
			 jp.repaint();
			 try {
	                Thread.sleep(100);//0.1��ˢ��һ��
	            }catch (InterruptedException e) {
	                e.printStackTrace();
	         }
		 }
	}
}