package Food;

import Data.FileData;
import main.APP;

public class Food {

	public static String getData(int foodId, int i)
	{
		String all = FileData.get(APP.user, "food", "food"+foodId);
		String[] splited = all.split(",");
		return splited[i-1];
	}
	
	/*获取食物名字*/
	public static String getName(int foodId) {
		String name = getData(foodId, 1);
		return name;
	}
	
	/*获取食物购买的钱*/
	public static double getMoney(int foodId) {
		double Money = Double.parseDouble(getData(foodId, 2));
		return Money;
	}
	
	/*获取食物最高可增加的体力值*/
	public static int getMaxHP(int foodId) {
		int maxhp = Integer.parseInt(getData(foodId, 3));
		return maxhp;
	}
	
	/*获取食物购买等级*/
	public static int getBuylevel(int foodId) {
		int buylevel = Integer.parseInt(getData(foodId, 4));
		return buylevel;
	}
	
	//获取食物图片
		public static String getFoodPic(int foodId)
		{
			String pic = getData(foodId, 5);
			return pic;
		}
}
