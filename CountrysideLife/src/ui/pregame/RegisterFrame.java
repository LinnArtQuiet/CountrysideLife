package ui.pregame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Data.FileData;
import Medium.Images;
import ui.father.MyFrameNext;

public class RegisterFrame extends MyFrameNext{
	
	public RegisterFrame() {
		setTitle("ע��");  //��������
		
		JPanel panel = new JPanel();
		JLabel bottom = new JLabel();
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		
		JTextField textField1 = new JTextField(15);
		JPasswordField textField2 = new JPasswordField(15);
		JPasswordField textField3 = new JPasswordField(15);
		textField2.setEchoChar('*');  //�������������ʾ*
		textField3.setEchoChar('*');  //�������������ʾ*
		
		ImageIcon bg=Images.getImg("/image/pagenext.png");  //����ͼ
		ImageIcon reset=Images.getImg("/image/resetnext.png");  //���ð�ť
		ImageIcon confirm=Images.getImg("/image/confirm.png");  //ȷ�ϰ�ť
		ImageIcon setID=Images.getImg("/image/setID.png"); 
		ImageIcon setpassword=Images.getImg("/image/setpassword.png"); 
		ImageIcon ensure=Images.getImg("/image/ensure.png"); 
		ensure.setImage(ensure.getImage().getScaledInstance(ensure.getIconWidth(),ensure.getIconHeight(), Image.SCALE_DEFAULT));
		setpassword.setImage(setpassword.getImage().getScaledInstance(setpassword.getIconWidth(),setpassword.getIconHeight(), Image.SCALE_DEFAULT));
		setID.setImage(setID.getImage().getScaledInstance(setID.getIconWidth(),setID.getIconHeight(), Image.SCALE_DEFAULT));
		bg.setImage(bg.getImage().getScaledInstance(bg.getIconWidth(),bg.getIconHeight(), Image.SCALE_DEFAULT));
		reset.setImage(reset.getImage().getScaledInstance(reset.getIconWidth(),reset.getIconHeight(), Image.SCALE_DEFAULT));
		confirm.setImage(confirm.getImage().getScaledInstance(confirm.getIconWidth(),confirm.getIconHeight(), Image.SCALE_DEFAULT));		
		
		JButton button1 = new JButton(confirm);
		JButton button2 = new JButton(reset);
		
		JLabel text1 = new JLabel(setID);
		JLabel text2 = new JLabel(setpassword);
		JLabel text3 = new JLabel(ensure);
		
		this.add(panel);
		panel.setLayout(new GridLayout(1,1));
		panel.add(bottom);
		bottom.setIcon(bg);
			
		bottom.setLayout(new BorderLayout());
		bottom.add(p6,BorderLayout.CENTER);
		bottom.add(p7,BorderLayout.SOUTH);
		
		p7.setOpaque(false);
		p7.setLayout(new GridLayout(0,2,10,10));
		p7.add(button1);
		p7.add(button2);
		
		p6.setOpaque(false);
		p6.setLayout(new GridLayout(2,1));
		p6.add(new JLabel(""));
		p6.add(p1);
		p1.setOpaque(false);
		p1.setLayout(new BorderLayout());
		p1.add(p2,BorderLayout.WEST);
		p2.setOpaque(false);
		p1.add(p3,BorderLayout.EAST);
		p3.setOpaque(false);
		p1.add(p4,BorderLayout.SOUTH);
		p4.setOpaque(false);
		p1.add(p5,BorderLayout.CENTER);
		p5.setOpaque(false);
		p5.setLayout(new GridLayout(0,2,10,10));
		p5.add(text1);
		p5.add(textField1);
		p5.add(text2);
		p5.add(textField2);
		p5.add(text3);
		p5.add(textField3);
		
		button1.setFocusPainted(false);//��ȥ����Ŀ�  
		button1.setBorderPainted(false); //��ȥbutton�ı߿�
		button1.setContentAreaFilled(false);	
		button2.setFocusPainted(false);//��ȥ����Ŀ�  
		button2.setBorderPainted(false); //��ȥbutton�ı߿�
		button2.setContentAreaFilled(false);	
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String users = new String(textField1.getText());
				String passwords = new String(textField2.getPassword());
				String ensures =  new String(textField3.getPassword());
					
				if(users.equals("")) {
					JOptionPane.showMessageDialog(null,"�û�������Ϊ�գ�");
				}
				
				else if(passwords.equals("")) {
					JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�");
				}
				
				else if(!(passwords.equals(ensures))) {
					JOptionPane.showMessageDialog(null,"�����������벻ͬ����ȷ�ϣ�");
				}
				
				else if(users.length()>10 || users.length()<3)
				{
					JOptionPane.showMessageDialog(null,"�û�������ӦΪ3~10");
				}
				
				else if(passwords.length()>10 || passwords.length()<3)
				{
					JOptionPane.showMessageDialog(null,"���볤��ӦΪ3~10");
				}
				
				else {
					int is = JOptionPane.showConfirmDialog(null,"��ȷ�ϴ����˻���");
					if (is == JOptionPane.OK_OPTION) {
						try {
							if(FileData.search(users)==true) {
								JOptionPane.showMessageDialog(null,"���˺���ע�ᣡ");
							}
							else {
								FileData.initialize(users, passwords);
								//��������û�ͷ��
								Random rd = new Random();
								int index = rd.nextInt(6)+1;
								String path="/image/Photo/photo"+index+".png";
								FileData.update(users, "user", "photopath", path);
							}
							RegisterFrame.this.setVisible(false);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} 
					else if(is == JOptionPane.NO_OPTION){
						
					}
					else
					{
						RegisterFrame.this.setVisible(false);
					}
				
				}
			}
		});
		
        button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
			}
		});
        
	}
        

	
}
