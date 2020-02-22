package Bag;

import Data.FileData;
import main.APP;

public class FruitBag{

	/*获取农作物果实数量*/
	public static int getFruitCount(int cropId) {
		int fruitCount;
		fruitCount = Integer.parseInt(FileData.get(APP.user, "bag", "Fruit"+cropId));
		return fruitCount;
	}

	//农作物果实数量增加
	public static void addFruitCount(int cropId, int number) {
		int fruitCount = getFruitCount(cropId);
		fruitCount = fruitCount+number;
		FileData.update(APP.user, "bag", "Fruit"+cropId, fruitCount+"");
	}
	
	//农作物果实数量减少
	public static void minusFruitCount(int cropId, int number) {
		int fruitCount = getFruitCount(cropId);
		fruitCount = fruitCount-number;
		FileData.update(APP.user, "bag", "Fruit"+cropId, fruitCount+"");
	}
	
	public static boolean fruitIsHave() {
		boolean isHave = false;//false表示没有
		for(int l=1;l<=11;l++) {
			if(getFruitCount(l)!=0) {
				isHave = true;
				break;
			}
		}
		return isHave;
	}
}
