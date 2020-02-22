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
	
	/*获取农作物名字*/
	public static String getName(int cropId) {
		String name = getData(cropId, 1);
		return name;
	}
	
	/*获取农作物单位生长时间*/
	public static int getUnitTime(int cropId) {
		int unitTime = Integer.parseInt(getData(cropId, 2));
		return unitTime;
	}
		
	/*获取农作物总的生长阶段*/
	public static int getStageCount(int cropId) {
		int stageCount = Integer.parseInt(getData(cropId, 3));
		return stageCount;
	}
	
	/*获取农作物果实卖的钱*/
	public static double getFruitMoney(int cropId) {
		double fruitMoney = Double.parseDouble(getData(cropId, 4));
		return fruitMoney;
	}

	/*获取农作物种子的钱*/
	public static double getSeedMoney(int cropId) {
		double seedMoney = Double.parseDouble(getData(cropId, 5));
		return seedMoney;
	}
	
	/*获取农作物购买等级*/
	public static int getBuylevel(int cropId) {
		int buylevel = Integer.parseInt(getData(cropId, 6));
		return buylevel;
	}
	
	//获取农作物各阶段图片
	public static String getCropPic(int cropId, int statenow)
	{
		int i = statenow+7;
		return getData(cropId, i);
	}
	
}
