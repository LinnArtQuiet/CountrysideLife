package ui.pregame;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Medium.Images;
import Medium.Music;
import ui.father.MyFrame;

public class StartFrame extends MyFrame{
	
	public Music bgMusic;
	
	public StartFrame() {
		super();
		
		//“Ù¿÷≤•∑≈
		bgMusic = new Music(); //±≥æ∞“Ù¿÷
		bgMusic.open("src/sound/bgm.wav");
		bgMusic.loop(100);
				
		JLabel bottom = new JLabel();
		
		JPanel panel = new JPanel();
		
		this.add(panel);
		panel.setLayout(new GridLayout(1,1));
		panel.add(bottom);
		
		ImageIcon bg=Images.getImg("/image/startpage.png");  //±≥æ∞Õº
		ImageIcon start=Images.getImg("/image/start.png");  //±≥æ∞Õº
		ImageIcon darkstart=Images.getImg("/image/darkstart.png");  //±≥æ∞Õº
		
		bg.setImage(bg.getImage().getScaledInstance(1067,600, Image.SCALE_DEFAULT));
		darkstart.setImage(darkstart.getImage().getScaledInstance(darkstart.getIconWidth(),darkstart.getIconHeight(), Image.SCALE_DEFAULT));
		start.setImage(start.getImage().getScaledInstance(start.getIconWidth(),start.getIconHeight(), Image.SCALE_DEFAULT));
		
//		Player play = new Player(Images.class.getResource("/image/video.mp3"));
		
		
		
		JButton button = new JButton(start);
		
		bottom.setIcon(bg);
		bottom.setLayout(new GridLayout(4,3));
		int i;
		for(i=0;i<7;i++)
		{
			bottom.add(new JLabel(""));
		}
		bottom.add(button);
		for(i=0;i<4;i++)
		{
			bottom.add(new JLabel(""));
		}
		button.setFocusPainted(false);//≥˝»•Ωπµ„µƒøÚ  
		button.setBorderPainted(false); //≥˝»•buttonµƒ±ﬂøÚ
        button.setContentAreaFilled(false);
		
		button.addActionListener(new ActionListener()  //ºÃ–¯”Œœ∑
				{
			public void actionPerformed(ActionEvent e)
			{
				new LoginFrame();
				setVisible(false);  //–≈œ¢ΩÁ√Ê≤ªø…º˚	
			}
				});
		button.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setIcon(darkstart);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setIcon(start);
			}
	
		});
		
	}

}
