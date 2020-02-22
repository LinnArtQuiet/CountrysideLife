 package Event;

import java.util.Random;

import javax.swing.JOptionPane;

import Land.Land;
import Land.LandLabel;
import Medium.Music;
import main.APP;
import user.User;
import Bag.FruitBag;
import Bag.SeedBag;
import Crop.Crop;

public class Event {
	/*��ֲ�¼�*/
	public static void sow(int landId, int cropId,LandLabel landLabel) {
		Music sowbgm = new Music();
		sowbgm.open("src/sound/sow.wav");
		sowbgm.start();
		Land.setCropId(APP.user, landId, cropId);
		Land.setStageNow(APP.user, landId, 0);  //�ı�������ũ���������״̬
		Land.setState(APP.user, landId, 0);
		Land.grow(landId,landLabel);
		SeedBag.minusSeedCount(cropId, 1);  //������������
		/*User��������*/
		try {
			User.energyMinus(2);
			User.ExAdd(20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*�ջ��¼�*/
	public static void harvest(int landId) {
		Music harvestbgm = new Music();
		harvestbgm.open("src/sound/harvest.wav");
		harvestbgm.start();
		int cropId = Land.getCropId(APP.user, landId);
		Land.setState(APP.user, landId, 1);
		Land.setStageNow(APP.user, landId, (Crop.getStageCount(cropId)+1));
		Random random=new Random();
		int number=random.nextInt(31);
		if(number==0)
		{
			JOptionPane.showMessageDialog(null, "�칫���������ճ�Ƿ�ѣ�");
		}
		else
		{
			FruitBag.addFruitCount(cropId, number);
			JOptionPane.showMessageDialog(null, "��ϲ���ջ�"+number+"��"+Crop.getName(cropId)+"!");
		}
		/*User��������*/
		try {
			User.energyMinus(3);
			User.ExAdd(30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*�����¼�*/
	public static void move(int landId) {
		Music movebgm = new Music();
		movebgm.open("src/sound/move.wav");
		movebgm.start();
		Land.setCropId(APP.user, landId, -1);
		Land.setgrowTime(APP.user, landId, 0);
		Land.setdieTime(APP.user, landId, 0);
		Land.setStageNow(APP.user, landId, -1);
		Land.setState(APP.user, landId, 1);
		/*User��������*/
		try {
			User.energyMinus(2);
			User.ExAdd(15);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void water(int landId) {
		Music waterbgm = new Music();
		waterbgm.open("src/sound/water.wav");
		waterbgm.start();
		Land.setState(APP.user, landId, 2);
		Land.setdieTime(APP.user, landId, 0);
		Land.setgrowTime(APP.user, landId, 0);
		/*user��������*/
		try {
			User.energyMinus(1);
			User.ExAdd(8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
