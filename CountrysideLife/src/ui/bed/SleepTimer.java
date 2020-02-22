package ui.bed;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import Medium.Images;
import main.APP;
import user.User;

public class SleepTimer{
	//新建家里主界面的时候
	//GameTimer gametimer=new Gametimer();
	//睡觉的button监听器事件里
	//先写睡觉倒计时启动时要执行的事件
	//再写TimerTask weakTask=new TimerTask(){
	//				public void run(){
	//				//写睡醒要执行的事件	
	//				}
	//			}
	//最后写SleepTimer sleeptimer=new SleepTimer(gameTimer,weakTask);
	public SleepTimer() {
		User.sleep();
		run();
	}
	
	/**执行睡眠倒计时
	 * 每秒刷新检测到7点就结束倒计时*/
	public void run() {
		Timer sleep=new Timer();
		ImageIcon uppic=Images.getImg("/image/day.png");  //写入睡觉图片地址
		uppic.setImage(uppic.getImage().getScaledInstance(151,146, Image.SCALE_DEFAULT));
		sleep.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					if(APP.gf.gameTimer.getHour()==7)
					{
						User.awake();
						APP.room.sleep.setIcon(uppic);//睡眠图标转换成醒着图标
						APP.room.repaint();
						sleep.cancel();	
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				}
		}, 0, 10000);
	}
}