package Land;
import java.awt.BorderLayout;
/**
 * @author YJX
 * @updateTime 2019.12.11*/
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Bag.SeedBag;
import Crop.Crop;
import Event.Event;
import Medium.Images;
import main.APP;
import user.User;

public class LandLabel extends JLabel{
	
	private JLabel landstate;//土地状态贴图
	private JLabel cropstate;//作物状态贴图
	private int landId;//对应土地ID
	/**构造函数
	 * 传入依附的主界面对象及土地ID
	 * 进行初始化贴图
	 * 获取土地的农作物状态
	 * 添加监听器
	 * 定时刷新状态*/
	public LandLabel(int landId) {
		super();
		
		LandLabel.this.landId = landId;  //设置当前对象的id值
		//初始化贴图
		initGUI();
		//添加土地监听器
		myListioner();
		
//		if(Land.getCropId(APP.user, landId)!=-1)
		if(Land.getCropId(APP.user, landId)!=-1 && !Land.isCropRipe(landId))
		{
			Land.grow(landId,LandLabel.this);
		}
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
			
			//加载土地和作物状态图
			try {
				flush();
				}catch (Exception e1) {
					// TODO: handle exception
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*土地监听器*/
	private class MyMouseListener extends MouseAdapter{
		int level = Land.getLevel(landId);
		public void mouseClicked(MouseEvent e) {
			
			if(User.getClasses(APP.user)<level)
			{
				JOptionPane.showMessageDialog(null, "该土地"+level+"级解锁，您还需要努力！");
			}
			else
			{
				//获得鼠标携带值
				int flag = e.getModifiers();
				//判断鼠标状态是不是左键单击
				if (flag == InputEvent.BUTTON1_MASK) {
					if(User.getState(APP.user)==0)
					{
						JOptionPane.showMessageDialog(null, "睡眠状态无法进行操作");
					}
					else
					{
						//判断鼠标知道要进行收获
						if (APP.gf.getMouseCursorIcon() == 100) {//收获功能键鼠标携带值为100
							if (Land.getCropId(APP.user, landId)!=-1) {//判断土地是否为空
								//判断作物是否成熟
								if(Land.isCropRipe(landId)) {
									//调用Event类收获方法
									Event.harvest(landId);
									//刷新当前土地及农作物状态图
									try {
										flush();
										}catch (Exception e1) {
											// TODO: handle exception
										}
								}
								else if(Land.getStageNow(APP.user, landId)>Crop.getStageCount(Land.getCropId(APP.user, landId)))
								{
									JOptionPane.showMessageDialog(null, "请先铲除枯萎的"+Crop.getName(Land.getCropId(APP.user, landId))+"！");
									return;
								}
								else{//当前农作物还没成熟
									JOptionPane.showMessageDialog(null, Crop.getName(Land.getCropId(APP.user, landId))+"还没有成熟，再等等吧！");
									return;
									}
								}
							else{//当前土地没有农作物
								JOptionPane.showMessageDialog(null, "土地为空！");
								return;
							}
						}
						//判断鼠标知道要进行移除
						else if (APP.gf.getMouseCursorIcon() == 200) {//移除功能键鼠标携带值为200
							if (Land.getCropId(APP.user, landId)!=-1) {//判断土地是否为空
								if(Land.getStageNow(APP.user, landId)<=Crop.getStageCount(Land.getCropId(APP.user, landId)))
								{
									int is = JOptionPane.showConfirmDialog(null, Crop.getName(Land.getCropId(APP.user, landId))+"还没有枯萎，确定要铲除吗？");
									if(is == JOptionPane.OK_OPTION)
									{
										Event.move(landId);  //调用Event类移除方法
										//刷新当前土地及农作物状态图
										try {
											flush();
											}catch (Exception e1) {
												// TODO: handle exception
											}
									}
								}
								else
								{
									//调用Event类移除方法
									Event.move(landId);
									//刷新当前土地及农作物状态图
									try {
										flush();
										}catch (Exception e1) {
											// TODO: handle exception
										}
								}
							}
							else{//当前土地没有农作物
								 JOptionPane.showMessageDialog(null, "土地为空！");
								 return;
							}
						}
						//判断鼠标知道要进行浇水
						else if(APP.gf.getMouseCursorIcon() == 300) {//浇水功能键鼠标携带值为300
							if (Land.getCropId(APP.user, landId)!=-1) {//判断土地是否为空
								//判断是否枯死
								if(Land.getStageNow(APP.user, landId)>(Crop.getStageCount(Land.getCropId(APP.user, landId))))
								{
									JOptionPane.showMessageDialog(null, Crop.getName(Land.getCropId(APP.user, landId))+"已枯死，请及时铲除！");
								}
								else
								{
									//判断土地干湿状态
									if(Land.getState(APP.user, landId)==2) {//土地是湿的
										JOptionPane.showMessageDialog(null, "再浇水"+Crop.getName(Land.getCropId(APP.user, landId))+"就要被淹死啦！");
										return;
									}
									else if(Land.getState(APP.user, landId)==1) {//土地是正常状态的
										JOptionPane.showMessageDialog(null, "水分够啦！");
										return;
									}
									else{  //土地是干的
										//调用Event类浇水方法
										Event.water(landId);
										//刷新当前土地及农作物状态图
										try {
										flush();
										}catch (Exception e1) {
											// TODO: handle exception
											System.out.println("浇水刷新异常");
										}
										//刷新主界面用户体力和经验值
									}
								}
														
							}
							else {//当前土地没有农作物
								 JOptionPane.showMessageDialog(null, "土地为空！");
								 return;
							}
						}
						//判断鼠标知道要进行播种
						else if(APP.gf.getMouseCursorIcon()>0 && APP.gf.getMouseCursorIcon()<12) {//目前暂定11种农作物ID从1-11
							if(Land.getCropId(APP.user, landId) == -1) {//判断土地状态是否可种	
								//获取当前鼠标携带的农作物ID
								//调用Event类种植方法
								Event.sow( landId, APP.gf.getMouseCursorIcon(),LandLabel.this);
								//刷新当前土地及农作物状态图
								if(SeedBag.getSeedCount(APP.gf.getMouseCursorIcon())==0)  //若种子已经消耗完则不能再继续种植了
								{
									APP.gf.setMouseCursorIcon(0);
									APP.gf.setCursor(null);
								}
								try {
									flush();
									}catch (Exception e1) {
										// TODO: handle exception
										System.out.println("播种刷新异常");
									}
							}
							else{//当前土地已有农作物
								JOptionPane.showMessageDialog(null, "这块土地已经被种啦！");
								return;
							}
						}
					}
					
				}
			}
			
		}
	}
	
	/*添加土地监听器*/
	private void myListioner() {
		MyMouseListener myl = new MyMouseListener();
		LandLabel.this.addMouseListener(myl);
	}
	
	public void flush() {
		//调用土地数据库数据判断土地干湿状态
		landstate.setIcon(Images.getImg(Land.getLandPic(Land.getState(APP.user, landId))));
		if(0<=Land.getStageNow(APP.user, landId)&&Land.getStageNow(APP.user, landId)<=(Crop.getStageCount(Land.getCropId(APP.user, landId))+1))
		{
			//调用土地数据库判断作物状态
			String CropPicPath = Crop.getCropPic(Land.getCropId(APP.user, landId), Land.getStageNow(APP.user, landId));
			//设置当前作物当前状态的图
			cropstate.setIcon(Images.getImg(CropPicPath));
		}
		else
			cropstate.setIcon(null);
	}
	
}




