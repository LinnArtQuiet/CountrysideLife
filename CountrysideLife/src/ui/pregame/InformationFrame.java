package ui.pregame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Data.FileData;
import Medium.Images;
import main.APP;
import ui.father.MyFrame;
import ui.game.GameFrame;
import user.User;


public class InformationFrame extends MyFrame{
	
	public InformationFrame() throws Exception
	{
		super();

		JLabel bottom=new JLabel();
		
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(new GridLayout(1,1));
		panel.add(bottom);
		
		ImageIcon bg=Images.getImg("/image/informationpage.png");  //����ͼ
		ImageIcon zhuxiao=Images.getImg("/image/zhuxiao.png");  //ע��
		ImageIcon next=Images.getImg("/image/continue.png");  //������Ϸ
		ImageIcon restart=Images.getImg("/image/restart.png");  //���¿�ʼ��Ϸ
		ImageIcon ID=Images.getImg("/image/ID.png");  //�û���
		ImageIcon capital=Images.getImg("/image/capital.png");  //�����ʱ�
		ImageIcon hp=Images.getImg("/image/hp.png");  //����
		ImageIcon level=Images.getImg("/image/level.png");  //�ȼ�
		ImageIcon brief=Images.getImg("/image/brief.png");  //��Ϸ���
		
		
		
		bg.setImage(bg.getImage().getScaledInstance(1067,600, Image.SCALE_DEFAULT));
		zhuxiao.setImage(zhuxiao.getImage().getScaledInstance(zhuxiao.getIconWidth(),zhuxiao.getIconHeight(), Image.SCALE_DEFAULT));
		next.setImage(next.getImage().getScaledInstance(next.getIconWidth(),next.getIconHeight(), Image.SCALE_DEFAULT));
		restart.setImage(restart.getImage().getScaledInstance(restart.getIconWidth(),restart.getIconHeight(), Image.SCALE_DEFAULT));
		ID.setImage(ID.getImage().getScaledInstance(ID.getIconWidth(),ID.getIconHeight(), Image.SCALE_DEFAULT));
		capital.setImage(capital.getImage().getScaledInstance(capital.getIconWidth(),capital.getIconHeight(), Image.SCALE_DEFAULT));
		hp.setImage(hp.getImage().getScaledInstance(hp.getIconWidth(),hp.getIconHeight(), Image.SCALE_DEFAULT));
		level.setImage(level.getImage().getScaledInstance(hp.getIconWidth(),hp.getIconHeight(), Image.SCALE_DEFAULT));
		brief.setImage(brief.getImage().getScaledInstance(brief.getIconWidth(),brief.getIconHeight(), Image.SCALE_DEFAULT));
		
		JPanel margin1 = new JPanel();
		JPanel margin2 = new JPanel();
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		JPanel p10 = new JPanel();
		JPanel p11 = new JPanel();
		
		JButton button1 = new JButton(next);   //������Ϸ
		JButton button2 = new JButton(restart);   //��ʼ����Ϸ
		JButton button3 = new JButton(brief);   //�淨����
		JButton button4 = new JButton(zhuxiao);   //ע��
		
		JLabel title1 = new JLabel(ID);  //�û���
		JLabel title2 = new JLabel(APP.user);  //�û�����ֵ�������ݿ��л�ȡ
		JLabel title3 = new JLabel(capital);  //��ҽ��
		DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //��ø�ʽ�������
		dt.applyPattern("0.0");//����С����λ��(��λ) ���µĻ���������
		JLabel title4 = new JLabel(dt.format(User.getMoney(APP.user))+"");//��������������ݿ��л�ȡ
		JLabel title5 = new JLabel(hp);  //��Ҿ���
		JLabel title6 = new JLabel(User.getEnergy(APP.user)+""); //����ֵ�������ݿ��л�ȡ
		JLabel title7 = new JLabel(level);  //��Ҿ���
		JLabel title8 = new JLabel(User.getClasses(APP.user)+""); //����ֵ�������ݿ��л�ȡ
		
		
		bottom.setIcon(bg);
		bottom.setLayout(new BorderLayout(20,20));
		bottom.add(margin1,BorderLayout.SOUTH);
		bottom.add(margin2,BorderLayout.NORTH);
		margin1.setOpaque(false);
		margin2.setOpaque(false);
		margin1.setLayout(new BorderLayout());
		margin1.add(button3,BorderLayout.EAST);
		
		bottom.add(p,BorderLayout.CENTER);
		p.setOpaque(false);
		p.setLayout(new GridLayout(1,2,50,50));
		p.add(new JLabel(""));
		p.add(p1);
		
		
		p1.setOpaque(false);
		p1.setLayout(new BorderLayout(20,50));
		p1.add(p2,BorderLayout.NORTH);
		p1.add(p3,BorderLayout.CENTER);
		p1.add(p4,BorderLayout.SOUTH);
		
		p2.setOpaque(false);
		p2.setLayout(new BorderLayout());
		p2.add(button4,BorderLayout.EAST);
		button4.setFocusPainted(false);//��ȥ����Ŀ�  
		button4.setBorderPainted(false); //��ȥbutton�ı߿�
        button4.setContentAreaFilled(false);
		
        p3.setOpaque(false);
        p3.setLayout(new BorderLayout(50,50));
        p3.add(p5,BorderLayout.EAST);
        p3.add(p6,BorderLayout.WEST);
        p3.add(p7,BorderLayout.CENTER);
        
        p7.setLayout(new GridLayout(4,1,10,10));
        p7.add(p8);
        p7.add(p9);
        p7.add(p10);
        p7.add(p11);
        p8.setLayout(new GridLayout(1,2));
        p8.add(title1);
        p8.add(new JLabel("                    "));
        p8.add(title2);
        p9.setLayout(new GridLayout(1,2));
        p9.add(title3);
        p9.add(new JLabel("                    "));
        p9.add(title4);
        p10.setLayout(new GridLayout(1,2));
        p10.add(title5);
        p10.add(new JLabel("                    "));
        p10.add(title6);
        p11.setLayout(new GridLayout(1,2));
        p11.add(title7);
        p11.add(new JLabel("                    "));
        p11.add(title8);
        
		p4.setOpaque(false);
		p4.add(button1);
		p4.add(new JLabel("     "));
		p4.add(button2);
		
		p5.setOpaque(false);
		p6.setOpaque(false);
		p7.setOpaque(false);
		p8.setOpaque(false);
		p9.setOpaque(false);
		p10.setOpaque(false);
		p11.setOpaque(false);
		
		title2.setFont(new Font("Kristen ITC", Font.PLAIN, 20)); 
		title4.setFont(new Font("Kristen ITC", Font.PLAIN, 20)); 
		title6.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		title8.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		
		button1.setFocusPainted(false);//��ȥ����Ŀ�  
		button1.setBorderPainted(false); //��ȥbutton�ı߿�
        button1.setContentAreaFilled(false);
        button2.setFocusPainted(false);//��ȥ����Ŀ�  
		button2.setBorderPainted(false); //��ȥbutton�ı߿�
        button2.setContentAreaFilled(false);
        button3.setFocusPainted(false);//��ȥ����Ŀ�  
		button3.setBorderPainted(false); //��ȥbutton�ı߿�
        button3.setContentAreaFilled(false);
        button4.setFocusPainted(false);//��ȥ����Ŀ�  
		button4.setBorderPainted(false); //��ȥbutton�ı߿�
        button4.setContentAreaFilled(false);
		
		
		button1.addActionListener(new ActionListener()  //������Ϸ
		{
			public void actionPerformed(ActionEvent e)
			{
				if(User.getState(APP.user)==2)
				{
					JOptionPane.showMessageDialog(null, "�ǳ��ź������Ѿ������������¿�ʼ��Ϸ");
				}
				else
				{
					//�ڸ��û������½�����Ϸ���棬�����ݿ��б���ʵʱ����
					InformationFrame.this.dispose();  //�رյ�ǰ��Ϣ����
					new MapFrame();
				}
				
				}
		});
		
		button2.addActionListener(new ActionListener()  //���¿�ʼ��Ϸ
		{
			public void actionPerformed(ActionEvent e)
			{
				int is = JOptionPane.showConfirmDialog(null,"����ǰ����Ϸ��¼������գ���ȷ�ϳ�ʼ����Ϸ��");
				if(is==JOptionPane.OK_OPTION)
				{
					//���ݳ�ʼ����������Ϸ����
						FileData.initialize(APP.user, User.getPassword(APP.user));//��ʼ��
						Random rd = new Random();
						int index = rd.nextInt(6)+1;
						String path="/image/Photo/photo"+index+".png";
						FileData.update(APP.user, "user", "photopath", path);  //����ʼ�����ͷ��·�����д洢
						InformationFrame.this.dispose();  //��Ϣ����ر�
						try {
							new InformationFrame();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
	         }
		});
		
		button3.addActionListener(new ActionListener()  //�鿴�淨���
		{
			public void actionPerformed(ActionEvent e)
	        {
				InformationFrame.this.dispose();
				new IntroductionFrame();
	         }
		});
		
		button4.addActionListener(new ActionListener()  //ע��
				{
			public void actionPerformed(ActionEvent e)
			{
				int is = JOptionPane.showConfirmDialog(null,"�����˻�����Ϸ��¼������������ȷ��ע���˻���");  //����ѯ�ʴ���
				if(is==JOptionPane.OK_OPTION)  //���ٴο϶���ע�����˻�
				{
					//�����ݿ����������˻�
					try {
						FileData.delete(APP.user);  //ɾ�����û�id�ļ����µ�������Ϣ
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					APP.user=null;
					new StartFrame();  //���س�ʼ����	
					InformationFrame.this.dispose();  //��Ϣ����ر�
				}
			}
				});			
	}


}
