package user;

import javax.swing.JOptionPane;
import Data.FileData;
import main.APP;
import ui.pregame.InformationFrame;

public class User{

		
	//��ȡ�û���Ϣ	
	public static String getPassword(String uID) {
		String password=FileData.get(uID, "user","password");
		return password;
	}
	
	public static int getEnergy(String uID) {//�������ֵ����Ϊ60
		int energy=Integer.parseInt(FileData.get(uID,"user", "energy"));
		return energy;
	}
	
	public static double getMoney(String uID) {//��ҽ��ֵ��ʼ����100
		double money=Double.parseDouble(FileData.get(uID, "user","money"));
		return money;
	}
	
	public static int getState(String uID) {//���������״̬��0-˯�ţ�1-���� ��2-����
		int state=Integer.parseInt(FileData.get(uID, "user","state"));
		return state;
	}
	
	public static String getPhoto(String uID) {//���ͷ��·��
		String photopath=FileData.get(uID, "user","photopath");
		return photopath;
	}
	
	public static long getOutTime(String uID) {//�������Ϸ�ڵ�ʱ��
		long outTime=Long.parseLong(FileData.get(uID, "user","outTime"));
		return outTime;
	}
	
	public static int getClasses(String uID) {//��ҵȼ�
		int level = Integer.parseInt(FileData.get(uID, "user","level"));
		return level;
	}
	public static int getEx(String uID) {//��ҵ�ǰ�ȼ�����
		int experience = Integer.parseInt(FileData.get(uID, "user","experience"));
		return experience;
	}
	
	public static int getStoleTimes(String uID) {//��ҵ�ǰ�ȼ�����
		int stoletimes = Integer.parseInt(FileData.get(uID, "user","stoletimes"));
		return stoletimes;
	}
	
	public static int getHelpTimes(String uID) {//��ҵ�ǰ�ȼ�����
		int helptimes = Integer.parseInt(FileData.get(uID, "user","helptimes"));
		return helptimes;
	}
	
	public static boolean getNPC(String uID) {//��ҵ�ǰ�ȼ�����
		String npc = FileData.get(uID, "user","npc");
		if(npc.equals("false"))
			return false;
		else
			return true;
	}
	
	
	//�����û���Ϣ
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
	
	//�û�����
	public static void sleep()  //��˯
	{
		setState(APP.user,0);
	}
	public static void awake()  //����
	{
		setEnergy(APP.user,60);
		setState(APP.user,1);
		JOptionPane.showMessageDialog(null,"˯���������µ�һ���ҿ��ԣ�");
	}
	public static int eat(int add)  //��ʳ
	{
		if(User.getState(APP.user) == 0) //����˯��
		{
			JOptionPane.showMessageDialog(null,"��ҹʳ�õ�������Ŷ~");
			return 0;
		}
		else
		{
			if(getEnergy(APP.user)==60)
			{
				JOptionPane.showMessageDialog(null,"�������棬�����ʳ��");
				return 0;  //����ֵΪ0����ʳʧ�ܣ�ʳ������������
			}
			else
			{
				energyAdd(add);
				return 1;  //����ֵΪ1���ɹ���ʳ��ʳ����������
			}
		}
	}
	
	public static void die()
	{
		setState(APP.user,2);
		int is = JOptionPane.showConfirmDialog(null,"���������ҽ�ƶ����ڸ�����·�ϣ��Ƿ񻨷�10000��Ҿ�ҽ��");
		if(is == JOptionPane.OK_OPTION)//ѡ���ҽ
		{
			if(moneyMinus(APP.user, 10000)==1)//��Ǯ
			{
				JOptionPane.showMessageDialog(null, "��~�������ȼ�ʱ�����һ��Ҫ��ע����ϢŶ��");
			}
			else//ûǮ
			{
				JOptionPane.showMessageDialog(null, "������~ҽ�Ʒ�����˸߰�����֪��������ҽ����~");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "���Ϸ������ƣ�˵�õ��������أ�");
			APP.gf.dispose();
			try {  //����ˢ�£��ص���Ϣ����
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
				JOptionPane.showMessageDialog(null,"��ƾ��棡������������������첹�������ɣ�");
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
			JOptionPane.showMessageDialog(null,"��������!���Թ����ˣ�");
		}
	}
	
	public static void classAdd(int add)  //�û��ȼ�����
	{
		setClasses(APP.user,getClasses(APP.user)+add);
	}
	
	public static void ExAdd(int add)  //�û�����ֵ����
	{
		setEx(APP.user,getEx(APP.user)+add);
		if(getEx(APP.user)>5000)  //ÿ�ﵽ5000����ֵ��һ��
		{
			classAdd((int)getEx(APP.user)/5000);
			setEx(APP.user,(int)getEx(APP.user)%5000);
		}
		
	}
}
