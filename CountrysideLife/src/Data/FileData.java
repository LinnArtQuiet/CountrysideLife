package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class FileData {
	
	//初始化用户信息
	public static void initialize(String user, String password) {
		File filepack = new File("./user");
		File file = new File("./user/" + user);
		File fileuser = new File("./user/" + user + "/user.txt");
		File fileland1 = new File("./user/" + user + "/land1.txt");
		File fileland2 = new File("./user/" + user + "/land2.txt");
		File fileland3 = new File("./user/" + user + "/land3.txt");
		File fileland4 = new File("./user/" + user + "/land4.txt");
		File fileland5 = new File("./user/" + user + "/land5.txt");
		File fileland6 = new File("./user/" + user + "/land6.txt");
		File filebag = new File("./user/" + user + "/bag.txt");
		File filecrop = new File("./user/" + user + "/crop.txt");
		File filefood = new File("./user/" + user + "/food.txt");
		if (!filepack.exists()) {
			filepack.mkdir();
		}
		if (!file.exists()) {
			file.mkdir();
			try {
				fileuser.createNewFile();
				fileland1.createNewFile();
				fileland2.createNewFile();
				fileland3.createNewFile();
				fileland4.createNewFile();
				fileland5.createNewFile();
				fileland6.createNewFile();
				filebag.createNewFile();
				filecrop.createNewFile();
				filefood.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//对用户数据初始化
		Properties properties1 = new Properties();
		FileOutputStream fout1 = null;
		FileInputStream fin1 = null;
		InputStreamReader isr1 = null;
		OutputStreamWriter osw1 = null;
		
		try {
			fin1 = new FileInputStream(fileuser);
			isr1 = new InputStreamReader(fin1);
			properties1.load(isr1);
			properties1.setProperty("userID", user);
			properties1.setProperty("password", password);
			properties1.setProperty("state", String.valueOf(1));
			properties1.setProperty("photopath", "null");
			properties1.setProperty("money", String.valueOf(500.00));
			properties1.setProperty("energy", String.valueOf(60));
			properties1.setProperty("level", String.valueOf(1));
			properties1.setProperty("experience", String.valueOf(0));
			properties1.setProperty("random", "false");
			properties1.setProperty("stoletimes", String.valueOf(0));
			properties1.setProperty("helptimes", String.valueOf(0));
			properties1.setProperty("npc", "false");
			properties1.setProperty("outTime", String.valueOf(0));
			fout1 = new FileOutputStream(fileuser);
			osw1 = new OutputStreamWriter(fout1);
			properties1.store(fout1, "保存配置用！");
			fout1.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		//关闭数据流
		finally {
			if (osw1 != null) {
				try {
					osw1.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (isr1 != null) {
				try {
					isr1.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (fout1 != null) {
				try {
					fout1.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (fin1 != null) {
				try {
					fin1.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			}
		
		//对背包数据初始化
		Properties properties2 = new Properties();
		FileOutputStream fout2 = null;
		FileInputStream fin2 = null;
		InputStreamReader isr2 = null;
		OutputStreamWriter osw2 = null;

		try {
			fin2 = new FileInputStream(filebag);
			isr2 = new InputStreamReader(fin2);
			properties2.load(isr2);
			properties2.setProperty("Seed1", String.valueOf(0));
			properties2.setProperty("Seed2", String.valueOf(0));
			properties2.setProperty("Seed3", String.valueOf(0));
			properties2.setProperty("Seed4", String.valueOf(0));
			properties2.setProperty("Seed5", String.valueOf(0));
			properties2.setProperty("Seed6", String.valueOf(0));
			properties2.setProperty("Seed7", String.valueOf(0));
			properties2.setProperty("Seed8", String.valueOf(0));
			properties2.setProperty("Seed9", String.valueOf(0));
			properties2.setProperty("Seed10", String.valueOf(0));
			properties2.setProperty("Seed11", String.valueOf(0));
			properties2.setProperty("Fruit1", String.valueOf(0));
			properties2.setProperty("Fruit2", String.valueOf(0));
			properties2.setProperty("Fruit3", String.valueOf(0));
			properties2.setProperty("Fruit4", String.valueOf(0));
			properties2.setProperty("Fruit5", String.valueOf(0));
			properties2.setProperty("Fruit6", String.valueOf(0));
			properties2.setProperty("Fruit7", String.valueOf(0));
			properties2.setProperty("Fruit8", String.valueOf(0));
			properties2.setProperty("Fruit9", String.valueOf(0));
			properties2.setProperty("Fruit10", String.valueOf(0));
			properties2.setProperty("Fruit11", String.valueOf(0));
			properties2.setProperty("Food1", String.valueOf(0));
			properties2.setProperty("Food2", String.valueOf(0));
			properties2.setProperty("Food3", String.valueOf(0));
			properties2.setProperty("Food4", String.valueOf(0));
			properties2.setProperty("Food5", String.valueOf(0));
			properties2.setProperty("Food6", String.valueOf(0));
			properties2.setProperty("Food7", String.valueOf(0));
			properties2.setProperty("Food8", String.valueOf(0));
			properties2.setProperty("Food9", String.valueOf(0));
			
			fout2 = new FileOutputStream(filebag);
			osw2 = new OutputStreamWriter(fout2);
			properties2.store(fout2, "保存配置用！");
			fout2.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		//关闭数据流
		finally {
			if (osw2 != null) {
				try {
					osw2.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (isr2 != null) {
				try {
					isr2.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (fout2 != null) {
				try {
					fout2.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (fin2 != null) {
				try {
					fin2.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			}
		
		//对土地1信息初始化
		Properties properties3 = new Properties();
		FileOutputStream fout3 = null;
		FileInputStream fin3 = null;
		InputStreamReader isr3 = null;
		OutputStreamWriter osw3 = null;
		
		try {
			fin3 = new FileInputStream(fileland1);
			isr3 = new InputStreamReader(fin3);
			properties3.load(isr3);
			//cropId土地上所种植的作物的id,growTime该土地开始当前阶段的时间,dieTime该土地上作物进入枯萎倒计时的时间,stageNow该土地种植当前所作物的生长阶段,state该土地是否被浇水
			//土地状态1代表正常，0代表干枯，2代表湿润
			properties3.setProperty("cropId", "-1");  //-1表示没有作物 
			properties3.setProperty("growTime", "0");  //该土地上所种作物在当前生长阶段的时间
			properties3.setProperty("dieTime", "0");  //该土地上所种作物在当前死亡倒计时已经过的时间
			properties3.setProperty("stageNow", "-1");  //该土地上所种作物当前阶段，-1表示没有作物
			properties3.setProperty("state", "1");  //土地状态，0表示干枯，1表示正常，2表示湿润
			properties3.setProperty("getLevel", "1");  //土地解锁等级
			fout3 = new FileOutputStream(fileland1);
			osw3 = new OutputStreamWriter(fout3);
			properties3.store(fout3, "保存配置用！");
			fout3.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		//关闭数据流
		finally {
			if (osw3 != null) {
				try {
					osw3.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (isr3 != null) {
				try {
					isr3.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (fout3 != null) {
				try {
					fout3.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (fin3 != null) {
				try {
					fin3.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			}
		
		//对农作物相关数据初始化（该文件内的数据固定不可更改）
		Properties properties4 = new Properties();
		FileOutputStream fout4 = null;
		FileInputStream fin4 = null;
		InputStreamReader isr4 = null;
		OutputStreamWriter osw4 = null;
		
		try {
			fin4 = new FileInputStream(filecrop);
			isr4 = new InputStreamReader(fin4);
			properties4.load(isr4);
			//作物名称，单位生长时间，生长阶段数，果实价格，种子价格,作物购买解锁等级，种子图片路径，第一阶段图片路径，第二阶段图片路径，第三阶段图片路径，第四阶段图片路径
			properties4.setProperty("crop1", "胡萝卜,60000,3,2.5,5,1,/image/Crop1/seed.png,/image/Crop1/1.png,/image/Crop1/2.png,/image/Crop1/3.png,/image/Crop1/die.png");
			properties4.setProperty("crop2", "白菜,60000,4,4.3,6.3,2,/image/Crop2/seed.png,/image/Crop2/1.png,/image/Crop2/2.png,/image/Crop2/3.png,/image/Crop2/4.png,/image/Crop2/die.png");
			properties4.setProperty("crop3", "白萝卜,60000,3,6.2,8,4,/image/Crop3/seed.png,/image/Crop3/1.png,/image/Crop3/2.png,/image/Crop3/3.png,/image/Crop3/die.png");
			properties4.setProperty("crop4", "卷心菜,90000,3,8.9,13.2,7,/image/Crop4/seed.png,/image/Crop4/1.png,/image/Crop4/2.png,/image/Crop4/3.png,/image/Crop4/die.png");
			properties4.setProperty("crop5", "花椰菜,90000,3,10,14,11,/image/Crop5/seed.png,/image/Crop5/1.png,/image/Crop5/2.png,/image/Crop5/3.png,/image/Crop5/die.png");
			properties4.setProperty("crop6", "朝天椒,90000,3,13.8,17,16,/image/Crop6/seed.png,/image/Crop6/1.png,/image/Crop6/2.png,/image/Crop6/3.png,/image/Crop6/die.png");
			properties4.setProperty("crop7", "蘑菇,120000,3,16.2,19.7,22,/image/Crop7/seed.png,/image/Crop7/1.png,/image/Crop7/2.png,/image/Crop7/3.png,/image/Crop7/die.png");
			properties4.setProperty("crop8", "南瓜,120000,3,19.3,21.1,29,/image/Crop8/seed.png,/image/Crop8/1.png,/image/Crop8/2.png,/image/Crop8/3.png,/image/Crop8/die.png");
			properties4.setProperty("crop9", "茄子,120000,4,21.7,26,38,/image/Crop9/seed.png,/image/Crop9/1.png,/image/Crop9/2.png,/image/Crop9/3.png,/image/Crop9/4.png,/image/Crop9/die.png");
			properties4.setProperty("crop10", "青椒,180000,3,24.5,35.3,47,/image/Crop10/seed.png,/image/Crop10/1.png,/image/Crop10/2.png,/image/Crop10/3.png,/image/Crop10/die.png");
			properties4.setProperty("crop11", "西红柿,180000,3,26.7,40.2,57,/image/Crop11/seed.png,/image/Crop11/1.png,/image/Crop11/2.png,/image/Crop11/3.png,/image/Crop11/die.png");
			fout4 = new FileOutputStream(filecrop);
			osw4 = new OutputStreamWriter(fout4);
			properties4.store(fout4, "保存配置用！");
			fout4.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		//关闭数据流
		finally {
			if (osw4 != null) {
				try {
					osw4.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (isr4 != null) {
				try {
					isr4.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (fout4 != null) {
				try {
					fout4.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			if (fin4 != null) {
				try {
					fin4.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
			}
		
		//对土地2信息初始化
				Properties properties5 = new Properties();
				FileOutputStream fout5 = null;
				FileInputStream fin5 = null;
				InputStreamReader isr5 = null;
				OutputStreamWriter osw5 = null;
				
				try {
					fin5 = new FileInputStream(fileland2);
					isr5 = new InputStreamReader(fin5);
					properties5.load(isr5);
					//cropId土地上所种植的作物的id,growTime该土地开始当前阶段的时间,dieTime该土地上作物进入枯萎倒计时的时间,stageNow该土地种植当前所作物的生长阶段,state该土地是否被浇水
					//土地状态1代表正常，0代表干枯，2代表湿润
					properties5.setProperty("cropId", "-1");  //-1表示没有作物 
					properties5.setProperty("growTime", "0");  //该土地上所种作物在当前生长阶段的时间
					properties5.setProperty("dieTime", "0");  //该土地上所种作物在当前死亡倒计时已经过的时间
					properties5.setProperty("stageNow", "-1");  //该土地上所种作物当前阶段，-1表示没有作物
					properties5.setProperty("state", "1");  //土地状态，0表示干枯，1表示正常，2表示湿润
					properties5.setProperty("getLevel", "1");  //土地解锁等级
					fout5 = new FileOutputStream(fileland2);
					osw5 = new OutputStreamWriter(fout5);
					properties5.store(fout5, "保存配置用！");
					fout5.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				//关闭数据流
				finally {
					if (osw5 != null) {
						try {
							osw5.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (isr5 != null) {
						try {
							isr5.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fout5 != null) {
						try {
							fout5.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fin5 != null) {
						try {
							fin5.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					}
				
				//对土地3信息初始化
				Properties properties6 = new Properties();
				FileOutputStream fout6 = null;
				FileInputStream fin6 = null;
				InputStreamReader isr6 = null;
				OutputStreamWriter osw6 = null;
				
				try {
					fin6 = new FileInputStream(fileland3);
					isr6 = new InputStreamReader(fin6);
					properties6.load(isr6);
					//cropId土地上所种植的作物的id,growTime该土地开始当前阶段的时间,dieTime该土地上作物进入枯萎倒计时的时间,stageNow该土地种植当前所作物的生长阶段,state该土地是否被浇水
					//土地状态1代表正常，0代表干枯，2代表湿润
					properties6.setProperty("cropId", "-1");  //-1表示没有作物 
					properties6.setProperty("growTime", "0");  //该土地上所种作物在当前生长阶段的时间
					properties6.setProperty("dieTime", "0");  //该土地上所种作物在当前死亡倒计时已经过的时间
					properties6.setProperty("stageNow", "-1");  //该土地上所种作物当前阶段，-1表示没有作物
					properties6.setProperty("state", "1");  //土地状态，0表示干枯，1表示正常，2表示湿润
					properties6.setProperty("getLevel", "1");  //土地解锁等级
					fout6 = new FileOutputStream(fileland3);
					osw6 = new OutputStreamWriter(fout6);
					properties6.store(fout6, "保存配置用！");
					fout6.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				//关闭数据流
				finally {
					if (osw6 != null) {
						try {
							osw6.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (isr6 != null) {
						try {
							isr6.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fout6 != null) {
						try {
							fout6.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fin6 != null) {
						try {
							fin6.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					}
				
				//对土地4信息初始化
				Properties properties7 = new Properties();
				FileOutputStream fout7 = null;
				FileInputStream fin7 = null;
				InputStreamReader isr7 = null;
				OutputStreamWriter osw7 = null;
				
				try {
					fin7 = new FileInputStream(fileland4);
					isr7 = new InputStreamReader(fin7);
					properties7.load(isr7);
					//cropId土地上所种植的作物的id,growTime该土地开始当前阶段的时间,dieTime该土地上作物进入枯萎倒计时的时间,stageNow该土地种植当前所作物的生长阶段,state该土地是否被浇水
					//土地状态1代表正常，0代表干枯，2代表湿润
					properties7.setProperty("cropId", "-1");  //-1表示没有作物 
					properties7.setProperty("growTime", "0");  //该土地上所种作物在当前生长阶段的时间
					properties7.setProperty("dieTime", "0");  //该土地上所种作物在当前死亡倒计时已经过的时间
					properties7.setProperty("stageNow", "-1");  //该土地上所种作物当前阶段，-1表示没有作物
					properties7.setProperty("state", "1");  //土地状态，0表示干枯，1表示正常，2表示湿润
					properties7.setProperty("getLevel", "10");  //土地解锁等级
					fout7 = new FileOutputStream(fileland4);
					osw7 = new OutputStreamWriter(fout7);
					properties7.store(fout7, "保存配置用！");
					fout7.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				//关闭数据流
				finally {
					if (osw7 != null) {
						try {
							osw7.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (isr7 != null) {
						try {
							isr7.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fout7 != null) {
						try {
							fout7.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fin7 != null) {
						try {
							fin7.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					}
				
				//对土地5信息初始化
				Properties properties8 = new Properties();
				FileOutputStream fout8 = null;
				FileInputStream fin8 = null;
				InputStreamReader isr8 = null;
				OutputStreamWriter osw8 = null;
				
				try {
					fin8 = new FileInputStream(fileland5);
					isr8 = new InputStreamReader(fin8);
					properties8.load(isr8);
					//cropId土地上所种植的作物的id,growTime该土地开始当前阶段的时间,dieTime该土地上作物进入枯萎倒计时的时间,stageNow该土地种植当前所作物的生长阶段,state该土地是否被浇水
					//土地状态1代表正常，0代表干枯，2代表湿润
					properties8.setProperty("cropId", "-1");  //-1表示没有作物 
					properties8.setProperty("growTime", "0");  //该土地上所种作物在当前生长阶段的时间
					properties8.setProperty("dieTime", "0");  //该土地上所种作物在当前死亡倒计时已经过的时间
					properties8.setProperty("stageNow", "-1");  //该土地上所种作物当前阶段，-1表示没有作物
					properties8.setProperty("state", "1");  //土地状态，0表示干枯，1表示正常，2表示湿润
					properties8.setProperty("getLevel", "25");  //土地解锁等级
					fout8 = new FileOutputStream(fileland5);
					osw8 = new OutputStreamWriter(fout8);
					properties8.store(fout8, "保存配置用！");
					fout8.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				//关闭数据流
				finally {
					if (osw8 != null) {
						try {
							osw8.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (isr8 != null) {
						try {
							isr8.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fout8 != null) {
						try {
							fout8.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fin8 != null) {
						try {
							fin8.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					}
				
				//对土地6信息初始化
				Properties properties9 = new Properties();
				FileOutputStream fout9 = null;
				FileInputStream fin9 = null;
				InputStreamReader isr9 = null;
				OutputStreamWriter osw9 = null;
				
				try {
					fin9 = new FileInputStream(fileland6);
					isr9 = new InputStreamReader(fin9);
					properties9.load(isr9);
					//cropId土地上所种植的作物的id,growTime该土地开始当前阶段的时间,dieTime该土地上作物进入枯萎倒计时的时间,stageNow该土地种植当前所作物的生长阶段,state该土地是否被浇水
					//土地状态1代表正常，0代表干枯，2代表湿润
					properties9.setProperty("cropId", "-1");  //-1表示没有作物 
					properties9.setProperty("growTime", "0");  //该土地上所种作物在当前生长阶段的时间
					properties9.setProperty("dieTime", "0");  //该土地上所种作物在当前死亡倒计时已经过的时间
					properties9.setProperty("stageNow", "-1");  //该土地上所种作物当前阶段，-1表示没有作物
					properties9.setProperty("state", "1");  //土地状态，0表示干枯，1表示正常，2表示湿润
					properties9.setProperty("getLevel", "40");  //土地解锁等级
					fout9 = new FileOutputStream(fileland6);
					osw9 = new OutputStreamWriter(fout9);
					properties9.store(fout9, "保存配置用！");
					fout9.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				//关闭数据流
				finally {
					if (osw9 != null) {
						try {
							osw9.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (isr9 != null) {
						try {
							isr9.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fout9 != null) {
						try {
							fout9.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fin9 != null) {
						try {
							fin9.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					}
				
				//对食物信息初始化
				Properties properties10 = new Properties();
				FileOutputStream fout10 = null;
				FileInputStream fin10 = null;
				InputStreamReader isr10 = null;
				OutputStreamWriter osw10 = null;
				
				try {
					fin10 = new FileInputStream(filefood);
					isr10 = new InputStreamReader(fin10);
					properties10.load(isr10);
					//名称，购买价格，最高可补充的体力值，购买解锁等级，图片路径
					properties10.setProperty("food1", "桂花糕,17.9,3,1,/image/Food/1.png");
					properties10.setProperty("food2", "千层饼,20,4,3,/image/Food/2.png");
					properties10.setProperty("food3", "雪花酥,26.6,4,7,/image/Food/3.png");
					properties10.setProperty("food4", "花茶,32.1,9,13,/image/Food/4.png");
					properties10.setProperty("food5", "龙井,39.8,13,21,/image/Food/5.png");
					properties10.setProperty("food6", "柠檬茶,46.3,18,31,/image/Food/6.png");
					properties10.setProperty("food7", "芋泥糕,54.6,24,43,/image/Food/7.png");
					properties10.setProperty("food8", "奶油蛋糕,61.9,31,57,/image/Food/8.png");
					properties10.setProperty("food9", "乌龙茶,70.5,39,73,/image/Food/9.png");
					fout10 = new FileOutputStream(filefood);
					osw10 = new OutputStreamWriter(fout10);
					properties10.store(fout10, "保存配置用！");
					fout10.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				//关闭数据流
				finally {
					if (osw10 != null) {
						try {
							osw10.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (isr10 != null) {
						try {
							isr10.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fout10 != null) {
						try {
							fout10.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					if (fin10 != null) {
						try {
							fin10.close();
						} catch (IOException e) {
							e.printStackTrace();
							}
						}
					}
		
	}

	//从user文件夹中删除名为“user”的用户文件夹
	public static void delete(String user) {
		File file = new File("./user/" + user);
		File fileuser = new File("./user/" + user + "/user.txt");
		File fileland = new File("./user/" + user + "/land.txt");
		File filebag = new File("./user/" + user + "/bag.txt");
		File filecrop = new File("./user/" + user + "/crop.txt");
		if (file.exists()) {
			fileuser.delete();
			fileland.delete();
		    filebag.delete();
		    filecrop.delete();
		    file.delete();
		}
	}
	
	//在名为“user”的用户文件夹下的名为“sort”的txt文件内，将名为“project”的项目值改为“content”
	public static void update(String user,String sort,String project,String content) {
		File file = new File("./user/" + user + "/"+sort+".txt");
		Properties properties = new Properties();
		FileOutputStream fout = null;
		FileInputStream fin = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try {
			fin = new FileInputStream(file);
			isr = new InputStreamReader(fin);
			properties.load(isr);
			properties.setProperty(project, content);
			fout = new FileOutputStream(file);
			osw = new OutputStreamWriter(fout);
			properties.store(fout, "保存配置用！");
			fout.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//从名为“user”的用户文件夹下的名为“sort”的txt文件内获取名为“project”的项目值
	public static String get(String user,String sort,String project) {
		String content = null;
		File file = new File("./user/" + user + "/"+sort+".txt");
		InputStream inputstream = null;
		InputStreamReader isr = null;
		
		Properties properties = new Properties();
		try {
			inputstream = new FileInputStream(file);
			isr = new InputStreamReader(inputstream);
			properties.load(isr);
			content = properties.getProperty(project);
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
		return content;
	}
	
	//在user文件夹下检索是否存在名为“user”的用户文件夹
	//若该用户已存在，返回true，若该用户不存在，返回false
	public static boolean search(String user) {
		int count = 0;
		File file = new File("./user/");
		File[] arr = file.listFiles();
		for (int i = 0; i < file.list().length; i++) {
			if (user.equals(arr[i].getName())) {
				break;
			}
			count++;
		}
		if (count >= file.list().length) {
			return false;
		}
		return true;
	}
}
