package ui.bag;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Bag.SeedBag;
import Medium.Images;
import main.APP;
import user.User;

public class seedPanel extends BagPanel{
	
	public seedPanel() {
		
		String count1 = SeedBag.getSeedCount(1)+"";
		String count2 = SeedBag.getSeedCount(2)+"";
		String count3 = SeedBag.getSeedCount(3)+"";
		String count4 = SeedBag.getSeedCount(4)+"";
		String count5 = SeedBag.getSeedCount(5)+"";
		String count6 = SeedBag.getSeedCount(6)+"";
		String count7 = SeedBag.getSeedCount(7)+"";
		String count8 = SeedBag.getSeedCount(8)+"";
		String count9 = SeedBag.getSeedCount(9)+"";
		String count10 = SeedBag.getSeedCount(10)+"";
		String count11 = SeedBag.getSeedCount(11)+"";
		
        ImageIcon seed1=Images.getImg("/image/Crop1/fruit.png");
		JButton button1=new JButton("数量   "+count1,seed1);
		button1.setVerticalTextPosition(JButton.BOTTOM);
		button1.setHorizontalTextPosition(JButton.CENTER);
		button1.setBorderPainted(false);//不打印边框  
        button1.setBorder(null);//除去边框  
        button1.setFocusPainted(false);//除去焦点的框  
        button1.setContentAreaFilled(false);//除去默认的背景填充
        
		ImageIcon seed2=Images.getImg("/image/Crop2/fruit.png");
		JButton button2=new JButton("数量   "+count2,seed2);
		button2.setVerticalTextPosition(JButton.BOTTOM);
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setBorderPainted(false);//不打印边框  
        button2.setBorder(null);//除去边框  
        button2.setFocusPainted(false);//除去焦点的框  
        button2.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed3=Images.getImg("/image/Crop3/fruit.png");
		JButton button3=new JButton("数量   "+count3,seed3);
		button3.setVerticalTextPosition(JButton.BOTTOM);
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setBorderPainted(false);//不打印边框  
        button3.setBorder(null);//除去边框  
        button3.setFocusPainted(false);//除去焦点的框  
        button3.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed4=Images.getImg("/image/Crop4/fruit.png");
		JButton button4=new JButton("数量   "+count4,seed4);
		button4.setVerticalTextPosition(JButton.BOTTOM);
		button4.setHorizontalTextPosition(JButton.CENTER);
		button4.setBorderPainted(false);//不打印边框  
        button4.setBorder(null);//除去边框  
        button4.setFocusPainted(false);//除去焦点的框  
        button4.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed5=Images.getImg("/image/Crop5/fruit.png");
		JButton button5=new JButton("数量   "+count5,seed5);
		button5.setVerticalTextPosition(JButton.BOTTOM);
		button5.setHorizontalTextPosition(JButton.CENTER);
		button5.setBorderPainted(false);//不打印边框  
        button5.setBorder(null);//除去边框  
        button5.setFocusPainted(false);//除去焦点的框  
        button5.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed6=Images.getImg("/image/Crop6/fruit.png");
		JButton button6=new JButton("数量   "+count6,seed6);
		button6.setVerticalTextPosition(JButton.BOTTOM);
		button6.setHorizontalTextPosition(JButton.CENTER);
		button6.setBorderPainted(false);//不打印边框  
        button6.setBorder(null);//除去边框  
        button6.setFocusPainted(false);//除去焦点的框  
        button6.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed7=Images.getImg("/image/Crop7/fruit.png");
		JButton button7=new JButton("数量   "+count7,seed7);
		button7.setVerticalTextPosition(JButton.BOTTOM);
		button7.setHorizontalTextPosition(JButton.CENTER);
		button7.setBorderPainted(false);//不打印边框  
        button7.setBorder(null);//除去边框  
        button7.setFocusPainted(false);//除去焦点的框  
        button7.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed8=Images.getImg("/image/Crop8/fruit.png");
		JButton button8=new JButton("数量   "+count8,seed8);
		button8.setVerticalTextPosition(JButton.BOTTOM);
		button8.setHorizontalTextPosition(JButton.CENTER);
		button8.setBorderPainted(false);//不打印边框  
        button8.setBorder(null);//除去边框  
        button8.setFocusPainted(false);//除去焦点的框  
        button8.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed9=Images.getImg("/image/Crop9/fruit.png");
		JButton button9=new JButton("数量   "+count9,seed9);
		button9.setVerticalTextPosition(JButton.BOTTOM);
		button9.setHorizontalTextPosition(JButton.CENTER);
		button9.setBorderPainted(false);//不打印边框  
        button9.setBorder(null);//除去边框  
        button9.setFocusPainted(false);//除去焦点的框  
        button9.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed10=Images.getImg("/image/Crop10/fruit.png");
		JButton button10=new JButton("数量   "+count10,seed10);
		button10.setVerticalTextPosition(JButton.BOTTOM);
		button10.setHorizontalTextPosition(JButton.CENTER);
		button10.setBorderPainted(false);//不打印边框  
        button10.setBorder(null);//除去边框  
        button10.setFocusPainted(false);//除去焦点的框  
        button10.setContentAreaFilled(false);//除去默认的背景填充
		
		ImageIcon seed11=Images.getImg("/image/Crop11/fruit.png");
		JButton button11=new JButton("数量   "+count11,seed11);
		button11.setVerticalTextPosition(JButton.BOTTOM);
		button11.setHorizontalTextPosition(JButton.CENTER);
		button11.setBorderPainted(false);//不打印边框  
        button11.setBorder(null);//除去边框  
        button11.setFocusPainted(false);//除去焦点的框  
        button11.setContentAreaFilled(false);//除去默认的背景填充
		
        
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
        
        button1.setFont(new Font("楷体", Font.PLAIN, 16));
        button2.setFont(new Font("楷体", Font.PLAIN, 16));
        button3.setFont(new Font("楷体", Font.PLAIN, 16));
        button4.setFont(new Font("楷体", Font.PLAIN, 16));
        button5.setFont(new Font("楷体", Font.PLAIN, 16));
        button6.setFont(new Font("楷体", Font.PLAIN, 16));
        button7.setFont(new Font("楷体", Font.PLAIN, 16));
        button8.setFont(new Font("楷体", Font.PLAIN, 16));
        button9.setFont(new Font("楷体", Font.PLAIN, 16));
        button10.setFont(new Font("楷体", Font.PLAIN, 16));
        button11.setFont(new Font("楷体", Font.PLAIN, 16));
        
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
				if(SeedBag.getSeedCount(1) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(1);
					APP.gf.setCursor(createCursor("/image/Crop1/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(2) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(2);
					APP.gf.setCursor(createCursor("/image/Crop2/fruit.png"));
					APP.bf.dispose();
					
				}
    			 }
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(3) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(3);
					APP.gf.setCursor(createCursor("/image/Crop3/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button4.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(4) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(4);
					APP.gf.setCursor(createCursor("/image/Crop4/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button5.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(5) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(5);
					APP.gf.setCursor(createCursor("/image/Crop5/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button6.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(6) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(6);
					APP.gf.setCursor(createCursor("/image/Crop6/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button7.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(7) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(7);
					APP.gf.setCursor(createCursor("/image/Crop7/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button8.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(8) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(8);
					APP.gf.setCursor(createCursor("/image/Crop8/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button9.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(9) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(9);
					APP.gf.setCursor(createCursor("/image/Crop9/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button10.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(10) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(10);
					APP.gf.setCursor(createCursor("/image/Crop10/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
		
		button11.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				if(SeedBag.getSeedCount(11) == 0)
				{
					JOptionPane.showMessageDialog(null,"该作物种子已耗尽，快去商店购买吧！");
				}
				else
				{
					APP.gf.setMouseCursorIcon(11);
					APP.gf.setCursor(createCursor("/image/Crop11/fruit.png"));
					APP.bf.dispose();
				}
    			 }
		});
				
	}
	
	  public static Cursor createCursor(String path) {
	        String fileName = path;
	        Image cursor = Toolkit.getDefaultToolkit().createImage(BagFrame.class.getResource(fileName));
	        return Toolkit.getDefaultToolkit().createCustomCursor(cursor, new Point(16, 16), "mycursor");
	    }
}
