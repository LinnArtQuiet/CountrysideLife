package ui.bed;
/**
 * @author ZYN
 * @updateTime 2019/12/13
 */
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Medium.Images;
import main.APP;
import ui.father.MyFrame;
import user.User;


public class MainRoom extends MyFrame{
	
	//�����淿�����JButton,��Ӽ���(button.addActionListener(new ActionListener())
	JButton jb1=new JButton();
	JButton jb2=new JButton();
	JLabel sleep=new JLabel();
	public MainRoom() {
		
		
		setTitle("��԰С��");
		
		ImageIcon bg=Images.getImg("/image/bedroom.png");  //д��ͼƬ��ַ
		bg.setImage(bg.getImage().getScaledInstance(1067,600, Image.SCALE_DEFAULT));
		ImageIcon sleeppic=Images.getImg("/image/evening.png");  //д��˯��ͼƬ��ַ
		sleeppic.setImage(sleeppic.getImage().getScaledInstance(151,146, Image.SCALE_DEFAULT));
		ImageIcon uppic=Images.getImg("/image/day.png");  //д������ͼƬ��ַ
		sleeppic.setImage(sleeppic.getImage().getScaledInstance(151,146, Image.SCALE_DEFAULT));
		
		JPanel jpanel=new JPanel();
		jpanel.setOpaque(false);
		this.add(jpanel);
		
		JLabel background= new JLabel();//�󱳾�
		background.setBounds(0,0,1067,600);
		background.setIcon(bg);
		background.setLayout(null);
		
		
		jb1.setBounds(825, 350, 242, 195);
		jb2.setBounds(425,0,200,425);
		sleep.setBounds(879,102,151,146);
		
		//��ť����͸��
		jb1.setBorderPainted(false);//����ӡ�߿�  
		jb1.setBorder(null);//��ȥ�߿�  
		jb1.setFocusPainted(false);//��ȥ����Ŀ�  
		jb1.setContentAreaFilled(false);//��ȥĬ�ϵı������
		
		jb2.setBorderPainted(false);//����ӡ�߿�  
		jb2.setBorder(null);//��ȥ�߿�  
		jb2.setFocusPainted(false);//��ȥ����Ŀ�  
		jb2.setContentAreaFilled(false);//��ȥĬ�ϵı������
		
		jpanel.add(background);
		background.add(jb1);
		background.add(jb2);
		background.add(sleep);//��ԭ���Ļ����ϼ���˯����ZZZ������
		
		if(User.getState(APP.user)==0)
		{
			sleep.setIcon(sleeppic);
			repaint();
			new SleepTimer();
		}
		else if(User.getState(APP.user)==1)
		{
			sleep.setIcon(uppic);
			repaint();
		}
		
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(User.getState(APP.user)==1)  //������Ϣ
				{
					if (APP.gf.gameTimer.getState().equals("night")) {//ֻ�����ϲ��ܽ���˯��״̬
						MainRoom.this.sleep.setIcon(sleeppic);
						repaint();
						new SleepTimer();
					}
					else {
						JOptionPane.showMessageDialog(null, "δ��ҹ��������");
					}
				}
				else  //�Ѿ�����Ϣ��
				{
					JOptionPane.showMessageDialog(null, "������Ϣ��������ţ�");
				}
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainRoom.this.setVisible(false);
				APP.gf.setVisible(true);
			}
			
		});
	}

}
