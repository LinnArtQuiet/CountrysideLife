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
	private long systemtime;  //��ǰ��Ϸ�ھ�����ε�¼ʱ��
	private int nowhour;  //��ǰ��Ϸ��ʱ��Сʱ
	private String nowTime;  //��ǰ��Ϸʱ��
	private int nowDay;   //��ǰ��Ϸ�ڵ�����
	public static long startTime; //���δ���Ϸ��ʼʱ��
	public static long endTime;  //���ιر���Ϸʱ��
	private String state;//�����ҹ״̬
	public static ArrayList<String> timeList = new ArrayList<String>(){{add("��");add("��");add("��");add("��");add("��");add("î");
	add("î");add("��");add("��");add("��");add("��");add("��");add("��");add("δ");add("δ");add("��");add("��");add("��");add("��");
	add("��");add("��");add("��");add("��");add("��");}};
	
	/*���캯���������ʼ��ʱ��㼴�ϴ��˳���Ϸ��ʱ��*/
	public GameTimer(){
		systemtime = User.getOutTime(APP.user);
		startTime = System.currentTimeMillis();
		nowhour = (int)((systemtime/15000)%24);
		nowDay = (int)((systemtime/15000)/24);
		nowTime = timeList.get(nowhour);
		if(6<=nowhour&&nowhour<18)//6��-18��Ϊ����
			state="day";
		else//����Ϊҹ��
			state="night";
		run();
	}
	
	/*ÿ1��ˢ��һ�Σ������ҹ״̬����*/
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
					if(newhour>nowhour && User.getState(APP.user) == 1) //����һСʱ�������ﲻ����Ϣ����ֵ����1
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
					if(6<=nowhour&&nowhour<18)//6��-18��Ϊ����
						state="day";
					else//����Ϊҹ��
						state="night";
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		},1000,1000);
	}
	/*��ȡ��ǰ��ʱ���*/
	public int getHour() {//��ȡ��ǰСʱ
		return nowhour;
	}
	
	public int getDay() {//��ȡ��ǰСʱ
		return nowDay;
	}
	
	public String getNow() {//��ȡ��ǰʱ��
		return nowTime;
	}
	/*��ȡ��ǰ�İ����ҹ״̬*/
	public String getState() {
		return state;
	}
	public void setDay(int day) {//��ȡ��ǰСʱ
		nowDay = day;
	}
}


