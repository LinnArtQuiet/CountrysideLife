package Land;

import java.util.Timer;
import java.util.TimerTask;

import Crop.Crop;
import Data.FileData;
import main.APP;

public class Land {
	
	
	/*��ȡ��ֲ��ũ������*/
	public static int getCropId(String uID, int landId) {
		int cropId = Integer.parseInt(FileData.get(uID, "land"+landId, "cropId"));
		return cropId;
	}

	/*������ֲ��ũ������*/
	public static void setCropId(String uID, int landId, int cropId) {
		FileData.update(uID, "land"+landId, "cropId", cropId+"");
	}
	
	/*��ȡ��ǰ�׶��Ѿ���ʼʱ��*/
	public static long getgrowTime(String uID, int landId) {
		long growTime = Integer.parseInt(FileData.get(uID, "land"+landId, "growTime"));
		return growTime;
	}

	/*���õ�ǰ�׶��Ѿ���ʼʱ��*/
	public static void setgrowTime(String uID, int landId, long growTime) {
		FileData.update(uID, "land"+landId, "growTime", growTime+"");
	}
	
	
	/*��ȡ��������ʱʱ��*/
	public static long getdieTime(String uID, int landId) {
		long dieTime = Integer.parseInt(FileData.get(uID, "land"+landId, "dieTime"));
		return dieTime;
	}
	
	/*���ÿ�������ʱʱ��*/
	public static void setdieTime(String uID, int landId, long dieTime) {
		FileData.update(uID, "land"+landId, "dieTime", dieTime+"");
	}
	
	/*��ȡ��ǰ������ũ����������׶�*/
	public static int getStageNow(String uID, int landId) {
		int stageNow = Integer.parseInt(FileData.get(uID, "land"+landId, "stageNow"));
		return stageNow;
	}
	
	/*���õ�ǰ������ũ���������׶�*/
	public static void setStageNow(String uID, int landId, int stageNow) {
		FileData.update(uID, "land"+landId, "stageNow", stageNow+"");
	}
	
	/*��ȡ����״̬*/
	public static int getState(String uID, int landId) {
		int state = Integer.parseInt(FileData.get(uID, "land"+landId, "state"));
		return state;
	
	}
	
	/*��������״̬*/
	public static void setState(String uID, int landId, int state) {
		FileData.update(uID, "land"+landId, "state", state+"");
	}
	
	/*��ȡ���ؽ����ȼ�*/
	public static int getLevel(int landId) {
		int state = Integer.parseInt(FileData.get(APP.user, "land"+landId, "getLevel"));
		return state;
	}
	
	//��ȡ����ͼƬ��ַ
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
	
	/*�ж�������ũ�����Ƿ����*/	
	public static boolean isCropRipe(int landId) {
		boolean isRipe = false;//false��ʾδ����
		//�����������ݿ��жϵ�ǰ�����ϵ�ũ����״̬
		if(Land.getStageNow(APP.user, landId) == Crop.getStageCount(Land.getCropId(APP.user, landId))){
			isRipe = true;//true��ʾ������
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
					if(getCropId(APP.user, landId)!=-1)  //������������
					{
						if(getState(APP.user, landId)!=0)  //���ش��ڲ�ȱˮ״̬�������ϵ�ֲ����������	
						{
							setgrowTime(APP.user, landId, growTime+(landId%3+1)*1000);
							if((growTime > 0.5*Crop.getUnitTime(Land.getCropId(APP.user, landId)) && (growTime < Crop.getUnitTime(Land.getCropId(APP.user, landId)))))
							{//����״̬��������
								setState(APP.user, landId, 1);
								landlabel.flush();
							}
							else if(growTime > Crop.getUnitTime(Land.getCropId(APP.user, landId)))
							{//��ǰ�����׶ν���
								int stage = getStageNow(APP.user, landId);  //������һ�׶�
								stage++;
								setStageNow(APP.user, landId, stage);
								setgrowTime(APP.user, landId,0);  //�ý׶�������ʱ��Ϊ0
								if(stage == Crop.getStageCount(Land.getCropId(APP.user, landId)))  //�����ջ���
								{
									landlabel.flush();
									System.out.println("�ѳ��죬�˳�grow()");
									timer.cancel();
								}
								else  //δ�����ջ���
								{
									setState(APP.user, landId, 0);  //������Ҫ��ˮ
									landlabel.flush();
								}
							}
						}
						else
						{//����ȱˮ��������������Ҫ��ˮ
							setdieTime(APP.user, landId, dieTime+(landId%3+1)*1000);
							if(dieTime>360000)
							{
								setStageNow(APP.user, landId, Crop.getStageCount(Land.getCropId(APP.user, landId))+1); //�������ϵ�����״̬����Ϊ����
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
		},(long)(landId%3+1)*1000,(long)(landId%3+1)*1000);  //�ӳ�ˢ��ʱ������������Ϊ�˷�ֹ�̳߳�ͻ
	}
	
	}

