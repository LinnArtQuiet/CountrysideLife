package ui.bed;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import Medium.Images;
import main.APP;
import user.User;

public class SleepTimer{
	//�½������������ʱ��
	//GameTimer gametimer=new Gametimer();
	//˯����button�������¼���
	//��д˯������ʱ����ʱҪִ�е��¼�
	//��дTimerTask weakTask=new TimerTask(){
	//				public void run(){
	//				//д˯��Ҫִ�е��¼�	
	//				}
	//			}
	//���дSleepTimer sleeptimer=new SleepTimer(gameTimer,weakTask);
	public SleepTimer() {
		User.sleep();
		run();
	}
	
	/**ִ��˯�ߵ���ʱ
	 * ÿ��ˢ�¼�⵽7��ͽ�������ʱ*/
	public void run() {
		Timer sleep=new Timer();
		ImageIcon uppic=Images.getImg("/image/day.png");  //д��˯��ͼƬ��ַ
		uppic.setImage(uppic.getImage().getScaledInstance(151,146, Image.SCALE_DEFAULT));
		sleep.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					if(APP.gf.gameTimer.getHour()==7)
					{
						User.awake();
						APP.room.sleep.setIcon(uppic);//˯��ͼ��ת��������ͼ��
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