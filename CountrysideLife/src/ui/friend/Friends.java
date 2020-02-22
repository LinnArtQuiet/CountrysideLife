package ui.friend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Vector;

import Data.FileData;
import main.APP;

public class Friends {
	public String name;
	public String path;
	
	//构造函数
	public Friends(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}
	
	public static String getName(int i) {
		Vector<Friends> friends = Friends.getFriends();
		String name = friends.get(i).name;
		return name;
	}
	
	public static String getPath(int i) {
		Vector<Friends> friends = Friends.getFriends();
		String path = friends.get(i).path;
		return path;
	}
	
	public static Vector<Friends> getFriends(){
		File file = new File("./user/");
		File[] fileList = file.listFiles();
		InputStreamReader isr = null;
		Properties properties = new Properties();
		Vector<Friends> friends = new Vector<Friends>();
		Friends f = null;
		try {
			for (int i = 0; i < file.list().length; i++) {
				String filePath = fileList[i].getName();//user文件下的各id的玩家文件夹
				if(!filePath.equals(APP.user))
				{
					File fileUser = new File("./user/" + filePath + "/user.txt");//各id玩家文件夹内的user的txt文件
					isr = new InputStreamReader(new FileInputStream(fileUser));
					String picPath = FileData.get(filePath, "user", "photopath");
					f = new Friends(filePath, picPath);
					friends.add(f);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		return friends;
	}
}
