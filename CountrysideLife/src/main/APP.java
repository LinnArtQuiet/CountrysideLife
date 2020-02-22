package main;

import javax.swing.JFrame;

import ui.bag.BagFrame;
import ui.bed.MainRoom;
import ui.game.GameFrame;
import ui.pregame.StartFrame;

public class APP {
	
	public static String user;//全局变量
	public static BagFrame bf;
	public static GameFrame gf = null;
	public static JFrame random;
	public static MainRoom room = null;

	/**
	 * 主函数,开始为登录界面
	 * 
	 */
	public static void main(String[] args) {
		
		StartFrame sf = new StartFrame();  //创建窗口
	}

} 
