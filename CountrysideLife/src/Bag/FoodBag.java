package Bag;

import Data.FileData;
import main.APP;

public class FoodBag {

	/*获取背包内食物数量*/
	public static int getFoodCount(int foodId) {
		int foodCount;
		foodCount = Integer.parseInt(FileData.get(APP.user, "bag", "Food"+foodId));
		return foodCount;
	}

	//背包内食物数量增加
	public static void addFoodCount(int foodId, int number) {
		int foodCount = getFoodCount(foodId);
		foodCount = foodCount+number;
		FileData.update(APP.user, "bag", "Food"+foodId, foodCount+"");
	}
	
	//背包内食物数量减少
	public static void minusFoodCount(int foodId, int number) {
		int foodCount = getFoodCount(foodId);
		foodCount = foodCount-number;
		FileData.update(APP.user, "bag", "Food"+foodId, foodCount+"");
	}
	
	public static boolean foodIsHave() {
		boolean isHave = false;//false表示没有
		for(int l=1;l<=9;l++) {
			if(getFoodCount(l)!=0) {
				isHave = true;
				break;
			}
		}
		return isHave;
	}
}
