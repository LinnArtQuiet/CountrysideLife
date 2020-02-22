package Bag;

import Data.FileData;
import main.APP;

public class SeedBag{

	/*��ȡũ������������*/
	public static int getSeedCount(int cropId) {
		int seedCount;
		seedCount = Integer.parseInt(FileData.get(APP.user, "bag", "Seed"+cropId));
		return seedCount;
	}

	//ũ����������������
	public static void addSeedCount(int cropId, int number) {
		int seedCount = getSeedCount(cropId);
		seedCount = seedCount+number;
		FileData.update(APP.user, "bag", "Seed"+cropId, seedCount+"");
	}
	
	//ũ����������������
	public static void minusSeedCount(int cropId, int number) {
		int seedCount = getSeedCount(cropId);
		seedCount = seedCount-number;
		FileData.update(APP.user, "bag", "Seed"+cropId, seedCount+"");
	}
	
	public static boolean seedIsHave() {
		boolean isHave = false;//false��ʾû��
		for(int l=1;l<=11;l++) {
			if(getSeedCount(l)!=0) {
				isHave = true;
				break;
			}
		}
		return isHave;
	}
}
