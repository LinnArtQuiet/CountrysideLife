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
	
	//�����ͱ���ͼ
	private JPanel GamePanel;
	private JLabel back;  //����ͼ����
	private JLabel npc; //����
	private JLabel talk; //�Ի���
	private JLabel words; //�Ի�
	
	//����back�����������¼�
	private int n = 0;
	//npc���������
	Random random2 = new Random();
	int j = random2.nextInt(7);
	//npc�Ի�
	/*�Ϲ��Ƴ�*/
	private ArrayList<String> npc0 = new ArrayList<String>(){{add("�Ϲ��Ƴ�����ѽ���þò�����");add("�Ϲ��Ƴ�������ճ����ѽ���һ����ٶ�һ�����أ�");add("�Ϲ��Ƴ����ϴ��������Ĳ��ر�ã��Ͽ��Ƕ���ϲ���ˣ�");add("�Ϲ��Ƴ����Ҹ���˵������������ǿǿ���֣�δ����Ȼ����԰��ϵһ��ѽ��");add("�Ϲ��Ƴ��˷ܵ�������ϸϸ����δ���ĺ�������...");}};
	/*԰��ʦ��*/
	private ArrayList<String> npc1 = new ArrayList<String>(){{add("԰��ʦ��������ѽ�������ֽ̾�������");add("<html>԰��ʦ�����Ҹ���˵�����ɱ�С������Ū���ݡ��ֲ˰�����ͷ����ѧ���أ�</html>");add("԰��ʦ���������Ҵ���������԰����Ļ�ľ");add("԰��ʦ������ι�����԰���ֵĻ�ľ...");add("԰��ʦ�����Ժ��ۿ��Զཻ����������԰������ľ��չ��ǰ����");}};
	/*�����ƹ�*/
	private ArrayList<String> npc2 = new ArrayList<String>(){{add("�����ƹ�Ӵ�������Ӳ������ˣ�");add("�����ƹ񣺽�������ǵ�����������������ϺõĲ��֣��п���������");add("�����ƹ������Ϲ˿��ˣ����Ǯ���Ȼ������ʵ�ڵ�~");add("�����ƹ�Ҫ�����������ǵ�ѽ��");add("�ٱ�ǰ���ƹ��͸���һЩ����...");}};
	/*�ɷ�˽������*/
	private ArrayList<String> npc3 = new ArrayList<String>(){{add("�ɷ�˽������������������ϰ�����ѽ��");add("�ɷ�˽��������ҵ�����ڻ����ң��в��ɳ�������ķ���ѧҵѽ��");add("�ɷ�˽����������˵��������˿����ũ��������������ˣ�");add("�ɷ�˽���������⵹��Щ���������ķ緶��");add("�ɷ�˽������������Ѱ���������ҷ���������԰��ӵ��ĵã�");}};
	/*��԰ͬ��*/
	private ArrayList<String> npc4 = new ArrayList<String>(){{add("��԰ͬ�����٣����ˣ�����ҪȥѰ���أ�");add("��԰ͬ����ǰ��������˵�ġ��찢��ƪһ������������ף�");add("��԰ͬ�������������˼����Ҳû�����ף�������������̽��̽�֡�");add("����ͬ����������������һƪ���찢�����ǡ�...");add("<html>��԰ͬ��������һϯ����ʤ��ʮ���鰡����лָ�㣡�ҵøϽ���ȥ�ٲ�������⡶���ǡ�֮��Ҫ��</html>");}};
	/*��������������*/
	private ArrayList<String> npc5 = new ArrayList<String>(){{add("�������������ˣ����������κ��죬��������˭��Ժ...");add("�������������ˣ���������԰������������������������·����");add("�������������ˣ����������������԰��ʿ����");add("<html>�������������ˣ�������˵�����⼸�ձ���·�ϣ����¶�ޣ��⸽�����п�ջ��Ͷ���òͣ�</html>");add("�������������ˣ������֮Զ�����ҿɵøϽ�ȥ��...");}};
	/*��ǿ��Է����*/
	private ArrayList<String> npc6 = new ArrayList<String>(){{add("��ǿ��Է���̣���ɽ��·��Ϊ������ǿ��Է���ȥ��");add("��ǿ��Է���̣������½�һ�������Ҫ������");add("��ǿ��Է���̣��⡶�찢��ƪ��ȫ��������������أ�");add("��ǿ��Է���̣�������Է��������ʮ��������һ�����˳��ۡ���");add("��ǿ��Է���̣��´��к���ظ������ţ�");}};
	
	//npc
	private ArrayList<ArrayList> npcAll = new ArrayList<ArrayList>() {{add(npc0);add(npc1);add(npc2);add(npc3);add(npc4);add(npc5);add(npc6);}};
	
	/*���캯��*/
	public NPC() {
		super();
		initGUI();
	}	
	
	//JFrame����
	private void initGUI() {
		try {
			
			GamePanel = new JPanel();
			this.add(GamePanel);
			GamePanel.setLayout(new GridLayout(1,1));
			
			//�����汳��
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
							//�жϰ������Ƿ��г����ʵ������
							if(FruitBag.fruitIsHave() == true) {
								int n=0;//���Ժ����ж����˼�����ʵ
								int k = JOptionPane.showConfirmDialog(null,"���Ƿ�Ը���͸��Ϲ��Ƴ�������еĳ����ճ��أ�","contact",JOptionPane.YES_NO_OPTION);
								if(k==0) {
									for(int m=1;m<=11;m++) {
									if(FruitBag.getFruitCount(m)!=0) {
										FruitBag.minusFruitCount(m, 1);
										n++;
									}
								}
									JOptionPane.showMessageDialog(null, "�㽫�����ճ��͸����Ƴ����Ƴ��ǳ����ģ��������Ϊ�����͸�����Ӵ��");
									User.moneyAdd(APP.user, 30*n);
							}
						 }else {
								JOptionPane.showMessageDialog(null, "��ѽ��������ɬ�����´μ��������͵㶫����~");
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
							//�жϰ������Ƿ��г����ʵ������
							if(FruitBag.fruitIsHave() == true) {
								int k = JOptionPane.showConfirmDialog(null,"���Ƿ�Ը���͵��߲˸�԰��ʦ���أ�","contact",JOptionPane.YES_NO_OPTION);
								if(k==0) {
									for(int m=1;m<=11;m++) {
									if(FruitBag.getFruitCount(m)!=0) {
										FruitBag.minusFruitCount(m, 1);
										SeedBag.addSeedCount(m, 3);//�õ���Ӧ�߲˵�����
									}
								}
									JOptionPane.showMessageDialog(null, "�㽫�߲��͸���ʦ����ʦ���ǳ����ģ�����Ӧ���߲�������Ϊ�����͸�����Ӵ��");
							}
						 }else {
								JOptionPane.showMessageDialog(null, "��ѽ��������ɬ�����´μ��������͵㶫����~");
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
							//ֱ�ӻ������
							for(int m=1;m<=11;m++) {
								SeedBag.addSeedCount(m, 2);
							}
							JOptionPane.showMessageDialog(null, "�����ƹ�̫��������");
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
							//�жϰ������Ƿ��г����ʵ������
							if(SeedBag.seedIsHave() == true) {
								int k = JOptionPane.showConfirmDialog(null,"�͵��߲˸�˽�������ɣ�","contact",JOptionPane.YES_NO_OPTION);
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
									JOptionPane.showMessageDialog(null, "˽��������������һ������԰���ʫ������Ǳ��ѧϰ������������~");
							}
						 }else {
								JOptionPane.showMessageDialog(null, "��ѽ��������ɬ�����´μ��������͵㶫����~");
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
							JOptionPane.showMessageDialog(null, "Ϊ��л��İ�����ͬ���͸�����һ��ʳ��~");
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
							JOptionPane.showMessageDialog(null, "Ϊ�˸�л���ָ·�����˻�������һ���ң�");
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
							//�жϰ������Ƿ��г����ʵ������
							if(FoodBag.foodIsHave() == true) {
								int k = JOptionPane.showConfirmDialog(null,"�͵�ʳ������̰ɣ�","contact",JOptionPane.YES_NO_OPTION);
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
									JOptionPane.showMessageDialog(null, "���̻�������һ���鼮������������~");
							}
						 }else {
								JOptionPane.showMessageDialog(null, "��ѽ��������ɬ�����´μ��������͵㶫����~");
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
			
			
			//�Ի���
			talk = new JLabel();
			talk.setLayout(new BorderLayout(200,0));
			ImageIcon icon =Images.getImg("/image/talk.png");
			talk.setIcon(icon);
			talk.setBounds((1067-icon.getIconWidth())/2,600-icon.getIconHeight(),icon.getIconWidth(),icon.getIconHeight());
			back.add(talk);
			
			//�Ի�
			words = new JLabel();
			words.setBounds(0, 0,1300,200);
			Font font= new Font("����",Font.PLAIN,20);
			words.setFont(font);
			words.setForeground(Color.white);
//			words.setHorizontalTextPosition(SwingConstants.CENTER);
			talk.add(new JLabel("   "),BorderLayout.WEST);
			talk.add(words,BorderLayout.CENTER);
			talk.add(new JLabel("   "),BorderLayout.EAST);
			pack();
		} catch (Exception e) {
			e.printStackTrace();//��ʾ�쳣·��
		}
	}
	
}
