package ui.pregame;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Medium.Images;
import ui.father.MyFrame;

public class IntroductionFrame extends MyFrame{

	public IntroductionFrame()
	{
		
		JPanel panel = new JPanel();
		JLabel bottom = new JLabel();
		
		ImageIcon bg=Images.getImg("/image/story.png");  //±³¾°Í¼
//		bg.setImage(bg.getImage().getScaledInstance(355, 400, Image.SCALE_DEFAULT));
		
		this.add(panel);
		
		panel.setLayout(new GridLayout(1,1));
		panel.add(bottom);
		bottom.setIcon(bg);
		
		bottom.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				IntroductionFrame.this.dispose();
				try {
					new InformationFrame();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
