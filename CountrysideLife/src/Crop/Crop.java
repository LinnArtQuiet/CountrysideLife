package Crop;


import Data.FileData;
import main.APP;

public class Crop{
	
	
	public static String getData(int cropId, int i)
	{
		String all = FileData.get(APP.user, "crop", "crop"+cropId);
		String[] splited = all.split(",");
		return splited[i-1];
	}
	
	/*��ȡũ��������*/
	public static String getName(int cropId) {
		String name = getData(cropId, 1);
		return name;
	}
	
	/*��ȡũ���ﵥλ����ʱ��*/
	public static int getUnitTime(int cropId) {
		int unitTime = Integer.parseInt(getData(cropId, 2));
		return unitTime;
	}
		
	/*��ȡũ�����ܵ������׶�*/
	public static int getStageCount(int cropId) {
		int stageCount = Integer.parseInt(getData(cropId, 3));
		return stageCount;
	}
	
	/*��ȡũ�����ʵ����Ǯ*/
	public static double getFruitMoney(int cropId) {
		double fruitMoney = Double.parseDouble(getData(cropId, 4));
		return fruitMoney;
	}

	/*��ȡũ�������ӵ�Ǯ*/
	public static double getSeedMoney(int cropId) {
		double seedMoney = Double.parseDouble(getData(cropId, 5));
		return seedMoney;
	}
	
	/*��ȡũ���ﹺ��ȼ�*/
	public static int getBuylevel(int cropId) {
		int buylevel = Integer.parseInt(getData(cropId, 6));
		return buylevel;
	}
	
	//��ȡũ������׶�ͼƬ
	public static String getCropPic(int cropId, int statenow)
	{
		int i = statenow+7;
		return getData(cropId, i);
	}
	
}
