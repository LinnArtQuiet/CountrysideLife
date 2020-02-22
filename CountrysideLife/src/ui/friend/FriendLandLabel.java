package ui.friend;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Bag.FruitBag;
import Crop.Crop;
import Data.FileData;
import Land.Land;
import Land.LandLabel;
import Medium.Images;
import Medium.Music;
import main.APP;
import user.User;

public class FriendLandLabel extends JLabel{

	private JLabel landstate;//����״̬��ͼ
	private JLabel cropstate;//����״̬��ͼ
	private int landId;//��Ӧ����ID
	private int cropId;//��Ӧ����ID
	private int stageNow;//��Ӧ����׶�
	private String friend;
	
	FriendLandLabel(FriendFrame frame,String friend, int landId)
	{
		FriendLandLabel.this.landId = landId;  //���õ�ǰ�����idֵ
		FriendLandLabel.this.friend = friend;  //���õ�ǰ�����������û�
		cropId = Land.getCropId(friend, landId);
		stageNow = Land.getStageNow(friend, landId);
		//��ʼ����ͼ
		initGUI();
		//������ؼ�����
		this.addMouseListener(new MouseListener() {
			
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
				if(frame.mouseCursorIcon == 100) //�ں��ѽ������ջ�
				{
					if(User.getState(APP.user) == 0)  //��������˯��
					{
						JOptionPane.showMessageDialog(null, "���ζ���͵����");
					}
					else  //���˴�������״̬
					{
						Music harvestbgm = new Music();
						harvestbgm.open("src/sound/harvest.wav");
						harvestbgm.start();
						if(cropId == -1) //��������û��ũ����
						{
							JOptionPane.showMessageDialog(null, "����ӿ����صõ�ʲô�أ�");
						}
						else if(Crop.getStageCount(cropId) != stageNow)  //���������ﲻ���ڳ���׶�
						{
							JOptionPane.showMessageDialog(null, "�ļ��Բ����ȶ����������ȴ��ɣ�");
						}
						else  //�����������ѳ���
						{
							int i = User.getStoleTimes(friend);  //�ú��ѽ��ձ�͵����
							if(i<2)  //�ú��ѽ��ձ�͵����С������2
							{
								Random random = new Random();
								int num = random.nextInt(10);
								try {
									User.energyMinus(3);  //ֻҪ͵����Ϳ۳�3������ֵ
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								if(num != 0)  //0.9�ĸ��ʿ���͵����
								{
									int hour = (int)User.getOutTime(friend)/15000%24;  //������ѵ�ʱ��
									if(6<=hour&&hour<18) //����
									{
										Random ran = new Random();
										int number = ran.nextInt(3);
										if(number != 0){
											JOptionPane.showMessageDialog(null, "�ߺߣ�����͵�ˣ���ץ��������һ���Ұ�!");
											double mon = 0.5*User.getMoney(APP.user);
											User.moneyMinus(APP.user, mon);
											User.moneyAdd(friend, mon);
											DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //��ø�ʽ�������
											dt.applyPattern("0.0");//����С����λ��(��λ) ���µĻ���������
											frame.moneyText = new JLabel(dt.format(User.getMoney(friend)));//��ȡ��������
											repaint();
										}
										else
										{
											FruitBag.addFruitCount(cropId, num);
											JOptionPane.showMessageDialog(null, "����������"+num+"��"+Crop.getName(cropId)+",���ѵĹ�ʵ�����ϣ�");
											User.setStoleTimes(friend, i+1);
										}
									}
									else
									{
										FruitBag.addFruitCount(cropId, num);
										JOptionPane.showMessageDialog(null, "����������"+num+"��"+Crop.getName(cropId)+",���ѵĹ�ʵ�����ϣ�");
										User.setStoleTimes(friend, i+1);
									}
									
								}
								else  //0.1�ĸ���ʲôҲ͵����������ʧȥ������
								{
									JOptionPane.showMessageDialog(null, "͵������ʴ���ף�");
								}
							}
							else  //�ú��ѽ��ձ�͵�����Ѵ�����2
							{
								JOptionPane.showMessageDialog(null, "ʩ�������죬����Ҫ�����");
							}
						}
					}
					
				}
				
				if(frame.mouseCursorIcon == 200)
				{
					if(User.getState(APP.user) == 0)
					{
						JOptionPane.showMessageDialog(null, "֪�����Ǵ���ˣ����Ǻ��ܹ�Լ���ʱ��Ͳ�Ҫ��������");
					}
					else
					{
						Music waterbgm = new Music();
						waterbgm.open("src/sound/water.wav");
						waterbgm.start();
						if(Land.getState(friend, landId) != 0)
						{
							JOptionPane.showMessageDialog(null, "лл�㣬����������ز��ý�ˮ�أ�");
						}
						else
						{
							int i = User.getHelpTimes(friend);
							if(i<2)
							{
								Random random = new Random();
								int num = random.nextInt(5);
								Land.setdieTime(friend, landId, 0);  //�ı���ѵ�����״̬
								Land.setgrowTime(friend, landId, 0);
								Land.setState(friend, landId, 2);
								User.setHelpTimes(friend,i+1);
								landstate.setIcon(Images.getImg(Land.getLandPic(getLState())));
								repaint();
								if(num>2)
								{
									Random ran = new Random();
									int number = ran.nextInt(30);
									JOptionPane.showMessageDialog(null, "�ۣ�̫��л���ˣ�����"+number+"Ԫ��һ��С�����ı����⣡");
									User.moneyAdd(APP.user, (double)number);
								}
								else
								{
									JOptionPane.showMessageDialog(null, "��л������");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "���ź�������"+friend+"���ձ����������Ѵ����ޣ�");
							}
						}	
					}
				}
			}
				
		});
	}
	
	/*��ʼ����ͼ*/
	private void initGUI() {
		try {
			this.setSize(225,80);
			this.setLayout(new BorderLayout());
			landstate= new JLabel();
			
			this.add(landstate,BorderLayout.CENTER);
			
			landstate.setLayout(null);
			landstate.setBounds(0, 0, 225,80);//����״̬��ͼλ��
			cropstate= new JLabel();
			landstate.add(cropstate);
			cropstate.setBounds(0, 0, 225,80);//����״̬��ͼλ��
			
			landstate.setIcon(Images.getImg(Land.getLandPic(getLState())));
			if(cropId == -1)
			{
				cropstate.setIcon(null);
			}
			else
			{
				cropstate.setIcon(Images.getImg(Crop.getCropPic(cropId, stageNow)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getLState()//��ȡ��Ӧ����״̬
	{
		int lstate = Land.getState(friend, landId);
		return lstate;
	}
}
