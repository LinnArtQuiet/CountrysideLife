package ui.bag;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Bag.FoodBag;
import Medium.Images;
import user.User;

public class foodPanel extends BagPanel{
	
	public foodPanel() {
		String count1 = FoodBag.getFoodCount(1)+"";
		String count2 = FoodBag.getFoodCount(2)+"";
		String count3 = FoodBag.getFoodCount(3)+"";
		String count4 = FoodBag.getFoodCount(4)+"";
		String count5 = FoodBag.getFoodCount(5)+"";
		String count6 = FoodBag.getFoodCount(6)+"";
		String count7 = FoodBag.getFoodCount(7)+"";
		String count8 = FoodBag.getFoodCount(8)+"";
		String count9 = FoodBag.getFoodCount(9)+"";
		
		ImageIcon food1=Images.getImg("/image/Food/1.png");
		JButton button1=new JButton("数量   "+count1,food1);
		button1.setVerticalTextPosition(JButton.BOTTOM);
		button1.setHorizontalTextPosition(JButton.CENTER);
		button1.setBorderPainted(false);//不打印边框  
        button1.setBorder(null);//除去边框  
        button1.setFocusPainted(false);//除去焦点的框  
        button1.setContentAreaFilled(false);//除去默认的背景填充
        
		ImageIcon food2=Images.getImg("/image/Food/2.png");
		JButton button2=new JButton("数量   "+count2,food2);
		button2.setVerticalTextPosition(JButton.BOTTOM);
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setBorderPainted(false);//不打印边框  
        button2.setBorder(null);//除去边框  
        button2.setFocusPainted(false);//除去焦点的框  
        button2.setContentAreaFilled(false);//除去默认的背景填充
        
        ImageIcon food3=Images.getImg("/image/Food/3.png");
		JButton button3=new JButton("数量   "+count3,food3);
		button3.setVerticalTextPosition(JButton.BOTTOM);
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setBorderPainted(false);//不打印边框  
        button3.setBorder(null);//除去边框  
        button3.setFocusPainted(false);//除去焦点的框  
        button3.setContentAreaFilled(false);//除去默认的背景填充
        
        ImageIcon food4=Images.getImg("/image/Food/4.png");
		JButton button4=new JButton("数量   "+count4,food4);
		button4.setVerticalTextPosition(JButton.BOTTOM);
		button4.setHorizontalTextPosition(JButton.CENTER);
		button4.setBorderPainted(false);//不打印边框  
        button4.setBorder(null);//除去边框  
        button4.setFocusPainted(false);//除去焦点的框  
        button4.setContentAreaFilled(false);//除去默认的背景填充
        
        ImageIcon food5=Images.getImg("/image/Food/5.png");
		JButton button5=new JButton("数量   "+count5,food5);
		button5.setVerticalTextPosition(JButton.BOTTOM);
		button5.setHorizontalTextPosition(JButton.CENTER);
		button5.setBorderPainted(false);//不打印边框  
        button5.setBorder(null);//除去边框  
        button5.setFocusPainted(false);//除去焦点的框  
        button5.setContentAreaFilled(false);//除去默认的背景填充
        
        ImageIcon food6=Images.getImg("/image/Food/6.png");
		JButton button6=new JButton("数量   "+count6,food6);
		button6.setVerticalTextPosition(JButton.BOTTOM);
		button6.setHorizontalTextPosition(JButton.CENTER);
		button6.setBorderPainted(false);//不打印边框  
        button6.setBorder(null);//除去边框  
        button6.setFocusPainted(false);//除去焦点的框  
        button6.setContentAreaFilled(false);//除去默认的背景填充
        
        ImageIcon food7=Images.getImg("/image/Food/7.png");
		JButton button7=new JButton("数量   "+count7,food7);
		button7.setVerticalTextPosition(JButton.BOTTOM);
		button7.setHorizontalTextPosition(JButton.CENTER);
		button7.setBorderPainted(false);//不打印边框  
        button7.setBorder(null);//除去边框  
        button7.setFocusPainted(false);//除去焦点的框  
        button7.setContentAreaFilled(false);//除去默认的背景填充
        
        ImageIcon food8=Images.getImg("/image/Food/8.png");
		JButton button8=new JButton("数量   "+count8,food8);
		button8.setVerticalTextPosition(JButton.BOTTOM);
		button8.setHorizontalTextPosition(JButton.CENTER);
		button8.setBorderPainted(false);//不打印边框  
        button8.setBorder(null);//除去边框  
        button8.setFocusPainted(false);//除去焦点的框  
        button8.setContentAreaFilled(false);//除去默认的背景填充
        
        ImageIcon food9=Images.getImg("/image/Food/9.png");
		JButton button9=new JButton("数量   "+count9,food9);
		button9.setVerticalTextPosition(JButton.BOTTOM);
		button9.setHorizontalTextPosition(JButton.CENTER);
		button9.setBorderPainted(false);//不打印边框  
        button9.setBorder(null);//除去边框  
        button9.setFocusPainted(false);//除去焦点的框  
        button9.setContentAreaFilled(false);//除去默认的背景填充
        
        button1.setFont(new Font("楷体", Font.PLAIN, 16));
        button2.setFont(new Font("楷体", Font.PLAIN, 16));
        button3.setFont(new Font("楷体", Font.PLAIN, 16));
        button4.setFont(new Font("楷体", Font.PLAIN, 16));
        button5.setFont(new Font("楷体", Font.PLAIN, 16));
        button6.setFont(new Font("楷体", Font.PLAIN, 16));
        button7.setFont(new Font("楷体", Font.PLAIN, 16));
        button8.setFont(new Font("楷体", Font.PLAIN, 16));
        button9.setFont(new Font("楷体", Font.PLAIN, 16));
        
        food1.setImage(food1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food2.setImage(food2.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food3.setImage(food3.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food4.setImage(food4.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food5.setImage(food5.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food6.setImage(food6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food7.setImage(food7.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food8.setImage(food8.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        food9.setImage(food9.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
        
        add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
        
        button1.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(1) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(1)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(8);
						if(eat == 1)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(1, 1);
							button1.setText("数量   "+FoodBag.getFoodCount(1));
							repaint();
						}
					}
				}
    			 }
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(2) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(2)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(5);
						if(eat == 1)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(2, 1);
							button2.setText("数量   "+FoodBag.getFoodCount(2));
							repaint();
						}
					}
				}
    			 }
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(3) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(3)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(7);
						if(eat == 1)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(3, 1);
							button3.setText("数量   "+FoodBag.getFoodCount(3));
							repaint();
						}
					}
				}
    			 }
		});
		
		button4.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(4) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(4)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(9);
						if(eat == 1)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(4, 1);
							button4.setText("数量   "+FoodBag.getFoodCount(4));
							repaint();
						}
					}
				}
    			 }
		});
		
		button5.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(5) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(5)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(11);
						if(eat == 1)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(5, 1);
							button5.setText("数量   "+FoodBag.getFoodCount(5));
							repaint();
						}
					}
				}
    			 }
		});
		
		button6.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(6) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(6)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(15);
						if(eat == 6)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(6, 1);
							button6.setText("数量   "+FoodBag.getFoodCount(6));
							repaint();
						}
					}
				}
    			 }
		});
		
		button7.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(7) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(7)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(20);
						if(eat == 1)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(7, 1);
							button7.setText("数量   "+FoodBag.getFoodCount(7));
							repaint();
						}
					}
				}
    			 }
		});
		
		button8.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(8) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(8)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(23);
						if(eat == 1)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(8, 1);
							button8.setText("数量   "+FoodBag.getFoodCount(8));
							repaint();
						}
					}
				}
    			 }
		});
		
		button9.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(FoodBag.getFoodCount(9) == 0)
				{
					JOptionPane.showMessageDialog(null,"该食物已经被您吃完了，快去商店购买吧！");
				}
				else
				{
					int is = JOptionPane.showConfirmDialog(null, "该食物还剩"+FoodBag.getFoodCount(9)+"份，您确定要食用吗？");
					if(is == JOptionPane.OK_OPTION)
					{
						int eat = User.eat(25);
						if(eat == 1)
						{
							JOptionPane.showMessageDialog(null,"食用成功，感觉人生圆满！");
							FoodBag.minusFoodCount(9, 1);
							button9.setText("数量   "+FoodBag.getFoodCount(9));
							repaint();
						}
					}
				}
    			 }
		});
		
		
	}
}
