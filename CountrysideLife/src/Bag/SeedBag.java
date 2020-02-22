package Bag;

import Data.FileData;
import main.APP;

public class SeedBag{

	/*获取农作物种子数量*/
	public static int getSeedCount(int cropId) {
		int seedCount;
		seedCount = Integer.parseInt(FileData.get(APP.user, "bag", "Seed"+cropId));
		return seedCount;
	}

	//农作物种子数量增加
	public static void addSeedCount(int cropId, int number) {
		int seedCount = getSeedCount(cropId);
		seedCount = seedCount+number;
		FileData.update(APP.user, "bag", "Seed"+cropId, seedCount+"");
	}
	
	//农作物种子数量减少
	public static void minusSeedCount(int cropId, int number) {
		int seedCount = getSeedCount(cropId);
		seedCount = seedCount-number;
		FileData.update(APP.user, "bag", "Seed"+cropId, seedCount+"");
	}
	
	public static boolean seedIsHave() {
		boolean isHave = false;//false表示没有
		for(int l=1;l<=11;l++) {
			if(getSeedCount(l)!=0) {
				isHave = true;
				break;
			}
		}
		return isHave;
	}
}
