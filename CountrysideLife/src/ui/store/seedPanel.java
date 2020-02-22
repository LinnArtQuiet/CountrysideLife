package ui.store;

import java.awt.Color;
import java.awt.Font;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Crop.Crop;
import Medium.Images;
import main.APP;
import user.User;


public class seedPanel extends ShopPanel{
	
	public seedPanel() {
		//格式化，只能显示一位小数，不足用0替代
		DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance();
		dt.applyPattern("0.0");
		
		double price1=Crop.getSeedMoney(1);
		double price2=Crop.getSeedMoney(2);
		double price3=Crop.getSeedMoney(3);
		double price4=Crop.getSeedMoney(4);
		double price5=Crop.getSeedMoney(5);
		double price6=Crop.getSeedMoney(6);
		double price7=Crop.getSeedMoney(7);
		double price8=Crop.getSeedMoney(8);
		double price9=Crop.getSeedMoney(9);
		double price10=Crop.getSeedMoney(10);
		double price11=Crop.getSeedMoney(11);

		ImageIcon seed1=Images.getImg("/image/Crop1/fruit.png");
		JButton button1=new JButton(seed1);
		button1.setBorderPainted(false);
        button1.setBorder(null);
        button1.setFocusPainted(false);  
        button1.setContentAreaFilled(false);
        
		ImageIcon seed2=Images.getImg("/image/Crop2/fruit.png");
		JButton button2=new JButton(seed2);
		button2.setBorderPainted(false);
        button2.setBorder(null); 
        button2.setFocusPainted(false); 
        button2.setContentAreaFilled(false);
		
		ImageIcon seed3=Images.getImg("/image/Crop3/fruit.png");
		JButton button3=new JButton(seed3);
		button3.setBorderPainted(false);
        button3.setBorder(null);
        button3.setFocusPainted(false);  
        button3.setContentAreaFilled(false);
		
		ImageIcon seed4=Images.getImg("/image/Crop4/fruit.png");
		JButton button4=new JButton(seed4);
		button4.setBorderPainted(false);
        button4.setBorder(null);  
        button4.setFocusPainted(false);  
        button4.setContentAreaFilled(false);
		
		ImageIcon seed5=Images.getImg("/image/Crop5/fruit.png");
		JButton button5=new JButton(seed5);
		button5.setBorderPainted(false);
        button5.setBorder(null); 
        button5.setFocusPainted(false);  
        button5.setContentAreaFilled(false);
		
		ImageIcon seed6=Images.getImg("/image/Crop6/fruit.png");
		JButton button6=new JButton(seed6);
		button6.setBorderPainted(false);
        button6.setBorder(null);
        button6.setFocusPainted(false); 
        button6.setContentAreaFilled(false);
		
		ImageIcon seed7=Images.getImg("/image/Crop7/fruit.png");
		JButton button7=new JButton(seed7);
		button7.setBorderPainted(false);
        button7.setBorder(null);  
        button7.setFocusPainted(false);  
        button7.setContentAreaFilled(false);
		
		ImageIcon seed8=Images.getImg("/image/Crop8/fruit.png");
		JButton button8=new JButton(seed8);
		button8.setBorderPainted(false);
        button8.setBorder(null);
        button8.setFocusPainted(false);
        button8.setContentAreaFilled(false);
		
		ImageIcon seed9=Images.getImg("/image/Crop9/fruit.png");
		JButton button9=new JButton(seed9);
		button9.setBorderPainted(false);
        button9.setBorder(null);
        button9.setFocusPainted(false);  
        button9.setContentAreaFilled(false);
		
		ImageIcon seed10=Images.getImg("/image/Crop10/fruit.png");
		JButton button10=new JButton(seed10);
		button10.setBorderPainted(false); 
        button10.setBorder(null);
        button10.setFocusPainted(false);  
        button10.setContentAreaFilled(false);
		
		ImageIcon seed11=Images.getImg("/image/Crop11/fruit.png");
		JButton button11=new JButton(seed11);
		button11.setBorderPainted(false);  
        button11.setBorder(null);  
        button11.setFocusPainted(false);  
        button11.setContentAreaFilled(false);
		
//        System.out.println(seed1.getIconHeight()+"   "+seed1.getIconHeight());
        
        JLabel jl1 = new JLabel("  "+dt.format(price1));
        JLabel jl2 = new JLabel("  "+dt.format(price2));
        JLabel jl3 = new JLabel("  "+dt.format(price3));
        JLabel jl4 = new JLabel("  "+dt.format(price4));
        JLabel jl5 = new JLabel("  "+dt.format(price5));
        JLabel jl6 = new JLabel("  "+dt.format(price6));
        JLabel jl7 = new JLabel("  "+dt.format(price7));
        JLabel jl8 = new JLabel("  "+dt.format(price8));
        JLabel jl9 = new JLabel("  "+dt.format(price9));
        JLabel jl10 = new JLabel("  "+dt.format(price10));
        JLabel jl11 = new JLabel("  "+dt.format(price11));
        
        jl1.setOpaque(true);
        jl2.setOpaque(true);
        jl3.setOpaque(true);
        jl4.setOpaque(true);
        jl5.setOpaque(true);
        jl6.setOpaque(true);
        jl7.setOpaque(true);
        jl8.setOpaque(true);
        jl9.setOpaque(true);
        jl10.setOpaque(true);
        jl11.setOpaque(true);
        
        jl1.setFont(new Font("楷体", Font.PLAIN, 16));
        jl2.setFont(new Font("楷体", Font.PLAIN, 16));
        jl3.setFont(new Font("楷体", Font.PLAIN, 16));
        jl4.setFont(new Font("楷体", Font.PLAIN, 16));
        jl5.setFont(new Font("楷体", Font.PLAIN, 16));
        jl6.setFont(new Font("楷体", Font.PLAIN, 16));
        jl7.setFont(new Font("楷体", Font.PLAIN, 16));
        jl8.setFont(new Font("楷体", Font.PLAIN, 16));
        jl9.setFont(new Font("楷体", Font.PLAIN, 16));
        jl10.setFont(new Font("楷体", Font.PLAIN, 16));
        jl11.setFont(new Font("楷体", Font.PLAIN, 16));
        
        seed1.setImage(seed1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed2.setImage(seed2.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed3.setImage(seed3.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed4.setImage(seed4.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed5.setImage(seed5.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed6.setImage(seed6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed7.setImage(seed7.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed8.setImage(seed8.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed9.setImage(seed9.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed10.setImage(seed10.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        seed11.setImage(seed11.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        
        button1.setBounds(125,40, 100, 100);
        jl1.setBounds(145, 125, 66, 24);
        button2.setBounds(225,40, 100, 100);
        jl2.setBounds(245, 125, 66, 24);
        button3.setBounds(340,40, 100, 100);
        jl3.setBounds(360, 125, 66, 24);
        button4.setBounds(440,40, 100, 100);
        jl4.setBounds(460, 125, 66, 24);   
        button5.setBounds(125,175, 100, 100);
        jl5.setBounds(145, 250, 66, 24);
        button6.setBounds(225,175, 100, 100);
        jl6.setBounds(245, 250, 66, 24);
        button7.setBounds(340,175, 100, 100);
        jl7.setBounds(360, 250, 66, 24);
        button8.setBounds(440,175, 100, 100);
        jl8.setBounds(460, 250, 66, 24);            
        button9.setBounds(125,315, 100, 100);
        jl9.setBounds(145, 395, 66, 24);
        button10.setBounds(285,315, 100, 100);
        jl10.setBounds(305, 395, 66, 24);
        button11.setBounds(445,315, 100, 100);
        jl11.setBounds(465, 395, 66, 24);
        
        jl1.setBackground(new Color(230,230,230));
        jl2.setBackground(new Color(230,230,230));
        jl3.setBackground(new Color(230,230,230));
        jl4.setBackground(new Color(230,230,230));
        jl5.setBackground(new Color(230,230,230));
        jl6.setBackground(new Color(230,230,230));
        jl7.setBackground(new Color(230,230,230));
        jl8.setBackground(new Color(230,230,230));
        jl9.setBackground(new Color(230,230,230));
        jl10.setBackground(new Color(230,230,230));
        jl11.setBackground(new Color(230,230,230));
        
        jl1.setForeground(Color.black);
        jl2.setForeground(Color.black);
        jl3.setForeground(Color.black);
        jl4.setForeground(Color.black);
        jl5.setForeground(Color.black);
        jl6.setForeground(Color.black);
        jl7.setForeground(Color.black);
        jl8.setForeground(Color.black);
        jl9.setForeground(Color.black);
        jl10.setForeground(Color.black);
        jl11.setForeground(Color.black);
		
        setLayout(null);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		add(button10);
		add(button11);
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);
		add(jl6);
		add(jl7);
		add(jl8);
		add(jl9);
		add(jl10);
		add(jl11);
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(1))
				{
					new PurchaseDialog(1,1,price1);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(1)+"种子"+Crop.getBuylevel(1)+"级解锁，您还需要努力！");
				}
			}
			
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(2))
				{
					new PurchaseDialog(1,2,price2);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(2)+"种子"+Crop.getBuylevel(2)+"级解锁，您还需要努力！");
				}
			}
			
		});
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(3))
				{
					new PurchaseDialog(1,3,price3);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(3)+"种子"+Crop.getBuylevel(3)+"级解锁，您还需要努力！");
				}
			}
			
		});
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(4))
				{
					new PurchaseDialog(1,4,price4);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(4)+"种子"+Crop.getBuylevel(4)+"级解锁，您还需要努力！");
				}
			}
			
		});
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(5))
				{
					new PurchaseDialog(1,5,price5);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(5)+"种子"+Crop.getBuylevel(5)+"级解锁，您还需要努力！");
				}
			}
			
		});
		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(6))
				{
					new PurchaseDialog(1,6,price6);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(6)+"种子"+Crop.getBuylevel(6)+"级解锁，您还需要努力！");
				}
								
			}
			
		});
		button7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(7))
				{
					new PurchaseDialog(1,7,price7);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(7)+"种子"+Crop.getBuylevel(7)+"级解锁，您还需要努力！");
				}
								
			}
			
		});
		button8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(8))
				{
					new PurchaseDialog(1,8,price8);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(8)+"种子"+Crop.getBuylevel(8)+"级解锁，您还需要努力！");
				}
								
			}
			
		});
		button9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(9))
				{
					new PurchaseDialog(1,9,price9);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(9)+"种子"+Crop.getBuylevel(9)+"级解锁，您还需要努力！");
				}
								
			}
			
		});
		button10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(10))
				{
					new PurchaseDialog(1,10,price10);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(10)+"种子"+Crop.getBuylevel(10)+"级解锁，您还需要努力！");
				}
							
			}
			
		});
		button11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Crop.getBuylevel(11))
				{
					new PurchaseDialog(1,11,price11);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑绉嶅瓙鏁�
				}
				else
				{
					JOptionPane.showMessageDialog(null, Crop.getName(11)+"种子"+Crop.getBuylevel(11)+"级解锁，您还需要努力！");
				}
								
			}
			
		});
	}
	
}
