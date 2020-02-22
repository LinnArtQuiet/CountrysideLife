package RandomHouse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Random;

import Bag.FoodBag;
import Bag.FruitBag;
import Data.FileData;
import main.APP;
import user.User;

public class RandomEvent {
	
	//从“random”文件夹下的“random”txt文件内获取序号为“number”的随机事件
	public static String eventGet(String number) {
		String event = null;
		File file = new File("./random/random.txt");
		InputStream inputstream = null;
		InputStreamReader isr = null;
			
		Properties properties = new Properties();
		try {
			inputstream = new FileInputStream(file);
			isr = new InputStreamReader(inputstream);
			properties.load(isr);
			event = properties.getProperty(number);
			eventHappen(number);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputstream != null) {
				try {
					inputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return event;
	}
	
	public static boolean getisHappen() {
		boolean isHappen;//判断这一天里是不是已经抽过了
		if(FileData.get(APP.user, "user","random").equals("true"))
		{
			isHappen = true;
		}
		else
		{
			isHappen = false;
		}
		return isHappen;
	}
	
	public static void setisHappen(boolean ishappen) {
		FileData.update(APP.user, "user", "random", ishappen+"");
	}
	
	//从“random”文件夹下的命名为“name”的txt文件内获取序号为“number”的话
		public static String helloGet(String number,String name) {
			String event = null;
			File file = new File("./random/"+name+".txt");
			InputStream inputstream = null;
			InputStreamReader isr = null;
				
			Properties properties = new Properties();
			try {
				inputstream = new FileInputStream(file);
				isr = new InputStreamReader(inputstream);
				properties.load(isr);
				event = properties.getProperty(number);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputstream != null) {
					try {
						inputstream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return event;
		}
		
	public static void eventHappen(String number) {
		switch(number) {
		case "0":
			{
				try {
					int x = (int)0.1*User.getEnergy(APP.user);
					User.energyMinus(x);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		case "1":
		{
			try {
				Random random = new Random();
				int num=random.nextInt(9)+1;
				FoodBag.addFoodCount(num, 3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "2":
		{
			try {
				int x = (int)0.2*User.getEnergy(APP.user);
				User.energyMinus(x);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "3":
		{
			try {
				int x = (int)0.5*User.getEnergy(APP.user);
				User.energyMinus(x);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "4":
		{
			try {
				double i = (double)0.1*User.getMoney(APP.user);
				User.moneyMinus(APP.user, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "5":
		{
			try {
				double i = (double)0.5*User.getMoney(APP.user);
				User.moneyMinus(APP.user, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "6":
		{
			try {
				double i = (double)0.3*User.getMoney(APP.user);
				User.moneyAdd(APP.user, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "7":
		{
			try {
				Random random = new Random();
				int num1 = random.nextInt(11)+1;
				int num2 = random.nextInt(15)+1;
				FruitBag.addFruitCount(num1, num2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "8":
		{
			break;
		}
		case "9":
		{
			try {
				Random random = new Random();
				int num = random.nextInt(200)+1;
				User.ExAdd(num);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "10":
		{
			try {
				User.energyAdd(5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "11":
		{
			try {
				User.moneyAdd(APP.user, User.getMoney(APP.user));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "12":
		{
			try {
				User.moneyAdd(APP.user, 10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "13":
		{
			break;
		}
		case "14":
		{
			try {
				User.moneyAdd(APP.user, 50);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "15":
		{
			break;
		}
		case "16":
		{
			try {
				User.energyMinus(15);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "17":
		{
			try {
				Bag.SeedBag.addSeedCount(1, 5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "18":
		{
			try {
				Bag.SeedBag.addSeedCount(6, 7);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "19":
		{
			try {
				Bag.SeedBag.addSeedCount(9, 6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "20":
		{
			try {
				Random random = new Random();
				int num=random.nextInt(9)+1;
				FoodBag.addFoodCount(num, 2);
				random = new Random();
				num=random.nextInt(9)+1;
				FoodBag.addFoodCount(num, 3);
				random = new Random();
				num=random.nextInt(9)+1;
				FoodBag.addFoodCount(num, 2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case "21":
		{
			try {
				Random random = new Random();
				int num=random.nextInt(5000)+1;
				User.ExAdd(num);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		default:break;
		}
	}
}
