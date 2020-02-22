package Land;

import java.util.Timer;
import java.util.TimerTask;

import Crop.Crop;
import Data.FileData;
import main.APP;

public class Land {
	
	
	/*获取种植的农作物编号*/
	public static int getCropId(String uID, int landId) {
		int cropId = Integer.parseInt(FileData.get(uID, "land"+landId, "cropId"));
		return cropId;
	}

	/*设置种植的农作物编号*/
	public static void setCropId(String uID, int landId, int cropId) {
		FileData.update(uID, "land"+landId, "cropId", cropId+"");
	}
	
	/*获取当前阶段已经开始时间*/
	public static long getgrowTime(String uID, int landId) {
		long growTime = Integer.parseInt(FileData.get(uID, "land"+landId, "growTime"));
		return growTime;
	}

	/*设置当前阶段已经开始时间*/
	public static void setgrowTime(String uID, int landId, long growTime) {
		FileData.update(uID, "land"+landId, "growTime", growTime+"");
	}
	
	
	/*获取枯死倒计时时间*/
	public static long getdieTime(String uID, int landId) {
		long dieTime = Integer.parseInt(FileData.get(uID, "land"+landId, "dieTime"));
		return dieTime;
	}
	
	/*设置枯死倒计时时间*/
	public static void setdieTime(String uID, int landId, long dieTime) {
		FileData.update(uID, "land"+landId, "dieTime", dieTime+"");
	}
	
	/*获取当前土地上农作物的生长阶段*/
	public static int getStageNow(String uID, int landId) {
		int stageNow = Integer.parseInt(FileData.get(uID, "land"+landId, "stageNow"));
		return stageNow;
	}
	
	/*设置当前土地上农作物生长阶段*/
	public static void setStageNow(String uID, int landId, int stageNow) {
		FileData.update(uID, "land"+landId, "stageNow", stageNow+"");
	}
	
	/*获取土地状态*/
	public static int getState(String uID, int landId) {
		int state = Integer.parseInt(FileData.get(uID, "land"+landId, "state"));
		return state;
	
	}
	
	/*设置土地状态*/
	public static void setState(String uID, int landId, int state) {
		FileData.update(uID, "land"+landId, "state", state+"");
	}
	
	/*获取土地解锁等级*/
	public static int getLevel(int landId) {
		int state = Integer.parseInt(FileData.get(APP.user, "land"+landId, "getLevel"));
		return state;
	}
	
	//获取土地图片地址
	public static String getLandPic(int state) {
		String path;
		if(state == 0)
		{
			path = "/image/Land.png";
		}
		else if(state == 1)
		{
			path = "/image/NormalLand.png";
		}
		else
		{
			path = "/image/WetLand.png";
		}
		return path;
	}
	
	/*判断土地上农作物是否成熟*/	
	public static boolean isCropRipe(int landId) {
		boolean isRipe = false;//false表示未成熟
		//调用土地数据库判断当前土地上的农作物状态
		if(Land.getStageNow(APP.user, landId) == Crop.getStageCount(Land.getCropId(APP.user, landId))){
			isRipe = true;//true表示成熟了
		}
		return isRipe;
	}
	
	public static void grow(int landId,LandLabel landlabel) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				
				try {
					long growTime = Land.getgrowTime(APP.user, landId);
					long dieTime = Land.getdieTime(APP.user, landId);
					if(getCropId(APP.user, landId)!=-1)  //土地上有作物
					{
						if(getState(APP.user, landId)!=0)  //土地处于不缺水状态，土地上的植物正在生长	
						{
							setgrowTime(APP.user, landId, growTime+(landId%3+1)*1000);
							if((growTime > 0.5*Crop.getUnitTime(Land.getCropId(APP.user, landId)) && (growTime < Crop.getUnitTime(Land.getCropId(APP.user, landId)))))
							{//土地状态进入正常
								setState(APP.user, landId, 1);
								landlabel.flush();
							}
							else if(growTime > Crop.getUnitTime(Land.getCropId(APP.user, landId)))
							{//当前生长阶段结束
								int stage = getStageNow(APP.user, landId);  //进入下一阶段
								stage++;
								setStageNow(APP.user, landId, stage);
								setgrowTime(APP.user, landId,0);  //该阶段已生长时间为0
								if(stage == Crop.getStageCount(Land.getCropId(APP.user, landId)))  //进入收获期
								{
									landlabel.flush();
									System.out.println("已成熟，退出grow()");
									timer.cancel();
								}
								else  //未进入收获期
								{
									setState(APP.user, landId, 0);  //土地需要浇水
									landlabel.flush();
								}
							}
						}
						else
						{//土地缺水，即其上作物需要浇水
							setdieTime(APP.user, landId, dieTime+(landId%3+1)*1000);
							if(dieTime>360000)
							{
								setStageNow(APP.user, landId, Crop.getStageCount(Land.getCropId(APP.user, landId))+1); //将土地上的作物状态设置为枯死
								setdieTime(APP.user, landId, 0);
								landlabel.flush();
								timer.cancel();
							}
						}
					}
					else
					{
						timer.cancel();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		},(long)(landId%3+1)*1000,(long)(landId%3+1)*1000);  //延迟刷新时间这样设置是为了防止线程冲突
	}
	
	}

