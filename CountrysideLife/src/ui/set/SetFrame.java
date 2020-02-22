package ui.set;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Medium.Images;
import main.APP;
import ui.father.MyFrameNext;
import user.User;

public class SetFrame extends MyFrameNext{

	public SetFrame()
	{
		setTitle("����");
		JPanel setPanel = new JPanel();
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
		JPanel p12 = new JPanel();
	
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		p4.setOpaque(false);
		p5.setOpaque(false);
		p6.setOpaque(false);
		p7.setOpaque(false);
		p8.setOpaque(false);
		p9.setOpaque(false);
		p10.setOpaque(false);
		p11.setOpaque(false);
		p12.setOpaque(false);
		
		JLabel back = new JLabel();
		JLabel setTitle = new JLabel();
	
		JLabel oldPW = new JLabel("ԭ����");
		JLabel newPW = new JLabel("������");
		JLabel ensure = new JLabel("ȷ������");
	
		JPasswordField oPW = new JPasswordField(15);
		JPasswordField nPW = new JPasswordField(15);
		JPasswordField ePW = new JPasswordField(15);
		oPW.setEchoChar('*');
		nPW.setEchoChar('*');
		ePW.setEchoChar('*');
		
		ImageIcon reset=Images.getImg("/image/resetnext.png");  //���ð�ťͼƬ
		ImageIcon confirm=Images.getImg("/image/confirm.png");  //ȷ�ϰ�ťͼƬ
		
		//ȷ�ϰ�ť
		JButton button1 = new JButton(confirm);
				
		//���ð�ť
		JButton button2 = new JButton(reset);
		
		this.add(setPanel);
		
		setPanel.setLayout(new GridLayout(1,1));
		setPanel.add(back);
		
		ImageIcon bg = Images.getImg("/image/DialogFrame.png");
		bg.setImage(bg.getImage().getScaledInstance(355, 400, Image.SCALE_DEFAULT));
		back.setIcon(bg);
		back.setLayout(new BorderLayout(40,10));
		back.add(p1,BorderLayout.SOUTH);
		back.add(p2,BorderLayout.WEST);
		back.add(p3,BorderLayout.EAST);
		back.add(setTitle,BorderLayout.NORTH);
		back.add(p4,BorderLayout.CENTER);
		
		p4.setLayout(new BorderLayout(10,10));
		p4.add(p5,BorderLayout.CENTER);
		p4.add(p6,BorderLayout.SOUTH);
		
		setTitle.setIcon(Images.getImg("/image/SetTitle.png"));
		
		p5.setLayout(new BorderLayout(10,20));
		p5.add(p7,BorderLayout.SOUTH);
		p5.add(p8,BorderLayout.NORTH);
		p5.add(p9,BorderLayout.CENTER);
		
		p6.setLayout(new GridLayout(0,3));
		p6.add(button1);
		p6.add(new JLabel(""));
		p6.add(button2);
		
		p9.setLayout(new GridLayout(3,1,10,25));
		p9.add(p10);
		p9.add(p11);
		p9.add(p12);
		
		p10.setLayout(new GridLayout(1,2));
		p10.add(oldPW);
		p10.add(oPW);
		
		p11.setLayout(new GridLayout(1,2));
		p11.add(newPW);
		p11.add(nPW);
		
		p12.setLayout(new GridLayout(1,2));
		p12.add(ensure);
		p12.add(ePW);
		
		
		//�޸���������
		oldPW.setFont(new Font("����",Font.PLAIN, 20));
		newPW.setFont(new Font("����",Font.PLAIN, 20));
		ensure.setFont(new Font("����",Font.PLAIN, 20));
		
		
		button1.setFocusPainted(false);//��ȥ����Ŀ�  
		button1.setBorderPainted(false); //��ȥbutton�ı߿�
		button1.setContentAreaFilled(false);	
		button2.setFocusPainted(false);//��ȥ����Ŀ�  
		button2.setBorderPainted(false); //��ȥbutton�ı߿�
		button2.setContentAreaFilled(false);
		
		button1.addActionListener(new ActionListener() {  //���û�����
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String yuan = new String(oPW.getPassword());
				String xin = new String(nPW.getPassword());
				String again = new String(ePW.getPassword());
				
				if(yuan.equals(""))  //δ����ԭ����
				{
					if(!xin.equals(""))  //������������
					{
						JOptionPane.showMessageDialog(null,"��������ԭ���룡");
					}
					else  //������Ҳû������
					{
						SetFrame.this.dispose();
					}
				}
				else  //������ԭ����
				{
					if(!xin.equals(""))   //������������
					{
						if(!xin.equals(""))  //ȷ��������
						{
							if(!yuan.equals(User.getPassword(APP.user)))  //ԭ�����������
							{
								JOptionPane.showMessageDialog(null,"ԭ�����������");
							}
							//ԭ����������ȷ
							else if(!xin.equals(again))  //��������ȷ�����벻һ��
							{
								JOptionPane.showMessageDialog(null,"�������������벻һ�£����飡");
							}
							else //��������ȷ������һ��
							{
								if(yuan.length()<3 || yuan.length()>10)
								{
									JOptionPane.showMessageDialog(null,"���볤��ӦΪ3~10");
								}
								else
								{
									int is = JOptionPane.showConfirmDialog(null, "�����Ҫ�޸�������");
									if(is == JOptionPane.OK_OPTION)
									{
										JOptionPane.showMessageDialog(null,"�������޸ĳɹ���");
										User.setPassword(APP.user,xin);
										SetFrame.this.dispose();
									}
								}
								
							}
						}
						else  //δȷ������
						{
							JOptionPane.showMessageDialog(null,"��ȷ�������룡");
						}
					}
					else
					{
						SetFrame.this.dispose();
					}
				}
			}
		});
		
		 button2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					oPW.setText("");
					nPW.setText("");
					ePW.setText("");
				}
			});
		
		}
}
