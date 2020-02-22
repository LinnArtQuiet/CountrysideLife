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
	
	/*��ȡʳ������*/
	public static String getName(int foodId) {
		String name = getData(foodId, 1);
		return name;
	}
	
	/*��ȡʳ�ﹺ���Ǯ*/
	public static double getMoney(int foodId) {
		double Money = Double.parseDouble(getData(foodId, 2));
		return Money;
	}
	
	/*��ȡʳ����߿����ӵ�����ֵ*/
	public static int getMaxHP(int foodId) {
		int maxhp = Integer.parseInt(getData(foodId, 3));
		return maxhp;
	}
	
	/*��ȡʳ�ﹺ��ȼ�*/
	public static int getBuylevel(int foodId) {
		int buylevel = Integer.parseInt(getData(foodId, 4));
		return buylevel;
	}
	
	//��ȡʳ��ͼƬ
		public static String getFoodPic(int foodId)
		{
			String pic = getData(foodId, 5);
			return pic;
		}
}
