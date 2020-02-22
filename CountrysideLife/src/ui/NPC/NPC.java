package ui.NPC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Bag.FoodBag;
import Bag.FruitBag;
import Bag.SeedBag;
import Medium.Images;
import main.APP;
import ui.father.MyFrame;
import user.User;

public class NPC extends MyFrame{
	
	//容器和背景图
	private JPanel GamePanel;
	private JLabel back;  //背景图容器
	private JLabel npc; //人物
	private JLabel talk; //对话框
	private JLabel words; //对话
	
	//控制back监听器触发事件
	private int n = 0;
	//npc的随机出现
	Random random2 = new Random();
	int j = random2.nextInt(7);
	//npc对话
	/*南光掌厨*/
	private ArrayList<String> npc0 = new ArrayList<String>(){{add("南光掌厨：哎呀！好久不见！");add("南光掌厨：最近收成如何呀？我还想再订一批菜呢！");add("南光掌厨：上次你送来的菜特别好！飨客们都可喜欢了！");add("南光掌厨：我跟你说啊，就咱们这强强联手，未来必然是厦园菜系一绝呀！");add("南光掌厨兴奋地拉着你细细商讨未来的合作事宜...");}};
	/*园艺师傅*/
	private ArrayList<String> npc1 = new ArrayList<String>(){{add("园艺师傅：是你呀！又来讨教经验啦？");add("<html>园艺师傅：我跟你说啊，可别小看这侍弄花草、种菜啊，里头可有学问呢！</html>");add("园艺师傅：来！我带你瞧瞧这园子里的花木");add("园艺师傅带你参观了厦园新种的花木...");add("园艺师傅：以后咱可以多交流交流这厦园花草林木发展的前景！");}};
	/*鸿润福掌柜*/
	private ArrayList<String> npc2 = new ArrayList<String>(){{add("鸿润福掌柜：哟，有阵子不见您了！");add("鸿润福掌柜：今儿个我们店里正好新添了许多上好的菜种，有空来看看？");add("鸿润福掌柜：您是老顾客了，这价钱嘛必然给您最实在的~");add("鸿润福掌柜：要多多来光顾我们店呀！");add("临别前，掌柜送给你一些种子...");}};
	/*成枫私塾先生*/
	private ArrayList<String> npc3 = new ArrayList<String>(){{add("成枫私塾先生：近来功课温习得如何呀？");add("成枫私塾先生：业精于勤荒于嬉，切不可痴迷旁物，荒废了学业呀！");add("成枫私塾先生：听说你近来辟了块地务农，过起田居生活了？");add("成枫私塾先生：这倒有些靖节先生的风范！");add("成枫私塾先生：改日寻个机会与大家分享分享这归园田居的心得？");}};
	/*厦园同窗*/
	private ArrayList<String> npc4 = new ArrayList<String>(){{add("厦园同窗：嘿，巧了，我正要去寻你呢！");add("厦园同窗：前两日先生说的《朱阿瓦篇一》你可有听明白？");add("厦园同窗：唉，我这苦思几日也没悟明白，今日特来找你探讨探讨。");add("你与同窗分享了你新作的一篇《朱阿瓦漫记》...");add("<html>厦园同窗：听君一席话，胜读十年书啊！多谢指点！我得赶紧回去再参悟参悟这《漫记》之精要！</html>");}};
	/*欣赏美景的行人*/
	private ArrayList<String> npc5 = new ArrayList<String>(){{add("欣赏美景的行人：良辰美景奈何天，赏心乐事谁家院...");add("欣赏美景的行人：不想这厦园还有如此美景！不枉我辛苦赶路啊。");add("欣赏美景的行人：哎哎！你可是这厦园人士？！");add("<html>欣赏美景的行人：不瞒你说，我这几日奔波路上，风餐露宿，这附近可有客栈能投宿用餐？</html>");add("欣赏美景的行人：啊如此之远，那我可得赶紧去了...");}};
	/*南强书苑书商*/
	private ArrayList<String> npc6 = new ArrayList<String>(){{add("南强书苑书商：书山有路勤为径，南强书苑最可去。");add("南强书苑书商：近日新进一批好书可要看看？");add("南强书苑书商：这《朱阿瓦篇》全册近来可是热卖呢！");add("南强书苑书商：近日书苑大酬宾，买十册书再饶一本《运筹论》！");add("南强书苑书商：下次有好书必给您留着！");}};
	
	//npc
	private ArrayList<ArrayList> npcAll = new ArrayList<ArrayList>() {{add(npc0);add(npc1);add(npc2);add(npc3);add(npc4);add(npc5);add(npc6);}};
	
	/*构造函数*/
	public NPC() {
		super();
		initGUI();
	}	
	
	//JFrame布局
	private void initGUI() {
		try {
			
			GamePanel = new JPanel();
			this.add(GamePanel);
			GamePanel.setLayout(new GridLayout(1,1));
			
			//主界面背景
			Random random1 = new Random();
			int i = random1.nextInt(18);
			back = new JLabel();
			ImageIcon bg;
			if(i<12)
			{
				bg = Images.getImg("/image/Sight/sight"+i+".jpg");
			}
			else
			{
				bg = Images.getImg("/image/Sight/sight"+i+".gif");
			}
			bg.setImage(bg.getImage().getScaledInstance(1067, 600, Image.SCALE_DEFAULT));
			back.setIcon(bg);
			GamePanel.add(back);
			
			back.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
//					System.out.println(e.getX());
//					System.out.println(e.getY());
					ArrayList npcNow = npcAll.get(j);
					words.setText((String) npcNow.get(n));
					n++;
					if(n==5) {
						switch(j) {
						case 0:{
							//判断包裹里是否有成熟果实可以送
							if(FruitBag.fruitIsHave() == true) {
								int n=0;//用以后面判断送了几个果实
								int k = JOptionPane.showConfirmDialog(null,"你是否愿意送给南光掌厨你包裹中的成熟收成呢？","contact",JOptionPane.YES_NO_OPTION);
								if(k==0) {
									for(int m=1;m<=11;m++) {
									if(FruitBag.getFruitCount(m)!=0) {
										FruitBag.minusFruitCount(m, 1);
										n++;
									}
								}
									JOptionPane.showMessageDialog(null, "你将成熟收成送给了掌厨，掌厨非常开心，将金币作为回礼送给了你哟！");
									User.moneyAdd(APP.user, 30*n);
							}
						 }else {
								JOptionPane.showMessageDialog(null, "哎呀，囊中羞涩，等下次见面了再送点东西叭~");
							}
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							NPC.this.dispose();
							APP.gf.setVisible(true);
                            break;
                        }
						case 1:{
							//判断包裹里是否有成熟果实可以送
							if(FruitBag.fruitIsHave() == true) {
								int k = JOptionPane.showConfirmDialog(null,"你是否愿意送点蔬菜给园艺师傅呢？","contact",JOptionPane.YES_NO_OPTION);
								if(k==0) {
									for(int m=1;m<=11;m++) {
									if(FruitBag.getFruitCount(m)!=0) {
										FruitBag.minusFruitCount(m, 1);
										SeedBag.addSeedCount(m, 3);//得到相应蔬菜的种子
									}
								}
									JOptionPane.showMessageDialog(null, "你将蔬菜送给了师傅，师傅非常开心，将相应的蔬菜种子作为回礼送给了你哟！");
							}
						 }else {
								JOptionPane.showMessageDialog(null, "哎呀，囊中羞涩，等下次见面了再送点东西叭~");
							}
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							NPC.this.dispose();
							APP.gf.setVisible(true);
							break;
							}
						case 2:{
							//直接获得种子
							for(int m=1;m<=11;m++) {
								SeedBag.addSeedCount(m, 2);
							}
							JOptionPane.showMessageDialog(null, "鸿润福掌柜太慷慨啦！");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							NPC.this.dispose();
							APP.gf.setVisible(true);
							break;
							}
						case 3:{
							//判断包裹里是否有成熟果实可以送
							if(SeedBag.seedIsHave() == true) {
								int k = JOptionPane.showConfirmDialog(null,"送点蔬菜给私塾先生吧？","contact",JOptionPane.YES_NO_OPTION);
								if(k==0) {
									for(int m=1;m<=11;m++) {
									if(FruitBag.getFruitCount(m)!=0) {
										FruitBag.minusFruitCount(m, 1);
										try {
											User.ExAdd(100);
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
									JOptionPane.showMessageDialog(null, "私塾先生回赠了你一本《归园田居诗集》，潜心学习，经验增长啦~");
							}
						 }else {
								JOptionPane.showMessageDialog(null, "哎呀，囊中羞涩，等下次见面了再送点东西叭~");
							}
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							NPC.this.dispose();
							APP.gf.setVisible(true);
							break;
							}
						case 4:{
							for(int l=1;l<=9;l++) {
								FoodBag.addFoodCount(l, 2);
							}
							JOptionPane.showMessageDialog(null, "为感谢你的帮助，同窗送给了你一点食物~");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							NPC.this.dispose();
							APP.gf.setVisible(true);
							break;
							}
						case 5:{
							User.moneyAdd(APP.user,100);
							JOptionPane.showMessageDialog(null, "为了感谢你的指路，行人回赠给你一点金币！");
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							NPC.this.dispose();
							APP.gf.setVisible(true);
							break;
							}
						case 6:{
							//判断包裹里是否有成熟果实可以送
							if(FoodBag.foodIsHave() == true) {
								int k = JOptionPane.showConfirmDialog(null,"送点食物给书商吧？","contact",JOptionPane.YES_NO_OPTION);
								if(k==0) {
									for(int m=1;m<=9;m++) {
									if(FruitBag.getFruitCount(m)!=0) {
										FruitBag.minusFruitCount(m, 1);
										try {
											User.ExAdd(100);
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
									JOptionPane.showMessageDialog(null, "书商回赠了你一本书籍，经验增长啦~");
							}
						 }else {
								JOptionPane.showMessageDialog(null, "哎呀，囊中羞涩，等下次见面了再送点东西叭~");
							}
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							NPC.this.dispose();
							APP.gf.setVisible(true);
							
							break;
							}
						}
					}
				}
			});
			
			//NPC
			npc = new JLabel();
			ImageIcon npcPic =Images.getImg("/image/NPC/npc"+j+".png");
			npcPic.setImage(npcPic.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
			npc.setIcon(npcPic);
			npc.setBounds(0, 250, 200, 300);
			back.add(npc);
			
			
			//对话框
			talk = new JLabel();
			talk.setLayout(new BorderLayout(200,0));
			ImageIcon icon =Images.getImg("/image/talk.png");
			talk.setIcon(icon);
			talk.setBounds((1067-icon.getIconWidth())/2,600-icon.getIconHeight(),icon.getIconWidth(),icon.getIconHeight());
			back.add(talk);
			
			//对话
			words = new JLabel();
			words.setBounds(0, 0,1300,200);
			Font font= new Font("楷体",Font.PLAIN,20);
			words.setFont(font);
			words.setForeground(Color.white);
//			words.setHorizontalTextPosition(SwingConstants.CENTER);
			talk.add(new JLabel("   "),BorderLayout.WEST);
			talk.add(words,BorderLayout.CENTER);
			talk.add(new JLabel("   "),BorderLayout.EAST);
			pack();
		} catch (Exception e) {
			e.printStackTrace();//显示异常路径
		}
	}
	
}
