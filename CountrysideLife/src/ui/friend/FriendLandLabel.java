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

	private JLabel landstate;//土地状态贴图
	private JLabel cropstate;//作物状态贴图
	private int landId;//对应土地ID
	private int cropId;//对应土地ID
	private int stageNow;//对应作物阶段
	private String friend;
	
	FriendLandLabel(FriendFrame frame,String friend, int landId)
	{
		FriendLandLabel.this.landId = landId;  //设置当前对象的id值
		FriendLandLabel.this.friend = friend;  //设置当前对象所属的用户
		cropId = Land.getCropId(friend, landId);
		stageNow = Land.getStageNow(friend, landId);
		//初始化贴图
		initGUI();
		//添加土地监听器
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
				if(frame.mouseCursorIcon == 100) //在好友界面点击收获
				{
					if(User.getState(APP.user) == 0)  //本人正在睡觉
					{
						JOptionPane.showMessageDialog(null, "做梦都想偷菜吗？");
					}
					else  //本人处于清醒状态
					{
						Music harvestbgm = new Music();
						harvestbgm.open("src/sound/harvest.wav");
						harvestbgm.start();
						if(cropId == -1) //该土地上没有农作物
						{
							JOptionPane.showMessageDialog(null, "你想从空土地得到什么呢？");
						}
						else if(Crop.getStageCount(cropId) != stageNow)  //土地上作物不处于成熟阶段
						{
							JOptionPane.showMessageDialog(null, "心急吃不了热豆腐，慢慢等待吧！");
						}
						else  //土地上作物已成熟
						{
							int i = User.getStoleTimes(friend);  //该好友今日被偷次数
							if(i<2)  //该好友今日被偷次数小于上限2
							{
								Random random = new Random();
								int num = random.nextInt(10);
								try {
									User.energyMinus(3);  //只要偷作物就扣除3点体力值
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								if(num != 0)  //0.9的概率可以偷到菜
								{
									int hour = (int)User.getOutTime(friend)/15000%24;  //计算好友的时间
									if(6<=hour&&hour<18) //白天
									{
										Random ran = new Random();
										int number = ran.nextInt(3);
										if(number != 0){
											JOptionPane.showMessageDialog(null, "哼哼，让你偷菜，被抓包，贡献一半金币吧!");
											double mon = 0.5*User.getMoney(APP.user);
											User.moneyMinus(APP.user, mon);
											User.moneyAdd(friend, mon);
											DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //获得格式化类对象
											dt.applyPattern("0.0");//设置小数点位数(两位) 余下的会四舍五入
											frame.moneyText = new JLabel(dt.format(User.getMoney(friend)));//调取好友数据
											repaint();
										}
										else
										{
											FruitBag.addFruitCount(cropId, num);
											JOptionPane.showMessageDialog(null, "嘻嘻，到手"+num+"个"+Crop.getName(cropId)+",朋友的果实更香呦！");
											User.setStoleTimes(friend, i+1);
										}
									}
									else
									{
										FruitBag.addFruitCount(cropId, num);
										JOptionPane.showMessageDialog(null, "嘻嘻，到手"+num+"个"+Crop.getName(cropId)+",朋友的果实更香呦！");
										User.setStoleTimes(friend, i+1);
									}
									
								}
								else  //0.1的概率什么也偷不到，反而失去了体力
								{
									JOptionPane.showMessageDialog(null, "偷鸡不成蚀把米！");
								}
							}
							else  //该好友今日被偷次数已达上限2
							{
								JOptionPane.showMessageDialog(null, "施主好面熟，做人要厚道！");
							}
						}
					}
					
				}
				
				if(frame.mouseCursorIcon == 200)
				{
					if(User.getState(APP.user) == 0)
					{
						JOptionPane.showMessageDialog(null, "知道你是大好人，但是和周公约会的时候就不要分心啦！");
					}
					else
					{
						Music waterbgm = new Music();
						waterbgm.open("src/sound/water.wav");
						waterbgm.start();
						if(Land.getState(friend, landId) != 0)
						{
							JOptionPane.showMessageDialog(null, "谢谢你，但是这块土地不用浇水呢！");
						}
						else
						{
							int i = User.getHelpTimes(friend);
							if(i<2)
							{
								Random random = new Random();
								int num = random.nextInt(5);
								Land.setdieTime(friend, landId, 0);  //改变好友的土地状态
								Land.setgrowTime(friend, landId, 0);
								Land.setState(friend, landId, 2);
								User.setHelpTimes(friend,i+1);
								landstate.setIcon(Images.getImg(Land.getLandPic(getLState())));
								repaint();
								if(num>2)
								{
									Random ran = new Random();
									int number = ran.nextInt(30);
									JOptionPane.showMessageDialog(null, "哇！太感谢你了！赠送"+number+"元，一点小报酬聊表心意！");
									User.moneyAdd(APP.user, (double)number);
								}
								else
								{
									JOptionPane.showMessageDialog(null, "多谢大侠！");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "很遗憾！好友"+friend+"当日被救助次数已达上限！");
							}
						}	
					}
				}
			}
				
		});
	}
	
	/*初始化贴图*/
	private void initGUI() {
		try {
			this.setSize(225,80);
			this.setLayout(new BorderLayout());
			landstate= new JLabel();
			
			this.add(landstate,BorderLayout.CENTER);
			
			landstate.setLayout(null);
			landstate.setBounds(0, 0, 225,80);//土地状态贴图位置
			cropstate= new JLabel();
			landstate.add(cropstate);
			cropstate.setBounds(0, 0, 225,80);//作物状态贴图位置
			
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
	
	public int getLState()//获取对应土地状态
	{
		int lstate = Land.getState(friend, landId);
		return lstate;
	}
}
