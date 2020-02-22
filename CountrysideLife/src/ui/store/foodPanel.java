package ui.store;

import java.awt.Color;

/**
 * @author ZYN
 * @updateTime 2019.12.15
 */

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Food.Food;
import Medium.Images;
import main.APP;
import user.User;


public class foodPanel extends ShopPanel{

	public foodPanel() {
		DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //鑾峰緱鏍煎紡鍖栫被瀵硅薄
		dt.applyPattern("0.0");//璁剧疆灏忔暟鐐逛綅鏁�(涓や綅) 浣欎笅鐨勪細鍥涜垗浜斿叆
		double price1=Food.getMoney(1);
		double price2=Food.getMoney(2);
		double price3=Food.getMoney(3);
		double price4=Food.getMoney(4);
		double price5=Food.getMoney(5);
		double price6=Food.getMoney(6);
		double price7=Food.getMoney(7);
		double price8=Food.getMoney(8);
		double price9=Food.getMoney(9);
		
		ImageIcon food1=Images.getImg(Food.getFoodPic(1));
		JButton button1=new JButton(food1);
		button1.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button1.setBorder(null);//闄ゅ幓杈规  
        button1.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button1.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
        
		ImageIcon food2=Images.getImg(Food.getFoodPic(2));
		JButton button2=new JButton(food2);
		button2.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button2.setBorder(null);//闄ゅ幓杈规  
        button2.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button2.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
        
        ImageIcon food3=Images.getImg(Food.getFoodPic(3));
		JButton button3=new JButton(food3);
		button3.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button3.setBorder(null);//闄ゅ幓杈规  
        button3.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button3.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
		
		ImageIcon food4=Images.getImg(Food.getFoodPic(4));
		JButton button4=new JButton(food4);
		button4.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button4.setBorder(null);//闄ゅ幓杈规  
        button4.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button4.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
		
		ImageIcon food5=Images.getImg(Food.getFoodPic(5));
		JButton button5=new JButton(food5);
		button5.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button5.setBorder(null);//闄ゅ幓杈规  
        button5.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button5.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
		
		ImageIcon food6=Images.getImg(Food.getFoodPic(6));
		JButton button6=new JButton(food6);
		button6.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button6.setBorder(null);//闄ゅ幓杈规  
        button6.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button6.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
		
		ImageIcon food7=Images.getImg(Food.getFoodPic(7));
		JButton button7=new JButton(food7);
		button7.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button7.setBorder(null);//闄ゅ幓杈规  
        button7.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button7.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
		
		ImageIcon food8=Images.getImg(Food.getFoodPic(8));
		JButton button8=new JButton(food8);
		button8.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button8.setBorder(null);//闄ゅ幓杈规  
        button8.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button8.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
		
		ImageIcon food9=Images.getImg(Food.getFoodPic(9));
		JButton button9=new JButton(food9);
		button9.setBorderPainted(false);//涓嶆墦鍗拌竟妗�  
        button9.setBorder(null);//闄ゅ幓杈规  
        button9.setFocusPainted(false);//闄ゅ幓鐒︾偣鐨勬  
        button9.setContentAreaFilled(false);//闄ゅ幓榛樿鐨勮儗鏅～鍏�
        
        
        JLabel jl1 = new JLabel("  "+dt.format(price1));
        JLabel jl2 = new JLabel("  "+dt.format(price2));
        JLabel jl3 = new JLabel("  "+dt.format(price3));
        JLabel jl4 = new JLabel("  "+dt.format(price4));
        JLabel jl5 = new JLabel("  "+dt.format(price5));
        JLabel jl6 = new JLabel("  "+dt.format(price6));
        JLabel jl7 = new JLabel("  "+dt.format(price7));
        JLabel jl8 = new JLabel("  "+dt.format(price8));
        JLabel jl9 = new JLabel("  "+dt.format(price9));
        
        jl1.setOpaque(true);
        jl2.setOpaque(true);
        jl3.setOpaque(true);
        jl4.setOpaque(true);
        jl5.setOpaque(true);
        jl6.setOpaque(true);
        jl7.setOpaque(true);
        jl8.setOpaque(true);
        jl9.setOpaque(true);
        
		
        jl1.setFont(new Font("楷体", Font.PLAIN, 16));
        jl2.setFont(new Font("楷体", Font.PLAIN, 16));
        jl3.setFont(new Font("楷体", Font.PLAIN, 16));
        jl4.setFont(new Font("楷体", Font.PLAIN, 16));
        jl5.setFont(new Font("楷体", Font.PLAIN, 16));
        jl6.setFont(new Font("楷体", Font.PLAIN, 16));
        jl7.setFont(new Font("楷体", Font.PLAIN, 16));
        jl8.setFont(new Font("楷体", Font.PLAIN, 16));
        jl9.setFont(new Font("楷体", Font.PLAIN, 16));
        
        food1.setImage(food1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food2.setImage(food2.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food3.setImage(food3.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food4.setImage(food4.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food5.setImage(food5.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food6.setImage(food6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food7.setImage(food7.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food8.setImage(food8.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food9.setImage(food9.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        
        button1.setBounds(125,40, 100, 100);
        jl1.setBounds(145, 125, 66, 24);
        button2.setBounds(285,40, 100, 100);
        jl2.setBounds(305, 125, 66, 24);
        button3.setBounds(445,40, 100, 100);
        jl3.setBounds(465, 125, 66, 24);
        button4.setBounds(125,175, 100, 100);
        jl4.setBounds(145, 250, 66, 24);
        button5.setBounds(285,175, 100, 100);
        jl5.setBounds(305, 250, 66, 24);
        button6.setBounds(445,175, 100, 100);
        jl6.setBounds(465, 250, 66, 24);
        button7.setBounds(125,315, 100, 100);
        jl7.setBounds(145, 395, 66, 24);
        button8.setBounds(285,315, 100, 100);
        jl8.setBounds(305, 395, 66, 24);
        button9.setBounds(445,315, 100, 100);
        jl9.setBounds(465, 395, 66, 24);
        
        jl1.setBackground(new Color(230,230,230));
        jl2.setBackground(new Color(230,230,230));
        jl3.setBackground(new Color(230,230,230));
        jl4.setBackground(new Color(230,230,230));
        jl5.setBackground(new Color(230,230,230));
        jl6.setBackground(new Color(230,230,230));
        jl7.setBackground(new Color(230,230,230));
        jl8.setBackground(new Color(230,230,230));
        jl9.setBackground(new Color(230,230,230));
        
        jl1.setForeground(Color.black);
        jl2.setForeground(Color.black);
        jl3.setForeground(Color.black);
        jl4.setForeground(Color.black);
        jl5.setForeground(Color.black);
        jl6.setForeground(Color.black);
        jl7.setForeground(Color.black);
        jl8.setForeground(Color.black);
        jl9.setForeground(Color.black);
        
        
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
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);
		add(jl6);
		add(jl7);
		add(jl8);
		add(jl9);
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(1))
				{
					new PurchaseDialog(2,1,price1);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Food.getName(1)+Food.getBuylevel(1)+"级解锁，您还需要努力！");
				}
							
			}
			
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(2))
				{
					new PurchaseDialog(2,2,price2);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�		
				}
				else
				{
					JOptionPane.showMessageDialog(null, Food.getName(2)+Food.getBuylevel(2)+"级解锁，您还需要努力！");
				}
						
			}
			
		});
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(3))
				{
					new PurchaseDialog(2,3,price3);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null,  Food.getName(3)+Food.getBuylevel(3)+"级解锁，您还需要努力！");
				}
							
			}
			
		});
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(4))
				{
					new PurchaseDialog(2,4,price4);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�
				}
				else
				{
					JOptionPane.showMessageDialog(null, Food.getName(4)+Food.getBuylevel(4)+"级解锁，您还需要努力！");
				}
								
			}
			
		});
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(5))
				{
					new PurchaseDialog(2,5,price5);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�
				}
				else
				{
					JOptionPane.showMessageDialog(null, Food.getName(5)+Food.getBuylevel(5)+"级解锁，您还需要努力！");
				}
								
			}
			
		});
		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(6))
				{
					new PurchaseDialog(2,6,price6);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�
				}
				else
				{
					JOptionPane.showMessageDialog(null, Food.getName(6)+Food.getBuylevel(6)+"级解锁，您还需要努力！");
				}
								
			}
			
		});
		button7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(7))
				{
					new PurchaseDialog(2,7,price7);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Food.getName(7)+Food.getBuylevel(7)+"级解锁，您还需要努力！");
				}
							
			}
			
		});
		button8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(8))
				{
					new PurchaseDialog(2,8,price8);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Food.getName(8)+Food.getBuylevel(8)+"级解锁，您还需要努力！");
				}
							
			}
			
		});
		button9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(User.getClasses(APP.user) >= Food.getBuylevel(9))
				{
					new PurchaseDialog(2,9,price9);//鍒锋柊閲戦挶锛屾洿鏂拌儗鍖呯晫闈㈢殑椋熺墿鏁�	
				}
				else
				{
					JOptionPane.showMessageDialog(null, Food.getName(9)+Food.getBuylevel(9)+"级解锁，您还需要努力！");
				}
							
			}
			
		});
	}
}
