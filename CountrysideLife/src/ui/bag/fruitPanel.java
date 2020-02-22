package ui.bag;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Bag.FoodBag;
import Bag.FruitBag;
import Crop.Crop;
import Medium.Images;
import main.APP;
import user.User;
public class fruitPanel extends BagPanel{
		
		public fruitPanel() {
			
			int count1 = FruitBag.getFruitCount(1);
			int count2 = FruitBag.getFruitCount(2);
			int count3 = FruitBag.getFruitCount(3);
			int count4 = FruitBag.getFruitCount(4);
			int count5 = FruitBag.getFruitCount(5);
			int count6 = FruitBag.getFruitCount(6);
			int count7 = FruitBag.getFruitCount(7);
			int count8 = FruitBag.getFruitCount(8);
			int count9 = FruitBag.getFruitCount(9);
			int count10 = FruitBag.getFruitCount(10);
			int count11 = FruitBag.getFruitCount(11);
			
	        ImageIcon fruit1=Images.getImg("/image/Crop1/fruit.png");
			JButton button1=new JButton("����   "+count1,fruit1);
			button1.setVerticalTextPosition(JButton.BOTTOM);
			button1.setHorizontalTextPosition(JButton.CENTER);
			button1.setBorderPainted(false);//����ӡ�߿�  
	        button1.setBorder(null);//��ȥ�߿�  
	        button1.setFocusPainted(false);//��ȥ����Ŀ�  
	        button1.setContentAreaFilled(false);//��ȥĬ�ϵı������
	        
			ImageIcon fruit2=Images.getImg("/image/Crop2/fruit.png");
			JButton button2=new JButton("����   "+count2,fruit2);
			button2.setVerticalTextPosition(JButton.BOTTOM);
			button2.setHorizontalTextPosition(JButton.CENTER);
			button2.setBorderPainted(false);//����ӡ�߿�  
	        button2.setBorder(null);//��ȥ�߿�  
	        button2.setFocusPainted(false);//��ȥ����Ŀ�  
	        button2.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit3=Images.getImg("/image/Crop3/fruit.png");
			JButton button3=new JButton("����   "+count3,fruit3);
			button3.setVerticalTextPosition(JButton.BOTTOM);
			button3.setHorizontalTextPosition(JButton.CENTER);
			button3.setBorderPainted(false);//����ӡ�߿�  
	        button3.setBorder(null);//��ȥ�߿�  
	        button3.setFocusPainted(false);//��ȥ����Ŀ�  
	        button3.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit4=Images.getImg("/image/Crop4/fruit.png");
			JButton button4=new JButton("����   "+count4,fruit4);
			button4.setVerticalTextPosition(JButton.BOTTOM);
			button4.setHorizontalTextPosition(JButton.CENTER);
			button4.setBorderPainted(false);//����ӡ�߿�  
	        button4.setBorder(null);//��ȥ�߿�  
	        button4.setFocusPainted(false);//��ȥ����Ŀ�  
	        button4.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit5=Images.getImg("/image/Crop5/fruit.png");
			JButton button5=new JButton("����   "+count5,fruit5);
			button5.setVerticalTextPosition(JButton.BOTTOM);
			button5.setHorizontalTextPosition(JButton.CENTER);
			button5.setBorderPainted(false);//����ӡ�߿�  
	        button5.setBorder(null);//��ȥ�߿�  
	        button5.setFocusPainted(false);//��ȥ����Ŀ�  
	        button5.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit6=Images.getImg("/image/Crop6/fruit.png");
			JButton button6=new JButton("����   "+count6,fruit6);
			button6.setVerticalTextPosition(JButton.BOTTOM);
			button6.setHorizontalTextPosition(JButton.CENTER);
			button6.setBorderPainted(false);//����ӡ�߿�  
	        button6.setBorder(null);//��ȥ�߿�  
	        button6.setFocusPainted(false);//��ȥ����Ŀ�  
	        button6.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit7=Images.getImg("/image/Crop7/fruit.png");
			JButton button7=new JButton("����   "+count7,fruit7);
			button7.setVerticalTextPosition(JButton.BOTTOM);
			button7.setHorizontalTextPosition(JButton.CENTER);
			button7.setBorderPainted(false);//����ӡ�߿�  
	        button7.setBorder(null);//��ȥ�߿�  
	        button7.setFocusPainted(false);//��ȥ����Ŀ�  
	        button7.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit8=Images.getImg("/image/Crop8/fruit.png");
			JButton button8=new JButton("����   "+count8,fruit8);
			button8.setVerticalTextPosition(JButton.BOTTOM);
			button8.setHorizontalTextPosition(JButton.CENTER);
			button8.setBorderPainted(false);//����ӡ�߿�  
	        button8.setBorder(null);//��ȥ�߿�  
	        button8.setFocusPainted(false);//��ȥ����Ŀ�  
	        button8.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit9=Images.getImg("/image/Crop9/fruit.png");
			JButton button9=new JButton("����   "+count9,fruit9);
			button9.setVerticalTextPosition(JButton.BOTTOM);
			button9.setHorizontalTextPosition(JButton.CENTER);
			button9.setBorderPainted(false);//����ӡ�߿�  
	        button9.setBorder(null);//��ȥ�߿�  
	        button9.setFocusPainted(false);//��ȥ����Ŀ�  
	        button9.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit10=Images.getImg("/image/Crop10/fruit.png");
			JButton button10=new JButton("����   "+count10,fruit10);
			button10.setVerticalTextPosition(JButton.BOTTOM);
			button10.setHorizontalTextPosition(JButton.CENTER);
			button10.setBorderPainted(false);//����ӡ�߿�  
	        button10.setBorder(null);//��ȥ�߿�  
	        button10.setFocusPainted(false);//��ȥ����Ŀ�  
	        button10.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
			ImageIcon fruit11=Images.getImg("/image/Crop11/fruit.png");
			JButton button11=new JButton("����   "+count11,fruit11);
			button11.setVerticalTextPosition(JButton.BOTTOM);
			button11.setHorizontalTextPosition(JButton.CENTER);
			button11.setBorderPainted(false);//����ӡ�߿�  
	        button11.setBorder(null);//��ȥ�߿�  
	        button11.setFocusPainted(false);//��ȥ����Ŀ�  
	        button11.setContentAreaFilled(false);//��ȥĬ�ϵı������
			
	        fruit1.setImage(fruit1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit2.setImage(fruit2.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit3.setImage(fruit3.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit4.setImage(fruit4.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit5.setImage(fruit5.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit6.setImage(fruit6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit7.setImage(fruit7.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit8.setImage(fruit8.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit9.setImage(fruit9.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit10.setImage(fruit10.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        fruit11.setImage(fruit11.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
	        
	        
	        button1.setFont(new Font("����", Font.PLAIN, 16));
	        button2.setFont(new Font("����", Font.PLAIN, 16));
	        button3.setFont(new Font("����", Font.PLAIN, 16));
	        button4.setFont(new Font("����", Font.PLAIN, 16));
	        button5.setFont(new Font("����", Font.PLAIN, 16));
	        button6.setFont(new Font("����", Font.PLAIN, 16));
	        button7.setFont(new Font("����", Font.PLAIN, 16));
	        button8.setFont(new Font("����", Font.PLAIN, 16));
	        button9.setFont(new Font("����", Font.PLAIN, 16));
	        button10.setFont(new Font("����", Font.PLAIN, 16));
	        button11.setFont(new Font("����", Font.PLAIN, 16));
	        
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
			
			button1.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(1) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(1);
						button1.setText("����   "+FruitBag.getFruitCount(1));
						repaint();
					}
	    			 }
			});
			
			button2.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(2) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(2);
						button2.setText("����   "+FruitBag.getFruitCount(2));
						repaint();
					}
	    			 }
			});
			
			button3.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(3) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(3);
						button3.setText("����   "+FruitBag.getFruitCount(3));
						repaint();
					}
	    			 }
			});
			
			button4.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(4) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(4);
						button4.setText("����   "+FruitBag.getFruitCount(4));
						repaint();
					}
	    			 }
			});
			
			button5.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(5) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(5);
						button5.setText("����   "+FruitBag.getFruitCount(5));
						repaint();
					}
	    			 }
			});
			
			button6.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(6) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(6);
						button6.setText("����   "+FruitBag.getFruitCount(6));
						repaint();
					}
	    			 }
			});
			
			button7.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(7) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(7);
						button7.setText("����   "+FruitBag.getFruitCount(7));
						repaint();
					}
	    			 }
			});
			
			button8.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(8) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(8);
						button8.setText("����   "+FruitBag.getFruitCount(8));
						repaint();
					}
	    			 }
			});
			
			button9.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(9) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(9);
						button9.setText("����   "+FruitBag.getFruitCount(9));
						repaint();
					}
	    			 }
			});
			
			button10.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(10) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(10);
						button10.setText("����   "+FruitBag.getFruitCount(10));
						repaint();
					}
	    			 }
			});
			
			button11.addActionListener(new ActionListener() {
				@Override
	    		public void actionPerformed(ActionEvent e) {
					if(FruitBag.getFruitCount(11) == 0)
					{
						JOptionPane.showMessageDialog(null,"���ı���û�иù�ʵ����ȥ��ֲ�ɣ�");
					}
					else
					{
						new SoldDialog(11);
						button11.setText("����   "+FruitBag.getFruitCount(11));
						repaint();
					}
	    			 }
			});
			
		}
}

