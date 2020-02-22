package Bag;

import Data.FileData;
import main.APP;

public class FruitBag{

	/*��ȡũ�����ʵ����*/
	public static int getFruitCount(int cropId) {
		int fruitCount;
		fruitCount = Integer.parseInt(FileData.get(APP.user, "bag", "Fruit"+cropId));
		return fruitCount;
	}

	//ũ�����ʵ��������
	public static void addFruitCount(int cropId, int number) {
		int fruitCount = getFruitCount(cropId);
		fruitCount = fruitCount+number;
		FileData.update(APP.user, "bag", "Fruit"+cropId, fruitCount+"");
	}
	
	//ũ�����ʵ��������
	public static void minusFruitCount(int cropId, int number) {
		int fruitCount = getFruitCount(cropId);
		fruitCount = fruitCount-number;
		FileData.update(APP.user, "bag", "Fruit"+cropId, fruitCount+"");
	}
	
	public static boolean fruitIsHave() {
		boolean isHave = false;//false��ʾû��
		for(int l=1;l<=11;l++) {
			if(getFruitCount(l)!=0) {
				isHave = true;
				break;
			}
		}
		return isHave;
	}
}
