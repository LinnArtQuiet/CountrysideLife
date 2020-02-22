package ui.game;
/**
 * @author YJX
 * @updateTime 2019.12.11*/
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import Data.FileData;
import RandomHouse.RandomEvent;
import main.APP;
import user.User;
public class GameTimer{
	private long systemtime;  //当前游戏内距离初次登录时间
	private int nowhour;  //当前游戏内时间小时
	private String nowTime;  //当前游戏时辰
	private int nowDay;   //当前游戏内的天数
	public static long startTime; //本次打开游戏初始时间
	public static long endTime;  //本次关闭游戏时间
	private String state;//白天黑夜状态
	public static ArrayList<String> timeList = new ArrayList<String>(){{add("子");add("丑");add("丑");add("寅");add("寅");add("卯");
	add("卯");add("辰");add("辰");add("巳");add("巳");add("午");add("午");add("未");add("未");add("申");add("申");add("酉");add("酉");
	add("戌");add("戌");add("亥");add("亥");add("子");}};
	
	/*构造函数，输入初始的时间点即上次退出游戏的时间*/
	public GameTimer(){
		systemtime = User.getOutTime(APP.user);
		startTime = System.currentTimeMillis();
		nowhour = (int)((systemtime/15000)%24);
		nowDay = (int)((systemtime/15000)/24);
		nowTime = timeList.get(nowhour);
		if(6<=nowhour&&nowhour<18)//6点-18点为白天
			state="day";
		else//其余为夜晚
			state="night";
		run();
	}
	
	/*每1秒刷新一次，白天黑夜状态更新*/
	public void run() {
		Timer clockTimer=new Timer();
		clockTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				
				try {
					long systemtimeNew;
					endTime = System.currentTimeMillis();
					systemtimeNew = systemtime+endTime-startTime;
					User.setOutTime(APP.user,systemtimeNew);
					int newhour = (int)((systemtimeNew/15000)%24);
					int daynew = (int)((systemtimeNew/15000)/24);
					nowTime = timeList.get(nowhour);
					if(newhour>nowhour && User.getState(APP.user) == 1) //过了一小时，且人物不在休息体力值减少1
					{
						User.energyMinus(1);
					}
					if(daynew>nowDay)
					{
						RandomEvent.setisHappen(false);
						User.setNPC(APP.user, false);
						User.setStoleTimes(APP.user, 0);
						User.setHelpTimes(APP.user, 0);
					}
					nowhour = newhour;
					nowDay = daynew;
					if(6<=nowhour&&nowhour<18)//6点-18点为白天
						state="day";
					else//其余为夜晚
						state="night";
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		},1000,1000);
	}
	/*获取当前的时间点*/
	public int getHour() {//获取当前小时
		return nowhour;
	}
	
	public int getDay() {//获取当前小时
		return nowDay;
	}
	
	public String getNow() {//获取当前时辰
		return nowTime;
	}
	/*获取当前的白天黑夜状态*/
	public String getState() {
		return state;
	}
	public void setDay(int day) {//获取当前小时
		nowDay = day;
	}
}


