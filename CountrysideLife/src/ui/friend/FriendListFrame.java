package ui.friend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Medium.Images;
import main.APP;
import ui.pregame.MapFrame;

public class FriendListFrame extends JFrame{
	MapFrame thisMapFrame;
	public FriendListFrame(MapFrame frame) {
		this.thisMapFrame=frame;
		initGUI();
		}
	public void initGUI() {
		setTitle("好友列表");//设置窗体标题
		setSize(350,429);//设置窗体大小
		setLocationRelativeTo(null);//设置窗体居中
		setResizable(false);//设置窗体不可改变大小
		FriendPanel friendPanel=new FriendPanel(this);//新建面板
		add(friendPanel);//将面板装入窗体
		setVisible(true);//设置窗体可见
	}
	
/**FriendListFrame内部类FriendPanel*/
private class FriendPanel extends JPanel{
		private JScrollPane jScrollPane1;//滚动面板
		private JList jList1;//列表
		private FriendListFrame friendListFrame;//对应的好友农场界面
		public FriendPanel(FriendListFrame friendListFrame) {
			this.friendListFrame=friendListFrame;
			initGUI();
			myListioner();
		}
		
		/**添加监听器*/
		private void myListioner() {
			JListListioner jll = new JListListioner();
			jList1.addMouseListener(jll);

		}

		/**写列表的监听器*/
		private class JListListioner extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				Friends friend = (Friends) jList1.getSelectedValue();
				int flag = e.getModifiers();
				if (flag == InputEvent.BUTTON1_MASK) {
					if (!friend.name.equals(APP.user)){
						FriendFrame thisFriendFrame=new FriendFrame(friend.name);
						FriendListFrame.this.dispose();
						thisMapFrame.dispose();
						
					}
				}
			}
		}

		/**初始化*/
		private void initGUI() {
			try {
				//设置面板大小
				
				this.setPreferredSize(new Dimension(350, 400));
				setLocationRelativeTo(null);
				
				JLabel topbackLabel=new JLabel();
				ImageIcon topback=Images.getImg("/image/moveback.jpg");
				topbackLabel.setIcon(topback);
				topbackLabel.setPreferredSize(new Dimension(350,400));
				this.add(topbackLabel);
				this.setPreferredSize(getPreferredSize());//1
				{
					jScrollPane1 = new JScrollPane();
					topbackLabel.add(jScrollPane1);
					//设置jScrollPane1透明
					jScrollPane1.setOpaque(false);
					jScrollPane1.getViewport().setOpaque(false);
					//设置jScrollPane1大小
					jScrollPane1.setBounds(0, 0, 340, 400);
					jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//设置垂直滚动条一直出现
					jList1 = new FriendList();
					//设置jlist1透明
					jList1.setBackground(new Color(255,255,255,0));
					jList1.setOpaque(false);
					((JLabel)jList1.getCellRenderer()).setOpaque(false);
					jScrollPane1.setViewportView(jList1);		
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}
}
