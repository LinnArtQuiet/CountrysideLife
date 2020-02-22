package ui.pregame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Data.FileData;
import Medium.Images;
import main.APP;
import ui.father.MyFrame;


public class LoginFrame extends MyFrame{

	
	public LoginFrame()
	{
		super();

		JLabel bottom=new JLabel();
		JLabel bottoms=new JLabel();
		
		JPanel panel = new JPanel();  //�������
		this.add(panel);
		panel.setLayout(new GridLayout(1,1));
		panel.add(bottom);
		
		ImageIcon bg=Images.getImg("/image/page.png"); //����ͼ
		ImageIcon load=Images.getImg("/image/load.png");  //��¼��
		ImageIcon login=Images.getImg("/image/login.png");  //��¼��ť
		ImageIcon register=Images.getImg("/image/register.png");  //ע�ᰴť
		ImageIcon reset=Images.getImg("/image/reset.png");  //���ð�ť
		ImageIcon user=Images.getImg("/image/user.png");  //�û���
		ImageIcon password=Images.getImg("/image/password.png");  //����
		bg.setImage(bg.getImage().getScaledInstance(1067,600, Image.SCALE_DEFAULT));
		load.setImage(load.getImage().getScaledInstance(load.getIconWidth(),load.getIconHeight(), Image.SCALE_DEFAULT));
		login.setImage(login.getImage().getScaledInstance(login.getIconWidth(),login.getIconHeight(), Image.SCALE_DEFAULT));
		register.setImage(register.getImage().getScaledInstance(register.getIconWidth(),register.getIconHeight(), Image.SCALE_DEFAULT));
		reset.setImage(reset.getImage().getScaledInstance(reset.getIconWidth(),reset.getIconHeight(), Image.SCALE_DEFAULT));
		user.setImage(user.getImage().getScaledInstance(user.getIconWidth(),user.getIconHeight(), Image.SCALE_DEFAULT));
		password.setImage(password.getImage().getScaledInstance(password.getIconWidth(),password.getIconHeight(), Image.SCALE_DEFAULT));
		
		bottom.setIcon(bg);
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		
		JPanel margin1=new JPanel();
		JPanel margin2=new JPanel();
		JPanel margin3=new JPanel();
		JPanel margin4=new JPanel();
		
		JLabel title1=new JLabel(user);
		JLabel title2=new JLabel(password);
		JTextField textField1=new JTextField(15);
		JPasswordField textField2=new JPasswordField(15);
		textField2.setEchoChar('*');  //�������������ʾ*
		
		JButton button1=new JButton(login);
		JButton button2=new JButton(reset);
		JButton button3=new JButton(register);
			
		bottom.setLayout(new BorderLayout(220,50));
		
		bottom.add(margin1,BorderLayout.EAST);
		bottom.add(margin2,BorderLayout.WEST);
		bottom.add(margin3,BorderLayout.SOUTH);
		bottom.add(margin4,BorderLayout.NORTH);
		bottom.add(bottoms,BorderLayout.CENTER);
		
		margin1.setOpaque(false);
		margin2.setOpaque(false);
		margin3.setOpaque(false);
		margin4.setOpaque(false);
		
		bottoms.setIcon(load);
		bottoms.setLayout(new GridLayout(6,1));
		bottoms.add(new JLabel(""));
		bottoms.add(new JLabel(""));
		bottoms.add(p1);
		bottoms.add(p2);
		bottoms.add(p3);
		bottoms.add(new JLabel(""));
		
		p1.setOpaque(false);
		p1.add(title1);
		p1.add(new JLabel("            "));
		p1.add(textField1);
		
		p2.setOpaque(false);
		p2.add(title2);
		p2.add(new JLabel("            "));
		p2.add(textField2);
		
		p3.setOpaque(false);
		p3.add(button1);
		p3.add(button2);
		p3.add(button3);

		button1.setFocusPainted(false);//��ȥ����Ŀ�  
		button1.setBorderPainted(false); //��ȥbutton�ı߿�
        button1.setContentAreaFilled(false);
        button2.setFocusPainted(false);//��ȥ����Ŀ�  
		button2.setBorderPainted(false); //��ȥbutton�ı߿�
        button2.setContentAreaFilled(false);
        button3.setFocusPainted(false);//��ȥ����Ŀ�  
		button3.setBorderPainted(false); //��ȥbutton�ı߿�
        button3.setContentAreaFilled(false);
		
		button1.addActionListener(new ActionListener()  //��¼
		{
			public void actionPerformed(ActionEvent e)
			{
				String users = new String(textField1.getText());
				String passwords = new String(textField2.getPassword());
				
				if(users.equals("")) {
					JOptionPane.showMessageDialog(null,"�û�������Ϊ�գ�");
				}
				
				else if(passwords.equals("")) {
					JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�");
				}
				
				else
				{
					try {
						if(FileData.search(users)==false) {
							JOptionPane.showMessageDialog(null,"���û������ڣ�");
						}
						else if(!(passwords.equals(FileData.get(users,"user","password")))){
							JOptionPane.showMessageDialog(null,"�����������");
						}
						else {
							APP.user=users;
							//������Ϸ
							LoginFrame.this.dispose();
							new InformationFrame();
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
//					int count = 0;
//					File file = new File("./user/");
//					File[] arr = file.listFiles();
//					File fileuser = new File("./user/" + users + "/user.txt");
//					InputStreamReader is = null;
//					Properties properties = new Properties();
//					try {
//						for (int i = 0; i < file.list().length; i++) {
//							if (users.equals(arr[i].getName())) {
//								is = new InputStreamReader(new FileInputStream(fileuser));
//								properties.load(is);
//								if (passwords.equals(properties.getProperty("passWord"))) {
//									APP.user=users;
//									APP.password=passwords;
//									try {
//										new InformationFrame();
//									} catch (Exception e1) {
//										// TODO Auto-generated catch block
//										e1.printStackTrace();
//									}
//									LoginFrame.this.dispose();
//									break;
//								} else {
//									textField1.setText("");
//									textField2.setText("");
//									JOptionPane.showMessageDialog(null,"�����������");
//									return;
//								}
//							}
//							count++;
//						}
//						if (count >= file.list().length) {
//							textField1.setText("");
//							textField2.setText("");
//							JOptionPane.showMessageDialog(null,"�û��������ڣ����������ע���û���");
//							return;
//						}
//						// jTextField1.setText("");
//
//					} catch (FileNotFoundException e1) {
//						e1.printStackTrace();
//					} catch (IOException ex) {
//						ex.printStackTrace();
//					} finally {
//						/*
//						 * if (isr != null) { try { isr.close(); } catch
//						 * (IOException e1) { e1.printStackTrace(); } }
//						 */
//						if (is != null) {
//							try {
//								is.close();
//							} catch (IOException e1) {
//								e1.printStackTrace();
//							}
//						}
//					}
					}		
			}
		});
			
		button2.addActionListener(new ActionListener()  //����������û���
		{
			public void actionPerformed(ActionEvent e)
				{
					textField1.setText("");
					textField2.setText("");
				}
					});
			
		button3.addActionListener(new ActionListener()  //ע�����û�
		{
			public void actionPerformed(ActionEvent e)
		    {
				new RegisterFrame();	
				
		   	}
		});
			
	}
	
}
