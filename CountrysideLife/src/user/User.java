package user;

import javax.swing.JOptionPane;
import Data.FileData;
import main.APP;
import ui.pregame.InformationFrame;

public class User{

		
	//获取用户信息	
	public static String getPassword(String uID) {
		String password=FileData.get(uID, "user","password");
		return password;
	}
	
	public static int getEnergy(String uID) {//玩家体力值上限为60
		int energy=Integer.parseInt(FileData.get(uID,"user", "energy"));
		return energy;
	}
	
	public static double getMoney(String uID) {//玩家金币值初始分配100
		double money=Double.parseDouble(FileData.get(uID, "user","money"));
		return money;
	}
	
	public static int getState(String uID) {//玩家有三种状态：0-睡着；1-醒着 ；2-死亡
		int state=Integer.parseInt(FileData.get(uID, "user","state"));
		return state;
	}
	
	public static String getPhoto(String uID) {//玩家头像路径
		String photopath=FileData.get(uID, "user","photopath");
		return photopath;
	}
	
	public static long getOutTime(String uID) {//玩家在游戏内的时间
		long outTime=Long.parseLong(FileData.get(uID, "user","outTime"));
		return outTime;
	}
	
	public static int getClasses(String uID) {//玩家等级
		int level = Integer.parseInt(FileData.get(uID, "user","level"));
		return level;
	}
	public static int getEx(String uID) {//玩家当前等级经验
		int experience = Integer.parseInt(FileData.get(uID, "user","experience"));
		return experience;
	}
	
	public static int getStoleTimes(String uID) {//玩家当前等级经验
		int stoletimes = Integer.parseInt(FileData.get(uID, "user","stoletimes"));
		return stoletimes;
	}
	
	public static int getHelpTimes(String uID) {//玩家当前等级经验
		int helptimes = Integer.parseInt(FileData.get(uID, "user","helptimes"));
		return helptimes;
	}
	
	public static boolean getNPC(String uID) {//玩家当前等级经验
		String npc = FileData.get(uID, "user","npc");
		if(npc.equals("false"))
			return false;
		else
			return true;
	}
	
	
	//设置用户信息
	public static void setPassword(String uID, String pw) {
		FileData.update(uID, "user", "password", pw);
	}
	
	public static void setEnergy(String uID, int hp) {
		FileData.update(uID, "user", "energy", hp+"");
	}
	
	public static void setMoney(String uID, double mon) {
		FileData.update(uID, "user", "money", mon+"");
	}
	
	public static void setState(String uID, int sta) {
		FileData.update(uID, "user", "state", sta+"");
	}
	
	public static void setPhoto(String uID, String path) {
		FileData.update(uID, "user", "photopath", path);
	}
	
	public static void setOutTime(String uID, long time) {
		FileData.update(uID, "user","outTime",time+"");
	}
	
	public static void setClasses(String uID, int level) {
		FileData.update(uID, "user", "class", level+"");
	}
	
	public static void setEx(String uID, int experience) {
		FileData.update(uID, "user", "experience", experience+"");
	}
	
	public static void setStoleTimes(String uID, int stoletimes) {
		FileData.update(uID, "user", "stoletimes", stoletimes+"");
	}
	
	public static void setHelpTimes(String uID, int helptimes) {
		FileData.update(uID, "user", "helptimes", helptimes+"");
	}
	
	public static void setNPC(String uID, boolean npc) {
		FileData.update(uID, "user", "npc", npc+"");
	}
	
	//用户方法
	public static void sleep()  //入睡
	{
		setState(APP.user,0);
	}
	public static void awake()  //醒来
	{
		setEnergy(APP.user,60);
		setState(APP.user,1);
		JOptionPane.showMessageDialog(null,"睡饱饱啦，新的一天我可以！");
	}
	public static int eat(int add)  //进食
	{
		if(User.getState(APP.user) == 0) //正在睡觉
		{
			JOptionPane.showMessageDialog(null,"深夜食堂当心蛀牙哦~");
			return 0;
		}
		else
		{
			if(getEnergy(APP.user)==60)
			{
				JOptionPane.showMessageDialog(null,"精力充沛，无需进食！");
				return 0;  //返回值为0，进食失败，食物数量不减少
			}
			else
			{
				energyAdd(add);
				return 1;  //返回值为1，成功进食，食物数量减少
			}
		}
	}
	
	public static void die()
	{
		setState(APP.user,2);
		int is = JOptionPane.showConfirmDialog(null,"过劳猝死，医疗队正在赶来的路上，是否花费10000金币就医？");
		if(is == JOptionPane.OK_OPTION)//选择就医
		{
			if(moneyMinus(APP.user, 10000)==1)//有钱
			{
				JOptionPane.showMessageDialog(null, "呼~还好抢救及时，今后一定要多注意休息哦！");
			}
			else//没钱
			{
				JOptionPane.showMessageDialog(null, "呜呜呜~医疗费用如此高昂，早知道就申请医保了~");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "果断放弃治疗，说好的求生欲呢？");
			APP.gf.dispose();
			try {  //界面刷新，回到信息界面
				new InformationFrame();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void moneyAdd(String uID, double get)
	{
		double money=getMoney(uID)+get;
		setMoney(uID, money);
	}
	
	public static int moneyMinus(String uID, double lose)
	{
		if((getMoney(uID)-lose)>=0)
		{
			double money=getMoney(uID)-lose;
			setMoney(uID,money);
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public static void energyMinus(int lose)
	{
		if((getEnergy(APP.user)-lose)>0)
		{
			int energy=getEnergy(APP.user)-lose;
			setEnergy(APP.user,energy);
			if(getEnergy(APP.user) == 10 || getEnergy(APP.user) == 5)
			{
				JOptionPane.showMessageDialog(null,"红灯警告！您将不久于人世，快快补充体力吧！");
			}
		}
		else
		{
			die();
		}
			
	}
	
	public static void energyAdd(int add)
	{
		if(getEnergy(APP.user)+add<=60)
		{
			int energy=getEnergy(APP.user)+add;
			setEnergy(APP.user,energy);
		}
		else 
		{
			setEnergy(APP.user,60);
			JOptionPane.showMessageDialog(null,"精力充沛!可以工作了！");
		}
	}
	
	public static void classAdd(int add)  //用户等级增加
	{
		setClasses(APP.user,getClasses(APP.user)+add);
	}
	
	public static void ExAdd(int add)  //用户经验值增加
	{
		setEx(APP.user,getEx(APP.user)+add);
		if(getEx(APP.user)>5000)  //每达到5000经验值升一级
		{
			classAdd((int)getEx(APP.user)/5000);
			setEx(APP.user,(int)getEx(APP.user)%5000);
		}
		
	}
}
